package com.ddastudio.mrmr.account.model;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
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

    @EmbeddedId
    private SocialAuthId id;
    private String accessToken;
    private String refreshToken;
    private String secret;
    private BigDecimal expireTime;


}
