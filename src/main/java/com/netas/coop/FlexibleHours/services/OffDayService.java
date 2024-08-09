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
        return offDayRepository.findAll().stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    public OffDayResponse getById(long id) {
        return offDayRepository.findById(id).map(this::mapToResponse).orElseThrow();
    }

    public OffDayResponse create(CreateOffDayRequest request) {
        OffDayEntity offDay = new OffDayEntity();
        offDay.setDate(request.date());
        offDay.setDescription(request.description());
        UserEntity user = userRepository.findById(request.userId())
                                        .orElseThrow(() -> new IllegalArgumentException("User not found"));
        offDay.setUserEntity(user);
        return mapToResponse(offDayRepository.save(offDay));
    }

    public OffDayResponse update(UpdateOffDayRequest request) {
        OffDayEntity offDay = offDayRepository.findById(request.id()).orElseThrow();
        offDay.setDate(request.date());
        offDay.setDescription(request.description());
        UserEntity user = userRepository.findById(request.userId())
                                        .orElseThrow(() -> new IllegalArgumentException("User not found"));
        offDay.setUserEntity(user);
        return mapToResponse(offDayRepository.save(offDay));
    }

    public void delete(long id) {
        offDayRepository.deleteById(id);
    }

    private OffDayResponse mapToResponse(OffDayEntity entity) {
        return new OffDayResponse(entity.getId(), entity.getDate(), entity.getDescription(), entity.getUserEntity().getId());
    }
}
