package ru.accounterio.cost_management.repositories.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accounterio.cost_management.domains.Transaction;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findTransactionsByCategory_Id(int category_id);
    List<Transaction> findTransactionsByUser_Id(Long user_id);
}
