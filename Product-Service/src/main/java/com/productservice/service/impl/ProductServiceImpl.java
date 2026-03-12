package com.productservice.service.impl;

import com.productservice.client.ReviewsClient;
import com.productservice.dto.ProductWithReviewDTO;
import com.productservice.entity.Products;
import com.productservice.repository.ProductsRepository;
import com.productservice.service.ProductService;
import com.reviews.dto.ReviewDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private ReviewsClient reviewsClient;

    @Override
    @CircuitBreaker(name = "REVIEWS-SERVICE", fallbackMethod = "getProductWithoutReviews")
    public ProductWithReviewDTO getProductWithReviews(Long productId) {
        final Products product = productsRepository.findById(productId).
                                 orElseThrow(() -> new RuntimeException
                                 ("Product Not Found with this Product Id"));
        final List<ReviewDTO> reviews = reviewsClient.reviews(productId);

        return ProductWithReviewDTO.builder()
                .products(product).
                totalReviews(reviews.size())
                .message("Reviews Available")
                .reviewAvailable(true)
                .reviewDTOList(reviews)
                .build();
    }


    @Override
    public ProductWithReviewDTO getProductWithoutReviews(Long productId, Throwable ex) {
        final Products product = productsRepository.findById(productId)
                                .orElseThrow(() -> new RuntimeException
                                 ("Product Not Found with this Product Id"));

        return ProductWithReviewDTO.builder()
                .products(product).totalReviews(0)
                .message("Reviews Not Available !!Something Went Wrong Pleas Try Again!!!")
                .reviewAvailable(false)
                .reviewDTOList(Collections.emptyList())
                .build();
    }


}
