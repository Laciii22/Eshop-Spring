package sk.stuba.fei.uim.oop.assignment3.product.web.bodies;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductAmount {
    private Long amount;

    public ProductAmount(Long amount) {
        this.amount = amount;
    }


}

