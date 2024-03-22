package com.i.minishopping.Services.Product;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Brand;
import com.i.minishopping.Repositorys.Product.BrandsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandsRepository brandsRepository;

    public Brand saveBrand(String brandName, Created created){
        return brandsRepository.save(
                Brand.builder()
                        .brand_name(brandName)
                        .created(created)
                        .build()
        );
    }
    public Brand findById(Long id){
        return brandsRepository.findById(id).orElse(null);
    }

    public Brand findByName(String brandName){
        return brandsRepository.findByBrandName(brandName);
//      @Query("SELECT b FROM Brand b WHERE b.brand_name = ?1")
    }
}
