package restaurant.com.restaurant.web.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import restaurant.com.restaurant.menuitem.model.MenuItemType;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateMenuItemRequest {

    @Size(min = 2)
    @NotBlank
    private String name;

    @NotNull
    private MenuItemType menuItemType;

    @Positive
    private BigDecimal price;

    @PositiveOrZero
    private BigDecimal discount;

    @Size(min = 10)
    @NotBlank
    private String description;

    private String imagePath;
}
