package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.responce.CompanyResponse;
import com.example.springbootproject.mapper.edit.CompanyEditMapper;
import com.example.springbootproject.mapper.view.CompanyViewMapper;
import com.example.springbootproject.model.Company;
import com.example.springbootproject.repository.CompanyRepository;
import com.example.springbootproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyEditMapper companyEditMapper;
    private final CompanyViewMapper companyViewMapper;


    @Override
    public CompanyResponse saveCompany(CompanyRequest companyRequest) {
        return companyViewMapper.viewCompany(companyRepository.save(companyEditMapper.saveCompany(companyRequest)));
    }

    @Override
    public CompanyResponse getCompanyById(long id) {
        return companyViewMapper.viewCompany(companyRepository.getById(id));
    }

    @Override
    public void deleteCompanyById(Long id) {
        Company company = companyRepository.getById(id);
        companyRepository.delete(company);
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company1 = companyRepository.findById(id).get();
        companyEditMapper.update(company1, companyRequest);
        return companyViewMapper.viewCompany(companyRepository.save(company1));
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companyViewMapper.getCompanies(companies);
    }
}
