package uz.dosya.marketapp.mapper;

import lombok.Data;

@Data
public class CalculationSaleResult {
    private Long salePrice;
    private Long quantity;
    private Long profit;
}
