package com.netas.coop.FlexibleHours.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long authorityId;

    private String authorityRole;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}