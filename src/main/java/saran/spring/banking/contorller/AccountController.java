package saran.spring.banking.contorller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import saran.spring.banking.entity.Account;
import saran.spring.banking.service.AccountService;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account crateAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @GetMapping
    public List<Account> getAll(){
        return accountService.getAll();
    }


}
