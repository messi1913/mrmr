package com.ddastudio.mrmr.his;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    private int childId;
    private LocalDateTime measureDate;
}
