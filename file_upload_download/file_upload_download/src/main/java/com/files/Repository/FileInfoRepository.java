package com.files.Repository;

import com.files.Entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, Long> {
    
    Optional<FileInfo> findByFileName(String fileName);

    //Optional<FileInfo> findByID(Long id);

}
