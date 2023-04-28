package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

import java.util.List;

@Getter
public class CartResponse {
   private Long id;
   private List<ShoppingList> shoppingList;
    private boolean payed;
    public CartResponse(Cart c){
        this.id = c.getId();
        this.shoppingList = c.getShoppingList();
        this.payed = c.isPayed();
    }
}
