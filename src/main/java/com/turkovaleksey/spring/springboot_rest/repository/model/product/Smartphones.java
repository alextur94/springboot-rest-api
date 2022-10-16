package com.turkovaleksey.spring.springboot_rest.repository.model.product;

import com.turkovaleksey.spring.springboot_rest.repository.model.GeneralAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
public class Smartphones extends GeneralAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "smartphone_id")
    protected Integer id;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "memory")
    private String memory;



//    public static class Builder {
//        private Integer id;
//
//        public Builder() {
//        }
//
//        public Builder withId(Integer id) {
//            this.id = id;
//            return this;
//        }
//
//        public Smartphones build() {
//            Smartphones smartphones = new Smartphones();
//            smartphones.id = this.id;
//
//            return smartphones;
//        }
//    }
}
