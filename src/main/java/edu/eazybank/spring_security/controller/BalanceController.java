package edu.eazybank.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    @GetMapping()
    public String getContactDetails() {
        return "eazy bank balance details";
    }
}
