package com.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiGateWayController {

    @GetMapping("/")
    public String apiGateWay() {
        return "API GateWay";
    }
}
