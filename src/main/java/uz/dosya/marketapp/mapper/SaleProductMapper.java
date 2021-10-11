package uz.dosya.marketapp.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

@Component
public class SaleProductMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        SaleProductResult result=new SaleProductResult();
        result.setBrand(rs.getString("brand"));
        result.setName(rs.getString("name"));
        result.setProfit(rs.getLong("profit"));
        result.setQuantity(rs.getLong("quantity"));
        result.setSalePrice(rs.getLong("sale_price"));
        result.setDate(rs.getLong("date"));
        result.setSize(rs.getString("size"));
        return result;
    }
}
