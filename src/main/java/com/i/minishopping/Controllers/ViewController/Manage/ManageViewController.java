package com.i.minishopping.Controllers.ViewController.Manage;

import com.i.minishopping.DTOResponse.Manage.MProductListView;
import com.i.minishopping.Services.Product.ProductViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ManageViewController {

    private final ProductViewService productService;
    private final int PAGINGSIZE = 8;

    @GetMapping("/manage")
    public String ManagePageLoad() {
        return "Manage/Main";
    }

    @PostMapping("/GET/manage")
    public ResponseEntity<List<MProductListView>> getProduct() {
        Pageable pageRange = PageRequest.of(0, PAGINGSIZE);
        List<MProductListView> products = productService.managePdList(pageRange).stream()
                .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
                .toList();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/GET/manage/search")
    public ResponseEntity<List<MProductListView>> getProductByName(
            @RequestParam(name="id", required = false) Integer id,
            @RequestParam(name="name", required = false) String name){
        Pageable pageRange = PageRequest.of(0, PAGINGSIZE);
        List<MProductListView> list = null;
        if(id==null){
            list = productService.managePdListByName(pageRange, name).stream()
                    .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
                    .toList();
            return ResponseEntity.ok().body(list);
        }
        if(id == 1) {
            list = productService.managePdListByNameOrderByPrice(pageRange, name, "DESC").stream()
                    .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
                    .toList();
            return ResponseEntity.ok().body(list);
        }
        if(id == 2) { list = productService.managePdListByNameOrderByPrice(pageRange, name, "DESC").stream()
                .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
                .toList();
            return ResponseEntity.ok().body(list);
        }
        if(id == 3) { list = productService.managePdListByNameOrderByPrice(pageRange, name, "DESC").stream()
                .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
                .toList();
            return ResponseEntity.ok().body(list);
        }
        return ResponseEntity.ok().body(list);
    }
}
