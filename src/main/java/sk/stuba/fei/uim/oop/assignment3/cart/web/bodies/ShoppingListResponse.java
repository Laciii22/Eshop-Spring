package sk.stuba.fei.uim.oop.assignment3.cart.web.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingListResponse {
    private final Long productId;
    private final Long amount;

    public ShoppingListResponse(Long id, Long productId, Long amount) {
        this.productId = productId;
        this.amount = amount;
    }
}
