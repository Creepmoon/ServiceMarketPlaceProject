package main.webshop.service.authService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.webshop.Dto.Requests.UserLoginRequest;
import main.webshop.Dto.Requests.UserRegisterRequest;
import main.webshop.Dto.Response.LoginResponse;

import javax.security.auth.login.CredentialException;

public interface UserAuthService {

    public LoginResponse login(UserLoginRequest userLoginRequest,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws CredentialException;


    public void register(UserRegisterRequest userRegisterRequest);
}
