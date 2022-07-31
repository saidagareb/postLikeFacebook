package com.example.models;

import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Post implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "TEXT")
    private String content;
    @Column(name = "createdDate")
    private LocalDate createdDate;
    @Column(name = "fileName")
    private String fileName;
    @Column(name = "fileType")
    private String fileType;
//    @Transient
//    @Nullable
//    private MultipartFile fileData;
//    @Lob

//    public MultipartFile getFileData() {
//        return fileData;
//    }
//
//    public void setFileData(MultipartFile fileData) {
//        this.fileData = fileData;
//    }

    public Post(LocalDate createdDate, String content) {
        this.createdDate = createdDate;
        this.content = content;
    }

    public Post(String fileName, String fileType, LocalDate createdDate, String content) {
        this.fileName = fileName;
        this.content = content;
        this.createdDate = createdDate;
        this.fileType = fileType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
