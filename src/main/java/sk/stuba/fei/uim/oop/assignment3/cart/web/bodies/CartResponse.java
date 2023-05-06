package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class CartResponse {
   private Long id;
   private final List<ShoppingListResponse> shoppingList =  new ArrayList<>();
    private boolean payed;
    public CartResponse(Cart c){
        this.id = c.getId();
        this.shoppingList.addAll(c.getShoppingList().stream().map(ShoppingListResponse::new).collect(Collectors.toList()));
        this.payed = c.isPayed();
    }
}
