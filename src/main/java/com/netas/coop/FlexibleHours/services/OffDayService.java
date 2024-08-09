package com.netas.coop.FlexibleHours.services;

import com.netas.coop.FlexibleHours.entities.OffDayEntity;
import com.netas.coop.FlexibleHours.entities.UserEntity;
import com.netas.coop.FlexibleHours.repositories.OffDayRepository;
import com.netas.coop.FlexibleHours.repositories.UserRepository;
import com.netas.coop.FlexibleHours.requests.CreateOffDayRequest;
import com.netas.coop.FlexibleHours.requests.UpdateOffDayRequest;
import com.netas.coop.FlexibleHours.responses.OffDayResponse;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OffDayService {

    private final OffDayRepository offDayRepository;
    private final UserRepository userRepository;

    public OffDayService(OffDayRepository offDayRepository, UserRepository userRepository) {
        this.offDayRepository = offDayRepository;
        this.userRepository = userRepository;
    }

    public List<OffDayResponse> getAll() {
        return offDayRepository.findAll().stream().map((offDay) -> new OffDayResponse(offDay)).collect(Collectors.toList());
    }

    public OffDayResponse getById(long id) {
        OffDayEntity offDay = offDayRepository.findById(id).orElseThrow(() -> new RuntimeException("Off day not found"));
        return new OffDayResponse(offDay);
    }

    public OffDayResponse create(CreateOffDayRequest request) {
        OffDayEntity offDay = new OffDayEntity();

        offDay.setStartDate(request.startDate());
        offDay.setEndDate(request.endDate());
        offDay.setDescription(request.description());
        UserEntity user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        offDay.setUserEntity(user);
        return new OffDayResponse(offDayRepository.save(offDay));
    }

    public OffDayResponse update(UpdateOffDayRequest request) {
        OffDayEntity offDay = offDayRepository.findById(request.id()).orElseThrow();

        offDay.setStartDate(request.startDate());
        offDay.setEndDate(request.endDate());
        offDay.setDescription(request.description());
        UserEntity user = userRepository.findById(request.userId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        offDay.setUserEntity(user);
        return new OffDayResponse(offDayRepository.save(offDay));
    }

    public void delete(long id) {
        offDayRepository.deleteById(id);
    }

}
