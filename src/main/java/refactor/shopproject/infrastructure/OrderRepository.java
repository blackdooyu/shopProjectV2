package refactor.shopproject.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import refactor.shopproject.domain.order.Order;

public interface OrderRepository extends JpaRepository<Order, String> {
}
