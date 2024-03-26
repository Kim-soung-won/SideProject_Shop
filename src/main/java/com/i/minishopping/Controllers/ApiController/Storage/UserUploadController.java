package com.i.minishopping.Controllers.ApiController.Storage;

import com.i.minishopping.Domains.test.UploadTest;
import com.i.minishopping.Services.Storage.NCPObjectStorageService;
import com.i.minishopping.Services.Storage.UploadService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserUploadController {

    private final UploadService uploadService;

    private final NCPObjectStorageService ncpObjectStorageService;

    private String bucketName = "sideprojectbucket";

    @GetMapping("/uploadForm")
    public String uploadForm(){
        return "/Test/uploadForm";
    }

    @PostMapping("/api/upload")
    public String upload(@ModelAttribute UploadTest uploadTest,
            @RequestParam("img[]")List<MultipartFile> list,
                         HttpSession session){
        System.out.println("11111111111111111111111111111");
        String filepath = session.getServletContext().getRealPath("storage");
        System.out.println("실제폴더 = " + filepath);

        String imageFileName = "";
        String imageOriginalName = "";
        File file;
        String result = "";

        List<UploadTest> userImageList = new ArrayList<>();

        for(MultipartFile img : list){
            imageOriginalName = img.getOriginalFilename();
            System.out.println("originalName = " + imageOriginalName);

            imageFileName = ncpObjectStorageService.uploadFile(bucketName, "storage/", img);

            file = new File(filepath, imageOriginalName);

            try{
                img.transferTo(file);
            }catch (IOException e){
                e.printStackTrace();
            }
            try{
                result += "<span><img src='/storage"
                        + URLEncoder.encode(imageOriginalName, "UTF-8")
                        + "'width='200' height='200'></span>";
            } catch (UnsupportedEncodingException e){
                throw new RuntimeException(e);
            }

            UploadTest data = UploadTest.builder()
                    .imageName(uploadTest.getImageName())
                    .imageContent(uploadTest.getImageContent())
                    .imageFileName(imageFileName)
                    .imageOriginalName(imageOriginalName)
                    .build();
            userImageList.add(data);
        }

        uploadService.upload(userImageList);
        return result;

    }
}
