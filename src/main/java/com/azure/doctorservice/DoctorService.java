package com.azure.doctorservice;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DoctorService {

    private List<DoctorDto> doctorDtoList = new ArrayList<>();

    {
        DoctorDto doctorDto1 = DoctorDto.builder().id(1).name("venkatesh").department("ONCOLOGY").city("Hyderabad").country("India").build();
        DoctorDto doctorDto2 = DoctorDto.builder().id(2).name("suguna").department("PEDIATRIAN").city("Hyderabad").country("India").build();
        DoctorDto doctorDto3 = DoctorDto.builder().id(3).name("sruthi").department("SKIN").city("Hyderabad").country("India").build();
        DoctorDto doctorDto4 = DoctorDto.builder().id(4).name("kitty").department("ORTHO").city("Hyderabad").country("India").build();
        doctorDtoList.addAll(Arrays.asList(doctorDto1, doctorDto2, doctorDto3, doctorDto4));
    }

    public DoctorDto addDoctor(DoctorDto dto) {
        DoctorDto doctorDto = doctorDtoList.stream().filter(doc -> dto.getId() == doc.getId()).findFirst().orElse(null);
        if (doctorDto != null) {
            throw new RuntimeException("Doctor with id " + dto.getId() + " is already present");
        }

        doctorDtoList.add(dto);
        return dto;
    }

    public DoctorDto findDoctorById(long id) {
        return doctorDtoList.stream().filter(doc -> doc.getId() == id).findFirst().orElse(null);
    }

    public void removeDoctor(long id) {
        DoctorDto dto = doctorDtoList.stream().filter(doc -> doc.getId() == id).findFirst().orElse(null);
        if (dto != null) {
            doctorDtoList.remove(dto);
        }
    }

    public List<DoctorDto> findAllDoctors() {
        return doctorDtoList;
    }
}
