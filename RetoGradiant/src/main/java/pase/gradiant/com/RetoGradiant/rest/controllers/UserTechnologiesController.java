package pase.gradiant.com.RetoGradiant.rest.controllers;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pase.gradiant.com.RetoGradiant.model.entities.Technology;
import pase.gradiant.com.RetoGradiant.model.entities.User;
import pase.gradiant.com.RetoGradiant.model.entities.UserTechnology;
import pase.gradiant.com.RetoGradiant.model.exceptions.InstanceNotFoundException;
import pase.gradiant.com.RetoGradiant.model.service.ModelService;
import pase.gradiant.com.RetoGradiant.rest.dtos.TechnologiesOfUserDTO;
import pase.gradiant.com.RetoGradiant.rest.dtos.TechnologyDTO;
import pase.gradiant.com.RetoGradiant.rest.dtos.UserTechnologyDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/searchs")
public class UserTechnologiesController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/byTechnologies")
    public ResponseEntity<List<UserTechnologyDTO>> searchByTechnologies(@RequestParam String name) {
        List<UserTechnology> techList = modelService.findByTechnology(name);
        List<UserTechnologyDTO> dtoList = techList.stream()
                .map(ut -> new UserTechnologyDTO(
                        ut.getUser(),
                        ut.getLevel()))
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);

    }

    @GetMapping("/byUsers")
    public ResponseEntity<TechnologiesOfUserDTO> searchByUsers(@RequestParam String email) {
        List<UserTechnology> techList = modelService.findUserTechnology(email);

        User user = techList.get(0).getUser();

        List<Technology> technologies = techList.stream()
                .map(UserTechnology::getTechnology)
                .collect(Collectors.toList());

        TechnologiesOfUserDTO dto = new TechnologiesOfUserDTO(user, technologies);

        return ResponseEntity.ok().body(dto);

    }

    @ExceptionHandler(InstanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleInstanceNotFoundException(InstanceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

}
