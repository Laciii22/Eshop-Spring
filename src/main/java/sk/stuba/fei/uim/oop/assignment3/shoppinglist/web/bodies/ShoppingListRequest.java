package sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingListRequest {
    private Long productId;
    private Long amount;
}
