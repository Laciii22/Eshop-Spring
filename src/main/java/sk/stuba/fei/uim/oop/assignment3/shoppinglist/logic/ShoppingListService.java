package sk.stuba.fei.uim.oop.assignment3.shoppinglist.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.IShoppingListRepository;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

@Service
public class ShoppingListService implements IShoppingListService{
    @Autowired
    IShoppingListRepository shoppingListRepository;

    @Override
    public ShoppingList create() {
        return this.shoppingListRepository.save(new ShoppingList());
    }

    @Override
    public ShoppingList getById(Long id) throws NotFoundException {
        ShoppingList shoppingList = this.shoppingListRepository.findShoppingListById(id);
        if (shoppingList == null) {
            throw new NotFoundException();
        }
        return shoppingList;
    }

    @Override
    public void deleteById(Long id) throws NotFoundException {
       shoppingListRepository.delete(getById(id));
    }

    @Override
    public ShoppingList update(ShoppingList shoppingList) {
        return shoppingListRepository.save(shoppingList);
    }
}
