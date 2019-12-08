package com.ddastudio.mrmr.history;

import com.ddastudio.mrmr.profile.Profile;
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
