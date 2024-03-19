package com.i.minishopping.Controllers.ViewController.Product;

import com.i.minishopping.DTO.Product.ProductListResponse;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.Product.ProductViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductViewController {

    private final ProductViewService productViewService;
    private final ProductService productService;
    private final int PAGINGSIZE = 4;
    @GetMapping("/productList")
    public String getProductList(Model model){
        Pageable pageRange = PageRequest.of(0,PAGINGSIZE);
        List<ProductListResponse> products = productViewService.findAllByPage(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();
        System.out.println(products.get(2).getName());
        model.addAttribute("product",products);
        return "Main/Main";
    }
    @GetMapping("/product/{id}")
    public String getProductDetail(@PathVariable Long id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "Main/Detail";
    }
    @PostMapping("/product/category/{name}")
    public ResponseEntity<List<ProductListResponse>> getPopularList(Model model){
        Pageable pageRange = PageRequest.of(0,PAGINGSIZE);
        List<ProductListResponse> products = productViewService.findPopularList(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();;
        return ResponseEntity.ok(products);
    }

    @PostMapping("/product/{sortBy}")
    public ResponseEntity<List<ProductListResponse>> getPopularList(@PathVariable String sortBy){
        Pageable pageRange = PageRequest.of(0,PAGINGSIZE);
        List<ProductListResponse> products = productViewService.findPopularList(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();;
        return ResponseEntity.ok(products);
    }
    @PostMapping("/product/latest")
    public ResponseEntity<List<ProductListResponse>> getLatestList(){
        Pageable pageRange = PageRequest.of(0,PAGINGSIZE);
        List<ProductListResponse> products = productViewService.findLatestList(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();;
        return ResponseEntity.ok(products);
    }
    @PostMapping("/product/highPrice")
    public ResponseEntity<List<ProductListResponse>> getHighPriceList(){
        Pageable pageRange = PageRequest.of(0,PAGINGSIZE);
        List<ProductListResponse> products = productViewService.findHighPriceList(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();;
        return ResponseEntity.ok(products);
    }
    @PostMapping("/product/lowPrice")
    public ResponseEntity<List<ProductListResponse>> getLowPriceList(){
        Pageable pageRange = PageRequest.of(0,PAGINGSIZE);
        List<ProductListResponse> products = productViewService.findLowPriceList(pageRange).stream()
                .map(ProductListResponse::new)
                .toList();;
        return ResponseEntity.ok(products);
    }
}
