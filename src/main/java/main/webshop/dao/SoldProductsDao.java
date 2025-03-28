package main.webshop.dao;

import main.webshop.Domain.SoldProduct;
import main.webshop.Dto.model.BucketModel;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Dto.model.SoldProductModel;
import main.webshop.Repositories.BucketRepository;
import main.webshop.Repositories.PersonRepository;
import main.webshop.Repositories.ProductRepository;
import main.webshop.Repositories.SoldProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SoldProductsDao {

    SoldProductRepository soldProductRepository;

    ProductRepository productRepository;

    PersonRepository personRepository;
    BucketRepository bucketRepository;


    public void AddSoldProduct(SoldProductModel soldProductModel){

        SoldProduct soldProduct = SoldProduct.builder()
                .product(productRepository.findByName(soldProductModel.getProductModel().getName()))
                .owner(bucketRepository.findFirstByOwnerOrderByIdDesc(
                        personRepository.findByEmail(soldProductModel.getBucketModel().getOwner().getEmail())
                )).build();
        soldProductRepository.save(soldProduct);

    }

    public List<SoldProductModel> getAllProductByOwner(PersonModel personModel){
        List<SoldProduct> soldProducts = soldProductRepository.findAllByOwner(bucketRepository.findFirstByOwnerOrderByIdDesc(
                personRepository.findByEmail(personModel.getEmail())
        ));
        return soldProducts.stream()
                .map(SoldProductModel::fromEntity)
                .toList();
    }




}
