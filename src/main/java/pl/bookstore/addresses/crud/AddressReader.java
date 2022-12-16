package pl.bookstore.addresses.crud;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pl.bookstore.addresses.Address;
import pl.bookstore.addresses.AddressRepository;
import pl.bookstore.basic.ReaderClassesUtils;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AddressReader {

    private final AddressRepository repository;

    public List<? extends EntityDto<Address>> getAllAddresses(Integer pageNumber, Integer pageSize, String fieldName, SortDirection sortDirection) {
        var addresses = ReaderClassesUtils.getEntitiesSortedByField(repository, pageNumber, pageSize, fieldName, sortDirection);
        return ReaderClassesUtils.getDtoList(addresses);
    }

    public EntityDto<Address> getAddressDtoById(Long id) {
        var address = findAddress(id);
        return address.toDto();
    }

    protected Address findAddress(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Book not found"));
    }

}
