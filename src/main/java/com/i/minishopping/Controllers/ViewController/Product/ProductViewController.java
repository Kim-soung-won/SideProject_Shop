package com.i.minishopping.Controllers.ViewController.Product;

import com.i.minishopping.DTO.Product.Response.ProductListResponse;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.Product.ProductViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductViewController {

    private final ProductViewService productViewService;
    private final ProductService productService;
    private final int PAGINGSIZE = 10;

    @GetMapping("/productList")
    public String getProductList(){
        return "Main/Main";
    }
    @GetMapping("/product/{id}")
    public String getProductDetail(@PathVariable Long id, Model model, Authentication authentication){
        System.out.println("name : "+authentication.getName());
        System.out.println("prin : "+authentication.getPrincipal());
        System.out.println("detail : "+authentication.getDetails());
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "Main/Detail";
    }
    @PostMapping("/product/category")
    public ResponseEntity<List<ProductListResponse>> getByCategory(@RequestParam(name="id", required = false) String name){
        Pageable pageRange = PageRequest.of(0,PAGINGSIZE, Sort.by("count_love").descending());
        List<ProductListResponse> products = productViewService.findByCategory(pageRange, name).stream()
                .map(data -> new ProductListResponse(200,"success",data))
                .toList();;
        return ResponseEntity.ok(products);
    }

    @PostMapping("/product")
    public ResponseEntity<List<ProductListResponse>> getPopularList(
            @RequestParam(name="id", required = false) int param){
        Pageable pageRange=null;
        if(param == 1) {pageRange = PageRequest.of(0, PAGINGSIZE, Sort.by("count_love").descending());}
        if(param == 2) {pageRange = PageRequest.of(0, PAGINGSIZE, Sort.by("created_at").descending());}
        if(param == 3) {pageRange = PageRequest.of(0, PAGINGSIZE, Sort.by("pd_price").ascending());}
        if(param == 4) {pageRange = PageRequest.of(0, PAGINGSIZE, Sort.by("pd_price").descending());}
        List<ProductListResponse> products = productViewService.findPopularList(pageRange).stream()
                .map(data -> new ProductListResponse(200,"success",data))
                .toList();;
        return ResponseEntity.ok(products);
    }
}
