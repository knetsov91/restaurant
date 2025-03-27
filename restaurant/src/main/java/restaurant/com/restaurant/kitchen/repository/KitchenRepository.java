package restaurant.com.restaurant.kitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restaurant.com.restaurant.kitchen.model.Kitchen;

@Repository
public interface KitchenRepository extends JpaRepository<Kitchen, Long> {
}
