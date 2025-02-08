package com.crack.vision.doc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.crack.vision.doc.entity.File;

public interface FileService {

    String uploadFile(MultipartFile file, String fileName,Integer userId);

    Page<File> getFiles(Integer userId,int page,int size);
}
