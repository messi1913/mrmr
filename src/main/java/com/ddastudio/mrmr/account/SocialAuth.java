package com.ddastudio.mrmr.account;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialAuth {

    @Embedded
    private SocialAuthId id;
    private String accessToken;
    private String refreshToken;
    private String secret;
    private BigDecimal expireTime;


}
