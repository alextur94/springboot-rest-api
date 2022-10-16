package com.turkovaleksey.spring.springboot_rest.repository.model.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "smartphones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Smartphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smartphone_id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "photo")
    private String photo;
    @Column(name = "price")
    private Double price;
    @Column(name = "shop_id")
    private Integer shop_id;
    @Column(name = "category_id")
    private Integer category_id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "memory")
    private Integer memory;

    public static class Builder {
        private Integer id;
        private String brand;
        private String model;
        private Integer memory;
        private String title;
        private String description;
        private String photo;
        private Double price;
        private Integer shop_id;
        private Integer category_id;

        public Builder() {
        }

        public Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder withDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder withPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        public Builder withShopId(Integer shop_id) {
            this.shop_id = shop_id;
            return this;
        }

        public Builder withCategoryId(Integer category_id) {
            this.category_id = category_id;
            return this;
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withMemory(Integer memory) {
            this.memory = memory;
            return this;
        }

        public Smartphone build() {
            Smartphone smartphone = new Smartphone();
            smartphone.title = this.title;
            smartphone.description = this.description;
            smartphone.photo = this.photo;
            smartphone.price = this.price;
            smartphone.shop_id = this.shop_id;
            smartphone.category_id = this.category_id;
            smartphone.id = this.id;
            smartphone.brand = this.brand;
            smartphone.model = this.model;
            smartphone.memory = this.memory;
            return smartphone;
        }
    }
}
