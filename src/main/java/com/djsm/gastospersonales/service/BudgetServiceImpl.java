package com.djsm.gastospersonales.service;

import com.djsm.gastospersonales.model.Budget;
import com.djsm.gastospersonales.repositories.BudgetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("budgetService")
@Transactional
public class BudgetServiceImpl implements BudgetService {

    public static Logger LOGGER= LoggerFactory.getLogger(BudgetServiceImpl.class);


    @Autowired
    private BudgetRepository budgetRepository;

    @Override
    public Budget findById(Long id) {
        return budgetRepository.getOne(id);
    }

    @Override
    public Budget findByBudgetDate(Date date) {
        return budgetRepository.findByBudgetDate(date);
    }

    @Override
    public void saveBudget(Budget budget) {
        budgetRepository.save(budget);
    }

    @Override
    public void updateBudget(Budget budget) {

        saveBudget(budget);
    }

    @Override
    public void deleteById(long id) {
            budgetRepository.deleteById(id);
    }

    @Override
    public List<Budget> findAllBudget() {
        return budgetRepository.findAll();
    }

    @Override
    public boolean isExistBudget(Budget budget) {
        return findByBudgetDate(budget.getBudgetDate())!=null;
    }


}
