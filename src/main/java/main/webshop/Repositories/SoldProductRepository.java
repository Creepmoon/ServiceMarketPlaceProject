package main.webshop.Repositories;

import main.webshop.Domain.Bucket;
import main.webshop.Domain.SoldProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SoldProductRepository extends CrudRepository<SoldProduct, Integer>{
    List<SoldProduct> findAllByOwner(Bucket bucket);
}
