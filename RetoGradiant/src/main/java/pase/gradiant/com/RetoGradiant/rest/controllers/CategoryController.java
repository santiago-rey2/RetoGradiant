package pase.gradiant.com.RetoGradiant.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pase.gradiant.com.RetoGradiant.model.entities.Category;
import pase.gradiant.com.RetoGradiant.model.service.ModelService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ModelService modelService;

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(String name) {
        Category newcategory =  modelService.addCategory(name);
        return ResponseEntity.created(null).body(newcategory);
    }
}
