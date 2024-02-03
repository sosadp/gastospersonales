package com.djsm.gastospersonales.repositories;

import com.djsm.gastospersonales.model.Concepts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConceptsRepository extends JpaRepository<Concepts, UUID> {
    Concepts findByName(String name);
}
