package sk.stuba.fei.uim.oop.assignment3.shoppinglist.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.StringJoiner;

@Repository
public interface IShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    ShoppingList findShoppingListBy(Long id);
}
