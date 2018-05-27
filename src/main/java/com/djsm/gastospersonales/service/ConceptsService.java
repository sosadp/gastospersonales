package com.djsm.gastospersonales.service;

import com.djsm.gastospersonales.model.Concepts;

import java.util.List;

public interface ConceptsService {

    Concepts findById(Long id);

    Concepts findByName(String name);

    void saveConcepts(Concepts concepts);

    void updateConcepts(Concepts concepts);

    void deleteConceptsById(Long id);

    void deleteAllConcepts();

    List<Concepts> findAllConcepts();

    boolean isConceptsExist(Concepts concepts);


}
