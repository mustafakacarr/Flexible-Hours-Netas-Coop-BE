package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "managements")
public class UnitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;


}