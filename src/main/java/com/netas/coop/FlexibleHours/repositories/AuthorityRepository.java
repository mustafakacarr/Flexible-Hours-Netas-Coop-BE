package com.netas.coop.FlexibleHours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.netas.coop.FlexibleHours.entities.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
