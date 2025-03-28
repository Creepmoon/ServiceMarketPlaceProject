package main.webshop.service.UserService;


import main.webshop.Dto.model.PersonModel;

import java.util.List;

public interface UserService {

    public List<PersonModel> getAllUsers();

    public void LockUser(PersonModel personModel);


}
