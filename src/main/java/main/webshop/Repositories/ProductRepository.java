package main.webshop.Repositories;

import main.webshop.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    Product findByName(String Name);

    List<Product> getAllBy();
    Product getProductByName(String name);
    boolean existsByName(String name);
}
