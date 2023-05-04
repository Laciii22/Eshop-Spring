package sk.stuba.fei.uim.oop.assignment3.product.logic;

import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.product.data.IProductRepository;
import sk.stuba.fei.uim.oop.assignment3.product.data.Product;
import sk.stuba.fei.uim.oop.assignment3.product.web.bodies.ProductRequest;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository repository;

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product create(ProductRequest request) {
        return this.repository.save(new Product(request));
    }

    @Override
    public Product getById(Long id) throws NotFoundException {
        Product p = this.repository.findProductById(id);
        if (p == null) {
            throw new NotFoundException();
        }
        return p;
    }

    public Product update(Long id, ProductRequest request) throws NotFoundException {
        Product p = this.getById(id);
        if (request.getName() != null) {
            p.setName(request.getName());
        }
        if (request.getDescription() != null) {
            p.setDescription(request.getDescription());
        }
        return this.repository.save(p);
    }


    public void delete(Long id) throws NotFoundException {
        Product p = this.getById(id);
        this.repository.delete(p);
    }

    public long getAmount(Long id) throws NotFoundException {
        Product p = this.getById(id);
        return p.getAmount();
    }

    public void addAmount(Long id, Long amount) throws NotFoundException {
        Product p = this.getById(id);
        p.setAmount(p.getAmount() + amount);
        this.repository.save(p);
    }

    @Override
    public void removeAmount(Long id, Long amount) throws NotFoundException {
        Product p = this.getById(id);
        p.setAmount(p.getAmount() - amount);
        this.repository.save(p);
    }
}
