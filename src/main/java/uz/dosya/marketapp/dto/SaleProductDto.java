package uz.dosya.marketapp.dto;

import lombok.Data;

@Data
public class SaleProductDto {
    private Long productId;
    private Long salePrice;
    private Long quantity;
}
