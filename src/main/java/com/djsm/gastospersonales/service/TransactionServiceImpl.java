package com.djsm.gastospersonales.service;

import com.djsm.gastospersonales.model.Transactions;
import com.djsm.gastospersonales.repositories.TransactionsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("transactionsServices")
@Transactional
public class TransactionServiceImpl implements TransactionsServices{

    public static Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Override
    public Transactions findById(Long id) {
        return transactionsRepository.getOne(id);
    }

    @Override
    public void saveTransactions(Transactions transactions) {
            transactionsRepository.save(transactions);
    }

    @Override
    public void updateTransactions(Transactions transactions) {
            saveTransactions(transactions);
    }

    @Override
    public void deleteTransactionsById(Long id) {
            transactionsRepository.deleteById(id);
    }

    @Override
    public void deleteAllTransactions() {
        transactionsRepository.deleteAll();
    }

    @Override
    public List<Transactions> findAllTransactions() {
        return transactionsRepository.findAll();
    }

    /*@Override
    public Page<Transactions> findAllTransactions(Pageable pageable) {
        return transactionsRepository.findAll(pageable);
    } */


    @Override
    public boolean isTransactionsExist(Transactions transactions) {
        return false;
    }
}
