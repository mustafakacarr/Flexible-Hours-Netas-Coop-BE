


package com.netas.InventorySystem.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "special_dates")
public class SpecialDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long specialId;

    private String specialDate;

    private String name;
}
