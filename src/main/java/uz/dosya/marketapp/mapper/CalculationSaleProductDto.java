package uz.dosya.marketapp.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
@Component
public class CalculationSaleProductDto implements RowMapper {


    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        CalculationSaleResult saleProductResult=new CalculationSaleResult();
        saleProductResult.setSalePrice(rs.getLong("sale_price"));
        saleProductResult.setQuantity(rs.getLong("quantity"));
        saleProductResult.setProfit(rs.getLong("profit"));
        return saleProductResult;
    }
}
