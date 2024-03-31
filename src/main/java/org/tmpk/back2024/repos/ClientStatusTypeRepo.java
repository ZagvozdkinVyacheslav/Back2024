package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.ClientStatusType;
import org.tmpk.back2024.entity.Roles;

@Repository
public interface ClientStatusTypeRepo extends JpaRepository<ClientStatusType,Long> {
    @Query(value = "SELECT * FROM clientstatustype WHERE name = ?1", nativeQuery = true)
    ClientStatusType findByName(String name);
}
