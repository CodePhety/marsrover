package com.codephety.controller;

import com.codephety.objects.PlaneteryData;
import com.codephety.service.MarsRoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/")
public class MarsRoverController {

    @Autowired
    private MarsRoverService marsRoverService;

    @RequestMapping("v1/marsrover")
    public List<PlaneteryData> fetchMarsRoverData() {
        return marsRoverService.fetchMarsRoverDataWithDateFile();
    }

    @RequestMapping("v2/marsrover")
    public PlaneteryData fetchMarsRoverData(@RequestParam String date) {
        return marsRoverService.fetchMarsRoverDateWithSingleDate(date);
    }


}