package com.preonboding.work.company.service;


import com.preonboding.work.company.dto.CompanyPostDto;
import com.preonboding.work.company.entity.Company;
import com.preonboding.work.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    //채용공고 등록
    public Company createCompany(Company company){

        return companyRepository.save(company);

    }
}
