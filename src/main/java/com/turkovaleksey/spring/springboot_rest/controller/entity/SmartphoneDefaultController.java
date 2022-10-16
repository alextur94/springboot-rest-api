package com.turkovaleksey.spring.springboot_rest.controller.entity;

import com.turkovaleksey.spring.springboot_rest.controller.api.DefaultController;
import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphone;
import com.turkovaleksey.spring.springboot_rest.service.api.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/smartphones")
public class SmartphoneDefaultController implements DefaultController<Smartphone, Integer> {

    private SmartphoneService smartphoneService;

    @Autowired
    public void setProductService(SmartphoneService smartphoneService) {
        this.smartphoneService = smartphoneService;
    }

    @Override
    @GetMapping("/")
    public List<Smartphone> getAll() {
        List<Smartphone> productList = smartphoneService.getAll();
        return productList;
    }

    @Override
    @PutMapping("/")
    public Smartphone saveOrUpdate(@RequestBody Smartphone entity) {
        smartphoneService.saveOrUpdate(entity);
        return entity;
    }

    @Override
    @GetMapping("/{id}")
    public Smartphone getById(@PathVariable Integer id) {
        Smartphone smartphone = smartphoneService.getByID(id);
        return smartphone;
    }

    @Override
    public String deleteById(@PathVariable Integer id) {
        smartphoneService.deleteById(id);
        return "Device with ID = " + id + " was deleted";
    }

}
