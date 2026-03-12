package com.productservice.controller;

import com.productservice.dto.ProductWithReviewDTO;
import com.productservice.service.ProductService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static com.productservice.constants.EndPointConstants.GET_PRODUCT;


@RestController
public class ProductController {

    @Autowired
    private Environment environment;

    @Autowired
    private ProductService productService;

    @GetMapping(GET_PRODUCT)
    public String getProduct() {
        return "Product Fetched Successfully!!"+"Port No -> "+"("+environment.getProperty("server.port")+")";
    }

    @GetMapping("/getProductWithReviews/{productId}")
    public ResponseEntity<?> getProductWithReviews(@PathVariable Long productId)
    {
        final ProductWithReviewDTO productWithReviews = productService.getProductWithReviews(productId);
        return ResponseEntity.ok(productWithReviews);
    }


}
