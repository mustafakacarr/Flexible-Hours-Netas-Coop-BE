package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long permissionId;

    private long date;

    private String explanation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}