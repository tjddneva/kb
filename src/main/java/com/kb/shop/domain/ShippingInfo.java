package com.kb.shop.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class ShippingInfo {

    @Id
    private Long id;

    // Order id
    Long orderId;

    // OrderItem id
    Long orderItemId;

    private String shippingStatus;
}
