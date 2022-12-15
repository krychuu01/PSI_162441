package pl.bookstore.addresses;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.bookstore.addresses.crud.AddressReader;
import pl.bookstore.addresses.crud.AddressUpdater;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;
import pl.bookstore.basic.interfaces.CrudInterface;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressFacade implements CrudInterface<Address> {

    private final AddressReader reader;
    private final AddressUpdater updater;

    @Override
    public MessageListDto create(EntityDto<Address> entityDto) {
        throw new IllegalStateException("Address is only created while adding a new User.");
    }

    @Override
    public EntityDto<Address> readOne(Long id) {
        return reader.getAddressDtoById(id);
    }

    @Override
    public List<? extends EntityDto<Address>> readAll(Integer pageNumber, Integer pageSize) {
        return reader.getAllAddresses(pageNumber, pageSize);
    }

    @Override
    public MessageListDto updateField(Long entityId, UpdateDto dto) {
        return updater.updateField(entityId, dto.fieldName(), dto.value());
    }

    @Override
    public MessageListDto delete(Long entityId) {
        throw new IllegalStateException("Address is only deleted when the user assigned to it is deleted.");
    }

}
