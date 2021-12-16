package uz.dosya.marketapp.service.Impl;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.dosya.marketapp.dto.DebtorDto;
import uz.dosya.marketapp.dto.OrderDto;
import uz.dosya.marketapp.dto.SaleProductDto;
import uz.dosya.marketapp.enam.Status;
import uz.dosya.marketapp.entity.Debtor;
import uz.dosya.marketapp.entity.Order;
import uz.dosya.marketapp.entity.Product;
import uz.dosya.marketapp.entity.SaleProduct;
import uz.dosya.marketapp.repository.DebtorRepository;
import uz.dosya.marketapp.repository.OrderRepository;
import uz.dosya.marketapp.repository.ProductRepository;
import uz.dosya.marketapp.repository.SaleProductRepository;
import uz.dosya.marketapp.service.OrderService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final SaleProductRepository saleProductRepository;
    private final DebtorRepository debtorRepository;

    @Override
    public Order save(OrderDto dto, Long id) throws NotFoundException {
        Order order = new Order();
        List<SaleProduct> productList = new ArrayList<>();
        for (SaleProductDto sale : dto.getSaleProducts()) {
            Product product = productRepository.getById(id);
            product.setQuantity(product.getQuantity() - sale.getQuantity());
            if (product.getQuantity()<0){
                throw new  NotFoundException("Kechirasiz "+product.getName()+" bu turdagi mahsulot bazada yetarli emas");
            }
            SaleProduct saleProduct = new SaleProduct();
            saleProduct.setProduct(productRepository.save(product));
            saleProduct.setSalePrice(sale.getQuantity()*sale.getSalePrice());
            saleProduct.setQuantity(sale.getQuantity());
            saleProduct.setDate(new Date().getTime());
            saleProduct.setProfit(sale.getQuantity()*(sale.getSalePrice() - saleProduct.getProduct().getPrice()));
            saleProduct.setBrand(product.getBrand());
            saleProduct.setName(product.getName());
            saleProduct.setSize(product.getSize());
            saleProduct.setStatus(Status.NAXT);
            productList.add(saleProductRepository.save(saleProduct));
        }
        order.setSaleProducts(productList);
        return orderRepository.save(order);
    }

    @Override
    public Order saveDebt(OrderDto dto, DebtorDto debtorDto) throws NotFoundException {
        Order order = new Order();
        List<SaleProduct> productList = new ArrayList<>();
        for (SaleProductDto sale : dto.getSaleProducts()) {
            Product product = productRepository.getById(sale.getProductId());
            product.setQuantity(product.getQuantity() - sale.getQuantity());
            if (product.getQuantity()<0){
                throw new  NotFoundException("Kechirasiz "+product.getName()+" bu turdagi mahsulot bazada yetarli emas");
            }
            SaleProduct saleProduct = new SaleProduct();
            saleProduct.setProduct(productRepository.save(product));
            saleProduct.setSalePrice(sale.getQuantity()*sale.getSalePrice());
            saleProduct.setQuantity(sale.getQuantity());
            saleProduct.setDate(new Date().getTime());
            saleProduct.setProfit(sale.getQuantity()*(sale.getSalePrice() - saleProduct.getProduct().getPrice()));
            saleProduct.setBrand(product.getBrand());
            saleProduct.setName(product.getName());
            saleProduct.setSize(product.getSize());
            saleProduct.setStatus(Status.NASIYA);
            productList.add(saleProductRepository.save(saleProduct));
        }
        order.setSaleProducts(productList);
        return orderRepository.save(order);
    }




    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
