package com.crack.vision.doc.service;

import java.util.Base64;
import java.util.List;

import org.modelmapper.internal.bytebuddy.asm.Advice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.crack.vision.doc.dao.FileDao;
import com.crack.vision.doc.entity.File;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileDao fileDao;

    public String uploadFile(MultipartFile multipartFile, String fileName,Integer userId) {

        try {
            if (multipartFile != null && !multipartFile.isEmpty()) {
                String base64Image = Base64.getEncoder().encodeToString(multipartFile.getBytes());
                File file = new File();
                file.setName(fileName);
                file.setFile(base64Image);
                file.setUploadedBy(null);
                file.setUserId(userId);
                //To be refactored
                return fileDao.save(file).toString();
            } else {
                return "File not found";
            }
        } catch (Exception e) {
            return "Exception in handelling file";
        }
    }

    public Page<File> getFiles(Integer userId, int page, int size){
       
        Pageable pageable = PageRequest.of(page,size,Sort.by("id"));
        return fileDao.getFiles(userId,pageable);
    }


}
