package com.ddastudio.mrmr.account.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
class SocialAuthId implements Serializable {

    @Column(length = 11)
    private String accountId;
    @Column(length = 255)
    private String provider_id;



}
