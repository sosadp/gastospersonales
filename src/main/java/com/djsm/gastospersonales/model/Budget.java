package com.djsm.gastospersonales.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "BUDGET")
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Budget implements Serializable{

    @Id
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "BUDGET_DATE")
    private Date budgetDate;

}
