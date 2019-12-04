package com.ddastudio.mrmr.his;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/11/29
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Record {

    @EmbeddedId
    private RecordId recordId;
    @Column(precision = 5, scale = 2)
    private double height;
    @Column(precision = 5, scale = 2)
    private double weight;
    @Column(precision = 5, scale = 2)
    private double bmi;
    @Column(precision = 5, scale = 2)
    private double headCircumference;
    @Column(length = 1)
    private String useYn = "Y";

}
