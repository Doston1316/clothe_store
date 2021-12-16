package uz.dosya.marketapp.entity;

import lombok.Data;
import uz.dosya.marketapp.enam.Status;

import javax.persistence.*;


@Entity
@Data
public class SaleProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Product product;
    private Long salePrice;
    private Long quantity;
    private Long profit;
    private Long date;
    private String name;
    private String size;
    private String brand;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean deleted=false;
}
