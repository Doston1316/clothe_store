package uz.dosya.marketapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Product product;
    private Long salePrice;
    private Long quantity;
    private Long profit;
    private Long date;
    private String name;
    private String size;
    private String brand;
}
