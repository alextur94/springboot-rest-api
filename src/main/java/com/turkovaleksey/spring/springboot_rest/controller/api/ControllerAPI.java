package com.turkovaleksey.spring.springboot_rest.controller.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ControllerAPI<T, K> {
    List<T> getAll();
    T getById(@PathVariable K id);
    T saveOrUpdate(@RequestBody T entity);
    String deleteById(@PathVariable K id);
}
