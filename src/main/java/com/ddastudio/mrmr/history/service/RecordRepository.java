package com.ddastudio.mrmr.history.service;

import com.ddastudio.mrmr.history.model.Record;
import com.ddastudio.mrmr.history.model.RecordId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
public interface RecordRepository extends JpaRepository<Record, RecordId> {


}
