package com.i.minishopping.Controllers.ViewController.Manage;

import com.i.minishopping.DTORequest.Param.ProductSortRequest;
import com.i.minishopping.DTOResponse.Manage.MProductListView;
import com.i.minishopping.Mapper.DTO.MProductSortAndOrder;
import com.i.minishopping.Services.MView.MProductService;
import com.i.minishopping.Services.Product.ProductViewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ManageViewController {

    private final ProductViewService productService;
    private final int PAGINGSIZE = 8;
    private final MProductService mProductService;

    @GetMapping("/manage")
    public String ManagePageLoad() {
        return "Manage/Main";
    }

    @PostMapping("/GET/manage")
    public ResponseEntity<List<MProductListView>> getProduct() {
        Pageable pageRange = PageRequest.of(0, PAGINGSIZE);
        List<MProductListView> products = productService.managePdList(pageRange).stream()
                .map(data -> new MProductListView(data.getId(), data.getBrandName(), data.getName(), data.getPrice(), data.getAmount(), data.getSales()))
                .toList();
        return ResponseEntity.ok().body(products);
    }

    @PostMapping("/GET/manage/search")
    public ResponseEntity<List<MProductListView>> getProductByName(
            @ModelAttribute ProductSortRequest request){
        int id = request.getId();
        String name = request.getName();
        String order = null;
        if(id > 0){
            if(id == 1) { order = "price DESC"; }
            if (id == 2){ order = "amount DESC"; }
            if (id == 3){ order = "sales DESC"; }
        }
        else {
            if(id == -1) { order = "price ASC"; }
            if (id == -2){ order = "amount ASC"; }
            if (id == -3){ order = "sales ASC"; }
        }
        System.out.println(order);
        MProductSortAndOrder data = new MProductSortAndOrder(name, order, 0, 10);
        List<MProductListView> list = mProductService.sortAndSearch(data);

        return ResponseEntity.ok().body(list);
    }

//    @PostMapping("/GET/manage/search")
//    public ResponseEntity<List<MProductListView>> getProductByName(
//            @RequestParam(name="id", required = false) Integer id,
//            @RequestParam(name="name", required = false) String name,
//            @RequestParam(name="order", required = false) String order){
//        Pageable pageRange = PageRequest.of(0, PAGINGSIZE);
//        List<MProductListView> list = null;
//        System.out.println(order);
//        if(id==null){
//            list = productService.managePdListByName(pageRange, name).stream()
//                    .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
//                    .toList();
//            return ResponseEntity.ok().body(list);
//        }
//        if(id == 1) {
//            list = productService.managePdListByNameOrderByPrice(pageRange, name, order).stream()
//                    .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
//                    .toList();
//            return ResponseEntity.ok().body(list);
//        }
//        if(id == 2) { list = productService.managePdListByNameOrderByAmount(pageRange, name, order).stream()
//                .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
//                .toList();
//            return ResponseEntity.ok().body(list);
//        }
//        if(id == 3) { list = productService.managePdListByNameOrderBySales(pageRange, name, order).stream()
//                .map(data -> new MProductListView(data.getId(), data.getBrand(), data.getName(), data.getPrice(), data.getAmount(), data.getSum()))
//                .toList();
//            return ResponseEntity.ok().body(list);
//        }
//        return ResponseEntity.ok().body(list);
//    }
}
