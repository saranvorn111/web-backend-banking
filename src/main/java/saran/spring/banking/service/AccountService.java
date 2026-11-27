package saran.spring.banking.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import saran.spring.banking.entity.Account;
import saran.spring.banking.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    public Account updatedAccount(Integer id, Account account) {
        Account exitedAaccount = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        exitedAaccount.setAccountName(account.getAccountName());
        exitedAaccount.setBalance(account.getBalance());

        return accountRepository.save(exitedAaccount);
    }

    public String deletedAccount(Integer id) {
        Account exitedAccount = accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        accountRepository.delete(exitedAccount);
        return "Deleted success";
    }


}



