package refactor.shopproject.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import refactor.shopproject.domain.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
