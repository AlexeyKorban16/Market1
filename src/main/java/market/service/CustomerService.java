package market.service;

import jakarta.persistence.EntityNotFoundException;
import market.dto.CustomerDto;
import market.dto.ProductDto;
import market.entity.Customer;
import market.entity.Product;
import market.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductService productService;

    public CustomerDto getCustomerById(int id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapCustomer(customer);
    }

    public CustomerDto updateCustomer(int id, CustomerDto customerDto) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setNumber(customerDto.getNumber());
        customer.setGender(customerDto.getGender());

        updateProducts(customerDto.getProducts(), customer);
        return mapCustomer(customerRepository.save(customer));


    }

    public CustomerDto mapCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        customerDto.setNumber(customer.getNumber());
        customerDto.setGender(customer.getGender());
        customerDto.setProducts(productService.mapProductsToDto(customer.getProducts()));
        return customerDto;
    }

    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setNumber(customerDto.getNumber());
        customer.setGender(customerDto.getGender());

        updateProducts(customerDto.getProducts(), customer);
        return mapCustomer(customerRepository.save(customer));
    }

    private void updateProducts(List<ProductDto> productDtos, Customer customer) {
        if (productDtos != null) {

            List<Product> products = new ArrayList<>();
            for (ProductDto productDto : productDtos) {
                Product product = productService.mapProductDtoToProduct(productDto);
                product.setCustomer(customer);
                products.add(product);
            }
            customer.setProducts(products);
        } else {
            customer.setProducts(null);
        }
    }

    public void deleteCustomerById(Integer id) {
        customerRepository.deleteById(id);
    }
}
