package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Balance;
import org.tmpk.back2024.entity.ClientStatusType;
import org.tmpk.back2024.entity.ClientType;

@Repository
public interface ClientTypeRepo extends JpaRepository<ClientType,Long> {
    @Query(value = "SELECT * FROM clienttype WHERE name = ?1", nativeQuery = true)
    ClientType findByName(String name);
}
