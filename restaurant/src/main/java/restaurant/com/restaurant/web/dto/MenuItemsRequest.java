package restaurant.com.restaurant.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.com.restaurant.menuitem.model.MenuItemType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MenuItemsRequest {

    private String name;

    private MenuItemType menuItemType;

    private BigDecimal price;

    private BigDecimal discount;

    private String description;

    private String imagePath;

    private LocalDateTime createdAt;
}
