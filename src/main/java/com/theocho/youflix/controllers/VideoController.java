package com.theocho.youflix.controllers;

import com.theocho.youflix.models.Video;
import com.theocho.youflix.repositories.VideoRepository;
import com.theocho.youflix.services.VideoServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
<<<<<<< HEAD
=======

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
>>>>>>> 98ed052da684d72e9bec544861987ce6c2393f4b


@Controller
@RequestMapping("")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080", "http://localhost"})
public class VideoController {

    @Autowired
    private VideoServices videoServices;
    public static final Logger LOGGER = LoggerFactory.getLogger(VideoController.class);


    @Autowired
    private VideoRepository videoRepository;

    @Autowired
    public VideoController(VideoServices videoServices) {
        this.videoServices = videoServices;
    }

    @PostMapping("/videos")
    public ResponseEntity createVideo(@RequestBody Video video) {
        LOGGER.info("Request received");
        return new ResponseEntity(videoServices.create(video), HttpStatus.CREATED);
    }
    
    @GetMapping("/videos/{id}")
    public ResponseEntity<Video> show(@PathVariable Long id){
        return new ResponseEntity<>(videoServices.showOne(id), HttpStatus.OK);
    }

    @GetMapping("/videos")
    public ResponseEntity<Iterable<Video>> showAllVideos(){
        return new ResponseEntity<>(videoServices.showAll(),HttpStatus.OK);
    }

}
