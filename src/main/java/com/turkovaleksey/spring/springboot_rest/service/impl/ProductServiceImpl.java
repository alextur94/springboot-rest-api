package com.turkovaleksey.spring.springboot_rest.service.impl;

import com.turkovaleksey.spring.springboot_rest.repository.api.ProductRepository;
import com.turkovaleksey.spring.springboot_rest.repository.model.product.Product;
import com.turkovaleksey.spring.springboot_rest.service.api.ProductService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Product entity) {
        productRepository.save(entity);
    }

    @Override
    public Product getByID(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

}
