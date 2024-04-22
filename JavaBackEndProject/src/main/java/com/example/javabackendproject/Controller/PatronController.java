package com.example.javabackendproject.Controller;
import com.example.javabackendproject.model.entities.Patron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    private PatronController patronService;

    // GET /api/patrons
    @GetMapping
    public ResponseEntity<List<Patron>> getAllPatrons() {
        List<Patron> patrons = (List<Patron>) patronService.getAllPatrons();
        return new ResponseEntity<>(patrons, HttpStatus.OK);
    }

    // GET /api/patrons/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        Patron patron = patronService.getPatronById(id).getBody();
        if (patron != null) {
            return new ResponseEntity<>(patron, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // POST /api/patrons
    @PostMapping
    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron) {
        Patron newPatron = patronService.addPatron(patron).getBody();
        return new ResponseEntity<>(newPatron, HttpStatus.CREATED);
    }

    // PUT /api/patrons/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron patron) {
        Patron updatedPatron = patronService.updatePatron(id, patron).getBody();
        if (updatedPatron != null) {
            return new ResponseEntity<>(updatedPatron, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE /api/patrons/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        boolean deleted = patronService.deletePatron(id).hasBody();
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
