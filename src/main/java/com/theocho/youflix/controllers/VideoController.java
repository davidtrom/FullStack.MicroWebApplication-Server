package com.theocho.youflix.controllers;

import com.theocho.youflix.models.VideoModel;
import com.theocho.youflix.services.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping
    public UploadFileResponse uploadVideo(@RequestParam("file")MultipartFile file){
        VideoModel videoFile = videoService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(videoFile.getId())
                .toUriString();

        return new UploadFileResponse (videoFile.getFileName(), fileDownloadUri, file.getContentType(), file.getSize());
    }


}
