package uz.dosya.marketapp.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.dosya.marketapp.entity.SaleProduct;
import uz.dosya.marketapp.excel.SaleProductExcelExport;
import uz.dosya.marketapp.service.Impl.SaleProductServiceImpl;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sale")
@RequiredArgsConstructor
public class SaleProductController {

    private final SaleProductServiceImpl service;

    @GetMapping()
    public List<SaleProduct> findAll() {
        return service.findAllSaleProducts();
    }


    //    count
    @GetMapping("/count")
    public List<SaleProduct> findAllSearch(@RequestParam Long start, @RequestParam Long end) {
        return service.findAllSearch(start, end);
    }

    @PutMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        String headerKey = "Content-Disposition";
        String headerValue = " attachement; fileName=saleProduct.xlsx";

        response.setHeader(headerKey, headerValue);
        List<SaleProduct> saleProducts = service.findAll();

        SaleProductExcelExport excelExport = new SaleProductExcelExport(saleProducts);
        excelExport.export(response);
    }

//    search
    @GetMapping("/{name}")
    public List<SaleProduct>saleProducts(@PathVariable("name") String name){
        return service.search(name);
    }

    @PutMapping("/vozvrat/{id}")
    public void vozvrat(@PathVariable Long id) {
        service.vozvrat(id);
    }


}
