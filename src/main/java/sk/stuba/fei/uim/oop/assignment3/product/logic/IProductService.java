package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product create(ProductRequest body);

    Product getById(Long id) throws NotFoundException;

    Product update(Long productId, ProductRequest request ) throws NotFoundException;

    void delete(Long productId) throws NotFoundException;

    long getAmount(Long id) throws NotFoundException;

    void addAmount(Long id, Long amount) throws NotFoundException;

    void removeAmount(Long id, Long amount) throws NotFoundException;
}
