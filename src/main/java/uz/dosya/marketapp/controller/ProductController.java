package uz.dosya.marketapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.dosya.marketapp.entity.Product;
import uz.dosya.marketapp.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return service.save(product);
    }


    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

//    delete
    @PutMapping ("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable("id") Long id,
                          @RequestBody Product product) throws Exception {
        return service.update(id,product);
    }

    @GetMapping("/{name}")
    public List<Product>search(@PathVariable("name")String name){
        return service.search(name);
    }

    @GetMapping("/deleted")
    public List<Product> findAllDeleted() {
        return service.findAllDeleted();
    }


//    tugagan tovarlar
    @GetMapping("/finished")
    public List<Product> findAllFinishedProducts() {
        return service.findAllFinishedProducts();
    }


}
