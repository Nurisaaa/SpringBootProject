package com.example.springbootproject.api;

import com.example.springbootproject.dto.request.CompanyRequest;
import com.example.springbootproject.dto.responce.CompanyResponse;
import com.example.springbootproject.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/companies")
public class CompanyApi {
    private final CompanyService companyService;

    @GetMapping
    public List<CompanyResponse> getCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping
    public CompanyResponse createCompany(@RequestBody CompanyRequest companyRequest) {
        return companyService.saveCompany(companyRequest);
    }

    @DeleteMapping("delete/{id}")
    public void deleteCompanyById(@PathVariable("id") Long id) {
        companyService.deleteCompanyById(id);
    }

    @PatchMapping("update/{id}")
    public CompanyResponse updateCompany(@RequestBody CompanyRequest companyRequest, @PathVariable("id") Long id) {
        return companyService.updateCompany(id, companyRequest);
    }

    @GetMapping("{id}")
    public CompanyResponse getCompanyById(@PathVariable("id") Long id){
        return companyService.getCompanyById(id);
    }
}
