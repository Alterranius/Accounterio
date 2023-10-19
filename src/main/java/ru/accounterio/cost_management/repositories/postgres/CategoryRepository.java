package ru.accounterio.cost_management.repositories.postgres;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.accounterio.cost_management.domains.Category;

import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Set<Category> findCategoriesByUser_Id(Long user_id);
}
