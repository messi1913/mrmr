package com.ddastudio.mrmr.history.service;

import com.ddastudio.mrmr.history.model.Record;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class RecordService {

    private final RecordRepository repository;

    public Record recordProfile(Record record){
        record.getRecordId().setMeasureDate(LocalDateTime.now());
        return repository.save(record);
    }

}
