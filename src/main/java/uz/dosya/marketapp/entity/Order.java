package uz.dosya.marketapp.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<SaleProduct> saleProducts;
}
