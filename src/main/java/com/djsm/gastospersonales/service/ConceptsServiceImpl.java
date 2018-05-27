package com.djsm.gastospersonales.service;

import com.djsm.gastospersonales.model.Concepts;
import com.djsm.gastospersonales.repositories.ConceptsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("conceptsService")
@Transactional
public class ConceptsServiceImpl implements ConceptsService{

    public static Logger LOGGER= LoggerFactory.getLogger(ConceptsServiceImpl.class);


    @Autowired
    private ConceptsRepository conceptsRepository;

    @Override
    public Concepts findById(Long id) {

        LOGGER.info("----------->{}",id,conceptsRepository.getOne(id).getName());
        return conceptsRepository.getOne(id);
    }

    @Override
    public Concepts findByName(String name) {
        return conceptsRepository.findByName(name);
    }

    @Override
    public void saveConcepts(Concepts concepts) {
        conceptsRepository.save(concepts);
    }

    @Override
    public void updateConcepts(Concepts concepts) {
        saveConcepts(concepts);
    }

    @Override
    public void deleteConceptsById(Long id) {
        conceptsRepository.deleteById(id);
    }

    @Override
    public void deleteAllConcepts() {
        conceptsRepository.deleteAll();
    }

    @Override
    public List<Concepts> findAllConcepts() {
        return conceptsRepository.findAll();
    }

    @Override
    public boolean isConceptsExist(Concepts concepts) {
        return findByName(concepts.getName())!=null;
    }
}
