package ua.internetshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.internetshop.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findAccountByUsername(String username);
}
