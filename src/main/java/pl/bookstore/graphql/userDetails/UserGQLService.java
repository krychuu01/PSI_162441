package pl.bookstore.graphql.userDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookstore.graphql.addressDetails.AddressGQL;
import pl.bookstore.graphql.repository.AddressGQLRepository;
import pl.bookstore.graphql.repository.UserGQLRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserGQLService {

    private final UserGQLRepository userGQLRepository;
    private final AddressGQLRepository addressGQLRepository;

    public List<UserGQL> findAllUsers() {
        return userGQLRepository.findAll();
    }

    public UserGQL findUserById(Long id) {
        return userGQLRepository.findById(id).orElse(null);
    }

    public List<UserGQL> findUsersByFirstName(String firstName) {
        return userGQLRepository.findByFirstNameLike(firstName);
    }

    public UserGQL addUser(UserGQL userGQL) {
        return userGQLRepository.save(userGQL);
    }

    public UserGQL changeUserEmail(Long id, String email) {
        var user = findUserById(id);
        user.setEmail(email);
        return userGQLRepository.save(user);
    }

    public Long deleteUserById(Long id) {
        userGQLRepository.deleteById(id);
        return id;
    }

    public List<UserGQL> findUsersByCountry(String givenCountry) {
        var addresses = addressGQLRepository.findByCountry(givenCountry);
        var addressesFromGivenCountry =
                addresses.stream()
                .mapToLong(AddressGQL::getId)
                .boxed()
                .toList();
        return userGQLRepository.findUsersByGivenAddressIds(addressesFromGivenCountry);
    }

    public List<UserGQL> findUsersByCity(String givenCity) {
        var addresses = addressGQLRepository.findByCity(givenCity);
        var addressesFromGivenCity =
                addresses.stream()
                        .mapToLong(AddressGQL::getId)
                        .boxed()
                        .toList();
        return userGQLRepository.findUsersByGivenAddressIds(addressesFromGivenCity);
    }

}
