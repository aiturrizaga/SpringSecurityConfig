package pe.edu.vallegrande.securityrestdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.edu.vallegrande.securityrestdemo.entity.Product;
import pe.edu.vallegrande.securityrestdemo.error.ProductNotFoundException;
import pe.edu.vallegrande.securityrestdemo.repository.ProductRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // Find all products
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }

    // Save new product
    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product newProduct(@Valid @RequestBody Product newProduct) {
        return this.productRepository.save(newProduct);
    }

    // Find one product by id
    @GetMapping("/products/{id}")
    public Product findOneProduct(@PathVariable Long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    // Save or update product
    @PutMapping("/products/{id}")
    public Product saveOrUpdateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return this.productRepository.findById(id)
                .map(prod -> {
                    prod.setName(newProduct.getName());
                    prod.setBrand(newProduct.getBrand());
                    prod.setPrice(newProduct.getPrice());
                    prod.setCategory(newProduct.getCategory());
                    prod.setStatus(newProduct.getStatus());
                    return this.productRepository.save(prod);
                }).orElseGet(() -> {
                    newProduct.setId(id);
                    return this.productRepository.save(newProduct);
                });
    }

    // Delete product by id
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        this.productRepository.deleteById(id);
    }
}
