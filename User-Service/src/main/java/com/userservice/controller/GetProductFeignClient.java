package com.userservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "PRODUCT-SERVICE")
public interface GetProductFeignClient {

    @GetMapping("/getProduct")
    String getProduct();
}