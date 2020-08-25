/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DistanceController {
    @LogExecutionTime
    @GetMapping("/conversions/mtok")
    public KilometerResponse getMiles(@RequestBody KilometerRequest kilometerRequest) {
        return new KilometerResponse(kilometerRequest.getMiles() * 1.609);
    }
    
    @LogExecutionTime
    @GetMapping("/conversions/ktom")
    public MilesResponse getKilometer(@RequestBody MilesRequest milesRequest) {
        return new MilesResponse(milesRequest.getKilometer() / 1.609);
    }
}

class MilesResponse {
    
    private double miles;

    public MilesResponse(double miles) {
        this.miles = miles;
    }

    public double getMiles() {
        return miles;
    }
}

class KilometerResponse {
    
    private double kilometer;

    public KilometerResponse(double kilometer) {
        this.kilometer = kilometer;
    }
    
    public double getKilometer() {
        return kilometer;
    }
}

class MilesRequest {
    private double kilometer;

    public double getKilometer() {
        return kilometer;
    }

    public void setKilometer(double kilometer) {
        this.kilometer = kilometer;
    }
}

class KilometerRequest {
    private double miles;
    
    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }
}