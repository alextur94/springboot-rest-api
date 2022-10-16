package com.turkovaleksey.spring.springboot_rest.controller.entity;

import com.turkovaleksey.spring.springboot_rest.controller.api.ControllerAPI;
import com.turkovaleksey.spring.springboot_rest.service.api.ProductService;
import com.turkovaleksey.spring.springboot_rest.service.converter.ProductConverter;
import com.turkovaleksey.spring.springboot_rest.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController implements ControllerAPI<ProductDto, Integer> {

    private ProductService productService;
    private ProductConverter productConverter;

    @Autowired
    public void setProductService(ProductService productService, ProductConverter productConverter) {
        this.productService = productService;
        this.productConverter = productConverter;
    }

    @Override
    @GetMapping("/")
    public List<ProductDto> getAll() {
        List<ProductDto> productList = productService.getAll();
        return productList;
    }

    @Override
    @PutMapping("/")
    public ProductDto saveOrUpdate(@RequestBody ProductDto entity) {
        productService.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Integer id) {
        ProductDto productDto = productService.getByID(id);
        return productDto;
    }

    @Override
    public String deleteById(@PathVariable Integer id) {
        productService.deleteById(id);
        return "Employee with ID = " + id + " was deleted";
    }

}
