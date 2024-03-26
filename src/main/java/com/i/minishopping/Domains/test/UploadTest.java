package com.i.minishopping.Domains.test;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name="testcomment")
@NoArgsConstructor
public class UploadTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="image_name")
    private String imageName;

    @Column(name="image_content")
    private String imageContent;

    @Column(name="image_filename")
    private String imageFileName;

    @Column(name="image_originalname")
    private String imageOriginalName;

    @Builder
    public UploadTest(String imageName, String imageContent, String imageFileName, String imageOriginalName){
        this.imageName = imageName;
        this.imageContent = imageContent;
        this.imageFileName = imageFileName;
        this.imageOriginalName = imageOriginalName;
    }
}
