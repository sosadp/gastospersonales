package com.djsm.gastospersonales.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Table(name = "BUDGET_DETAILS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Transactions implements Serializable {

    @Id
    private UUID id;

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
}
