package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.PurchasingBasis;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Repositories.PurchasingBasisRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PurchasingBasisService {
    @Autowired
    private PurchasingBasisRepository purchasingBasisRepository;

    public PurchasingBasis create(PurchasingBasis purchasingBasis){
        return purchasingBasisRepository.save(purchasingBasis);
    }
    public List<PurchasingBasis> getAlls(){
        return purchasingBasisRepository.findAll();
    }


}
