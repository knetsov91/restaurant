package restaurant.com.restaurant.menuitem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.repository.MenuItemRepository;
import restaurant.com.restaurant.web.dto.MenuItemsRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public void create(MenuItemsRequest menuItem) {

        menuItemRepository.save(map(menuItem));
    }


    private MenuItem map(MenuItemsRequest menuItemsRequest) {
        return MenuItem
                .builder()
                .name(menuItemsRequest.getName())
                .menuItem(menuItemsRequest.getMenuItemType())
                .price(menuItemsRequest.getPrice())
                .discount(menuItemsRequest.getDiscount())
                .createdAt(LocalDateTime.now())
                .description(menuItemsRequest.getDescription())
                .imagePath(menuItemsRequest.getImagePath())
                .discount(menuItemsRequest.getDiscount())
                .build();
    }
}
