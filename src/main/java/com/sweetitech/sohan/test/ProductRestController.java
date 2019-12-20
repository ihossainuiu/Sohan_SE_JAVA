package com.sweetitech.sohan.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllEmployees() {
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getEmployeeById(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + employeeId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/products")
    public Product createEmployee(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateEmployee(@PathVariable(value = "id") Long employeeId,
                                                  @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Products not found for this id :: " + employeeId));

        product.setPercentage(productDetails.getPercentage());
        product.setPrice(productDetails.getPrice());
        product.setName(productDetails.getName());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/products/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
            throws ResourceNotFoundException {
        Product product = productRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Products not found for this id :: " + employeeId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}