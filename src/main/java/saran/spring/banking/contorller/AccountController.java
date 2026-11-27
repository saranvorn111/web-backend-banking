package saran.spring.banking.contorller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import saran.spring.banking.dto.AccountRequest;
import saran.spring.banking.dto.AccountResponse;
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
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse createAccount(@RequestBody AccountRequest request) {
        return accountService.saveAccount(request);
    }

    @GetMapping
    public List<AccountResponse> getAll() {
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public AccountResponse findById(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public AccountResponse updatedAccount(@PathVariable Integer id, @RequestBody AccountRequest request) {
        return accountService.updatedAccount(id, request);
    }

    @DeleteMapping("/{id}")
    public String deletedAccount(@PathVariable Integer id) {
        accountService.deletedAccount(id);
        return "Deleted success";
    }

}
