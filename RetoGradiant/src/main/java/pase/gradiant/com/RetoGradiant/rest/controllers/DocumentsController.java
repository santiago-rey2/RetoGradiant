package pase.gradiant.com.RetoGradiant.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pase.gradiant.com.RetoGradiant.model.entities.Documents;
import pase.gradiant.com.RetoGradiant.model.service.ModelService;
import pase.gradiant.com.RetoGradiant.rest.dtos.DocumentsDTO;

import java.util.List;

@RestController
@RequestMapping("/documents")
public class DocumentsController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/byTechnology")
    public ResponseEntity<List<Documents>> getDocumentsByTechnology(@RequestParam String technology) {
        List<Documents> documents = modelService.findDocuments(technology);
        return ResponseEntity.ok(documents);
    }


}
