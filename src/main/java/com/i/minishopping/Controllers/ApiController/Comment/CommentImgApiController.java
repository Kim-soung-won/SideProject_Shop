package com.i.minishopping.Controllers.ApiController.Comment;

import com.i.minishopping.Services.Comment.CommentImgService;
import com.i.minishopping.Services.Storage.NCPObjectStorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentImgApiController {
    private final CommentImgService commentImgService;
    private final NCPObjectStorageService ncpObjectStorageService;
}
