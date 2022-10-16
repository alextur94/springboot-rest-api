package com.turkovaleksey.spring.springboot_rest.service.converter;

public interface Converter<T, V> {
    T convertDao(V entity);
    V convertDto(T entity);
}
