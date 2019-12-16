package com.ddastudio.mrmr.account.model;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class AccountModel extends Resource<AccountDTO> {
    public AccountModel(AccountDTO content, Link... links) {
        super(content, links);
    }
}
