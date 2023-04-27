package sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

import java.util.List;
import java.util.stream.Collectors;

public class ShoppingListResponse {
    private Long id;
    private List<ShoppingList> shoppingList;
    boolean payed;

    public ShoppingListResponse(Cart cart) {
        this.id = cart.getId();
        this.shoppingList = cart.getShoppingList().stream().map(ShoppingList::new).collect(Collectors.toList());
        this.payed = cart.isPayed();
    }
}
