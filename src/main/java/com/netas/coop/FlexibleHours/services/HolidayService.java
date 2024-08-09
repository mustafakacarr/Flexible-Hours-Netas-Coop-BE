package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.HolidayEntity;
import com.netas.coop.FlexibleHours.repositories.HolidayRepository;
import com.netas.coop.FlexibleHours.requests.CreateHolidayRequest;
import com.netas.coop.FlexibleHours.requests.UpdateHolidayRequest;
import com.netas.coop.FlexibleHours.responses.HolidayResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;

    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public List<HolidayResponse> getAll() {
        return holidayRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public HolidayResponse getById(long id) {
        return holidayRepository.findById(id).map(this::mapToResponse).orElseThrow();
    }

    public HolidayResponse create(CreateHolidayRequest request) {
        HolidayEntity holiday = new HolidayEntity();
        holiday.setStartDate(request.startDate());
        holiday.setEndDate(request.endDate());
        holiday.setName(request.name());
        return mapToResponse(holidayRepository.save(holiday));
    }

    public HolidayResponse update(UpdateHolidayRequest request) {
        HolidayEntity holiday = holidayRepository.findById(request.id()).orElseThrow();
        holiday.setStartDate(request.startDate());
        holiday.setEndDate(request.endDate());
        holiday.setName(request.name());
        return mapToResponse(holidayRepository.save(holiday));
    }

    public void delete(long id) {
        holidayRepository.deleteById(id);
    }

    private HolidayResponse mapToResponse(HolidayEntity entity) {
        return new HolidayResponse(entity.getId(), entity.getStartDate(), entity.getEndDate(), entity.getName());
    }
}
