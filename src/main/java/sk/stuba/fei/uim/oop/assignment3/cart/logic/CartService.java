package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;

import java.util.List;

@Service
public class CartService implements ICartService{
    @Autowired
    private ICartRepository repository;

    @Override
    public List<Cart> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Cart create(CartRequest request) {
        return this.repository.save(new Cart((CartRequest) request.getShoppingList()));
    }



}
