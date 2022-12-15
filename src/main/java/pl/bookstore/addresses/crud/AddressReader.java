package pl.bookstore.addresses.crud;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import pl.bookstore.addresses.Address;
import pl.bookstore.addresses.AddressRepository;
import pl.bookstore.basic.ReaderClassesUtils;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AddressReader {

    private final AddressRepository repository;

    public List<? extends EntityDto<Address>> getAllAddresses(Integer pageNumber, Integer pageSize) {
        var number = ReaderClassesUtils.validatePageNumber(pageNumber);
        var size = ReaderClassesUtils.validatePageSize(pageSize);
        var addresses = repository.findAll(PageRequest.of(number, size)).getContent();
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
