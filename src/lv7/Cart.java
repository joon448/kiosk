package lv7;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
            if (cartItem.getMenuItem().getName().equals(menuItem.getName())) {
                cartItem.addQuantity(quantity);
                return;
            }
        }
        cartItems.add(new CartItem(menuItem, quantity));
    }

    public void removeFromCart(MenuItem menuItem) {
        cartItems = cartItems.stream()
                .filter(c -> !menuItem.getName().equals(c.getMenuItem().getName()))
                .collect(Collectors.toList());
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
        System.out.println("\n[ Orders ]");
        IntStream.range(0, cartItems.size())
                .forEach(i-> {
                    CartItem cartItem = cartItems.get(i);
                    System.out.printf("%-2d. %-15s | ₩ %-6d * %d%n", i+1 , cartItem.getMenuItem().getName(), cartItem.getMenuItem().getPrice(), cartItem.getQuantity());});
        System.out.println("[ Total ]");
        System.out.printf("₩ %d%n", getTotalPrice());
    }
}

