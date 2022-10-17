package com.turkovaleksey.spring.springboot_rest.service.impl;

import com.turkovaleksey.spring.springboot_rest.repository.api.product.SmartphoneRepository;
import com.turkovaleksey.spring.springboot_rest.repository.model.product.Smartphone;
import com.turkovaleksey.spring.springboot_rest.service.api.SmartphoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneServiceImpl implements SmartphoneService {

    private SmartphoneRepository smartphoneRepository;

    @Autowired
    public void setEntity (SmartphoneRepository smartphoneRepository) {
        this.smartphoneRepository = smartphoneRepository;
    }

    @Override
    public List<Smartphone> getAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public void saveOrUpdate(Smartphone entity) {
        smartphoneRepository.save(entity);
    }

    @Override
    public Smartphone getByID(Integer id) {
        Optional<Smartphone> product = smartphoneRepository.findById(id);
        return product.orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        smartphoneRepository.deleteById(id);
    }

}
