package com.i.minishopping.Controllers.ViewController.Product;

import com.i.minishopping.DTO.Product.ProductListResponse;
import com.i.minishopping.Services.Product.ProductViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductViewController {

    private final ProductViewService productViewService;
    @GetMapping("/productList")
    public String getProductList(Model model){
        System.out.println("/GET/productList");
        Pageable pageRange = PageRequest.of(0,4);
        List<ProductListResponse> products = productViewService.findAllByPage(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();
        System.out.println(products.get(2).getName());
        model.addAttribute("product",products);
        return "Main/Main";
    }
}
