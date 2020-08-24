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
public class TemperatureController {
    @GetMapping("/conversions/ktoc")
    public CelsiusResponse getCelsius(@RequestBody CelsiusRequest celsiusRequest) {
        
        return new CelsiusResponse(celsiusRequest.getKelvin() - 273.15);
    }
    
    @GetMapping("/conversions/ctok")
    public KelvinResponse getKelvin(@RequestBody KelvinRequest celsius) {
        return new KelvinResponse(celsius.getCelsius() + 273.15);
    }
}

class KelvinResponse {
    
    private double kelvin;

    public KelvinResponse(double kelvin) {
        this.kelvin = kelvin;
    }

    public double getKelvin() {
        return kelvin;
    }
}

class CelsiusResponse {
    
    private double celsius;

    public CelsiusResponse(double celsius) {
        this.celsius = celsius;
    }
    
    public double getCelsius() {
        return celsius;
    }
}

class CelsiusRequest {
    private double kelvin;

    public double getKelvin() {
        return kelvin;
    }

    public void setKelvin(double kelvin) {
        this.kelvin = kelvin;
    }
}

class KelvinRequest {
    private double celsius;
    
    public double getCelsius() {
        return celsius;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }
}