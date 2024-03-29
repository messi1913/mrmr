package com.ddastudio.mrmr.account.service;

import com.ddastudio.mrmr.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/08
 */
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByIdAndUseYn(int id, String useYn);

    Optional<Account> findByEmailAndUseYn(String email, String useYn);
}
