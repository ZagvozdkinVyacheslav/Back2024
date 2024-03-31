package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.Expenses;
import org.tmpk.back2024.entity.Roles;

@Repository
public interface ExpensesRepo extends JpaRepository<Expenses,Long> {
    @Query(value = "SELECT * FROM expenses WHERE clientid = ?1", nativeQuery = true)
    Expenses findByClientId(Long clientId);
}
