package main.webshop.service.UserService;

import lombok.RequiredArgsConstructor;
import main.webshop.Domain.Person;
import main.webshop.Dto.model.PersonModel;
import main.webshop.Enums.Status;
import main.webshop.dao.PersonDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final PersonDao personDao;


    @Override
    public List<PersonModel> getAllUsers() {

        return personDao.getAllUsers() ;
    }

    @Override
    public void LockUser(PersonModel personModel) {
        personDao.findUserByEmail(personModel.getEmail());

    }

    public PersonModel GetUser(String email){
        PersonModel personModel = personDao.getUserByEmail(email);
        return personModel;
    }


}
