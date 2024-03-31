package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Operators;

@Repository
public interface OperatorRepo extends JpaRepository<Operators,Long> {

    Operators findByLogin(String login);

}
