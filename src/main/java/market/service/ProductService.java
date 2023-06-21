package market.service;

import jakarta.persistence.EntityNotFoundException;
import market.dto.ProductDto;
import market.entity.Product;
import market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return mapProductToDto(product);
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = mapProductDtoToProduct(productDto);
        return mapProductToDto(productRepository.save(product));
    }

    public ProductDto updateProduct(int id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setCapacity(productDto.getCapacity());

        return mapProductToDto(productRepository.save(product));
    }

    public void deleteProductById(Integer id) {
        productRepository.deleteById(id);
    }

    public Product mapProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setPrice(productDto.getPrice());
        product.setCapacity(productDto.getCapacity());
        return product;
    }

    private ProductDto mapProductToDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setPrice(product.getPrice());
        productDto.setCapacity(product.getCapacity());
        productDto.setId(product.getId());
        return productDto;

    }

    public List<ProductDto> mapProductsToDto(List<Product> products) {
        if (products == null) {
            return null;
        }
        List<ProductDto> productDto = new ArrayList<>();
        for (Product product : products) {
            productDto.add(mapProductToDto(product));
        }
        return productDto;
    }
}
