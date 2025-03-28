package main.webshop.service.productService;

import lombok.RequiredArgsConstructor;
import main.webshop.Dto.Requests.ProductCreateRequest;
import main.webshop.Dto.model.ProductModel;
import main.webshop.dao.ProductDao;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;


    @Override
    public void createProduct(ProductCreateRequest productCreateRequest) {

        productDao.addNewProduct(
                ProductModel.builder()
                        .name(productCreateRequest.getName())
                        .description(productCreateRequest.getDiscrpiption())
                        .picture(productCreateRequest.getPicture())
                        .price(productCreateRequest.getPirce())
                        .build()
        );
    }

    @Override
    public List<ProductModel> getAllProducts(){
        return productDao.getAllProducts();
    }
}
