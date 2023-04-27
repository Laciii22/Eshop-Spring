package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartResponse {
    private final Long id;
    private final List<ShoppingListResponse> shoppingList;
    private final boolean payed;

    public CartResponse(Cart c){
        shoppingList = new ArrayList<>();
        this.id = c.getId();
        for (int i = 0; i < c.getShoppingLists().size(); i++) {
            this.shoppingList.add(new ShoppingListResponse((Long) c.getShoppingLists().get(i).getId(), c.getShoppingLists().get(i).getProductId(), c.getShoppingLists().get(i).getAmount()));
        }
        this.payed = c.isPayed();
    }
}

