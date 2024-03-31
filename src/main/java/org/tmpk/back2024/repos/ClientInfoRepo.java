package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.ClientInfo;
import org.tmpk.back2024.entity.OperatorInfo;

@Repository
public interface ClientInfoRepo extends JpaRepository<ClientInfo,Long> {
}
