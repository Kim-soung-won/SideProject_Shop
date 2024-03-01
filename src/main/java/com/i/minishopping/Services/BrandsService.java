package com.i.minishopping.Services;

import com.i.minishopping.Domains.Brands;
import com.i.minishopping.Repositorys.BrandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandsService {
    private final BrandsRepository brandsRepository;

    public Brands saveBrand(String brandName){
        return brandsRepository.save(new Brands(brandName));
    }

    public Brands findByName(String brandName){
        return brandsRepository.findByBrandName(brandName);
    }
}
