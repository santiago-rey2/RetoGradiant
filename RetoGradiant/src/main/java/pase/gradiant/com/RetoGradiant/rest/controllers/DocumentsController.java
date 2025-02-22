package pase.gradiant.com.RetoGradiant.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pase.gradiant.com.RetoGradiant.model.entities.Documents;
import pase.gradiant.com.RetoGradiant.model.exceptions.InputValidationException;
import pase.gradiant.com.RetoGradiant.model.exceptions.InstanceNotFoundException;
import pase.gradiant.com.RetoGradiant.model.service.ModelService;
import pase.gradiant.com.RetoGradiant.rest.dtos.DocumentDTO;

import javax.management.InstanceAlreadyExistsException;
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


    @PostMapping("/add")
    public ResponseEntity<Documents> addDocument(@RequestBody DocumentDTO documentDTO) throws InstanceAlreadyExistsException {
        if (documentDTO.getName() == null || documentDTO.getUrl() == null || documentDTO.getTechnology() == null) {
            throw new InputValidationException("All fields are required");
        }
        Documents documents = modelService.addDocument(documentDTO.getName(), documentDTO.getUrl(), documentDTO.getTechnology());
        return ResponseEntity.created(null).body(documents);
    }

    @ExceptionHandler(InstanceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleInstanceNotFoundException(InstanceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
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
