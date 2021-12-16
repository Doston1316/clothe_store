package uz.dosya.marketapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.dosya.marketapp.entity.Product;
import uz.dosya.marketapp.excel.ProductExcelExport;
import uz.dosya.marketapp.service.ProductService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    @PutMapping("{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@PathVariable("id") Long id,
                          @RequestBody Product product) throws Exception {
        return service.update(id, product);
    }

    @GetMapping("/{name}")
    public List<Product> search(@PathVariable("name") String name) {
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


    //    excel
    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = " attachement; fileName=AllProducts.xlsx";

        response.setHeader(headerKey,headerValue);
        List<Product>products=service.getAll();

        ProductExcelExport productExcelExport=new ProductExcelExport(products);
        productExcelExport.export(response);
    }


}
