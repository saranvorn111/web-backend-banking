package saran.spring.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saran.spring.banking.entity.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
