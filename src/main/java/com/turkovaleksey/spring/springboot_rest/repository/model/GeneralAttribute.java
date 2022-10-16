package com.turkovaleksey.spring.springboot_rest.repository.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public abstract class GeneralAttribute {
    @Column(name = "title")
    protected String title;
    @Column(name = "description")
    protected String description;
    @Column(name = "photo")
    protected String photo;
    @Column(name = "price")
    protected Double price;
    @Column(name = "shop_id")
    protected Integer shop_id;
    @Column(name = "category_id")
    protected Integer category_id;
}
