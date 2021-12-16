package uz.dosya.marketapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "debtors")
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String productName;
    private String description;
    private String phone;
    private Long date;
    private Boolean deleted=false;



}
