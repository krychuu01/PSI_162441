package pl.bookstore.graphql.addressDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.bookstore.graphql.repository.AddressGQLRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressGQLService {

    private final AddressGQLRepository addressGQLRepository;

    public List<AddressGQL> findAllAddresses() {
        return addressGQLRepository.findAll();
    }

    public AddressGQL findAddressById(Long id) {
        return addressGQLRepository.findById(id).orElse(null);
    }

    public List<AddressGQL> findAllByCountry(String countryName) {
        return addressGQLRepository.findByCountry(countryName);
    }

    public AddressGQL addAddress(AddressGQL addressGQL) {
        return addressGQLRepository.save(addressGQL);
    }

    public AddressGQL changeAddressCountry(Long id, String newCountry) {
        var address = findAddressById(id);
        address.setCountry(newCountry);
        return addressGQLRepository.save(address);
    }

    public Long deleteAddressById(Long id) {
        addressGQLRepository.deleteById(id);
        return id;
    }

}
