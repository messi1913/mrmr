package com.ddastudio.mrmr.account.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;

public class AccountAdapter extends User {

    private Account account;

    public AccountAdapter(Account account) {
        super(account.getEmail(), "", authorities(""));
        this.account = account;
    }

    private static Collection<? extends GrantedAuthority> authorities(String role) {
        if(Objects.isNull(role))
            role = "ROLE_USER";
        return Set.of(new SimpleGrantedAuthority(role));
    }

    public Account getAccount() {
        return this.account;
    }
}
