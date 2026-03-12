package com.productservice.service;

import com.productservice.dto.ProductWithReviewDTO;

public interface ProductService {

  ProductWithReviewDTO getProductWithReviews(Long productId);
  ProductWithReviewDTO getProductWithoutReviews(Long productId,Throwable ex);
}
