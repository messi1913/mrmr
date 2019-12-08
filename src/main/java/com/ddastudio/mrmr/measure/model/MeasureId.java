package com.ddastudio.mrmr.measure.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/05
 */
@Embeddable
@Data
public class MeasureId implements Serializable {
    @Column(length = 4)
    private String publishYear = "2007";
    private Integer gender; // 1:male, 2:female
    private Integer age;
    private Integer month;
}
