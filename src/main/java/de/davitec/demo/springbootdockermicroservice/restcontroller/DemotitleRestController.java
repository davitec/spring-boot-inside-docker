package de.davitec.demo.springbootdockermicroservice.restcontroller;

import de.davitec.demo.springbootdockermicroservice.models.DemoTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import de.davitec.demo.springbootdockermicroservice.repositories.DemotitleRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/demotitle")
public class DemotitleRestController {

    @Autowired
    DemotitleRepository demotitleRepository;

    @GetMapping()
    public ResponseEntity<?> getList(){
        List<DemoTitle> res = demotitleRepository.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> getSingle(@PathVariable long id){
        return new ResponseEntity<>(demotitleRepository.findOne(id), HttpStatus.OK);
    }
}
