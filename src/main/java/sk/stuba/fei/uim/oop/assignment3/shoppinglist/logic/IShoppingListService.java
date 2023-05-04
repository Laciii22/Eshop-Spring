package sk.stuba.fei.uim.oop.assignment3.shoppinglist.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

public interface IShoppingListService {
    ShoppingList create();

    ShoppingList getById(Long id) throws NotFoundException;

    void deleteById(Long id) throws NotFoundException;

    ShoppingList update(ShoppingList shoppingList);
}
