package pl.bookstore.graphql.addressDetails;

import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class AddressGQLController {

    private final AddressGQLService addressGQLService;

    @QueryMapping
    List<AddressGQL> findAllAddresses() {
        return addressGQLService.findAllAddresses();
    }

    @QueryMapping
    AddressGQL findAddressById(@Argument Long id) {
        return addressGQLService.findAddressById(id);
    }

    @QueryMapping
    List<AddressGQL> findAllByCountry(@Argument String country) {
        return addressGQLService.findAllByCountry(country);
    }

    @MutationMapping
    AddressGQL addAddress(@Argument AddressGQL address) {
        return addressGQLService.addAddress(address);
    }

    @MutationMapping
    AddressGQL changeAddressCountry(@Argument Long id, @Argument String country) {
        return addressGQLService.changeAddressCountry(id, country);
    }

    @MutationMapping
    Long deleteAddressById(@Argument Long id) {
        return addressGQLService.deleteAddressById(id);
    }

}
