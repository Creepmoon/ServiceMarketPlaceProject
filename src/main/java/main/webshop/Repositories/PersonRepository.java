package main.webshop.Repositories;

import jakarta.persistence.criteria.CriteriaBuilder;
import main.webshop.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends CrudRepository<Person,Integer> {


    Person findByEmail(String Email);

    boolean existsByEmail(String Email);

    List<Person> getAllBy();


}
