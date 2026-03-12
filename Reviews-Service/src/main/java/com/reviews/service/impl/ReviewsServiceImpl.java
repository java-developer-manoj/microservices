package com.reviews.service.impl;

import com.reviews.dto.ReviewDTO;
import com.reviews.entity.Reviews;
import com.reviews.repository.ReviewsRepository;
import com.reviews.service.ReviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewsServiceImpl implements ReviewsService {

    @Autowired
    private ReviewsRepository reviewsRepository;

    private ReviewDTO reviewDTO;

    @Override
    public List<ReviewDTO> reviews(Long productId) {

        final List<Reviews> reviews = reviewsRepository.findByProductId(productId);
        ReviewDTO reviewDTO = new ReviewDTO();

        return reviews.stream().map(review -> {
            reviewDTO.setComment(review.getComment());
            reviewDTO.setRating(review.getRating());
            reviewDTO.setUserId(review.getUserId());
            reviewDTO.setProductId(review.getProductId());
            return reviewDTO;
        }).toList();


    }

}
