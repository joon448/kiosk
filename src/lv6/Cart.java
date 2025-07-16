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

    public int getTotalPrice(){
        int totalPrice = 0;
        for(CartItem cartItem : cartItems){
            totalPrice += cartItem.getTotalPrice();
        }
        return totalPrice;
    }

    public void printCart() {
        System.out.println("아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            System.out.printf("%-2d. %-15s | %-2d개 | ₩ %-6d%n", i+1 , cartItem.getMenuItem().getName(), cartItem.getQuantity(), cartItem.getMenuItem().getPrice());
        }
        System.out.println("[ Total ]");
        System.out.printf("₩ %d", getTotalPrice());
    }
}

