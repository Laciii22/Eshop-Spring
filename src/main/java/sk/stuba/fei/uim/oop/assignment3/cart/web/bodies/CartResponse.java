package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListResponse;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class CartResponse {
   private Long id;
   private List<ShoppingListResponse> shoppingList;
    private boolean payed;
    public CartResponse(Cart c){
        this.id = c.getId();
        this.shoppingList = c.getShoppingList().stream().map(ShoppingListResponse::new).collect(Collectors.toList());
        this.payed = c.isPayed();
    }
}
