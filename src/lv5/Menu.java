package lv5;

import java.util.List;

public class Menu {
    public String category;
    public List<MenuItem> menuItems;

    Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public String getCategory() {
        return category;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

}
