package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
@Table(name = "work_times")
public class WorkTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalTime startTime;
    private LocalTime endTime;
    //f.e. 09:00-18:00
}
