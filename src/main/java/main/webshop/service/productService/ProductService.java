package main.webshop.service.productService;


import main.webshop.Dto.Requests.ProductCreateRequest;
import main.webshop.Dto.model.ProductModel;

import java.util.List;

public interface ProductService {

    public void createProduct(ProductCreateRequest productCreateRequest);

    public List<ProductModel> getAllProducts();

}
