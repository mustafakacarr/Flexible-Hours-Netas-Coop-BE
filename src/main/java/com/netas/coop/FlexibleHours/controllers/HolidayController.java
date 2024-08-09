package com.netas.coop.FlexibleHours.controllers;

import com.netas.coop.FlexibleHours.requests.CreateHolidayRequest;
import com.netas.coop.FlexibleHours.requests.UpdateHolidayRequest;
import com.netas.coop.FlexibleHours.responses.HolidayResponse;
import com.netas.coop.FlexibleHours.services.HolidayService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<HolidayResponse> getAllHolidays() {
        return holidayService.getAll();
    }

    @GetMapping("/{id}")
    public HolidayResponse getHolidayById(@PathVariable long id) {
        return holidayService.getById(id);
    }

    @PostMapping
    public HolidayResponse createHoliday(@RequestBody CreateHolidayRequest request) {
        return holidayService.create(request);
    }

    @PutMapping("/{id}")
    public HolidayResponse updateHoliday(@PathVariable long id, @RequestBody UpdateHolidayRequest request) {
        return holidayService.update(request);
    }

    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable long id) {
        holidayService.delete(id);
    }
}
