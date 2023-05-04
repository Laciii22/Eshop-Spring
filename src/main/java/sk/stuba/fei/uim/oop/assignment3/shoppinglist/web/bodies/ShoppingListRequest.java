package sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ShoppingListRequest {
    private Long productId;
    private Long amount;

}
