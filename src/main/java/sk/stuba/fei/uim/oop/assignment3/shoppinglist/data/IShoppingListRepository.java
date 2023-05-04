package sk.stuba.fei.uim.oop.assignment3.shoppinglist.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    ShoppingList findShoppingListById(Long id);
}
