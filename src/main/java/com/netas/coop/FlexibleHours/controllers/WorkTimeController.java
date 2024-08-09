package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.dtos.WorkTimeRequest;
import com.netas.coop.FlexibleHours.dtos.WorkTimeResponse;
import com.netas.coop.FlexibleHours.entities.WorkTimeEntity;
import com.netas.coop.FlexibleHours.services.WorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/work-times")
public class WorkTimeController {

    @Autowired
    private WorkTimeService workTimeService;

    @GetMapping
    public List<WorkTimeResponse> getAllWorkTimes() {
        return workTimeService.getAllWorkTimes().stream()
                .map(WorkTimeResponse::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkTimeResponse> getWorkTimeById(@PathVariable long id) {
        return workTimeService.getWorkTimeById(id)
                .map(workTime -> ResponseEntity.ok(WorkTimeResponse.fromEntity(workTime)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public WorkTimeResponse createWorkTime(@RequestBody WorkTimeRequest request) {
        WorkTimeEntity workTime = new WorkTimeEntity();
        workTime.setWorkHours(request.workHours());
        return WorkTimeResponse.fromEntity(workTimeService.createWorkTime(workTime));
    }

    @PutMapping("/{id}")
    public ResponseEntity<WorkTimeResponse> updateWorkTime(@PathVariable long id, @RequestBody WorkTimeRequest request) {
        WorkTimeEntity workTime = new WorkTimeEntity();
        workTime.setWorkHours(request.workHours());
        return ResponseEntity.ok(WorkTimeResponse.fromEntity(workTimeService.updateWorkTime(id, workTime)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkTime(@PathVariable long id) {
        workTimeService.deleteWorkTime(id);
        return ResponseEntity.noContent().build();
    }
}
