package de.davitec.demo.springbootdockermicroservice.restcontroller;

import de.davitec.demo.springbootdockermicroservice.models.DemoTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import de.davitec.demo.springbootdockermicroservice.repositories.DemotitleRepository;

import java.util.List;

@RestController
public class DemotitleRestController {

    @Autowired
    DemotitleRepository demotitleRepository;

    @RequestMapping(value="/api/demotitle", method = RequestMethod.GET)
    public ResponseEntity<?> getDemotitles(){
        List<DemoTitle> res = demotitleRepository.findAll();
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
