package com.turkovaleksey.spring.springboot_rest.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmartphoneDto extends AbstractDto<Integer> {
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
