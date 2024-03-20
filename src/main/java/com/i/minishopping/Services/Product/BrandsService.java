package com.i.minishopping.Services.Product;

import com.i.minishopping.Domains.Product.Brands;
import com.i.minishopping.Repositorys.Product.BrandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandsService {
    private final BrandsRepository brandsRepository;

    public Brands saveBrand(String brandName){
        return brandsRepository.save(
                Brands.builder()
                        .brand_name(brandName)
                        .build()
        );
    }
    public Brands findById(Long id){
        return brandsRepository.findById(id).orElse(null);
    }

    public Brands findByName(String brandName){
        return brandsRepository.findByBrandName(brandName);
//      @Query("SELECT b FROM Brands b WHERE b.brand_name = ?1")
    }
}
