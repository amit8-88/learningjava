package io.github.amit.services;

import io.github.amit.entities.Account;
import io.github.amit.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service @Transactional
public class AccountService {

    @Autowired
    private AccountRepository repository;

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public BigDecimal getBalance(Long id) {
        return repository.findOne(id).getBalance();
    }

    public BigDecimal deposit(Long id, BigDecimal amount) {
        Account account = repository.findOne(id);
        BigDecimal newBalance = account.getBalance().add(amount);
        account.setBalance(newBalance);
        repository.save(account);
        return newBalance;
    }

    public BigDecimal withdraw(Long id, BigDecimal amount) {
        return deposit(id, amount.negate());
    }

    public void transfer(Long fromId, Long toId, BigDecimal amount) {
        withdraw(fromId, amount);
        deposit(toId, amount);
    }
}
