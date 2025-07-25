package lv6;

import java.util.Collections;
import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> menuItems;

    Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItems() {
        return Collections.unmodifiableList(menuItems);
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
    
    // 메뉴 아이템 출력 기능
    public void printMenuItems() {
        System.out.printf("[ %s MENU ]%n", category);
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            System.out.printf("%-2d. %-15s | ₩ %-6d | %s%n", i+1 , menuItem.getName(), menuItem.getPrice(), menuItem.getDetail());
        }
        System.out.println("0 . 뒤로 가기");
    }
}
