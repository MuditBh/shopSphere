package com.mudit.shopsphere.service;

import com.mudit.shopsphere.entity.Product;
import com.mudit.shopsphere.exception.ResourceNotFoundException;
import com.mudit.shopsphere.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // GET PRODUCT BY ID
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    //  DELETE PRODUCT
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}