package pase.gradiant.com.RetoGradiant.rest.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pase.gradiant.com.RetoGradiant.model.entities.User;
import pase.gradiant.com.RetoGradiant.model.exceptions.InputValidationException;
import pase.gradiant.com.RetoGradiant.model.exceptions.UserAllreadySingUp;
import pase.gradiant.com.RetoGradiant.model.service.ModelService;
import pase.gradiant.com.RetoGradiant.rest.dtos.UserDTO;

@RestController
@RequestMapping("/users")
public class ServiceController {

    @Autowired
    private ModelService modelService;

    //Mirarse luego esta funcionalidad de nuevo
    @PostMapping("/signUp")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDto) throws UserAllreadySingUp {
        UserDTO newUser = modelService.singUp(userDto.getPssw(), userDto.getName(), userDto.getEmail(), userDto.getRole());
        return ResponseEntity.created(null).body(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDto){
        UserDTO user = modelService.logIn(userDto.getEmail(), userDto.getPssw());
        return ResponseEntity.ok().body(user);
    }

    @ExceptionHandler(InputValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleInputValidationException(InputValidationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(UserAllreadySingUp.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleUserAllreadySingUp(UserAllreadySingUp ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
