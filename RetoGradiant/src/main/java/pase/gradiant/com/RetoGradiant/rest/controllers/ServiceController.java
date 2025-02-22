package pase.gradiant.com.RetoGradiant.rest.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pase.gradiant.com.RetoGradiant.model.entities.User;
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




}
