package uz.dosya.marketapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import uz.dosya.marketapp.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from Product as p where p.quantity>0 and p.deleted=false order by p.quantity desc",nativeQuery = true)
    List<Product> findAllByDeletedFalse();

    @Query("select p from Product p where p.name like %?1% " +
            "or p.brand like %?1%" +
            "or p.color like %?1%" +
            "or p.size like %?1%")
    List<Product>search(String name);


    List<Product>findAllByDeletedTrue();

    @Query(value = "select * from Product as p where p.quantity=0 and p.deleted=false",nativeQuery = true)
    List<Product>findByAllFinishedProducts();
}
