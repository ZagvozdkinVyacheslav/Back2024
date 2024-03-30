package org.tmpk.back2024.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.tmpk.back2024.entity.Roles;

@Repository
public interface RolesRepo extends JpaRepository<Roles,Long> {
}
