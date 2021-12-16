package uz.dosya.marketapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String size;
    private String brand;
    private String color;
    private Long price;
    private Long quantity;
    private Boolean deleted=false;
}
