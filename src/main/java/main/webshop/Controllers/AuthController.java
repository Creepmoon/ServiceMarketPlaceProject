package main.webshop.Controllers;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import main.webshop.Dto.Requests.UserLoginRequest;
import main.webshop.Dto.Requests.UserRegisterRequest;
import main.webshop.Dto.Response.LoginResponse;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Dto.model.ProductModel;
import main.webshop.service.UserService.UserServiceImpl;
import main.webshop.service.authService.UserAuthService;
import main.webshop.service.authService.UserAuthServiceImpl;
import main.webshop.service.productService.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import main.webshop.service.UserService.UserService;
import javax.security.auth.login.CredentialException;
import java.util.List;
import main.webshop.service.productService.ProductService;
import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/api/CakeShop/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserAuthService userAuthService;
    private final UserService userService;
    private final ProductService productService;


    @PostMapping("/register")
    HttpStatus userRegister(@RequestBody UserRegisterRequest request){

        userAuthService.register(request);
        return HttpStatus.CREATED;
    }

    @PostMapping("/login")
    HttpStatus userLogin(@RequestBody UserLoginRequest loginRequest,
                         HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse)throws CredentialException{

        LoginResponse loginResponse = userAuthService.login(loginRequest, httpServletRequest, httpServletResponse);

        return HttpStatus.OK;
    }




}
