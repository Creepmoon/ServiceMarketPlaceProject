package main.webshop.dao;

import lombok.RequiredArgsConstructor;
import main.webshop.Domain.Product;
import main.webshop.Dto.model.ProductModel;
import main.webshop.Repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class ProductDao {

  private final ProductRepository productRepository;

  public List<ProductModel> getAllProducts(){

      List<Product> products = productRepository.getAllBy();

      return products.stream()
              .map(ProductModel::fromEntity)
              .toList();

  }

  public void addNewProduct(ProductModel productModel){

      if(!productRepository.existsByName(productModel.getName())){
          Product product = Product.builder()
                  .name(productModel.getName())
                  .price(productModel.getPrice())
                  .description(productModel.getDescription())
                  .Picture(productModel.getPicture()).build();
          productRepository.save(product);
      }


  }



}
