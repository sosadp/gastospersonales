package com.djsm.gastospersonales.service;

import com.djsm.gastospersonales.model.Transactions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TransactionsServices {

    Transactions findById(Long id);

    void saveTransactions(Transactions transactions);

    void updateTransactions(Transactions transactions);

    void deleteTransactionsById(Long id);

    void deleteAllTransactions();

    //Page<Transactions>  findAllTransactions(Pageable pageable);

    List<Transactions> findAllTransactions();

    boolean isTransactionsExist(Transactions transactions);
}

