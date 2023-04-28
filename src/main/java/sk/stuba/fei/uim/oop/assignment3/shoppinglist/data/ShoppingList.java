package sk.stuba.fei.uim.oop.assignment3.shoppinglist.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListRequest;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;
    private Long amount;

    @ManyToOne
    private Cart cart;

    public ShoppingList(ShoppingListRequest r){
        this.productId = r.getProductId();
        this.amount = r.getAmount();
    }
}
