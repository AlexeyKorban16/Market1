package market.controller;

import market.dto.ProductDto;
import market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public ProductDto updateProductById(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    @PostMapping
    public ProductDto createProductById(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

}
