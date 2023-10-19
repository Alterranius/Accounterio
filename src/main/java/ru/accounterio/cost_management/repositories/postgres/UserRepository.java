package ru.accounterio.cost_management.repositories.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accounterio.cost_management.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
