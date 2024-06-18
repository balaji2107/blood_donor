package com.example.blooddonor.controller;

import com.example.blooddonor.dto.CityDTO;
import com.example.blooddonor.dto.DistrictDTO;
import com.example.blooddonor.dto.FindDonor;
import com.example.blooddonor.dto.StateDTO;
import com.example.blooddonor.service.ICityService;
import com.example.blooddonor.service.IDistrictService;
import com.example.blooddonor.service.IStateService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CommonController {

    @Autowired
    private IStateService stateService;
    @Autowired
    private IDistrictService districtService;
    @Autowired
    private ICityService cityService;

    @PostMapping("/onFindDonors")
    public String onFindDonors(@RequestBody FindDonor findDonor) {
        return "ok";
    }

    @GetMapping("/onGetStateByCountryId")
    public ResponseEntity<List<StateDTO>> onGetStateByCountryId(@RequestParam("countryId") Long countryId) {
        List<StateDTO> states = stateService.onGetStateByCountryId(countryId);
        if (states != null || !states.isEmpty())
            return ResponseEntity.ok(states);
        else
            return ResponseEntity.status(200).body(null);
    }

    @GetMapping("/onGetDistrictByStateId")
    public ResponseEntity<List<DistrictDTO>> onGetDistrictByStateId(@RequestParam("stateId") Long stateId) {
        List<DistrictDTO> districts = districtService.onGetStateById(stateId);
        if (districts != null || !districts.isEmpty())
            return ResponseEntity.ok(districts);
        else
            return ResponseEntity.status(200).body(null);
    }

    @GetMapping("/onGetCityByDistrictId")
    public ResponseEntity<List<CityDTO>> onGetCityByDistrictId(@RequestParam("districtId") Long districtId) {
        List<CityDTO> cities = cityService.onGetCityByDistrictId(districtId);
        if (cities != null || !cities.isEmpty())
            return ResponseEntity.ok(cities);
        else
            return ResponseEntity.status(200).body(null);
    }

}
