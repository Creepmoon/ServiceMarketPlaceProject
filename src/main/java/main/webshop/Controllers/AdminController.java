package main.webshop.Controllers;

import lombok.RequiredArgsConstructor;
import main.webshop.Dto.Requests.OrderRequest;
import main.webshop.Dto.Requests.ProductCreateRequest;
import main.webshop.Dto.model.OrderModel;
import main.webshop.Dto.model.PersonModel;
import main.webshop.service.UserService.UserServiceImpl;
import main.webshop.service.orderService.OrderServiceImpl;
import main.webshop.service.productService.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/CakeShop/admin")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('Admin')")
public class AdminController {

    private final ProductServiceImpl productService;
    private final UserServiceImpl userService;
    private final OrderServiceImpl orderService;

    @PostMapping("/createProduct")
    HttpStatus CreateProduct(@RequestBody ProductCreateRequest request){
        productService.createProduct(request);
        return HttpStatus.CREATED;
    }

    @GetMapping("/getAllUsers")
    List<PersonModel> GetAllPersons(){

       return userService.getAllUsers();
    }

    @GetMapping("/getAllOrders")
    List<OrderModel> GetAllOrderModel(){

        return orderService.getAllOrders();
    }

    @PostMapping("/lockUser")
     HttpStatus LockPerson(PersonModel personModel){
        userService.LockUser(personModel);
        return HttpStatus.LOCKED;
    }

    @PostMapping("/finishOrder")
    HttpStatus Finish(OrderModel orderModel){
        orderService.finishOrder(orderModel);
        return HttpStatus.OK;
    }


}
