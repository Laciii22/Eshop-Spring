package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

public interface ICartService {
    Cart create();
    Cart getById(Long id) throws NotFoundException;

    void delete(Long id) throws NotFoundException;
    Cart addNewProduct(ShoppingList productToAdd, Long id) throws NotFoundException, IllegalOperationException;

}
