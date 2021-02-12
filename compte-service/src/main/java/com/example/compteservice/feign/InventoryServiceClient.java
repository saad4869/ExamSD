//package com.example.compteservice.feign;
//
//import com.example.billingservice.model.Product;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.hateoas.PagedModel;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient(name = "INVENTORY-SERVICE")
//public interface InventoryServiceClient{
//    @GetMapping("/products/{id}")
//    Product findProductById(@PathVariable("id") Long id,@RequestHeader("Authorization") String Bearer);
//    @GetMapping("/products")
//    PagedModel<Product> findAllProducts(@RequestHeader("Authorization") String Bearer);
//}
