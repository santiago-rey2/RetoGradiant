package pase.gradiant.com.RetoGradiant.utils;

import pase.gradiant.com.RetoGradiant.model.entities.User;
import pase.gradiant.com.RetoGradiant.model.exceptions.InputValidationException;

public class PropertyValidator {

    public static void userValidator(User user) {
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new InputValidationException("Name cant be empty");
        }
        if(user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new InputValidationException("Email cant be empty");
        }
    }
}
