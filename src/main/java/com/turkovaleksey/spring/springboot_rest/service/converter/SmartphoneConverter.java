package com.turkovaleksey.spring.springboot_rest.service.converter;

import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphone;
import com.turkovaleksey.spring.springboot_rest.service.converter.api.Converter;
import com.turkovaleksey.spring.springboot_rest.service.dto.SmartphoneDto;
import org.springframework.stereotype.Component;

@Component
public class SmartphoneConverter implements Converter<Smartphone, SmartphoneDto> {
    @Override
    public Smartphone convert(SmartphoneDto entity) {
        return null;
    }

    @Override
    public SmartphoneDto convert(Smartphone entity) {
        return null;
    }
}
