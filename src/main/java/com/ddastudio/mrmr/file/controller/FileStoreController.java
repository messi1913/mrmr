package com.ddastudio.mrmr.file.controller;

import com.ddastudio.mrmr.file.FileResponse;
import com.ddastudio.mrmr.file.model.FileStore;
import com.ddastudio.mrmr.file.service.FileStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/17
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/files")
public class FileStoreController {

    private final FileStoreService service;

    @PostMapping("/uploadFile")
    public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        FileStore fileStore = service.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(String.valueOf(fileStore.getId()))
                .toUriString();

        return FileResponse.builder()
                .fileDownloadUri(fileDownloadUri)
                .fileType(fileStore.getType())
                .fileName(fileStore.getName())
                .size(fileStore.getSize())
                .build();
    }

    @PostMapping("/uploadMultipleFiles")
    public List<FileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return List.of(files).stream()
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws Exception {
        FileStore fileStore = this.service.getFile(Integer.parseInt(fileId));
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(fileStore.getType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileStore.getName() + "\"")
                .body(new ByteArrayResource(fileStore.getCont()));
    }



}
