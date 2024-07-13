package com.example.springBoot03.company;

import com.example.springBoot03.jobs.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController(CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompaniesController(){
        return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyController(@PathVariable Long id, @RequestBody Company company){
        if(companyService.updateCompany(id, company))
            return new ResponseEntity<String>("Company updated successfully", HttpStatus.OK);

        return new ResponseEntity<String>("Company not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping()
    public ResponseEntity<String> addCompanyController(@RequestBody Company company){
        companyService.addCompany(company);
        return new ResponseEntity<>("Company added successfully", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyController(@PathVariable Long id){
        if(companyService.deleteCompany(id))
            return new ResponseEntity<>("Company deleted successfully",HttpStatus.OK);

        return new ResponseEntity<>("Failed to delete company", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findByIdController(@PathVariable Long id){
        Company company = companyService.getCompanyByid(id);
        if(company !=null)
            return new ResponseEntity<>(company, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
