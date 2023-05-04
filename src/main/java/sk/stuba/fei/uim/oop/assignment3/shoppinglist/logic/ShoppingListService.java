package sk.stuba.fei.uim.oop.assignment3.shoppinglist.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.IShoppingListRepository;

@Service
public class ShoppingListService implements IShoppingListService{
    @Autowired
    IShoppingListRepository shoppingListRepository;

}
