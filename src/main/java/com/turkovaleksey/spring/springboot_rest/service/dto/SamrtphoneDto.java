package com.turkovaleksey.spring.springboot_rest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SamrtphoneDto {
    private Integer id;
    private String title;
    private String description;
    private String photo;
    private Double price;
    private String brand;
    private String model;
    private Integer memory;
    private Integer categoryId;
    private Integer shopId;
}
