package com.turkovaleksey.spring.springboot_rest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private String brand;
    private String model;
    private String description;
    private Double price;
    private String photo;
    private String category;
    private String shop;
}
