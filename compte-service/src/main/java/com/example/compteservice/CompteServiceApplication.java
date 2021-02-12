package com.example.compteservice;

import com.example.compteservice.entities.Compte;
import com.example.compteservice.entities.Operation;//import org.keycloak.KeycloakSecurityContext;

import com.example.compteservice.feign.CustomerServiceClient;
import com.example.compteservice.repository.CompteRepository;
import com.example.compteservice.repository.OperationRepository;
//import com.example.compteservice.sec.KeycloakAdapterConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;


@SpringBootApplication
public class CompteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteServiceApplication.class, args);
    }
//    @Bean
//    CommandLineRunner start(CompteRepository compteRepository, OperationRepository operationRepository,
//
//                            RepositoryRestConfiguration repositoryRestConfiguration){
//        repositoryRestConfiguration.exposeIdsFor(Compte.class);
//        return args -> {
////			Compte bill=new Compte();
////			bill.setDateCreation(new Date());
//////            String bearer = "Bearer " + "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcEYxNTg5NFRub2RQbTlpSF9QU01JV0hGanpxNkU3clBHTlZTTnZINlowIn0.eyJleHAiOjE2MTMxMjQ1NzksImlhdCI6MTYxMzA4ODU3OSwiYXV0aF90aW1lIjoxNjEzMDg4NTc5LCJqdGkiOiIzNjRmYjU1Zi1jMjM1LTRjOWUtYjUwOS00YmQwMDljNDI3NDEiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvYXBwLXJlYWxtIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImYwNzVlNzZhLTUzMzctNDU0NC04MTgxLThhMTU1ZTUwZDliOSIsInR5cCI6IkJlYXJlciIsImF6cCI6IkFuZ3VsYXJQcm9kdWN0c0FwcCIsIm5vbmNlIjoiMWVkMjU2MmItZjZkYy00ZjJjLTk0NDgtYjM0M2VmNzkzNjdhIiwic2Vzc2lvbl9zdGF0ZSI6ImVjMDZlYTg2LTY4YzYtNDJhMC1iNDMwLWEyYjIxYjljOTlkMyIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDo0MjAwIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJCSUxMSU5HX01BTkFHRVIiLCJQUk9EVUNUX01BTkFHRVIiLCJvZmZsaW5lX2FjY2VzcyIsIkNVU1RPTUVSX01BTkFHRVIiLCJBRE1JTiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6InNhYWQiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ1c2VyMSIsImdpdmVuX25hbWUiOiJzYWFkIiwiZW1haWwiOiJ1c2VyMUBnbWFpbC5jb20ifQ.kVMc4-D5Q-v2QrBiZq1WRJU-h8tAIe6sOemys-mPGq9wYVcpiSJ3D5NyWzw9S4YEWzZJIrAKrZvjjfouLa9QJTJExJzP3tKY74VOp3CyMlW0PT3aHqmGBKMYRFdFkcvlstCDWrGKZfQfYVuhy1XXcQVDKFad4mMsnm_khZx-Y0wLsd30Ux5_F-n0WShK2FRYBvnFuXbPrUjkJY1k0GDBkWPdA73djZVJVwowLhrJJ3lgzuw8VBt7y258kyEoTjXe9Wbq2o9Gx3FCZIuaSRfsl-UErLmCs0BofT4sQoFsR_P0JuS35KVEhTVWrOlKxDYjiPSiq3TAdvpLw2XW-T2bAA";
////            Customer customer = customerServiceClient.findCustomerById(1L);
////            System.out.println("*************");
////            System.out.println("Name =" + customer.getName());
////            Compte compte = compteRepository.save(new Compte());
////            PagedModel<Product> products = inventoryServiceClient.findAllProducts(bearer);
////            products.getContent().forEach(p -> {
////                System.out.println(p.getName());
////                productItemRepository.save(new ProductItem(null, null, p.getId(), p.getPrice(), 30, bill));
////
////            });
//        };
//    }
    @RestController
    class CompteRestController {
        @Autowired
        private CompteRepository compteRepository;
//        @Autowired
//        private OperationServiceClient operationServiceClient;
        @Autowired
        private CustomerServiceClient customerServiceClient;
//        @Autowired
//        private KeycloakAdapterConfig keycloakAdapterConfig;

        @GetMapping("/fullCompte/{id}")
        public Compte getCompte(@PathVariable(name = "id") Long id) {
//			String bearer = "Bearer "+keycloakAdapterConfig.keycloakSecurityContext().getTokenString();
            String bearer = "Bearer " + "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJLcEYxNTg5NFRub2RQbTlpSF9QU01JV0hGanpxNkU3clBHTlZTTnZINlowIn0.eyJleHAiOjE2MTMxMjQ1NzksImlhdCI6MTYxMzA4ODU3OSwiYXV0aF90aW1lIjoxNjEzMDg4NTc5LCJqdGkiOiIzNjRmYjU1Zi1jMjM1LTRjOWUtYjUwOS00YmQwMDljNDI3NDEiLCJpc3MiOiJodHRwOi8vbG9jYWxob3N0OjgwODAvYXV0aC9yZWFsbXMvYXBwLXJlYWxtIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6ImYwNzVlNzZhLTUzMzctNDU0NC04MTgxLThhMTU1ZTUwZDliOSIsInR5cCI6IkJlYXJlciIsImF6cCI6IkFuZ3VsYXJQcm9kdWN0c0FwcCIsIm5vbmNlIjoiMWVkMjU2MmItZjZkYy00ZjJjLTk0NDgtYjM0M2VmNzkzNjdhIiwic2Vzc2lvbl9zdGF0ZSI6ImVjMDZlYTg2LTY4YzYtNDJhMC1iNDMwLWEyYjIxYjljOTlkMyIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDo0MjAwIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJCSUxMSU5HX01BTkFHRVIiLCJQUk9EVUNUX01BTkFHRVIiLCJvZmZsaW5lX2FjY2VzcyIsIkNVU1RPTUVSX01BTkFHRVIiLCJBRE1JTiIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJvcGVuaWQgcHJvZmlsZSBlbWFpbCIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibmFtZSI6InNhYWQiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJ1c2VyMSIsImdpdmVuX25hbWUiOiJzYWFkIiwiZW1haWwiOiJ1c2VyMUBnbWFpbC5jb20ifQ.kVMc4-D5Q-v2QrBiZq1WRJU-h8tAIe6sOemys-mPGq9wYVcpiSJ3D5NyWzw9S4YEWzZJIrAKrZvjjfouLa9QJTJExJzP3tKY74VOp3CyMlW0PT3aHqmGBKMYRFdFkcvlstCDWrGKZfQfYVuhy1XXcQVDKFad4mMsnm_khZx-Y0wLsd30Ux5_F-n0WShK2FRYBvnFuXbPrUjkJY1k0GDBkWPdA73djZVJVwowLhrJJ3lgzuw8VBt7y258kyEoTjXe9Wbq2o9Gx3FCZIuaSRfsl-UErLmCs0BofT4sQoFsR_P0JuS35KVEhTVWrOlKxDYjiPSiq3TAdvpLw2XW-T2bAA";
            Compte compte = compteRepository.findById(id).get();
//            compte.setCustomer(customerServiceClient.findCustomerById(compte.getCustomerID()));
//			compte.setCompteItems(productItemRepository.findByCompteId(id, bearer));
//            compte.getOperations().forEach(operation->{
//                operation.setOperation(inventoryServiceClient.findCompteById(operation.getCompteID(), bearer));
//            });
            return compte;
        }

        @PostMapping(value = "/comptes/create")
        public Compte CreateCompte(@RequestBody Compte c) {

            return  compteRepository.save(new Compte(c.getSolde(), c.getDateCreation(),c.getTypeCompte(),c.getEtat(),c.getCustomerID(),c.getOperations()));
        }
        @PutMapping(value = "/comptes/versement/{montant}")
        public Compte versement(@RequestBody Compte c,@PathVariable double montant) {

            Compte compte = compteRepository.findById(c.getId()).get();
            compte.setSolde(compte.getSolde()+montant);
            return compteRepository.save(compte);
        }
        @PutMapping(value = "/comptes/retrait/{montant}")
        public Compte retrait(@RequestBody Compte c,@PathVariable double montant) {

            Compte compte = compteRepository.findById(c.getId()).get();
            compte.setSolde(compte.getSolde()-montant);
            return compteRepository.save(compte);
        }
        @PutMapping(value = "/comptes/virement/{c1}/{c2}/{montant}")
        public void virement(@RequestBody Compte c,@PathVariable Compte c1,@PathVariable Compte c2,@PathVariable double montant) {

            Compte compte1 = compteRepository.findById(c.getId()).get();
            Compte compte2 = compteRepository.findById(c2.getId()).get();
            retrait(compte1,montant);
            versement(compte2,montant);
        }
        @GetMapping(value = "comptes/operations")
        public PagedModel<Operation> getOperations(@RequestBody Compte c){
            Compte compte = compteRepository.findById(c.getId()).get();
            PagedModel<Operation> operations = compte.getOperations();
            return operations;
        }
        @GetMapping(value = "comptes/{id}")//relook
        public Compte getComptebyClient(@RequestBody  Long id)
        {
            Compte compte = compteRepository.findById(id).get();
            compte.setCustomer(customerServiceClient.findCustomerById(compte.getCustomerID()));
            return compte;
        }

        @PutMapping(value="Activation/{id}")
        public Compte changeState(@RequestBody Long id)
        {
            Compte compte = compteRepository.findById(id).get();
            if(compte.getEtat()==false)
                compte.setEtat(true);
            else
                compte.setEtat(false);
            return compteRepository.save(compte);
        }




    }
}
