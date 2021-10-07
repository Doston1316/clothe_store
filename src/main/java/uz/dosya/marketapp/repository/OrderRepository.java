package uz.dosya.marketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.dosya.marketapp.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
