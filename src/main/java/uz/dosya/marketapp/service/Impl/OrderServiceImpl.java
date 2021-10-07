package uz.dosya.marketapp.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.dosya.marketapp.dto.OrderDto;
import uz.dosya.marketapp.dto.SaleProductDto;
import uz.dosya.marketapp.entity.Order;
import uz.dosya.marketapp.entity.Product;
import uz.dosya.marketapp.entity.SaleProduct;
import uz.dosya.marketapp.repository.OrderRepository;
import uz.dosya.marketapp.repository.ProductRepository;
import uz.dosya.marketapp.repository.SaleProductRepository;
import uz.dosya.marketapp.service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final SaleProductRepository saleProductRepository;

    @Override
    public Order save(OrderDto dto) {
        Order order = new Order();
        List<SaleProduct> productList = new ArrayList<>();
        Double totalPrice = 0.0;
        for (SaleProductDto sale : dto.getSaleProducts()) {
            totalPrice += sale.getSalePrice();
            Product product = productRepository.getById(sale.getProductId());
            product.setQuantity(product.getQuantity() - sale.getQuantity());
            SaleProduct saleProduct = new SaleProduct();
            saleProduct.setProduct(productRepository.save(product));
            saleProduct.setSalePrice(sale.getSalePrice());
            saleProduct.setQuantity(sale.getQuantity());
            saleProduct.setDate(new Date());
            saleProduct.setProfit(sale.getSalePrice() - saleProduct.getProduct().getPrice());
            productList.add(saleProductRepository.save(saleProduct));
        }
        order.setSaleProducts(productList);
        order.setTotalPrice(totalPrice);
        order.setDate(new Date());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
