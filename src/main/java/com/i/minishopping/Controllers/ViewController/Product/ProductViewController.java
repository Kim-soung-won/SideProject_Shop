package com.i.minishopping.Controllers.ViewController.Product;

import com.i.minishopping.DTO.Product.ProductListResponse;
import com.i.minishopping.Services.Product.ProductViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductViewController {

    private final ProductViewService productViewService;
    @GetMapping("/api/GET/productList")
    public List<ProductListResponse> getProductList(){
        System.out.println("/GET/productList");
        Pageable pageRange = PageRequest.of(0,5);
        List<ProductListResponse> products = productViewService.findAllByPage(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();

        return products;
    }
}
