package com.turkovaleksey.spring.springboot_rest.service.converter;

import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphones;
import com.turkovaleksey.spring.springboot_rest.service.dto.ProductDto;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<Smartphones, ProductDto> {
    @Override
    public Smartphones convertDao(ProductDto entity) {
        return null;
    }

    @Override
    public ProductDto convertDto(Smartphones entity) {
        return null;
    }
}
