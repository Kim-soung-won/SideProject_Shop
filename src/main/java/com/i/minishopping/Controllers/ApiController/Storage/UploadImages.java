package com.i.minishopping.Controllers.ApiController.Storage;

import com.i.minishopping.Domains.Comment.Comment;
import com.i.minishopping.Domains.Comment.CommentImg;
import com.i.minishopping.Services.Comment.CommentImgService;
import com.i.minishopping.Services.Storage.NCPObjectStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class UploadImages {
    private final CommentImgService commentImgService;
    private final NCPObjectStorageService ncpObjectStorageService;

    private String bucketName = "sideprojectbucket";

    public void commentUploadImages(List<MultipartFile> images, Comment comment) {
        String imageFileName = "";
        String imageOriginalName = "";

        List<CommentImg> commentImgList = new ArrayList<>();

        for(MultipartFile img : images){
            imageOriginalName = img.getOriginalFilename();
            imageFileName = ncpObjectStorageService.uploadFile(bucketName, "storage/", img);

            CommentImg commentImg = CommentImg.builder()
                    .comment_id(comment)
                    .url(imageFileName)
                    .name(imageOriginalName)
                    .build();
            commentImgList.add(commentImg);
        }
        commentImgService.upload(commentImgList);
    }
}
