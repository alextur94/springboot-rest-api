package com.trurkovaleksey.spring.boot.sprinbboot_rest.dao.api;

import java.util.List;

public interface Dao<T> {
    List<T> gelAll();

    void saveOrUpdate(T entity);

    T getByID(Integer id);

    void deleteById(Integer id);
}
