package main.webshop.service.bucketService;

import main.webshop.Domain.SoldProduct;
import main.webshop.Dto.Response.ProductResponse;
import main.webshop.Dto.model.BucketModel;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Dto.model.ProductModel;

import java.util.List;

public interface BucketService {

    public void CreateBucket(ProductModel productModel, PersonModel owner);

    public void UpdateBucket(ProductModel productModel, PersonModel owner);

    public List<ProductModel> getBucket(BucketModel bucketModel, PersonModel owner);




}
