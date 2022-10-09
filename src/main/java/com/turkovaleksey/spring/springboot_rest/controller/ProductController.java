package com.turkovaleksey.spring.springboot_rest.controller;

import com.turkovaleksey.spring.springboot_rest.controller.api.ControllerAPI;
import com.turkovaleksey.spring.springboot_rest.repository.model.product.Product;
import com.turkovaleksey.spring.springboot_rest.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController implements ControllerAPI<Product, Integer> {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @GetMapping("/")
    public List<Product> getAll() {
        List<Product> productList = productService.getAll();
        return productList;
    }

    @Override
    @PutMapping("/")
    public Product saveOrUpdate(@RequestBody Product entity) {
        productService.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @GetMapping("/{id}")
    public Product getById(@PathVariable Integer id) {
        Product product = productService.getByID(id);
        return product;
    }

    @Override
    public String deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return "Employee with ID = " + id + " was deleted";
    }
}
