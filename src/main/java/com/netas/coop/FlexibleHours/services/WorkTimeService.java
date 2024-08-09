package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.WorkCalendarEntity;
import com.netas.coop.FlexibleHours.repositories.WorkCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkCalendarService {

    @Autowired
    private WorkCalendarRepository workCalendarRepository;

    public List<WorkCalendarEntity> getAllWorkCalendars() {
        return workCalendarRepository.findAll();
    }

    public Optional<WorkCalendarEntity> getWorkCalendarById(long id) {
        return workCalendarRepository.findById(id);
    }

    public WorkCalendarEntity createWorkCalendar(WorkCalendarEntity workCalendar) {
        return workCalendarRepository.save(workCalendar);
    }

    public WorkCalendarEntity updateWorkCalendar(long id, WorkCalendarEntity workCalendarDetails) {
        WorkCalendarEntity workCalendar = workCalendarRepository.findById(id).orElseThrow(() -> new RuntimeException("Work calendar not found"));
        workCalendar.setDate(workCalendarDetails.getDate());
        workCalendar.setWorkTimeEntity(workCalendarDetails.getWorkTimeEntity());
        workCalendar.setUserEntity(workCalendarDetails.getUserEntity());
        return workCalendarRepository.save(workCalendar);
    }

    public void deleteWorkCalendar(long id) {
        workCalendarRepository.deleteById(id);
    }
}
