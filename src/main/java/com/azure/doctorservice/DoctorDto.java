package com.azure.doctorservice;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DoctorDto {

    private long id;
    private String name;
    private String department;
    private String country;
    private String city;
}
