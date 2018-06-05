package com.djsm.gastospersonales.controller;

import com.djsm.gastospersonales.model.Concepts;
import com.djsm.gastospersonales.service.ConceptsService;
import com.djsm.gastospersonales.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConceptsApiController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConceptsApiController.class);

    @Autowired
    ConceptsService conceptsService;


    @RequestMapping(value = "/concepts", method = RequestMethod.GET)
    public ResponseEntity<List<Concepts>> listAllConcepts(){

        List<Concepts> concepts = conceptsService.findAllConcepts();


        if (concepts.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity <List<Concepts>>(concepts,HttpStatus.OK);
    }

    @RequestMapping(value = "/concepts/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getConcepts(@PathVariable("id") Long id){

        LOGGER.info("Fetching concepts with id {}",id);
        Concepts concepts= conceptsService.findById(id);

        if (concepts==null){
            LOGGER.error("concepts with id {} not found",id);
            return new ResponseEntity(new CustomErrorType("Concept with id "+id+" not found"),HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Concepts>(concepts, HttpStatus.OK);
    }


    @RequestMapping(value = "/concepts/", method = RequestMethod.POST)
    public ResponseEntity<?> createConcepts(@RequestBody Concepts concepts, UriComponentsBuilder ucBuilder){

        LOGGER.info("Unable to create. A User with name {} already exist",concepts);

        if(conceptsService.isConceptsExist(concepts)){
            LOGGER.error("Unable to create. A User with name {} already exist",concepts.getName());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Concept with name "+ concepts.getName()+" Already exist"),HttpStatus.CONFLICT);

        }

        conceptsService.saveConcepts(concepts);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/concepts/{id}").buildAndExpand(concepts.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);

    }

    @RequestMapping(value = "/concepts/{id}",method = RequestMethod.PUT)
    public  ResponseEntity<?> updateConcepts(@PathVariable("id") long id, @RequestBody Concepts concepts){
        LOGGER.info("Se actualizara el concepto {}",id);

        Concepts currentConcepts= conceptsService.findById(id);

        if (currentConcepts==null){

            LOGGER.error("No se encontro el concepto {} ",id);

            return new ResponseEntity(new CustomErrorType("No se puede eliminar el concepto "+id),HttpStatus.NOT_FOUND);
        }

        currentConcepts.setName(concepts.getName());

        conceptsService.updateConcepts(currentConcepts);

        return new ResponseEntity<Concepts>(currentConcepts,HttpStatus.OK);


    }

    @RequestMapping(value = "/concepts/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<?> deteleConcepts(@PathVariable("id") long id){

        LOGGER.info("Se buscará y eliminara el siguiente id {} ",id);

        Concepts concepts= conceptsService.findById(id);

        if (concepts==null){

            LOGGER.error("El concepto no esta {}",id);
            return new ResponseEntity(new CustomErrorType("No se puede eliminar el concepto "+id),HttpStatus.NOT_FOUND);
        }

        conceptsService.deleteConceptsById(id);

        return new ResponseEntity<Concepts>(HttpStatus.NO_CONTENT);

    }




}
