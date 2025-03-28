package main.webshop.Dto.model;

import lombok.Builder;
import lombok.Data;
import main.webshop.Domain.Bucket;
import main.webshop.Domain.SoldProduct;

import java.util.List;
import java.util.Optional;

@Data
@Builder
public class BucketModel {

    PersonModel owner;

    Integer price;

    boolean status;

    public static BucketModel fromEntity(Bucket bucket){

        return BucketModel.builder()
                .owner(Optional.ofNullable(bucket.getOwner()).map(PersonModel::fromEntity).orElse(null))
                .price(bucket.getPrice())
                .status(bucket.isStatus())
                .build();
    }
}
