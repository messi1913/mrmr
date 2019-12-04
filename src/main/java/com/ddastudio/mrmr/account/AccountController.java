package com.ddastudio.mrmr.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author messi1913@gmail.com
 * @Github http://github.com/messi1913
 * @since 2019/12/04
 */
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    public ResponseEntity createUser(){
        Account account = Account.builder()
                .email("messi1913@gmail.com")
                .userName("상메시")
                .build();
        return ResponseEntity.ok(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable int id){
        Account account = Account.builder()
                .email("messi1913@gmail.com")
                .userName("상메시")
                .build();
        return ResponseEntity.ok(account);
    }

    @PutMapping
    public ResponseEntity modifyUser(){
        Account account = Account.builder()
                .email("messi1913@gmail.com")
                .userName("상메시")
                .build();
        return ResponseEntity.ok(account);
    }
}
