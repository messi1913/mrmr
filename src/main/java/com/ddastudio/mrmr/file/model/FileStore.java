package com.ddastudio.mrmr.file.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Blob;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/17
 */
@Entity
@Data
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileStore {
    @Id
    @GeneratedValue
    @Column(length = 11)
    private int id;
    @Column(length = 200)
    private String name;
    @Column(length = 100)
    private Long size;
    @Column(length = 50)
    private String type;
    @Lob
    private byte[] cont;

}
