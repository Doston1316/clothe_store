package uz.dosya.marketapp.service;

import javassist.NotFoundException;
import org.aspectj.weaver.ast.Or;
import uz.dosya.marketapp.dto.OrderDto;
import uz.dosya.marketapp.entity.Order;

import java.util.List;

public interface OrderService {

    Order save(OrderDto dto) throws NotFoundException;

    List<Order> getAll();
}
