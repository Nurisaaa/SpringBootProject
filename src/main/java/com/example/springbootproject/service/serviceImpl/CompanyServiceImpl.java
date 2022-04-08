package com.example.springbootproject.service.serviceImpl;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.responce.CompanyResponse;
import com.example.springbootproject.exception.BadRequest;
import com.example.springbootproject.dto.mapper.edit.CompanyEditMapper;
import com.example.springbootproject.dto.mapper.view.CompanyViewMapper;
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
        return companyViewMapper.viewCompany(companyRepository
                .save(companyEditMapper
                        .saveCompany(companyRequest)));
    }

    @Override
    public CompanyResponse getCompanyById(Long id) {
        Company company = getCompany(id);
        return companyViewMapper.viewCompany(company);
    }

    @Override
    public void deleteCompanyById(Long id) {
        Company company = getCompany(id);
        companyRepository.delete(company);
    }

    @Override
    public CompanyResponse updateCompany(Long id, CompanyRequest companyRequest) {
        Company company = getCompany(id);
        companyEditMapper.update(company, companyRequest);
        return companyViewMapper.viewCompany(companyRepository.save(company));
    }

    @Override
    public List<CompanyResponse> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companyViewMapper.getCompanies(companies);
    }

    private Company getCompany(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new BadRequest(
                        String.format("Company with this %d does not exist ", id)
                ));
    }
}
