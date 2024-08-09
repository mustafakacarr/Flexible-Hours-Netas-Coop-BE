package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.requests.CreateOffDayRequest;
import com.netas.coop.FlexibleHours.requests.UpdateOffDayRequest;
import com.netas.coop.FlexibleHours.responses.OffDayResponse;
import com.netas.coop.FlexibleHours.services.OffDayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1.0/off-days")
public class OffDayController {

    private final OffDayService offDayService;

    public OffDayController(OffDayService offDayService) {
        this.offDayService = offDayService;
    }

    @GetMapping
    public List<OffDayResponse> getAllOffDays() {
        return offDayService.getAll();
    }

    @GetMapping("/{id}")
    public OffDayResponse getOffDayById(@PathVariable long id) {
        return offDayService.getById(id);
    }

    @PostMapping
    public OffDayResponse createOffDay(@RequestBody CreateOffDayRequest request) {
        return offDayService.create(request);
    }

    @PutMapping("/{id}")
    public OffDayResponse updateOffDay(@PathVariable long id, @RequestBody UpdateOffDayRequest request) {
        return offDayService.update(request);
    }

    @DeleteMapping("/{id}")
    public void deleteOffDay(@PathVariable long id) {
        offDayService.delete(id);
    }
}
