package lv6;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> cartItems = new ArrayList<CartItem>();

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public void addToCart(MenuItem menuItem) {
        cartItems.add(new CartItem(menuItem, 1));
    }

    public void removeFromCart(MenuItem menuItem) {
        for (CartItem cartItem : cartItems) {
            if (menuItem.getName().equals(cartItem.getMenuItem().getName())) {
                cartItems.remove(cartItem);
            }
        }
    }

    public void clearCart() {
        cartItems.clear();
    }

    public void printCart() {
        System.out.println("[ CART ]");
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            System.out.printf("%-2d. %-15s | ₩ %-6d | %d%n", i+1 , cartItem.getMenuItem().getName(), cartItem.getMenuItem().getPrice(), cartItem.getTotalPrice());
        }
    }
}

