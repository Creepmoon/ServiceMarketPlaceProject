package main.webshop.Controllers;

import lombok.RequiredArgsConstructor;
import main.webshop.Dto.model.PersonModel;
import main.webshop.service.UserService.UserServiceImpl;
import main.webshop.service.productService.ProductServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/CakeShop/user")
@PreAuthorize("hasAuthority('USER')")
public class UserController {


    private final UserServiceImpl service;
    private final ProductServiceImpl productService;

    @GetMapping("/getUserData/{Email}")
    public String GetUserData(@RequestBody String email, Model model){
        model.addAttribute("user", service.GetUser(email));
        return "user";
    }




}
