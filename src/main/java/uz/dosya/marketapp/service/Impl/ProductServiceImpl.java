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
    public Product findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Product update(Long id, Product product) throws Exception {
        Product newProduct=repository.findById(id).get();
        newProduct.setId(id);
        newProduct.setQuantity(product.getQuantity());
        if (newProduct.getQuantity()<=0){
            throw new Exception("Kechirasiz tovar soni 0 dan katta bo'lishi lozim");
        }
        newProduct.setPrice(product.getPrice());
        newProduct.setSize(product.getSize());
        newProduct.setColor(product.getColor());
        newProduct.setBrand(product.getBrand());
        newProduct.setName(product.getName());
        return repository.save(newProduct);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAllByDeletedFalse();
    }

    @Override
    public List<Product> search(String name) {
        return repository.search(name);
    }

    @Override
    public List<Product> findAllDeleted() {
        return repository.findAllByDeletedTrue();
    }

    @Override
    public List<Product> findAllFinishedProducts() {
        return repository.findByAllFinishedProducts();
    }


    @Override
    public void delete(Long id) {
        Product product = repository.getById(id);
        product.setDeleted(true);
        repository.save(product);
    }
}
