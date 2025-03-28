package main.webshop.Repositories;

import main.webshop.Domain.Order;
import main.webshop.Domain.Person;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {


    List<Order> findAll();

    List<Order> findAllByOwner(Person person);

}
