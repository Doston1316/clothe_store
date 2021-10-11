package uz.dosya.marketapp.mapper;

import lombok.Data;
import uz.dosya.marketapp.entity.Product;

import javax.persistence.OneToOne;
import java.util.Date;
@Data
public class SaleProductResult {

    private Long salePrice;
    private Long quantity;
    private Long profit;
    private Date date;
    private String name;
    private String size;
    private String brand;
}
