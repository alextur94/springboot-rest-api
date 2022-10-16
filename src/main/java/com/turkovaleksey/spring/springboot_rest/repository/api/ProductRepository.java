package com.turkovaleksey.spring.springboot_rest.repository.api;

import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Smartphones, Integer> {
}
