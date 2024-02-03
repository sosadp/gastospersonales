package com.djsm.gastospersonales.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "CONCEPTS")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Concepts implements Serializable {


    @Id
    private UUID id;

    @Column(name = "NAME",nullable = false)
    private String name;

    @OneToMany(mappedBy = "concepts")
    private Collection<Transactions> transBudgets = new ArrayList<Transactions>();
}
