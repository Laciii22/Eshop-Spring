package sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingListRequest {
    private Long productId;
    private Long amount;

    public ShoppingListRequest(ShoppingList s) {
        this.productId = s.getProductId().getId();
        this.amount = s.getAmount();
    }
}
