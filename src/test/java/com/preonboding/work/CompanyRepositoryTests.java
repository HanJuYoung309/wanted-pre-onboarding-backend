package com.preonboding.work;

import com.preonboding.work.company.entity.Company;
import com.preonboding.work.company.repository.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompanyRepositoryTests {

    @Autowired
    private CompanyRepository companyRepository;


    @Test
    public void savedCompanyTest(){

        //given
        Company company= new Company();
        company.setPostion("백엔드 개발자");
        company.setCompanyCost("100000");
        company.setContent("원티드에서 개발자뽑아요");
        company.setTechnology("Spring");

        //when
        Company savedCompany= companyRepository.save(company);

        //then
        assertNotNull(savedCompany);
        assertTrue(company.getPostion().equals(savedCompany.getPostion()));
        assertTrue(company.getCompanyCost().equals(savedCompany.getCompanyCost()));
        assertTrue(company.getContent().equals(savedCompany.getContent()));
        assertTrue(company.getTechnology().equals(savedCompany.getTechnology()));


    }
}
