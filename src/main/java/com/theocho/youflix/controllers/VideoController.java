package com.theocho.youflix.controllers;

import com.theocho.youflix.models.Video;
import com.theocho.youflix.services.VideoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/storage/")
public class VideoController {

    private VideoServices videoServices;

    @Autowired
    VideoController(VideoServices videoServices) {
        this.videoServices = videoServices;
    }

    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> show(@PathVariable Long id) {
        return new ResponseEntity<Video>(videoServices.show(id), HttpStatus.OK);
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return this.videoServices.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return this.videoServices.deleteFileFromS3Bucket(fileUrl);
    }
}
