package com.reviews.service;

import com.reviews.dto.ReviewDTO;

import java.util.List;

public interface ReviewsService {

    List<ReviewDTO> reviews(Long productId);
}
