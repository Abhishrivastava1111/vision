package com.crack.vision.doc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crack.vision.doc.entity.File;

public interface FileRepo extends JpaRepository<File, Integer> {

}
