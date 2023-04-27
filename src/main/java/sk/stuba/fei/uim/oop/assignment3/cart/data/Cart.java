package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(cascade = {CascadeType.REMOVE})
    private List<ShoppingList> shoppingLists;

    private boolean payed;
    public Cart(CartRequest request) {
        this.shoppingLists = new ArrayList<>();
    }
}
