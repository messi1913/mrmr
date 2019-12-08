package com.ddastudio.mrmr.history;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/11/29
 */
@Data
@Embeddable
public class RecordId implements Serializable {
    @Column(length = 11)
    private int profileId;
    private LocalDateTime measureDate;
}
