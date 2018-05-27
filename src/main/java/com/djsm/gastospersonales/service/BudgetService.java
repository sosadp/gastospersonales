package com.djsm.gastospersonales.service;

import com.djsm.gastospersonales.model.Budget;

import java.util.Date;
import java.util.List;

public interface BudgetService {

    Budget findById(Long id);

    Budget findByBudgetDate(Date date);

    void saveBudget(Budget budget);

    void updateBudget(Budget budget);

    void deleteById(long id);

    List<Budget> findAllBudget();

    boolean isExistBudget(Budget budget);

}
