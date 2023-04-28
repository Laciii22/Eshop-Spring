package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;

import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository repository;

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Cart create() {
        Cart c = new Cart();
        return this.repository.save(c);
    }

    @Override
    public Cart getById(Long id) throws NotFoundException {
        return this.repository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        this.repository.delete(this.getById(id));
    }

    @Override
    public Cart addNewProduct(ShoppingList productToAdd, Long id) throws NotFoundException, IllegalOperationException {
        return null;
    }
}