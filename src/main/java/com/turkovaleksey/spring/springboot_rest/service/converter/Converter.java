package com.turkovaleksey.spring.springboot_rest.service.converter;

import com.turkovaleksey.spring.springboot_rest.service.dto.AbstractDto;

public interface Converter<T, V extends AbstractDto> {
    T convert(V value);
    V convert(T value);
}
