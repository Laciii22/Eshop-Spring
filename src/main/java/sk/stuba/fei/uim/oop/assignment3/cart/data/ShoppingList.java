package sk.stuba.fei.uim.oop.assignment3.cart.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
@NoArgsConstructor

public class ShoppingList {
    @Id
    private Long id;
    @ManyToOne
    private Cart cart;
    private Long productId;
    private Long amount;

}
