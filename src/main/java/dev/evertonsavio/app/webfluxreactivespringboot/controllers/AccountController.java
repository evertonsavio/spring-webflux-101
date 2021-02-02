package dev.evertonsavio.app.webfluxreactivespringboot.controllers;

import dev.evertonsavio.app.webfluxreactivespringboot.data.Account;
import dev.evertonsavio.app.webfluxreactivespringboot.templates.AccountTemplateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/account")
public class AccountController {

    @Autowired
    private AccountTemplateOperations accountTemplate;

    @PostMapping()
    public @ResponseBody
    Mono<Account> addAccount(@RequestBody Mono<Account> account) {
        return accountTemplate.save(account);
    }

    @GetMapping()
    public @ResponseBody
    Flux<Account> getAllAccounts() {
        return accountTemplate.findAll();
    }


}
