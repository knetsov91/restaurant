package restaurant.com.restaurant.menuitem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restaurant.com.restaurant.menuitem.model.MenuItem;
import restaurant.com.restaurant.menuitem.repository.MenuItemRepository;
import restaurant.com.restaurant.web.dto.CreateMenuItemRequest;
import restaurant.com.restaurant.web.mapper.DtoMapper;
import java.util.List;
import java.util.UUID;

@Service
public class MenuItemService {

    private final MenuItemRepository menuItemRepository;

    @Autowired
    public MenuItemService(MenuItemRepository menuItemRepository) {
        this.menuItemRepository = menuItemRepository;
    }

    public List<MenuItem> getAllMenuItems() {
        return menuItemRepository.findAll();
    }

    public void createMenuItem(CreateMenuItemRequest menuItem) {
        MenuItem mapped = DtoMapper.mapCreateMenuItemRequestToMenuItem(menuItem);

        menuItemRepository.save(mapped);
    }

    public MenuItem getMenuItemById(UUID menuItemId) {
        return menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("No menu item found with id: " + menuItemId));
    }
}