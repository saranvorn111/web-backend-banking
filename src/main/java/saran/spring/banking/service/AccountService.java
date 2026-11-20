package saran.spring.banking.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import saran.spring.banking.entity.Account;
import saran.spring.banking.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

}
