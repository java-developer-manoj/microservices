package com.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.userservice.constants.EndPointConstants.GET_PRODUCT;
import static com.userservice.constants.EndPointConstants.GET_USER;

@RestController
public class UserController {

    @Autowired
    private GetProductFeignClient getProductFeignClient;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to User Service!!";
    }

    @GetMapping(GET_USER)
    public String getUser() {
        return "User Fetched Successfully!!";
    }

    @GetMapping(GET_PRODUCT)
    public String getProduct() {

        String product = getProductFeignClient.getProduct();

        return "User Service Called -> " + product;
    }
}