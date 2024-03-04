package com.i.minishopping.Controllers.ApiController.Product;

import com.i.minishopping.Domains.EMBEDDED.Created;
import com.i.minishopping.Domains.Product.Product;
import com.i.minishopping.Services.Product.ProductService;
import com.i.minishopping.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
public class AiSettingApiController {

    private final ProductService productService;
    private final UserService userService;
    private static ArrayList<String>[] arr = new ArrayList[10];


    @PostMapping("/api/POST/DataSet")
    public void saveDataSet(){
        setListKor();
        for(int j=1; j<=5000; j++) {
            StringBuilder sb = new StringBuilder();
            Product product = new Product();
            product.setName(j+"번옷");
            product.setPrice((int) (Math.random() * 20+1) * 10000);
            Created created = new Created();
            created.setCreated_who(userService.findById(1L));
            created.setCreated_at(LocalDateTime.now());
            product.setCreated(created);
            for (int i = 0; i < 10; i++) {
                String str = arr[i].get((int) (Math.random() * arr[i].size()));
                if (i < 9)
                    sb.append(str).append(",");
                else
                    sb.append(str);
            }
            System.out.println("번째 : " + sb);
            String categorys = String.valueOf(sb);
            product.setCategory(categorys);
            System.out.println("product : " + product);
            productService.saveManyProduct(product);
        }
    }
    public void setList(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] style = {"Casual", "Formal", "Business", "Vintage", "Luxury", "Street", "Rough", "Cute", "Sophisticated", "Classic", "Funky", "Hipster", "Sports", "Retro", "Bohemian", "Elegant", "Modern", "Minimalist", "Unique", "Classic", "Comfortable", "Trendy", "Avant-garde" };
        String[] material = {"Cotton", "Silk", "Denim", "Linen", "Wool", "Leather", "Fleece", "Cashmere", "Velvet", "Corduroy", "Tweed", "Polyester", "Rayon", "Chiffon", "Knit", "Camouflage", "Zipper", "Check", "Stripe", "Pattern" };
        String[] color = {"Black", "White", "Red", "Blue", "Green", "Yellow", "Pink", "Orange", "Purple", "Brown", "Gray", "Gold", "Silver", "Navy", "Burgundy", "Teal", "Mustard", "Khaki", "Mint", "Rose Gold" };
        String[] size = {"S", "M", "L", "XL", "XXL", "Plus Size", "Petite Size", "Custom Size", "Loose Fit", "Slim Fit", "Regular Fit" };
        String[] season = {"Spring", "Summer", "Fall", "Winter", "Off-season", "New Arrival", "Discounted Items" };
        String[] place = {"Business", "Party", "Date", "Casual", "Beach", "Club", "Sports", "School", "Home", "Travel", "Fitness", "Health", "Yoga" };
        String[] part = {"Top", "Bottom", "Outer", "Dress", "Underwear", "Accessory" };
        String[] brand = {"Domestic Brand", "Overseas Brand", "Designer Brand", "High-end Brand", "Cheap Brand", "Famous Brand", "Luxury Brand" };
        String[] feature = {"Eco-friendly", "Handmade", "Recycle", "Organic", "Vegan", "Sustainable", "Limited Edition", "Custom Made" };
        String[] target = {"Women", "Men", "Children", "Teenagers", "Adults", "Silver Generation", "Newlyweds", "College Students", "Office Workers", "Infants", "Pregnant Women" };
        for(int i=0; i<10; i++) arr[i] = new ArrayList<String>();
        for(int i=0; i<style.length; i++) arr[0].add(style[i]);
        for(int i=0; i<material.length; i++) arr[1].add(material[i]);
        for(int i=0; i<color.length; i++) arr[2].add(color[i]);
        for(int i=0; i<size.length; i++) arr[3].add(size[i]);
        for(int i=0; i<season.length; i++) arr[5].add(season[i]);
        for(int i=0; i<place.length; i++) arr[4].add(place[i]);
        for(int i=0; i<part.length; i++) arr[6].add(part[i]);
        for(int i=0; i<brand.length; i++) arr[7].add(brand[i]);
        for(int i=0; i<feature.length; i++) arr[8].add(feature[i]);
        for(int i=0; i<target.length; i++) arr[9].add(target[i]);
    }
    public void setListKor(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] style = {"캐주얼", "포멀", "비즈니스", "빈티", "럭셔리", "스트리트", "러프", "귀여운", "세련된", "고전적인", "펑키", "힙스터", "스포츠", "레트로", "보헤미안", "고급스러운", "모던", "미니멀리스트", "유니크", "클래식", "편안한", "트디", "아방가르드"};
        String[] material = {"코튼", "실크", "데님", "리넨", "울", "가죽", "플리스", "캐시미어", "벨벳", "코듀로이", "트위드", "폴리에스테르", "레이온", "잔스", "니트", "카모플라지", "지퍼", "체크", "스트라이프", "패턴"};
        String[] color = {"블랙", "화이트", "레드", "블루", "그린", "옐로우", "핑크", "오렌지", "퍼플", "브라운", "그레이", "골드", "실버", "네이비", "버건디", "테일", "머스타드", "카키", "민트", "로즈골드"};
        String[] size = {"S", "M", "L", "XL", "XXL", "Plus Size", "Petite Size", "Custom Size", "Loose Fit", "Slim Fit", "Regular Fit" };
        String[] season = { "봄", "여름", "가을", "겨울", "시즌오프", "신상품", "할인상품"};
        String[] place = {"비즈니스", "파티", "데이트", "캐주얼", "비치", "클럽", "스포츠", "학교", "집", "여행", "피트니스", "헬스", "요가"};
        String[] part = { "상의", "하의", "아우터", "원피스", "언더웨어", "액세서리"};
        String[] brand = { "국내브랜드", "해외브랜드", "디자이너브랜드", "고급브랜드", "저렴한 브랜드", "유명브랜드", "럭셔리브랜드"};
        String[] feature = {"이코프렌드리", "핸드메이드", "리사이클", "오가닉", "비건", "지속가능한", "한정판", "커스텀메이드"};
        String[] target = {"여성", "남성", "어린이", "청소년", "어른", "실버세대", "신혼부부", "대학생", "직장인", "유아", "임산부"};
        for(int i=0; i<10; i++) arr[i] = new ArrayList<String>();
        for(int i=0; i<style.length; i++) arr[0].add(style[i]);
        for(int i=0; i<material.length; i++) arr[1].add(material[i]);
        for(int i=0; i<color.length; i++) arr[2].add(color[i]);
        for(int i=0; i<size.length; i++) arr[3].add(size[i]);
        for(int i=0; i<season.length; i++) arr[5].add(season[i]);
        for(int i=0; i<place.length; i++) arr[4].add(place[i]);
        for(int i=0; i<part.length; i++) arr[6].add(part[i]);
        for(int i=0; i<brand.length; i++) arr[7].add(brand[i]);
        for(int i=0; i<feature.length; i++) arr[8].add(feature[i]);
        for(int i=0; i<target.length; i++) arr[9].add(target[i]);
    }
}
