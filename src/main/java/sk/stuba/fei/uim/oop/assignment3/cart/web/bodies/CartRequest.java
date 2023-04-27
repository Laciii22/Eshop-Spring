package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class CartRequest {
    private Long id;
    private List<ShoppingListResponse> shoppingList;
    private boolean payed;

    public CartRequest(Long id, List<ShoppingListResponse> shoppingList, boolean payed) {
        this.id = id;
        this.shoppingList = shoppingList;
        this.payed = payed;
    }
}