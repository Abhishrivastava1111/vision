package com.crack.vision.doc.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.crack.vision.doc.entity.File;

public interface FileRepo extends JpaRepository<File, Integer> {

    Page<File> getListOfFilesByUserId(Integer userId,Pageable pageable);
}
