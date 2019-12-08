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
    public ResponseEntity<AccountDTO> createUser(@RequestBody AccountDTO accountDTO){
        AccountDTO user = accountService.createUser(accountDTO);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getUser(@PathVariable int id) throws Exception {
      return ResponseEntity.ok(accountService.getUser(id));
    }

    @PutMapping
    public ResponseEntity<AccountDTO> modifyUser(@RequestBody AccountDTO accountDTO){
        AccountDTO savedDto = this.accountService.modifyUser(accountDTO);
        return ResponseEntity.ok(savedDto);
    }
}
