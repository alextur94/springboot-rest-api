package com.turkovaleksey.spring.springboot_rest.repository.api.product;

import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
