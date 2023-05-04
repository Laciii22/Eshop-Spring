package sk.stuba.fei.uim.oop.assignment3.product.web.bodies;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductAmount {
    private long amount;

    public ProductAmount(Long amount) {
        this.amount = amount;
    }

    public ProductAmount() {
    }
}

