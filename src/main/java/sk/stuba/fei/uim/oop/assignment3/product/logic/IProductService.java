package sk.stuba.fei.uim.oop.assignment3.product.logic;

import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

public interface IProductService {
    List<Product> getAll();

    Product create(ProductRequest body);

    Product getById(long id) throws NotFoundException;

    Product update(long productId, ProductRequest request ) throws NotFoundException;

    void delete(long productId) throws NotFoundException;

    long getAmount(long id) throws NotFoundException;

    void addAmount(long id, long amount) throws NotFoundException;
}
