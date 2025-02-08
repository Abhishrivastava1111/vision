package com.crack.vision.doc.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crack.vision.doc.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;

    @PostMapping
    public ResponseEntity<String> saveFile(@RequestParam(name = "file") MultipartFile file,
            @RequestParam(name = "name") String name) {
        return ResponseEntity.ok(fileService.uploadFile(file, name));

    }

}
