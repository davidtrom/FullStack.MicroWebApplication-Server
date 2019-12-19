package com.theocho.youflix.models;


import javax.persistence.*;

@Entity
//@Table("videos")
public class VideoModel {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    public VideoModel(){

    }

    public VideoModel(String fileName, String fileType, byte[] data){
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
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

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
