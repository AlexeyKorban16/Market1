package market.service;

import jakarta.persistence.EntityNotFoundException;
import market.dto.CustomerDto;
import market.entity.Customer;
import market.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductService productService;

    public CustomerDto getCustomerById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);




        return  mapCustomer(customer);
    }
    public CustomerDto updateCustomer(int id,CustomerDto customerDto){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setNumber(customerDto.getNumber());
        customer.setGender(customerDto.getGender());


     return mapCustomer( customerRepository.save(customer)) ;


    }
    public  CustomerDto mapCustomer(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setNumber(customer.getNumber());
        customerDto.setGender(customer.getGender());
        customerDto.setProducts(productService.mapProductsToDto(customer.getProducts()));
        return  customerDto;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer=new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setNumber(customerDto.getNumber());
        customer.setGender(customerDto.getGender());
        return  mapCustomer(customerRepository.save(customer));
    }

    public   void deleteCustomerById(Integer id) {
         customerRepository.deleteById(id) ;
    }
}
