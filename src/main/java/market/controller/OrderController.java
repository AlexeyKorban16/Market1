package market.controller;

import fororders.OrderRequest;
import market.entity.Customer;
import market.entity.Product;
import market.repository.CustomerRepository;
import market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request) {

        return customerRepository.save(request.getCustomer());

    }
    @GetMapping

public List<Customer> findAllOrders(){
    return  customerRepository.findAll();
}
}