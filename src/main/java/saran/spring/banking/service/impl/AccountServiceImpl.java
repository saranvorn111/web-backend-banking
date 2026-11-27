package saran.spring.banking.service.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import saran.spring.banking.dto.AccountRequest;
import saran.spring.banking.dto.AccountResponse;
import saran.spring.banking.entity.Account;
import saran.spring.banking.repository.AccountRepository;
import saran.spring.banking.service.AccountService;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountResponse saveAccount(AccountRequest request) {
        Account account = new Account();
        account.setAccountName(request.accountName());
        account.setBalance(request.balance());

        return AccountResponse.fromEntity(accountRepository.save(account));
    }

    @Override
    public List<AccountResponse> getAll() {
        return accountRepository.findAll()
                .stream()
                .map(AccountResponse::fromEntity)
                .toList();
    }

    @Override
    public AccountResponse getAccountById(Integer id) {
        return AccountResponse.fromEntity(findAccountOrThrow(id));
    }

    @Override
    public AccountResponse updatedAccount(Integer id, AccountRequest request) {
        Account existingAccount = findAccountOrThrow(id);
        existingAccount.setAccountName(request.accountName());
        existingAccount.setBalance(request.balance());

        return AccountResponse.fromEntity(accountRepository.save(existingAccount));
    }

    @Override
    public void deletedAccount(Integer id) {
        accountRepository.delete(findAccountOrThrow(id));
    }

    private Account findAccountOrThrow(Integer id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Account not found with id: " + id));
    }
}
