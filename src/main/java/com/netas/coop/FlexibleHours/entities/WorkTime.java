package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import java.util.*;

@Data
@Entity
@Table(name = "work_times")
public class WorkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workTimeId;

    private String workHours;

    @OneToMany(mappedBy = "workTime")
    private List<WorkCalendar> workCalendars;
}
