package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.ClientInfo;
import org.tmpk.back2024.entity.Roles;

@Repository
public interface BalanceRepo extends JpaRepository<Balance,Long> {
}
