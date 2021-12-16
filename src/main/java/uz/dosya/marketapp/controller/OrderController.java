package uz.dosya.marketapp.controller;

import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.dosya.marketapp.dto.OrderDto;
import uz.dosya.marketapp.entity.Order;
import uz.dosya.marketapp.repository.DebtorRepository;
import uz.dosya.marketapp.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@AllArgsConstructor
public class OrderController {

    private OrderService service;
    private DebtorRepository debtorRepository;

    @PostMapping("/{id}")
    public Order save(@PathVariable("id") Long id,
                      @RequestBody OrderDto dto) throws NotFoundException {
        return service.save(dto,id);
    }


    @PostMapping("/debt/{id}")
    public Order saveDebtor(@PathVariable("id") Long id,
                      @RequestBody OrderDto dto) throws NotFoundException {
        return service.save(dto,id);
    }

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }
}
