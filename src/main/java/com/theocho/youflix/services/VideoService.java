package com.theocho.youflix.services;


import com.theocho.youflix.models.VideoModel;
import com.theocho.youflix.repositories.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class VideoService {

    @Autowired
    private VideoRepository videoRepository;

    public VideoModel storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            VideoModel videoFile = new VideoModel(fileName, file.getContentType(), file.getBytes());

            return videoRepository.save(videoFile);

        } catch (IOException e){
                throw new FileStorageException("Could not store file " + fileName + ". Please try again!", e);
            }
        }

    public VideoModel getFile(String fileId){
        return videoRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
