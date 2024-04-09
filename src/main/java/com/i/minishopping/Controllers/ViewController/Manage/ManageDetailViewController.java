package com.i.minishopping.Controllers.ViewController.Manage;

import com.i.minishopping.DTOResponse.Manage.MProductDetailView;
import com.i.minishopping.Services.MView.MProductDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ManageDetailViewController {
    private final MProductDetailService detailService;
    @GetMapping("/manage/product/")
    public String getProudctDetail(@RequestParam Long id, Model model) {
        MProductDetailView response = detailService.getDetail(id);
        model.addAttribute("data", response);
        System.out.println("data : " + response.getDetails());
        return "Manage/Detail";
    }
}
