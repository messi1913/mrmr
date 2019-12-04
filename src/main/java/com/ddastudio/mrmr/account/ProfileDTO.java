package com.ddastudio.mrmr.account;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/11/27
 */
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ProfileDTO {

    private int id;
    private String name;
    private int gender;
    private LocalDateTime birthday;
    private double height;
    private double weight;
    private double headCircumference;
    private String color;
    private String icon;
}
