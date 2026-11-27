package saran.spring.banking.dto;

import java.math.BigDecimal;

// Data the client sends when creating or updating an account (no id: the database generates it)
public record AccountRequest(
        String accountName,
        BigDecimal balance
) {
}
