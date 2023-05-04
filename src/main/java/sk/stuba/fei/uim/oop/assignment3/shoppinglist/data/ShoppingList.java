package sk.stuba.fei.uim.oop.assignment3.shoppinglist.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListRequest;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Product productId;
    private Long amount;

    public ShoppingList(ShoppingListRequest r, Product p) {
        this.productId = p;
        this.amount = r.getAmount();
    }
}

