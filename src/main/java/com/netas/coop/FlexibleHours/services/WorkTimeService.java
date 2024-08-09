package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.WorkTimeEntity;
import com.netas.coop.FlexibleHours.repositories.WorkTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkTimeService {

    @Autowired
    private WorkTimeRepository workTimeRepository;

    public List<WorkTimeEntity> getAllWorkTimes() {
        return workTimeRepository.findAll();
    }

    public Optional<WorkTimeEntity> getWorkTimeById(long id) {
        return workTimeRepository.findById(id);
    }

    public WorkTimeEntity createWorkTime(WorkTimeEntity workTime) {
        return workTimeRepository.save(workTime);
    }

    public WorkTimeEntity updateWorkTime(long id, WorkTimeEntity workTimeDetails) {
        WorkTimeEntity workTime = workTimeRepository.findById(id).orElseThrow(() -> new RuntimeException("Work time not found"));
        workTime.setWorkHours(workTimeDetails.getWorkHours());
        return workTimeRepository.save(workTime);
    }

    public void deleteWorkTime(long id) {
        workTimeRepository.deleteById(id);
    }
}
