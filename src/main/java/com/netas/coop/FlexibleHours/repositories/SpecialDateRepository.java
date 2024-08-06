package com.netas.coop.FlexibleHours.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netas.coop.FlexibleHours.entities.SpecialDate;

@Repository
public interface SpecialDateRepository extends JpaRepository<SpecialDate, Long> {
}