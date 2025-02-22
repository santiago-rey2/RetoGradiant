package pase.gradiant.com.RetoGradiant.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pase.gradiant.com.RetoGradiant.model.entities.Category;
import pase.gradiant.com.RetoGradiant.model.exceptions.InputValidationException;
import pase.gradiant.com.RetoGradiant.model.service.ModelService;

import javax.management.InstanceAlreadyExistsException;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(String name) throws InstanceAlreadyExistsException {
        Category newcategory =  modelService.addCategory(name);
        return ResponseEntity.created(null).body(newcategory);
    }

    @ExceptionHandler(InputValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleInputValidationException(InputValidationException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> handleInstanceAlreadyExistsException(InstanceAlreadyExistsException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }
}
