package sk.stuba.fei.uim.oop.assignment3.cart.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.ICartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.data.ShoppingList;
import sk.stuba.fei.uim.oop.assignment3.shoppinglist.web.bodies.ShoppingListResponse;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private ICartService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ShoppingListResponse> addCart() {
        return new ResponseEntity<>(new ShoppingListResponse(this.service.create()), HttpStatus.CREATED);
    }

}
