//package com.example.compteservice.entities;
//
//
//import com.example.compteservice.model.Product;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.rest.core.config.Projection;
//
//import javax.persistence.*;
//import java.beans.Transient;
//import java.util.Collection;
//import java.util.Date;
//
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ProductItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long
//    @ManyToOne
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    private Compte compte;
//}
//
//@Projection(name="fullbill", types= Compte.class)
//interface Billprojection {
//    public long getId();
//    public Date getbillingDate();
//    public long getcustomerID();
//    public Collection<ProductItem> getproductItems();
//}
