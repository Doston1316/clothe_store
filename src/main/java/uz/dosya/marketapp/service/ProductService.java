package uz.dosya.marketapp.service;

import uz.dosya.marketapp.entity.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);
    Product findById(Long id);
    Product update(Long id,Product product) throws Exception;
    List<Product> getAll();
    List<Product> search(String name);
    List<Product>findAllDeleted();
    List<Product>findAllFinishedProducts();
    void delete(Long id);
}
