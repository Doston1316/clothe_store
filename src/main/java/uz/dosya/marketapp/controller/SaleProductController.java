package uz.dosya.marketapp.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.dosya.marketapp.entity.SaleProduct;
import uz.dosya.marketapp.service.Impl.SaleProductServiceImpl;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
public class SaleProductController {

    private final SaleProductServiceImpl service;

    @GetMapping("")
    public List<SaleProduct> findAll(){
        return service.findAllSaleProducts();
    }


//    search
    @GetMapping("/search")
    public List<SaleProduct> findAllSearch(){
        return service.findAllSearch();
    }


}
