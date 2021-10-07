package uz.dosya.marketapp.service;

import uz.dosya.marketapp.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    List<Product> getAll();
    void delete(Long id);
}
