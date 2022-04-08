package com.example.springbootproject.dto.mapper.view;

import com.example.springbootproject.dto.responce.CompanyResponse;
import com.example.springbootproject.model.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyViewMapper {

    public CompanyResponse viewCompany(Company company) {
        if (company == null) {
            return null;
        }
        CompanyResponse companyResponse = new CompanyResponse();
        if (company.getId() != null) {
            companyResponse.setId(Long.valueOf(company.getId()));
        }
        companyResponse.setName(company.getName());
        companyResponse.setLocatedCountry(company.getLocatedCountry());
//        companyResponse.setCourses(company.getCourses());
        return companyResponse;
    }

    public List<CompanyResponse> getCompanies(List<Company> companies) {
        List<CompanyResponse> companyResponses = new ArrayList<>();
        for (Company c : companies) {
            companyResponses.add(viewCompany(c));
        }
        return companyResponses;

    }

}
