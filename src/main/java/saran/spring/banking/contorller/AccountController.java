package saran.spring.banking.contorller;

import org.springframework.web.bind.annotation.*;
import saran.spring.banking.entity.Account;
import saran.spring.banking.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account crateAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping
    public List<Account> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Account> findById(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public Account updatedAccount(@PathVariable Integer id, @RequestBody Account account){
       return accountService.updatedAccount(id, account);
    }

    @DeleteMapping("/{id}")
    public String deletedAccount(@PathVariable Integer id){
        accountService.deletedAccount(id);
        return "Deleted success";
    }

}
