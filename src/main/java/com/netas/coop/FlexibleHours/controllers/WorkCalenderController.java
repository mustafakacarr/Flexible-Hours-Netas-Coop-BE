package com.netas.coop.FlexibleHours.controllers;


import com.netas.coop.FlexibleHours.entities.WorkCalendarEntity;
import com.netas.coop.FlexibleHours.services.WorkCalendarService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1.0/work-calendars")

public class WorkCalenderController {

    private WorkCalendarService workCalendarService;

    public WorkCalenderController(WorkCalendarService workCalendarService) {
        this.workCalendarService = workCalendarService;
    }

    @GetMapping
    public List<WorkCalendarEntity> getAllWorkCalendars() {
        return workCalendarService.getAllWorkCalendars();
    }

    @GetMapping("/{id}")
    public Optional<WorkCalendarEntity> getWorkCalendarById(@PathVariable long id) {
        return workCalendarService.getWorkCalendarById(id);
    }

    @PostMapping
    public WorkCalendarEntity createWorkCalendar(@RequestBody WorkCalendarEntity workCalendar) {
        return workCalendarService.createWorkCalendar(workCalendar);
    }

    @PutMapping("/{id}")
    public WorkCalendarEntity updateWorkCalendar(@PathVariable long id, @RequestBody WorkCalendarEntity workCalendarDetails) {
        return workCalendarService.updateWorkCalendar(id, workCalendarDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkCalendar(@PathVariable long id) {
        workCalendarService.deleteWorkCalendar(id);
    }
}
