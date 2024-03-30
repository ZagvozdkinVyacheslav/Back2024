package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.OperatorInfo;
import org.tmpk.back2024.entity.Operators;

@Repository
public interface OperatorInfoRepo extends JpaRepository<OperatorInfo,Long> {
}
