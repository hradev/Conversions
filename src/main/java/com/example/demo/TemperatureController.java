/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author henk
 */
public class TemperatureController {
    @RequestMapping("/conversions/ktoc")
    public CelsiusResponse getCelsius(String kelvin) {
        return new CelsiusResponse(50);
    }
    
    @RequestMapping("/conversions/ctok")
    public KelvinResponse getKelvin(double celsius) {
        return new KelvinResponse(100);
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
