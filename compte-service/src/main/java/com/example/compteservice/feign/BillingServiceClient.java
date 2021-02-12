//package com.example.compteservice.feign;
//
//import com.example.billingservice.entities.Bill;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.hateoas.PagedModel;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//
//@FeignClient(name = "BILLING-SERVICE")
//public interface BillingServiceClient {
//    @GetMapping(path="/bills/{id}")
//    PagedModel<Bill> findAllBills(@RequestHeader("Authorization") String Bearer);
//}
