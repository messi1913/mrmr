package com.ddastudio.mrmr.account.service;

import com.ddastudio.mrmr.account.model.Account;
import com.ddastudio.mrmr.account.model.AccountAdapter;
import com.ddastudio.mrmr.account.model.AccountDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/04
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AccountService implements UserDetailsService {

    private final ModelMapper modelMapper;
    private final AccountRepository repository;

    public AccountDTO getUser(int id) throws Exception {
        Account account = repository.findByIdAndUseYn(id, "Y").orElseThrow(() -> new Exception(""));
        return modelMapper.map(account, AccountDTO.class);
    }

    public AccountDTO modifyUser(AccountDTO accountDTO) {
        Account save = repository.save(modelMapper.map(accountDTO, Account.class));
        modelMapper.map(save, AccountDTO.class);
        return accountDTO;
    }

    public AccountDTO createUser(AccountDTO accountDTO) {
        //TODO : Validation
        Account save = repository.save(modelMapper.map(accountDTO, Account.class));
        modelMapper.map(save, AccountDTO.class);
        return accountDTO;
    }

    public Account getAccount(int id) throws Exception {
        return repository.findByIdAndUseYn(id, "Y").orElseThrow(() -> new Exception(""));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.repository.findByEmailAndUseYn(username, "Y")
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return new AccountAdapter(account);
    }
}
