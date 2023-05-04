package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListRequest;

public interface ICartService {

    Cart create();

    Cart getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;

    Cart addProduct(Long cartId, ShoppingListRequest productId) throws NotFoundException, IllegalOperationException;
}
