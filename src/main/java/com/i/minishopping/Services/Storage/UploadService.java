package com.i.minishopping.Services.Storage;

import com.i.minishopping.Domains.test.UploadTest;
import com.i.minishopping.Repositorys.Storage.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UploadService {

    private final TestRepository testRepository;

    public void upload(List<UploadTest> uploadTestList){
        testRepository.saveAll(uploadTestList);
    }

    public List<UploadTest> getUploadList(){
        return testRepository.findAll();
    }
}
