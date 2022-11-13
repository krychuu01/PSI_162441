package pl.bookstore.users.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.addresses.Address;
import pl.bookstore.addresses.AddressRepository;
import pl.bookstore.basic.ErrorListDto;
import pl.bookstore.basic.exceptions.DateValidationException;
import pl.bookstore.basic.exceptions.StringValidationException;
import pl.bookstore.basic.interfaces.EntityDto;
import pl.bookstore.users.User;
import pl.bookstore.users.UserRepository;

import java.util.ArrayList;

@RequiredArgsConstructor
@Component
public class UserCreator {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    public ErrorListDto create(EntityDto<User> userDto) {
        var errorList = new ErrorListDto(new ArrayList<>());
        saveUser(errorList, userDto);
        return errorList;
    }

    private void saveUser(ErrorListDto errorList, EntityDto<User> userDto) {
        try {
            var user = userDto.toEntity();
            var address = createNewAddress();
            user.setAddress(address);


            userRepository.save(user);
            errorList.buildMessage(String.format("Added user with %s email", user.getEmail()));
        }
        catch (StringValidationException | DateValidationException exception) {
            errorList.addError(exception.getMessage());
        }
    }

    private Address createNewAddress() {
        var address = new Address();
        addressRepository.save(address);
        return address;
    }

}
