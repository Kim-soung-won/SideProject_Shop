package com.i.minishopping.Controllers.ApiController.Brands;

import com.i.minishopping.DTO.Brands.AddBrandsRequest;
import com.i.minishopping.Domains.Product.Brands;
import com.i.minishopping.Services.BrandsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BrandsApiController {
    private final BrandsService brandsService;

    @PostMapping("/api/POST/brands")
    public ResponseEntity<Brands> addBrand(@RequestBody @Valid AddBrandsRequest request){
        Brands brands = brandsService.saveBrand(request.getBrandName());
        return ResponseEntity.status(HttpStatus.CREATED).body(brands);
    }
}
