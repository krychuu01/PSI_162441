package pl.bookstore.addresses;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bookstore.basic.SortDirection;
import pl.bookstore.basic.dto.MessageListDto;
import pl.bookstore.basic.dto.UpdateDto;
import pl.bookstore.basic.interfaces.EntityDto;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressFacade facade;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<? extends EntityDto<Address>> getAddresses(@RequestParam(required = false) Integer pageNumber,
                                                           @RequestParam(required = false) Integer pageSize,
                                                           @RequestParam(required = false) String fieldName,
                                                           @RequestParam SortDirection sortDirection) {
        return facade.readAll(pageNumber, pageSize, fieldName, sortDirection);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EntityDto<Address> getAddress(@PathVariable Long id) {
        return facade.readOne(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageListDto editAddressField(@PathVariable Long id, @RequestBody UpdateDto dto) {
        return facade.updateField(id, dto);
    }

}
