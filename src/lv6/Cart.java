package lv6;

import java.util.List;

public class Cart {
    private List<MenuItem> cartItems;

    public List<MenuItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<MenuItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(MenuItem menuItem) {
        cartItems.add(menuItem);
    }

    public void removeFromCart(MenuItem menuItem) {
        cartItems.remove(menuItem);
    }

    public void clearCart() {
        cartItems.clear();
    }

    public void printCart() {
        System.out.println("[ CART ]");
        for (int i = 0; i < cartItems.size(); i++) {
            MenuItem menuItem = cartItems.get(i);
            System.out.printf("%-2d. %-15s | ₩ %-6d | %s%n", i+1 , menuItem.getName(), menuItem.getPrice(), menuItem.getDetail());
        }
    }
}

