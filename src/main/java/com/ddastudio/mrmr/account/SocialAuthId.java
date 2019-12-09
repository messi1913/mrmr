package com.ddastudio.mrmr.account;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
class SocialAuthId {

    @Column(length = 11)
    private String accountId;
    @Column(length = 255)
    private String provider_id;



}
