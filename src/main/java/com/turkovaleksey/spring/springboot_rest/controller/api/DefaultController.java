package com.turkovaleksey.spring.springboot_rest.controller.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DefaultController<T, K> {
    List<T> getAll();
    T saveOrUpdate(@RequestBody T entity);
    T getById(@PathVariable K id);
    String deleteById(@PathVariable K id);
}
