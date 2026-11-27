package saran.spring.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import saran.spring.banking.entity.Account;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findById(Integer id);





}
