package com.ddastudio.mrmr.account.controller;

import com.ddastudio.mrmr.account.model.AccountDTO;
import com.ddastudio.mrmr.account.model.AccountModel;
import com.ddastudio.mrmr.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

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
    public ResponseEntity<AccountModel> createUser(@RequestBody AccountDTO accountDTO){
        log.info("===== Controller : register account =====");
        AccountDTO user = accountService.createUser(accountDTO);
        var model = new AccountModel(user);
        model.add(linkTo(AccountController.class).withSelfRel());
        model.add(new Link("/docs/account.html#resources-account-create").withRel("profile"));
        model.add(linkTo(AccountController.class).withRel("get-account"));
        return ResponseEntity.ok(model);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountModel> getUser(@PathVariable int id) throws Exception {
        log.info("===== Controller : Retrieve account =====");
        AccountDTO user = this.accountService.getUser(id);
        var model = new AccountModel(user);
        model.add(linkTo(AccountController.class).withSelfRel());
        model.add(new Link("/docs/account.html#resources-account-get").withRel("profile"));
        model.add(linkTo(AccountController.class).withRel("update-account"));
        return ResponseEntity.ok(model);
    }

    @PutMapping
    public ResponseEntity<AccountModel> modifyUser(@RequestBody AccountDTO accountDTO){
        log.info("===== Controller : Modify account =====");
        AccountDTO savedDto = this.accountService.modifyUser(accountDTO);
        var model = new AccountModel(savedDto);
        model.add(linkTo(AccountController.class).withSelfRel());
        model.add(new Link("/docs/account.html#resources-account-update").withRel("profile"));
        model.add(linkTo(AccountController.class).withRel("get-account"));
        return ResponseEntity.ok(model);
    }
}
