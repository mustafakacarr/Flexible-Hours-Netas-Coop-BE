package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.WorkTimeEntity;
import com.netas.coop.FlexibleHours.repositories.WorkTimeRepository;
import com.netas.coop.FlexibleHours.requests.WorkTimeRequest;
import com.netas.coop.FlexibleHours.responses.WorkTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WorkTimeService {
    private WorkTimeRepository workTimeRepository;

    public WorkTimeService(WorkTimeRepository workTimeRepository) {
        this.workTimeRepository = workTimeRepository;
    }

    public List<WorkTimeResponse> getAllWorkTimes() {
        return workTimeRepository.findAll().stream()
                .map((workTime) -> new WorkTimeResponse(workTime))
                .collect(Collectors.toList());
    }

    public WorkTimeResponse getWorkTimeById(long id) {
        WorkTimeEntity workTime = workTimeRepository.findById(id).orElseThrow(() -> new RuntimeException("Work time not found"));
        return new WorkTimeResponse(workTime);
    }

    public WorkTimeResponse createWorkTime(WorkTimeRequest workTimeRequest) {
        WorkTimeEntity workTime = new WorkTimeEntity();
        workTime.setStartTime(workTimeRequest.startTime());
        workTime.setEndTime(workTimeRequest.endTime());
        return new WorkTimeResponse(workTimeRepository.save(workTime));
    }

    public WorkTimeResponse updateWorkTime(long id, WorkTimeRequest workTimeRequest) {
        WorkTimeEntity workTime = workTimeRepository.findById(id).orElseThrow(() -> new RuntimeException("Work time not found"));
        workTime.setStartTime(workTimeRequest.startTime());
        workTime.setEndTime(workTimeRequest.endTime());
        return new WorkTimeResponse(workTimeRepository.save(workTime));
    }

    public void deleteWorkTime(long id) {
        workTimeRepository.deleteById(id);
    }
}
