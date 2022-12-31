package pl.bookstore.orders_info;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

    List<OrderInfo> findByBook_id(Long id);

    List<OrderInfo> findByOrder_id(Long id);

}
