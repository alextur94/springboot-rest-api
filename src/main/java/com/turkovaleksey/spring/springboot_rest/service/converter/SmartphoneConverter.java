package com.turkovaleksey.spring.springboot_rest.service.converter;

import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphone;
import com.turkovaleksey.spring.springboot_rest.service.dto.SamrtphoneDto;
import org.springframework.stereotype.Component;

@Component
public class SmartphoneConverter implements Converter<Smartphone, SamrtphoneDto> {
    @Override
    public Smartphone convertDao(SamrtphoneDto entity) {
        return null;
    }

    @Override
    public SamrtphoneDto convertDto(Smartphone entity) {
        return null;
    }
}
