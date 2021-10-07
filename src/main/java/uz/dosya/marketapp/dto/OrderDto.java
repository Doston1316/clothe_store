package uz.dosya.marketapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private List<SaleProductDto> saleProducts;
}


