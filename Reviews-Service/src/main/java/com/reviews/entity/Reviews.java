package com.reviews.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private BigDecimal rating;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "product_id")
    private Long productId;
}




