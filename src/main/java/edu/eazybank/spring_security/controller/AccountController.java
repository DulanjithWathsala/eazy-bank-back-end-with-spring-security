package edu.eazybank.spring_security.controller;

import edu.eazybank.spring_security.entity.AccountEntity;
import edu.eazybank.spring_security.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountsRepository;

    @GetMapping("/myAccount")
    public AccountEntity getAccountDetails(@RequestParam long id) {
        AccountEntity accounts = accountsRepository.findByCustomerId(id);
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }
}
