package uz.dosya.marketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.dosya.marketapp.entity.SaleProduct;

@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {
}
