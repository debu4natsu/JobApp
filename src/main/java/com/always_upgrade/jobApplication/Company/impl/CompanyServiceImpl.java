package com.always_upgrade.jobApplication.Company.impl;

import com.always_upgrade.jobApplication.Company.Company;
import com.always_upgrade.jobApplication.Company.CompanyRepository;
import com.always_upgrade.jobApplication.Company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public void createCompany(Company company) {
     companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id,Company updatedCompany) {
        Optional<Company> companyOptional=companyRepository.findById(id);
        if(companyOptional.isPresent()){
            Company company=companyOptional.get();
            company.setTitle(updatedCompany.getTitle());
            company.setDescription(updatedCompany.getDescription());
            company.setJobs(updatedCompany.getJobs());
            companyRepository.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCompany(Long id) {
            if (companyRepository.existsById(id)) {
                companyRepository.deleteById(id);
                return true;
            }
       else {
            return false;
        }
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
}


