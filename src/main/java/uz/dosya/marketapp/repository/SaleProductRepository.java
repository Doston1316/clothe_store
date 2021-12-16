package uz.dosya.marketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.dosya.marketapp.entity.Product;
import uz.dosya.marketapp.entity.SaleProduct;

import java.util.List;


@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {

    @Query("select p from SaleProduct p where p.name like %?1% " +
            "or p.brand like %?1%" +
            "or p.size like %?1%")
    List<SaleProduct> search(String name);





}
