package com.example.springbootproject.service;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.responce.CompanyResponse;
import java.util.List;

public interface CompanyService {
    CompanyResponse saveCompany(CompanyRequest companyRequest);
    List<CompanyResponse> getAllCompanies();
    CompanyResponse getCompanyById(Long id);
    void deleteCompanyById(Long id);
    CompanyResponse updateCompany(Long id,CompanyRequest company);
}

