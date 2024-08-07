package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "work_calendars")
public class WorkCalendarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String date;

    @ManyToOne
    @JoinColumn(name = "work_time_id")
    private WorkTimeEntity workTimeEntity;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}