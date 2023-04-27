package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.REMOVE)
    private List<ShoppingList> shoppingList;

    private boolean payed;
}
