package com.productservice.entity;

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
@Table(name = "products")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    private String description;

    private BigDecimal price;

    @Column(name = "stock_quantity")
    private Long stockQuantity;

    @Column(name = "image_url")
    private String imageUrl;

    private String category;
}