package uz.dosya.marketapp.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import uz.dosya.marketapp.entity.SaleProduct;
import uz.dosya.marketapp.mapper.CalculationSaleProductDto;
import uz.dosya.marketapp.mapper.SaleProductMapper;
import uz.dosya.marketapp.repository.SaleProductRepository;
import uz.dosya.marketapp.service.SaleProductService;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SaleProductServiceImpl implements SaleProductService {


    private final SaleProductRepository repository;
    private final NamedParameterJdbcTemplate template;
    private final SaleProductMapper mapper;
    private final CalculationSaleProductDto dto;


    String query = "select * from Sale_product s order by s.date desc";

    public List<SaleProduct> findAllSaleProducts() {
        return template.query(query, mapper);
    }



    public List<SaleProduct> findAllSearch(Long start, Long end) {
        String searchQuery = "select  sum(quantity) as quantity, sum(sale_price) as sale_price,sum(profit) as " +
                "profit from sale_product where date between "+start+" and "+end;
        return template.query(searchQuery, dto);
    }



}
