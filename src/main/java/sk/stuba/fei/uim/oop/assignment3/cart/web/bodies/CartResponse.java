package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

@Getter
@Setter
@NoArgsConstructor
public class CartResponse {
    private Long productId;
    private Long amount;
    public CartResponse(ShoppingList shoppingList){
        this.productId = shoppingList.getProductId();
        this.amount = shoppingList.getAmount();
    }
}
