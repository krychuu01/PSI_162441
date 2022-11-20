package pl.bookstore.orders.dtos;

import java.util.TreeMap;

public record OrderedBooksDto(TreeMap<Long, Integer> bookIdAndAmountMap, Integer discount) {



}
