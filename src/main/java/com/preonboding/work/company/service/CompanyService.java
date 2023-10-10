package com.preonboding.work.company.service;


import com.preonboding.work.company.entity.Company;
import com.preonboding.work.company.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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


    //채용공고 수정
    public Company updateCompany(Company company) throws Exception {

        Company companyId= findVerifiedCompany(company.getCompanyId());


        Optional.ofNullable(company.getPostion()).
                ifPresent(postion->companyId.setPostion(postion));
        Optional.ofNullable(company.getCompanyCost()).
                ifPresent(cost->companyId.setCompanyCost(cost));

        Optional.ofNullable(company.getContent()).
                ifPresent(content->companyId.setContent(content));

        Optional.ofNullable(company.getTechnology()).
                ifPresent(technology->companyId.setTechnology(technology));

        return companyRepository.save(companyId);

    }

    public  Company findVerifiedCompany(Long companyId) throws Exception {

           Optional<Company> companyOptional= companyRepository.findById(companyId);
           Company findCompanyId= companyOptional.orElseThrow(()->new Exception("존재하지 않는 Id입니다!"));

           return findCompanyId;

          }

    public void deleteCompany(long companyId) throws  Exception{

        Company company= findCompany(companyId);

        companyRepository.delete(company);
    }

    public Company findCompany(long companyId) throws Exception{

        return findVerifiedCompany(companyId);
    }
}
