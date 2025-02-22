package pase.gradiant.com.RetoGradiant.model.service;

import pase.gradiant.com.RetoGradiant.model.entities.*;
import pase.gradiant.com.RetoGradiant.model.exceptions.InputValidationException;
import pase.gradiant.com.RetoGradiant.model.exceptions.InstanceNotFoundException;
import pase.gradiant.com.RetoGradiant.model.exceptions.UserAllreadySingUp;
import pase.gradiant.com.RetoGradiant.rest.dtos.UserDTO;

import java.util.List;

public interface ModelService {

    public Category addCategory(String name) throws InputValidationException;
    public Documents addDocument(String name, String url, String technology) throws InputValidationException;

    public List<UserTechnology> findUserTechnology(String email) throws InstanceNotFoundException;
    public List<UserTechnology> findByTechnology(String technology);
    public List<Documents> findDocuments(String technology) throws InstanceNotFoundException;

    public UserDTO singUp(String pssw, String name, String email, String role) throws InputValidationException, UserAllreadySingUp;
    public UserDTO logIn(String email,String passw) throws InputValidationException, InstanceNotFoundException;

}
