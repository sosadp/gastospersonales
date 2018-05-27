package com.djsm.gastospersonales.repositories;

import com.djsm.gastospersonales.model.Concepts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConceptsRepository extends JpaRepository<Concepts, Long> {

    Concepts findByName(String name);
}
