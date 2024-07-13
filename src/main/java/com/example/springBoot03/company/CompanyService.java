package com.example.springBoot03.company;


import java.util.List;


public interface CompanyService {
    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company company);
    void addCompany(Company company);
    boolean deleteCompany(Long id);

    Company getCompanyByid(Long id);
}