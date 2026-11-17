
package com.klef.soa.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Tourist;
import com.klef.soa.service.TouristService;
import com.klef.soa.security.JwtUtil;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService service;
    private final JwtUtil jwtUtil;

    public TouristController(
            TouristService service,
            JwtUtil jwtUtil) {

        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    // ADD TOURIST AND GENERATE JWT
    @PostMapping("/add")
    public Map<String, Object> addTourist(
            @RequestBody Tourist tourist) {

        Tourist savedTourist =
                service.addTourist(tourist);

        String token =
                jwtUtil.generateToken(savedTourist.getEmail());

        Map<String, Object> response =
                new LinkedHashMap<>();

        response.put("message", "Tourist added successfully");
        response.put("tourist", savedTourist);
        response.put("token", token);

        return response;
    }

    // DISPLAY TOURIST BY ID
    @GetMapping("/{id}")
    public Tourist getTouristById(
            @PathVariable Long id) {

        return service.getTouristById(id);
    }

   
}
