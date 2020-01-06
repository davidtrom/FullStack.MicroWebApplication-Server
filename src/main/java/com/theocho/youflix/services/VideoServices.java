package com.theocho.youflix.services;


import com.theocho.youflix.exceptions.VideoNotFoundException;
import com.theocho.youflix.models.Video;
import com.theocho.youflix.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class VideoServices {

    private final VideoRepository videoRepository;

    public VideoServices(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public Video create(Video video) {
        return videoRepository.save(video);
    }

    public Video showOne(Long id) {
        Optional<Video> otherVideo = videoRepository.findById(id);
        return (otherVideo.isPresent())? otherVideo.get(): null;
//        else (Exception videoDoesNotExist = new Exception())
        // handle exceptions and pass up to controller
        // return
    }

    public Iterable<Video> showAll(){
        return videoRepository.findAll();
    }

}
