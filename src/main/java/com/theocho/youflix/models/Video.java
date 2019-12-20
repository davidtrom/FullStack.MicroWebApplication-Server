package com.theocho.youflix.models;


import javax.persistence.*;

@Entity
//@Table("videos")
public class Video {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private String fileType;
    private String url;
    private String thumbnailUrl;

    public Video(){

    }

    public Video(String fileName, String fileType, String url, String thumbnailUrl){
        this.fileName = fileName;
        this.fileType = fileType;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
