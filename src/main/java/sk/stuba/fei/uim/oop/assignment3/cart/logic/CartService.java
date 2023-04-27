package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

public class CartService implements ICartService{
    @Autowired
    private ICartRepository repository;
    @Override
    public Cart create() {
        return this.repository.save(new Cart());
    }

    @Override
    public Cart getById(Long id) throws NotFoundException {
        return null;
    }
}
