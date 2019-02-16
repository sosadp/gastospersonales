package com.djsm.gastospersonales.repositories;

import com.djsm.gastospersonales.model.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions,Long>{

        Page<Transactions> findByConcepts_Id(Long Id, Pageable pageable);
}
