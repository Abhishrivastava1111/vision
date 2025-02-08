package com.crack.vision.user.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crack.vision.user.dto.LoginDto;
import com.crack.vision.user.dto.UserDto;
import com.crack.vision.user.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody UserDto userDto) {
        System.out.println("UserDto in userController is : " + userDto);
        String response = userService.saveUser(userDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody @Valid LoginDto loginDto) {
        try {
            Integer userId = userService.loginUser(loginDto.getEmail(), loginDto.getPassword());
            return ResponseEntity.ok(userId);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }

    @PostMapping("/uploadDocument")
    public ResponseEntity<String> uploadDocument(@RequestParam("file") MultipartFile file,
            @RequestParam("description") String description, @RequestParam("userId") Integer userId) {
        try {
            if (file != null && !file.isEmpty()) {
                String base64Image = Base64.getEncoder().encodeToString(file.getBytes());
                userService.uploadDocument(userId, base64Image, description);
            }

            return ResponseEntity.ok("Image uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error uploading image");
        }
    }

    private String saveDocument(MultipartFile file) throws IOException {
        Path uploadPath = Paths.get("uploads/documents");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);

        file.transferTo(filePath.toFile());

        return filePath.toString();
    }
}
