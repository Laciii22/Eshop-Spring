package sk.stuba.fei.uim.oop.assignment3.cart.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.cart.logic.CartService;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartRequest;
import sk.stuba.fei.uim.oop.assignment3.cart.web.bodies.CartResponse;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CartResponse> getAll() {
        return service.getAll().stream().map(CartResponse::new).collect(Collectors.toList());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CartResponse> addCart(@RequestBody CartRequest body) throws NotFoundException {
        return new ResponseEntity<>(new CartResponse(service.create(body)), HttpStatus.CREATED);
    }

}
