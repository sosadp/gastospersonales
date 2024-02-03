package com.djsm.gastospersonales.repositories;

import com.djsm.gastospersonales.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, UUID>{
        Budget findByBudgetDate(Date date);
}
