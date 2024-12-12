package com.always_upgrade.jobApplication.Company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }
    @GetMapping
public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<>(companyService.getAllCompanies(),HttpStatus.OK);
}
@PostMapping
public ResponseEntity<String> createComapny(@RequestBody Company receivedCompany){
        companyService.createCompany(receivedCompany);
        return new ResponseEntity<>("Company Added Successfully",HttpStatus.CREATED);
}

@PutMapping("/{id}")
public ResponseEntity<String> updateCompanyByID(@PathVariable Long id, @RequestBody Company updatedCompany){
    boolean updated=companyService.updateCompany(id,updatedCompany);
    if(updated==true){
        return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    }
   return new ResponseEntity<>("Company Not Updated",HttpStatus.NOT_FOUND);
}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleteCompany(@PathVariable Long id){
       boolean isdeleted= companyService.deleteCompany(id);
        if(isdeleted==true){
            return new ResponseEntity<>("Company Deleted", HttpStatus.OK);
        }
    return new ResponseEntity<>("Company Not Deleted",HttpStatus.NOT_FOUND);
}}
