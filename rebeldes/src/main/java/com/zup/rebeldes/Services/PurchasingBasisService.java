package com.zup.rebeldes.Services;

import com.zup.rebeldes.Models.PurchasingBasis;
import com.zup.rebeldes.Models.Rebellious;
import com.zup.rebeldes.Repositories.PurchasingBasisRepository;
import com.zup.rebeldes.dtos.PurchasingBasisRequest;
import com.zup.rebeldes.dtos.PurchasingBasisResponse;
import com.zup.rebeldes.dtos.PurchasingInventoryRequest;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class PurchasingBasisService {
    @Autowired
    private PurchasingBasisRepository purchasingBasisRepository;
    @Autowired
    private ModelMapper modelMapper;

    public PurchasingBasisResponse create(PurchasingBasisRequest purchasingBasisRequest){
        PurchasingBasis purchasingBasis = new PurchasingBasis();
        modelMapper.map(purchasingBasisRequest,purchasingBasis);
        purchasingBasisRepository.save(purchasingBasis);
        return modelMapper.map(purchasingBasis,PurchasingBasisResponse.class);
    }
    public List<PurchasingBasisResponse> getAlls(){
        return purchasingBasisRepository.findAll()
                .stream().map(purchasingBasis -> modelMapper.map(purchasingBasis,PurchasingBasisResponse.class)).toList();
    }

    public PurchasingBasis findByName(String name){
        return purchasingBasisRepository.findByName(name)
                        .orElseThrow(()->new EntityNotFoundException("Produto não encontrado"));
    }

}
