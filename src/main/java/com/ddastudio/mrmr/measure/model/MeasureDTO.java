package com.ddastudio.mrmr.measure.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/15
 */
@Data
@Builder
@NoArgsConstructor @AllArgsConstructor
public class MeasureDTO {

    private String type;
    private String publishYear;
    private Integer gender; // 1:male, 2:female
    private Integer age;
    private Integer month;
    private Integer fromMonth;
    private Integer toMonth;
    private Double height;
    private double m;
    private double l;
    private double s;
    private double per1;
    private double per2;
    private double per5;
    private double per10;
    private double per15;
    private double per25;
    private double per50;
    private double per75;
    private double per85;
    private double per90;
    private double per95;
    private double per97;
    private double per99;
    @Column(name = "std_l1")
    private double stdl1;
    @Column(name = "std_l2")
    private double stdl2;
    @Column(name = "std_l3")
    private double stdl3;
    private double std0;
    @Column(name = "std_r1")
    private double stdr1;
    @Column(name = "std_r2")
    private double stdr2;
    @Column(name = "std_r3")
    private double stdr3;
}
