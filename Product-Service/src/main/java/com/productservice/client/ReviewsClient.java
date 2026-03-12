package com.productservice.client;

import com.reviews.dto.ReviewDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "REVIEWS-SERVICE")
public interface ReviewsClient {
    @GetMapping("/reviews/{productId}")
    List<ReviewDTO> reviews(@PathVariable  Long productId);
}
