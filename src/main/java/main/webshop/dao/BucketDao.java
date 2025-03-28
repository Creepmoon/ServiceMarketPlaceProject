package main.webshop.dao;

import main.webshop.Domain.Bucket;
import main.webshop.Domain.Person;
import main.webshop.Dto.model.BucketModel;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Repositories.BucketRepository;
import main.webshop.Repositories.PersonRepository;
import main.webshop.Repositories.SoldProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BucketDao {
    BucketRepository bucketRepository;
    SoldProductRepository soldProductRepository;
    PersonRepository personRepository;


    public BucketModel GetUserBucket(PersonModel personModel){
        return BucketModel.fromEntity(bucketRepository
                .findFirstByOwnerOrderByIdDesc(personRepository
                .findByEmail(personModel.getEmail())));
    }

    public void AddBucket(BucketModel bucketModel){

        Bucket bucket = Bucket.builder()
                .owner(personRepository.findByEmail(bucketModel.getOwner().getEmail()))
                .price(bucketModel.getPrice()).build();
        bucketRepository.save(bucket);

    }

    public List<BucketModel> GetAllBucketUser(PersonModel personModel){

        List<Bucket> buckets = bucketRepository.findBucketByOwner(personRepository.findByEmail(personModel.getEmail()));

        return buckets.stream()
                .map(BucketModel::fromEntity)
                .toList();
    }



}
