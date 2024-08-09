package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.requests.WorkTimeRequest;
import com.netas.coop.FlexibleHours.responses.WorkTimeResponse;
import com.netas.coop.FlexibleHours.services.WorkTimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/work-times")
public class WorkTimeController {


    private WorkTimeService workTimeService;

    public WorkTimeController(WorkTimeService workTimeService) {
        this.workTimeService = workTimeService;
    }

    @GetMapping
    public List<WorkTimeResponse> getAllWorkTimes() {
        return workTimeService.getAllWorkTimes();
    }

    @GetMapping("/{id}")
    public WorkTimeResponse getWorkTimeById(@PathVariable long id) {
        return workTimeService.getWorkTimeById(id);
    }

    @PostMapping
    public WorkTimeResponse createWorkTime(@RequestBody WorkTimeRequest request) {
        return workTimeService.createWorkTime(request);
    }

    @PutMapping("/{id}")
    public WorkTimeResponse updateWorkTime(@PathVariable long id, @RequestBody WorkTimeRequest request) {
      return workTimeService.updateWorkTime(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteWorkTime(@PathVariable long id) {
        workTimeService.deleteWorkTime(id);

    }
}
