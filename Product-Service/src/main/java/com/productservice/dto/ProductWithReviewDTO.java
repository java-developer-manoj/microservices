package com.productservice.dto;


import com.productservice.entity.Products;
import com.reviews.dto.ReviewDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductWithReviewDTO {
    private Products products;
    private Integer totalReviews;
    private String message;
    private boolean reviewAvailable;
    private List<ReviewDTO> reviewDTOList;
}
