package uz.dosya.marketapp.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.dosya.marketapp.entity.Product;
import uz.dosya.marketapp.repository.ProductRepository;
import uz.dosya.marketapp.service.ProductService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public Product save(Product p) {
        Product product = new Product();
        product.setBrand(p.getBrand());
        product.setColor(p.getColor());
        product.setPrice(p.getPrice());
        product.setName(p.getName());
        product.setQuantity(p.getQuantity());
        product.setSize(p.getSize());
        return repository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAllByDeletedFalse();
    }

    @Override
    public void delete(Long id) {
        Product product = repository.getById(id);
        product.setDeleted(true);
        repository.save(product);
    }
}
