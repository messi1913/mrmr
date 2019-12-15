package com.ddastudio.mrmr.account.model;

import com.ddastudio.mrmr.profile.model.ProfileDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
@Data
@Builder
public class AccountDTO {

    private int id;
    private String  email;
    private String provider;
    private String userName;
    private List<ProfileDTO> profiles;
}
