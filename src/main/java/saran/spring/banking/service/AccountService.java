package saran.spring.banking.service;

import saran.spring.banking.dto.AccountRequest;
import saran.spring.banking.dto.AccountResponse;

import java.util.List;

public interface AccountService {

    AccountResponse saveAccount(AccountRequest request);

    List<AccountResponse> getAll();

    AccountResponse getAccountById(Integer id);

    AccountResponse updatedAccount(Integer id, AccountRequest request);

    void deletedAccount(Integer id);
}
