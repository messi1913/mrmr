package com.ddastudio.mrmr.profile;

import com.ddastudio.mrmr.account.Account;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/11/27
 */
@Entity
@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    @GeneratedValue
    @Column(length = 11)
    private int id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    private String name;
    @Column(length = 1)
    private int gender;
    private LocalDateTime birthday;
    @Column(precision = 5, scale = 2)
    private double height;
    @Column(precision = 5, scale = 2)
    private double weight;
    @Column(precision = 5, scale = 2)
    private double headCircumference;
    @Column(length = 10)
    private String color;
    @Column(length = 30)
    private String icon;
    @Column(length = 1)
    private String useYn = "Y";


}
