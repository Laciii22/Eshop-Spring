package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;

import java.util.List;

public interface ICartService {
    List<Cart> getAll();

    Cart create(CartRequest body);
}
