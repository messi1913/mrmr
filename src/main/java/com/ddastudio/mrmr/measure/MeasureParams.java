package com.ddastudio.mrmr.measure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
@Data
@NoArgsConstructor @AllArgsConstructor
public class MeasureParams {
    private String type;
    private Integer gender;
    private Integer age;
    private Integer month;
    private Double height;
}
