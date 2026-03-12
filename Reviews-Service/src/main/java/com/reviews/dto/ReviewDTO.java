package com.reviews.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewDTO {
    private String comment;
    private BigDecimal rating;
    private Long userId;
    private Long productId;
}
