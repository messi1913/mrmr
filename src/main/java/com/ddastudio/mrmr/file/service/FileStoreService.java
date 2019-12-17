package com.ddastudio.mrmr.file.service;

import com.ddastudio.mrmr.file.model.FileStore;
import com.querydsl.core.types.ExpressionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/17
 */
@Service
@RequiredArgsConstructor
public class FileStoreService {

    private final FileStoreRepository fileStoreRepository;

    public FileStore storeFile(MultipartFile file) {
        if(Objects.isNull(file)){
            return null;
        }
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                //throw new Exception("Sorry! Filename contains invalid path sequence " + fileName);
                return null;
            }

            FileStore fileStore = FileStore.builder()
                    .name(fileName)
                    .type(file.getContentType())
                    .size(file.getSize())
                    .cont(file.getBytes())
                    .build();

            return fileStoreRepository.save(fileStore);
        } catch (IOException ex) {
            ex.printStackTrace();
            //throw new Exception("Could not store file " + fileName + ". Please try again!", ex);
            return null;
        }
    }

    public FileStore getFile(int fileId) throws Exception {
        return fileStoreRepository.findById(fileId)
                .orElseThrow(() -> new Exception("File not found with id " + fileId));
    }

}
