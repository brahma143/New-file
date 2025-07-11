package com.files.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data  // lombok annotations for getters, setters, hashcode, toString AND Equals
@Entity(name= "files")
@AllArgsConstructor
@NoArgsConstructor // Lombok annotation for no-arg constructor
@Table
public class FileInfo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String fileType;

    @Column(nullable = false)
    private String filePath;

    @Column(nullable = false)
    private long size;

    @Column(nullable = false)
    private LocalDateTime uploadDate;

    public FileInfo(Long id, String fileName, String fileType, String filePath, LocalDateTime uploadDate) {
        this.id = id;
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = filePath;
        this.uploadDate = uploadDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
