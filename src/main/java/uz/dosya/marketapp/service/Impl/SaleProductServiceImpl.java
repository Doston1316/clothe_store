package uz.dosya.marketapp.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import uz.dosya.marketapp.enam.Status;
import uz.dosya.marketapp.entity.Product;
import uz.dosya.marketapp.entity.SaleProduct;
import uz.dosya.marketapp.mapper.CalculationSaleProductDto;
import uz.dosya.marketapp.mapper.SaleProductMapper;
import uz.dosya.marketapp.repository.ProductRepository;
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
    private final ProductRepository productRepository;


    String query = "select * from Sale_product as s where s.status not like 'VOZVRAT' order by s.date desc";

    public List<SaleProduct> findAllSaleProducts() {
        return template.query(query, mapper);
    }

    public List<SaleProduct>findAll(){
        return repository.findAll();
    }



    public List<SaleProduct> findAllSearch(Long start, Long end) {
        String searchQuery = "select  sum(quantity) as quantity, sum(sale_price) as sale_price,sum(profit) as " +
                "profit from sale_product where date between "+start+" and "+end+" and status NOT like 'NASIYA'";
        return template.query(searchQuery, dto);
    }


    public void delete(Long id) {
        SaleProduct saleProduct = repository.getById(id);
        saleProduct.setDeleted(true);
        saleProduct.setStatus(Status.NAXT);
        repository.save(saleProduct);
    }


    public void vozvrat(Long id) {
        SaleProduct saleProduct = repository.getById(id);
        Product product=productRepository.getById(saleProduct.getProduct().getId());
        saleProduct.setStatus(Status.VOZVRAT);
        product.setQuantity(product.getQuantity()+saleProduct.getQuantity());
        saleProduct.setSize("0");
        saleProduct.setName("0");
        saleProduct.setProfit(0l);
        saleProduct.setBrand("0");
        saleProduct.setSalePrice(0l);
        saleProduct.setQuantity(0l);
        repository.save(saleProduct);
    }

    public List<SaleProduct>search(String name){
        return repository.search(name);
    }


}
