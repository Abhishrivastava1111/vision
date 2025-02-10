package com.crack.vision.doc.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crack.vision.doc.SuccessHandler;
import com.crack.vision.doc.entity.File;
import com.crack.vision.doc.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/file")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;
/* 
    @PostMapping
    public ResponseEntity<String> saveFile(@RequestParam(name = "file") MultipartFile file,
            @RequestParam(name = "name") String name,@RequestParam Integer userId) {
        return ResponseEntity.ok(fileService.uploadFile(file, name,userId));

    } */

    @PostMapping
    public ResponseEntity<SuccessHandler> saveFile(@RequestParam(name = "file") MultipartFile file,
            @RequestParam(name = "name") String name,@RequestParam Integer userId) {
                String respnseString = fileService.uploadFile(file, name,userId);
                SuccessHandler successHandler = new SuccessHandler(true, "file Saved Successfully", respnseString);
        return ResponseEntity.ok(successHandler);
            }

    /*
    @GetMapping("/getFiles")
    public ResponseEntity<List<File>> getListOfFilesByUserId(@RequestParam Integer userId){
        List<File> listOfFiles = (fileService.getFiles(userId));
        return ResponseEntity.ok(listOfFiles);
    } */
/* 
    @GetMapping("/getFiles")
    public ResponseEntity<Page<File>> getListOfFilesByUserId(@RequestParam Integer userId, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10") int size){
        Page<File> paginatedFiles = fileService.getFiles(userId,page,size);
        return ResponseEntity.ok(paginatedFiles);
    } */

    @GetMapping("/files")
    public ResponseEntity<SuccessHandler> getListOfFilesByUserId(@RequestParam Integer userId, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="10") int size){
        Page<File> paginatedFiles = fileService.getFiles(userId,page,size);
        // SuccessHandler successResponse = new SuccessHandler(true, "Files fetched successfully", paginatedFiles);
        String messageString="Files not fetched successfully";
        if(paginatedFiles!=null){
            messageString = "Files fetched successfully";
        }
        SuccessHandler successResponse = new SuccessHandler(true, messageString, paginatedFiles);
        return ResponseEntity.ok(successResponse);
    }

    
}
