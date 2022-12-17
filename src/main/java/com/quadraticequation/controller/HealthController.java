package com.quadraticequation.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class HealthController {
    @GetMapping(value = "/health")
    public ResponseEntity<String> heathCheck(){
        return ResponseEntity.ok("OK");
    }
}
