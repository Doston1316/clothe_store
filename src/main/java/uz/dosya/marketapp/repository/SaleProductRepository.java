package uz.dosya.marketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.dosya.marketapp.entity.SaleProduct;


@Repository
public interface SaleProductRepository extends JpaRepository<SaleProduct, Long> {

//    @Query(value = "select  sum(quantity) as quantity, sum(sale_price) as sale_price,sum(profit) as profit from sale_product",nativeQuery = true)
//    List<SaleProduct>findAllSearchSaleProducts(String name);


}
