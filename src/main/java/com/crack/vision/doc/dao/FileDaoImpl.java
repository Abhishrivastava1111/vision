package com.crack.vision.doc.dao;

import org.springframework.stereotype.Repository;

import com.crack.vision.doc.entity.File;
import com.crack.vision.doc.repo.FileRepo;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FileDaoImpl implements FileDao {
    private final FileRepo fileRepo;

    @Override
    public File save(File file) {
        try {
            return fileRepo.save(file);
        } catch (Exception e) {
            throw new RuntimeException("Error in saving file");
        }
    }

}
