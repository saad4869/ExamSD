package com.example.compteservice.repository;

import com.example.compteservice.entities.Compte;
import com.example.compteservice.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte,Long>{
    @GetMapping("/operations")
    PagedModel<Operation> getOperationsp();
}
