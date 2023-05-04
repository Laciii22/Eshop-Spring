package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;

import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

import sk.stuba.fei.uim.oop.assignment3.shoppinglist.logic.IShoppingListService;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListRequest;


@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository cartRepository;
    @Autowired
    IProductService productService;
    @Autowired
    IShoppingListService shoppingListService;

    @Override
    public Cart create() {
        return this.cartRepository.save(new Cart());
    }

    @Override
    public Cart getById(Long id) throws NotFoundException {
        Cart cart = this.cartRepository.findCartById(id);
        if (cart == null) {
            throw new NotFoundException();
        }
        return cart;
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        this.cartRepository.delete(this.getById(id));
    }

    @Override
    public Cart addProduct(Long cartId, ShoppingListRequest productId) throws NotFoundException, IllegalOperationException {
        Cart cart = this.getById(cartId);
        Product product = this.productService.getById(productId.getProductId());
        if (cart.isPayed() || product.getAmount() < productId.getAmount()) {
            throw new IllegalOperationException();
        }
        else{
            this.cartRepository.save(cart);
            product.setAmount(product.getAmount() - productId.getAmount());
        }
        return cart;
    }
}



