package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies/year")
    public ResponseEntity<List<Whisky>> findWhiskyByYear(@RequestParam(name="year", required = false) Integer year) {
    if (year != null){
        return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
    }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> findWhiskyByAgeAndDistilleryName
            (@RequestParam(name = "age", required = false) Integer age,
             @RequestParam(name="distillery", required= false) String distillery){
        if((age != null) && (distillery != null)){
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryName(age, distillery), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> findWhiskyByRegion
            (@RequestParam(name = "region", required = false) String region){
        if (region != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


}
