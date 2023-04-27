package sk.stuba.fei.uim.oop.assignment3.cart.logic;

import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.cart.data.Cart;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

@Service
public interface ICartService {
    Cart create();
    Cart getById(Long id) throws NotFoundException;

}
