package pl.bookstore.addresses.crud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.addresses.Address;
import pl.bookstore.addresses.AddressRepository;
import pl.bookstore.basic.EntityUtils;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.exceptions.StringValidationException;

@Component
@RequiredArgsConstructor
public class AddressUpdater {

    private final AddressRepository repository;
    private final AddressReader reader;


    public MessageListDto updateField(Long entityId, String fieldName, String value) {
        var messageList = new MessageListDto();

        try {
            var address = reader.findAddress(entityId);
            changeFieldValue(address, fieldName, value);
            messageList.buildMessage(String.format("changed %s value", fieldName));
        }
        catch (StringValidationException | IllegalStateException exception) {
            messageList.addError(exception.getMessage());
        }

        return messageList;
    }

    private void changeFieldValue(Address address, String fieldName, String value) {
        var field = EntityUtils.getFieldName(fieldName, Address.class);
        address.setFieldValue(field, value);
        repository.save(address);
    }

}
