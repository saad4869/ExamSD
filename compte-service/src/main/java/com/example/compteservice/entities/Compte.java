package com.example.compteservice.entities;

import com.example.compteservice.model.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    private Date dateCreation;
    private String typeCompte;
    private Boolean etat;
    @Transient private Customer customer;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private long customerID;
    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

    public Compte(double solde, Date dateCreation,
                  String typeCompte, Boolean etat,
                  long customerID, Collection<Operation> operations) {
        this.solde=solde;
        this.dateCreation=dateCreation;
        this.typeCompte=typeCompte;
        this.etat=true;
        this.customerID=customerID;
        this.operations=operations;
    }

//    Date billingDate;
//    @Transient private Customer customer;
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private long customerID;
////    @Transient
//    @OneToMany(mappedBy = "bill")
//    private Collection<ProductItem> productItems;

}
