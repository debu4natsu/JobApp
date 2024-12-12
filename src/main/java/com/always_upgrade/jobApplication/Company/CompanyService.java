package com.always_upgrade.jobApplication.Company;

import java.util.List;

public interface CompanyService {
    List<Company> getAllCompanies();
    void createCompany(Company company);
    boolean updateCompany(Long id,Company company);
    boolean deleteCompany(Long id);
    Company getCompanyById(Long id);
}
