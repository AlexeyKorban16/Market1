package market.controller;

import market.dto.CustomerDto;
import market.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public CustomerDto getCustomerById(@PathVariable Integer id) {
        return customerService.getCustomerById(id);
    }
    @PutMapping("/{id}")
    public CustomerDto updateCustomerById(@PathVariable Integer id,@RequestBody CustomerDto customerDto){
        return  customerService.updateCustomer(id,customerDto);
    }
    @PostMapping
    public  CustomerDto createCustomerById(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }
    @DeleteMapping("/{id}")
    public  void deleteCustomerById(@PathVariable Integer id) {
         customerService.deleteCustomerById(id);
    }

}
