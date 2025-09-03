package com.s3.fileupload.controller;

import com.s3.fileupload.service.S3Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {

    private final S3Service s3Service;

    public S3Controller(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            String key = s3Service.uploadFile(file);

            // Validate file content after upload using checksum
            boolean isValid = s3Service.validateFileContent(file, key);
            if (isValid) {
                return ResponseEntity.ok("File uploaded and content validated: " + key);
            } else {
                return ResponseEntity.status(500).body("Upload failed: Content mismatch.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Upload failed: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFile(@RequestParam("key") String key) {
        try {
            s3Service.deleteFile(key);
            return ResponseEntity.ok("File deleted: " + key);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Delete failed: " + e.getMessage());
        }
    }
}
