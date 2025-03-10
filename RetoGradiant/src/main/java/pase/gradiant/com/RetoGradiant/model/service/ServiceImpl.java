package pase.gradiant.com.RetoGradiant.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pase.gradiant.com.RetoGradiant.model.entities.*;
import pase.gradiant.com.RetoGradiant.model.exceptions.InputValidationException;
import pase.gradiant.com.RetoGradiant.model.exceptions.InstanceNotFoundException;
import pase.gradiant.com.RetoGradiant.model.exceptions.IntanceAllreadyExistsException;
import pase.gradiant.com.RetoGradiant.model.exceptions.UserAllreadySingUp;
import pase.gradiant.com.RetoGradiant.rest.dtos.UserDTO;

import javax.management.InstanceAlreadyExistsException;
import java.util.List;

import static pase.gradiant.com.RetoGradiant.utils.PropertyValidator.userValidator;

@Service
public class ServiceImpl implements ModelService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private TechnologyDAO technologyDAO;

    @Autowired
    private DocumentsDAO documentsDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private UserTechnologyDAO userTechnologyDAO;


    @Override
    public Category addCategory(String name) throws InputValidationException,InstanceAlreadyExistsException {
        if (name == null) {
            throw new InputValidationException("All fields are required");
        }
        if (categoryDAO.existsByName(name)) {
            throw new InstanceAlreadyExistsException("Category " + name + " already exists");
        }
        return categoryDAO.save(new Category(name));
    }

    @Override
    public Documents addDocument(String name, String url, String technology) throws InputValidationException, InstanceAlreadyExistsException {
        if (name == null || url == null || technology == null) {
            throw new InputValidationException("All fields are required");
        }
        if (documentsDAO.existsByUrl(url)) {
            throw new InstanceAlreadyExistsException("Document " + url + " already on database");
        }
        Technology tech = technologyDAO.findByName(technology);
        if (tech == null) {
            throw new InstanceNotFoundException("Technology " + technology + " not found");
        }
        Documents docu = new Documents(name, url, tech);
        System.out.println(docu);
        return documentsDAO.save(docu);
    }

    @Override
    public List<UserTechnology> findUserTechnology(String email) throws InstanceNotFoundException {
        if(!userDAO.existsByEmail(email)){
            throw new InstanceNotFoundException("User " + email + " not found");
        }
        System.out.println(userDAO.findByEmail(email).getIdUser());
        return userTechnologyDAO.findByUser_IdUser(userDAO.findByEmail(email).getIdUser());
    }

    @Override
    public List<UserTechnology> findByTechnology(String Name){
        Long id = technologyDAO.findByName(Name).getIdTechnology();
        return userTechnologyDAO.findByTechnology_IdTechnology(id);
    }

    @Override
    public List<Documents> findDocuments(String technology) throws InstanceNotFoundException {
        Technology tech = technologyDAO.findByName(technology);
        if (tech == null) {
            throw new InstanceNotFoundException("Technology " + technology + " not found");
        }

        return documentsDAO.findByTechnology_IdTechnology(tech.getIdTechnology());
    }

    @Override
    public UserDTO singUp(String pssw, String name, String email, String role) throws InputValidationException, UserAllreadySingUp {
        if (pssw == null || name == null || email == null || role == null) {
            throw new InputValidationException("All fields are required");
        }
        if (userDAO.existsByEmail(email)) {
            throw new UserAllreadySingUp("User " + email + " already exists");
        }
        User user = new User(pssw, name, email, role);
        user = userDAO.save(user);
        return new UserDTO(user);
    }

    @Override
    public UserDTO logIn(String email, String passw) throws InputValidationException {
        if (email == null || passw == null) {
            throw new InputValidationException("All fields are required");
        }
        User user = userDAO.findByEmail(email);
        if (user == null) {
            throw new InputValidationException("User " + email + " not found");
        }
        if (!user.getPassword().equals(passw)) {
            throw new InputValidationException("Incorrect password");
        }
        return new UserDTO(user);
    }

}
