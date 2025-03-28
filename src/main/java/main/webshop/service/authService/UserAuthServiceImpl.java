package main.webshop.service.authService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import main.webshop.Dto.Requests.UserLoginRequest;
import main.webshop.Dto.Requests.UserRegisterRequest;
import main.webshop.Dto.Response.LoginResponse;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Dto.model.TokenModel;
import main.webshop.Enums.Roles;
import main.webshop.Enums.Status;
import main.webshop.dao.PersonDao;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;

@Service
@RequiredArgsConstructor
public class UserAuthServiceImpl  implements UserAuthService{


    private final PersonDao personDao;

    @Override
    public LoginResponse login(UserLoginRequest userLoginRequest,
                               HttpServletRequest httpServletRequest,
                               HttpServletResponse httpServletResponse) throws CredentialException {

        if (!personDao.isUserWithEmailExist(userLoginRequest.getEmail())){
            throw new CredentialException("Invalid email");
        }
        if(!personDao.isUserPasswordValid(userLoginRequest.getEmail(),userLoginRequest.getPassword())){
            throw new CredentialException("Invalid password");
        }

        PersonModel personModel = personDao.getUserByEmail(userLoginRequest.getEmail());

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                personModel.getEmail(),
                personModel.getPassword(),
                personModel.getAuthorities()
        );

        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(token);
        SecurityContextHolder.setContext(securityContext);
        //   String jwt = jwtService.generateToken(personModel);

        return LoginResponse.builder()
                .email(personModel.getEmail())
                .token(
                        TokenModel.builder()
                            //    .token(jwt)
                                .email(personModel.getEmail())
                                .build()
                )
                .build();

    }

    @Override
    public void register(UserRegisterRequest userRegisterRequest) {
        System.out.println("1");
        PersonModel personModel= PersonModel.builder()
                .Email(userRegisterRequest.getEmail())
                .name(userRegisterRequest.getName())
                .PhoneNumber(userRegisterRequest.getPhoneNumber())
                .Password(userRegisterRequest.getPassword())
                .build();
        personDao.addNewUser(personModel);
    }
}
