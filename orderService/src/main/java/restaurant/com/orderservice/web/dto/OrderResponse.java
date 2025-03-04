package restaurant.com.orderservice.web.dto;


import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.com.orderservice.order.model.OrderStatus;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private OrderStatus orderStatus;

    private LocalDateTime finisedAt;

    private BigDecimal price;

    LocalDateTime createdAt;

}
