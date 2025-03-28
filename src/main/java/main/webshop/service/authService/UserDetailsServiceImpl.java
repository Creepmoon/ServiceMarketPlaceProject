package main.webshop.service.authService;

import lombok.RequiredArgsConstructor;
import main.webshop.Domain.Person;
import main.webshop.Dto.model.PersonModel;
import main.webshop.dao.PersonDao;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PersonDao personDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personDao.getUserByEmail(username);
    }
}
