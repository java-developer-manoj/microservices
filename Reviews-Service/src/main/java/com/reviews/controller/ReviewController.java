package com.reviews.controller;

import com.reviews.dto.ReviewDTO;
import com.reviews.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewsService reviewsService;

    @GetMapping("/reviews/{productId}")
    public List<ReviewDTO> reviews(@PathVariable  Long productId) {
        final List<ReviewDTO> reviews = reviewsService.reviews(productId);
        return reviews;
    }
}
