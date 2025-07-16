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

    public void addToCart(MenuItem menuItem, int quantity) {
        for (CartItem cartItem : cartItems) {
            if (cartItem.getMenuItem().equals(menuItem)) {
                cartItem.addQuantity(quantity);
                return;
            }
        }
        cartItems.add(new CartItem(menuItem, quantity));
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
        System.out.println("\n아래와 같이 주문하시겠습니까?\n");
        System.out.println("[ Orders ]");
        for (int i = 0; i < cartItems.size(); i++) {
            CartItem cartItem = cartItems.get(i);
            System.out.printf("%-2d. %-15s | ₩ %-6d * %d%n", i+1 , cartItem.getMenuItem().getName(), cartItem.getMenuItem().getPrice(), cartItem.getQuantity());
        }
        System.out.println("[ Total ]");
        System.out.printf("₩ %d%n", getTotalPrice());
    }
}

