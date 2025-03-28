package main.webshop.service.bucketService;

import lombok.RequiredArgsConstructor;
import main.webshop.Domain.Bucket;
import main.webshop.Domain.SoldProduct;
import main.webshop.Dto.model.BucketModel;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Dto.model.ProductModel;
import main.webshop.Dto.model.SoldProductModel;
import main.webshop.Repositories.PersonRepository;
import main.webshop.dao.BucketDao;
import main.webshop.dao.PersonDao;
import main.webshop.dao.ProductDao;
import main.webshop.dao.SoldProductsDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BucketServiceImpl implements BucketService{

    private BucketDao bucketDao;

    private PersonDao personDao;

    private SoldProductsDao soldProductsDao;


    @Override
    public void CreateBucket(ProductModel productModel, PersonModel owner) {

        if(!bucketDao.GetUserBucket(owner).isStatus()){

            BucketModel bucketModel = BucketModel.builder()
                    .owner(owner)
                    .status(true)
                    .build();
            SoldProductModel soldProductModel = SoldProductModel.builder()
                    .productModel(productModel)
                    .bucketModel(bucketModel)
                    .build();
            bucketModel.setPrice(bucketModel.getPrice() + soldProductModel.getProductModel().getPrice());
            bucketDao.AddBucket(bucketModel);
        }
    }

    @Override
    public void UpdateBucket(ProductModel productModel, PersonModel owner) {
        SoldProductModel soldProductModel = SoldProductModel.builder()
                .productModel(productModel)
                .bucketModel(bucketDao.GetUserBucket(owner))
                .build();
    }

    @Override
    public List<ProductModel> getBucket(BucketModel bucketModel, PersonModel owner) {
        List<SoldProductModel> soldProducts = soldProductsDao.getAllProductByOwner(bucketModel.getOwner());

        List<ProductModel> productModels = new ArrayList<>();
        for(SoldProductModel item: soldProducts){
            productModels.add(item.getProductModel());
        }
        return productModels;
    }



}
