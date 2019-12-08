package com.ddastudio.mrmr.measure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/measures")
public class MeasureController {

    private final MeasureService service;

    @GetMapping("/conditions")
    public ResponseEntity getMesure(MeasureParams params) throws Exception {
        return ResponseEntity.ok(service.getInfoByCondition(params));
    }

}
