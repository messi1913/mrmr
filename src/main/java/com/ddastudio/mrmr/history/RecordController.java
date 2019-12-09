package com.ddastudio.mrmr.history;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/records")
public class RecordController {
    private final RecordService service;

    @PostMapping
    public ResponseEntity<Record> recordProfile(@RequestBody Record record) {
        Record record1 = this.service.recordProfile(record);
        return ResponseEntity.ok(record1);
    }

}
