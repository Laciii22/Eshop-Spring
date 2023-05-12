package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.cart.data.ICartRepository;

import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.logic.IProductService;

import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.IShoppingListRepository;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListRequest;

@Service
public class CartService implements ICartService {
    @Autowired
    private ICartRepository cartRepository;
    @Autowired
    private IProductService productService;
    @Autowired
    private IShoppingListRepository shoppingListRepository;

    @Override
    public Cart create() {
        Cart cart = new Cart();
        this.cartRepository.save(cart);
        return cart;

    }

    @Override
    public Cart getById(Long id) throws NotFoundException {
        return cartRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @Override
    public void delete(Long id) throws NotFoundException {
        Cart cart = cartRepository.findById(id).orElseThrow(NotFoundException::new);
        cartRepository.delete(cart);
    }

    @Override
    public Cart addProduct(Long cartId, ShoppingListRequest request) throws NotFoundException, IllegalOperationException {
        Product product = this.productService.getById(request.getProductId());
        Cart cart = getById(cartId);
        if (cart.isPayed() || product.getAmount() < request.getAmount()) {
            throw new IllegalOperationException();
        }
        ShoppingList shoppingList = findShoppingListByProductId(cart, request.getProductId());
        if (shoppingList != null) {
            shoppingList.setAmount(shoppingList.getAmount() + request.getAmount());
        } else {
            shoppingList = createNewShoppingList(request);
            cart.getShoppingList().add(shoppingList);
        }

        this.shoppingListRepository.save(shoppingList);
        product.setAmount(product.getAmount() - request.getAmount());
        return cart;
    }

    private ShoppingList findShoppingListByProductId(Cart cart, Long productId) {
        return cart.getShoppingList().stream().filter(s -> s.getProductId().equals(productId)).findFirst().orElse(null);
    }

    private ShoppingList createNewShoppingList(ShoppingListRequest request) {
        ShoppingList shoppingList = new ShoppingList();
        shoppingList.setProductId(request.getProductId());
        shoppingList.setAmount(request.getAmount());
        return shoppingList;
    }




    @Override
    public String payCart(Long id) throws NotFoundException, IllegalOperationException {
        Cart cart = getById(id);
        if (cart.isPayed()) {
            throw new IllegalOperationException();
        }

        double sum = calculateCartTotal(cart);
        cart.setPayed(true);
        this.cartRepository.save(cart);

        return Double.toString(sum);
    }

    private double calculateCartTotal(Cart cart) throws NotFoundException {
        double sum = 0.0;
        for (ShoppingList shoppingList : cart.getShoppingList()) {
            Long productId = shoppingList.getProductId();
            Long amount = shoppingList.getAmount();
            Product product = this.productService.getById(productId);
            double price = product.getPrice();
            sum += price * amount;
        }
        return sum;
    }



}



