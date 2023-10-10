package com.preonboding.work.company.controller;


import com.preonboding.work.company.dto.CompanyPatchDto;
import com.preonboding.work.company.dto.CompanyPostDto;
import com.preonboding.work.company.entity.Company;
import com.preonboding.work.company.mapper.CompanyMapper;
import com.preonboding.work.company.service.CompanyService;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    private final CompanyMapper companyMapper;

    public CompanyController(CompanyService companyService, CompanyMapper companyMapper) {

        this.companyService = companyService;
        this.companyMapper = companyMapper;
    }

    //채용공고 등록
    @PostMapping
    public ResponseEntity createCompany(@RequestBody CompanyPostDto companyPostDto){

        Company company= companyService.createCompany(companyMapper.companyPostDtoToCompany(companyPostDto));

        return new ResponseEntity(companyMapper.companyToResponseDto(company), HttpStatus.CREATED);


    }

    //채용공고 수정
    @PatchMapping("/{company-id}")
    public ResponseEntity updateCompany(@PathVariable("company-id") long companyId,
                                        @RequestBody CompanyPatchDto companyPatchDto) throws Exception {

        companyPatchDto.setCompanyId(companyId);

        Company updateCompany= companyService.updateCompany(companyMapper.companyPatchDtoToCompany(companyPatchDto));

        return new ResponseEntity(companyMapper.companyToResponseDto(updateCompany),HttpStatus.OK);
    }

    //채용공고 삭제
    @DeleteMapping("/{company-id}")
    public ResponseEntity deleteCompany(@PathVariable("company-id") long companyId) throws Exception{


        companyService.deleteCompany(companyId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
