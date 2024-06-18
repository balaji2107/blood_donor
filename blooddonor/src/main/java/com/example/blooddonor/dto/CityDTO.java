package com.example.blooddonor.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityDTO {

    private Long id;
    private String name;
    private DistrictDTO district;

    public CityDTO(Long id, String name) {
        this.setId(id);
        this.setName(name);
    }
}
