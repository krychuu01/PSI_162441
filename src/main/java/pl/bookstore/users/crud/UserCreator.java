package pl.bookstore.users.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.addresses.Address;
import pl.bookstore.addresses.AddressRepository;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.exceptions.AlreadyExistException;
import pl.bookstore.basic.exceptions.DateValidationException;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.User;
import pl.bookstore.users.UserRepository;

@RequiredArgsConstructor
@Component
public class UserCreator {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public MessageListDto create(EntityDto<User> userDto) {
        var errorList = new MessageListDto();
        saveUser(errorList, userDto);
        return errorList;
    }

    private void saveUser(MessageListDto errorList, EntityDto<User> userDto) {
        try {
            var user = userDto.toEntity();
            if (existByEmailOrLogin(user)) {
                throw new AlreadyExistException("User with this email or login already exists!");
            }

            var address = createNewAddress();
            user.setAddress(address);
            userRepository.save(user);
            errorList.buildMessage(String.format("Added user with %s email", user.getEmail()));
        }
        catch (StringValidationException | DateValidationException | AlreadyExistException exception) {
            errorList.addError(exception.getMessage());
        }
    }

    private Address createNewAddress() {
        var address = new Address();
        return addressRepository.save(address);
    }

    private boolean existByEmailOrLogin(User user) {
        return userRepository.existsByEmail(user.getEmail()) || userRepository.existsByLogin(user.getLogin());
    }

}
