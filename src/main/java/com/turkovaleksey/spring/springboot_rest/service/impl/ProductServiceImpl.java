package com.turkovaleksey.spring.springboot_rest.service.impl;

import com.turkovaleksey.spring.springboot_rest.repository.api.ProductRepository;
import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphones;
import com.turkovaleksey.spring.springboot_rest.service.api.ProductService;
import com.turkovaleksey.spring.springboot_rest.service.converter.ProductConverter;
import com.turkovaleksey.spring.springboot_rest.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductConverter productConverter;

    @Autowired
    public void setEntity (ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @Override
    public List<ProductDto> getAll() {
        List<Smartphones> smartphones = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Smartphones smartphones : smartphones) {
            productDtos.add(productConverter.convertDto(smartphones));
        }
        return productDtos;
    }

    @Override
    public void saveOrUpdate(ProductDto entity) {
        Smartphones smartphones = productConverter.convertDao(entity);
        productRepository.save(smartphones);
    }

    @Override
    public ProductDto getByID(Integer id) {
        Optional<Smartphones> product = productRepository.findById(id);
        Smartphones p = product.orElse(null);
        return productConverter.convertDto(p);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

}
