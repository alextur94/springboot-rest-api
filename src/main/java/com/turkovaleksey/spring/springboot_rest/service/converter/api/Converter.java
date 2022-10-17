package com.turkovaleksey.spring.springboot_rest.service.converter.api;

import com.turkovaleksey.spring.springboot_rest.service.dto.AbstractDto;

public interface Converter<T, V extends AbstractDto> {
    T convert(V entity);
    V convert(T entity);
}
