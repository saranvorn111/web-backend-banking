package saran.spring.banking.dto;

import saran.spring.banking.entity.Account;

import java.math.BigDecimal;

// Data the API sends back to the client
public record AccountResponse(
        Integer id,
        String accountName,
        BigDecimal balance
) {
    public static AccountResponse fromEntity(Account account) {
        return new AccountResponse(
                account.getId(),
                account.getAccountName(),
                account.getBalance()
        );
    }
}
