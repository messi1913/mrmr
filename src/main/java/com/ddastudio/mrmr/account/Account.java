package com.ddastudio.mrmr.account;

import lombok.*;

import javax.persistence.*;
import java.util.List;

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
public class Account {
    @Id
    @GeneratedValue
    @Column(length = 11)
    private int id;
    @Column(unique = true, length = 50)
    private String  email;
    @Column(length = 15)
    private String provider;
    @Column(unique = true, length = 50)
    private String userName;
    @Column(length = 1)
    private String useYn = "Y";

}
