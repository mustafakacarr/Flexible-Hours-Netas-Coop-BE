package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "off_days")
public class OffDayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long startDate;
    private long endDate;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
}