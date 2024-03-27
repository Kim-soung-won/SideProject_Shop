package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.DTORequest.Brands.AddBrandsRequest;
import com.i.minishopping.DTOResponse.Product.BrandAddResponse;
import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Brand;
import com.i.minishopping.Domains.User.UserInfo;
import com.i.minishopping.Services.Product.BrandService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class BrandsApiController {
    private final BrandService brandsService;

    @PostMapping("/api/POST/brands")
    public ResponseEntity<BrandAddResponse> addBrand(@RequestBody @Valid AddBrandsRequest request,
                                                     HttpSession session){
        UserInfo user = (UserInfo) session.getAttribute("user");
        Created created = new Created(user, LocalDateTime.now());
        Brand brand = brandsService.saveBrand(request.getBrandName(), created);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new BrandAddResponse(
                        201,
                        "Brand Added Successfully",
                        brand.getBrand_name())
        );
    }
}
