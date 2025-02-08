package com.crack.vision.doc.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.crack.vision.doc.entity.File;

public interface FileDao {

    File save(File file);
    
    Page<File> getFiles(Integer userId,Pageable pageable);

}
