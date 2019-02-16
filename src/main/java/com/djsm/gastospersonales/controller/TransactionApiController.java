package com.djsm.gastospersonales.controller;

import com.djsm.gastospersonales.model.Budget;
import com.djsm.gastospersonales.model.Concepts;
import com.djsm.gastospersonales.model.Transactions;

import com.djsm.gastospersonales.service.BudgetService;
import com.djsm.gastospersonales.service.ConceptsService;
import com.djsm.gastospersonales.service.TransactionsServices;
import com.djsm.gastospersonales.util.CustomErrorType;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.json.JsonParser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TransactionApiController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ConceptsApiController.class);

    @Autowired
    TransactionsServices transactionsServices;
    @Autowired
    ConceptsService service;
    @Autowired
    BudgetService budgetService;

    /*
    @GetMapping("/transactions")
    public Page<Transactions> listAllTransactions(Pageable pageable){

        return transactionsServices.findAllTransactions(pageable);

    }
    */
    @RequestMapping(value = "/transactions",method = RequestMethod.GET)
    public ResponseEntity<List<Transactions>> getAllTransactions(){

        List<Transactions> trxs = transactionsServices.findAllTransactions();

        if (trxs.isEmpty()){

            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Transactions>>(trxs,HttpStatus.OK);
    }


    //@RequestMapping(value = "/transactions/",method = RequestMethod.POST)
    @PostMapping(value = "/transactions/")
    public ResponseEntity<?> createTransaction (@RequestBody Map<String,Object> trx, UriComponentsBuilder ucBuilder) {

        Concepts concepts=new Concepts();
        Transactions trxs= new Transactions();
        Budget  budget=new Budget();


        trxs.setId_pres(Long.parseLong(trx.get("id_pres").toString()) );
        trxs.setId_gastos(Long.parseLong(trx.get("id_gastos").toString()));
        trxs.setMonto( Float.parseFloat(trx.get("monto").toString()));

        HttpHeaders headers = new HttpHeaders();


        if (trx.containsKey("concepts")){
            concepts.setName(trx.get("concepts").toString());

            if (service.isConceptsExist(concepts)){
                    trxs.setConcepts(concepts);
            } else {
                service.saveConcepts(concepts);
                trxs.setConcepts(concepts);
                LOGGER.info("Se agrego un nuevo concepto de gasto" + concepts.getName());
            }

        }

        if (trx.containsKey("budget")){
            budget.setName(trx.get("budget").toString());
            budget.setBudgetDate((Date.valueOf(trx.get("budgetDate").toString())));

            if (budgetService.isExistBudget(budget)){

                trxs.setBudget(budget);
            } else {
                budgetService.saveBudget(budget);
                trxs.setBudget(budget);

                LOGGER.info("Se agrego un nuevo presupuesto" + budget.getName());


            }


        }


        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
        //Concepts concepts=service.findById(trx.getId_gastos());
        //Budget  budget =budgetService.findById(trx.getId_pres());
   //     HttpHeaders headers = new HttpHeaders();
 //       try {

        //trx.setConcepts(concepts);
        //trx.setBudget(budget);

    //    LOGGER.info("Unable to create. A Transaction with name {} already exist",trx.getId());

/*
        if(transactionsServices.isTransactionsExist(trx)){

            LOGGER.error("Unable to create. A Transacion with name {} already exist", trx);
            return new ResponseEntity(new CustomErrorType("Unable to create. A Concept with name "+ trx.getId() +" Already exist"),HttpStatus.CONFLICT);

        }

        transactionsServices.saveTransactions(trx);


        headers.setLocation(ucBuilder.path("/api/transactions/{id}").buildAndExpand(trx.getId()).toUri());
        return new ResponseEntity<String>(headers,HttpStatus.CREATED);
        } catch (Exception ex) {

            return new ResponseEntity<String>(headers,HttpStatus.BAD_REQUEST);

        } finally {

            concepts=null;
            budget=null;
            headers=null;
        }
*/

    }

    @RequestMapping(value = "/transactions/{id}",method = RequestMethod.GET)
    public ResponseEntity<?> getTransaction(@PathVariable("id") Long id){

    LOGGER.info("Fetching concepts with id {}",id);
    Transactions trx= transactionsServices.findById(id);

    if (trx==null){
        LOGGER.info("transaction with id {} not found",id);
        return new ResponseEntity(new CustomErrorType("Transactio with id "+id+" not found"),HttpStatus.NOT_FOUND);

    }

    return new ResponseEntity<Transactions>(trx,HttpStatus.OK);

    }



}
