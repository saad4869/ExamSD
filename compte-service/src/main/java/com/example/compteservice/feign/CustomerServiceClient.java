package com.example.compteservice.feign;

import com.example.compteservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceClient{
    @GetMapping(path="/customers/{id}")
    Customer findCustomerById(@PathVariable(name="id") Long id);
}
