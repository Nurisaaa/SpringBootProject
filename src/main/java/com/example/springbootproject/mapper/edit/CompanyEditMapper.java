package com.example.springbootproject.mapper.edit;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.model.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyEditMapper {

    public Company saveCompany(CompanyRequest companyRequest) {
        if (companyRequest == null) {
            return null;
        }
        Company company = new Company();
        company.setName(companyRequest.getName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
        return company;
    }

    public void update(Company company, CompanyRequest companyRequest) {
        company.setName(companyRequest.getName());
        company.setLocatedCountry(companyRequest.getLocatedCountry());
    }
}
