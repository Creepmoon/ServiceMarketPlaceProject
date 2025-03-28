package main.webshop.Dto.model;

import lombok.Builder;
import lombok.Data;
import main.webshop.Domain.Product;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.net.URL;

@Data
@Builder
public class ProductModel  {
    String name;

    String description;

    URL picture;

    Integer price;

    public static ProductModel fromEntity(Product product){
        return ProductModel.builder()
                .name(product.getName())
                .description(product.getDescription())
                .picture(product.getPicture())
                .price(product.getPrice())
                .build();
    }
}
