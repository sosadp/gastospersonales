package com.djsm.gastospersonales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Entity
@Table(name = "BUDGET_DETAILS")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Transactions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "id_pres")
    private Long id_pres;


    @Column(name = "id_gastos")
    private Long id_gastos;



    @Column(name = "monto")
    private float monto;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "CONCEPTS_ID", referencedColumnName = "id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Concepts concepts;


    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "BUDGET_id",referencedColumnName = "id",nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Budget budget;

    public Budget getBudget() {
        return budget;
    }

    public void setBudget(Budget budget) {
        this.budget = budget;
    }

    public Concepts getConcepts() {
        return concepts;
    }

    public void setConcepts(Concepts concepts) {
        this.concepts = concepts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_pres() {
        return id_pres;
    }

    public void setId_pres(Long id_pres) {
        this.id_pres = id_pres;
    }

    public Long getId_gastos() {
        return id_gastos;
    }

    public void setId_gastos(Long id_gastos) {
        this.id_gastos = id_gastos;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }
}
