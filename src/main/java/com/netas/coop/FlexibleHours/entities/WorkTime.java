


package com.netas.InventorySystem.entities;

import jakarta.persistence.;
import lombok.Data;

@Data
@Entity
@Table(name = work_times)
public class WorkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long workTimeId;

    private String workHours;

    @OneToMany(mappedBy = workTime)
    private ListWorkCalendar workCalendars;
}
