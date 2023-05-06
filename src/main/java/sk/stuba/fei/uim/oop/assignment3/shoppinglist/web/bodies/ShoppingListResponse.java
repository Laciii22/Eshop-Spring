package sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

@Getter
public class ShoppingListResponse {
    private final Long productId;
    private final Long amount;

    public ShoppingListResponse(ShoppingList s) {
        this.productId = s.getProductId();
        this.amount = s.getAmount();
    }
}
