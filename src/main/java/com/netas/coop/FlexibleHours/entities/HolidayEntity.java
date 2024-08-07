package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "holidays")
public class HolidayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long startDate;
    private long endDate;

    private String name;
}
