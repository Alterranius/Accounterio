package ru.accounterio.cost_management.repositories.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accounterio.cost_management.domains.Transaction;

import java.util.Set;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Set<Transaction> findTransactionsByCategory_Id(int category_id);
    Set<Transaction> findTransactionsByUser_Id(Long user_id);
}
