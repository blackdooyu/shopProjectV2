package refactor.shopproject.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import refactor.shopproject.domain.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
