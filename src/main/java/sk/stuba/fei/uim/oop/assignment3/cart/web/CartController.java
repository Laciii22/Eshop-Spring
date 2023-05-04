package sk.stuba.fei.uim.oop.assignment3.cart.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListRequest;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService service;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<CartResponse> createCart() {
        return new ResponseEntity<>(new CartResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse getById(@PathVariable ("id") Long id) throws NotFoundException {
        return new CartResponse(this.service.getById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCart(@PathVariable("id") Long id) throws NotFoundException {
        this.service.delete(id);
    }

    @PostMapping(value = "/{id}/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CartResponse addProduct(@PathVariable("id") Long id, @RequestBody ShoppingListRequest request) throws NotFoundException, IllegalOperationException {
        return new CartResponse(this.service.addProduct(id, request));
    }
}
