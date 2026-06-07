package com.azure.doctorservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Value("${config1}")
    private  String configValue;
    @Value("${config2}")
    private String configValue2;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping
    public ResponseEntity<DoctorDto> createDoctor(@RequestBody DoctorDto dto) {
        DoctorDto doctorDto = doctorService.addDoctor(dto);
        return new ResponseEntity<>(doctorDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{doctor-id}")
    public ResponseEntity<Void> DeleteDoctor(@PathVariable(name = "doctor-id") long id) {
        doctorService.removeDoctor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{doctor-id}")
    public ResponseEntity<DoctorDto> getDoctor(@PathVariable(name = "doctor-id") long id) {
        DoctorDto doctorDto = doctorService.findDoctorById(id);
        return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<DoctorDto>> getDoctors() {
        List<DoctorDto> doctorDto = doctorService.findAllDoctors();
        return new ResponseEntity<>(doctorDto, HttpStatus.OK);
    }

    @GetMapping("/secrets")
    public ResponseEntity<String> getSecrets() {
        String secrets = "name: Venkatesh bestfriend: ishira";
        return new ResponseEntity<>(secrets, HttpStatus.OK);
    }

    @GetMapping("/config")
    public ResponseEntity<String> getConfig() {
        String value = configValue + " " + configValue2;
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
}
