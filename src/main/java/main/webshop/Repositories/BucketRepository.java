package main.webshop.Repositories;


import main.webshop.Domain.Bucket;
import main.webshop.Domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BucketRepository extends CrudRepository<Bucket,Integer>{



    Bucket findFirstByOwnerOrderByIdDesc(Person person);

   List<Bucket> findBucketByOwner(Person person);

}
