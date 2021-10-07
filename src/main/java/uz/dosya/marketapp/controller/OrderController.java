package uz.dosya.marketapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.dosya.marketapp.dto.OrderDto;
import uz.dosya.marketapp.entity.Order;
import uz.dosya.marketapp.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @PostMapping
    public Order save(@RequestBody OrderDto dto) {
        return service.save(dto);
    }

    @GetMapping
    public List<Order> getAll() {
        return service.getAll();
    }
}
