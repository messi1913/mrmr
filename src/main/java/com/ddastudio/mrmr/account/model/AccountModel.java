package com.ddastudio.mrmr.account.model;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;

public class AccountModel extends EntityModel<AccountDTO> {
    public AccountModel(AccountDTO content, Link... links) {
        super(content, links);
    }
}
