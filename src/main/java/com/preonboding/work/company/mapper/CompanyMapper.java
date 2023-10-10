package com.preonboding.work.company.mapper;


import com.preonboding.work.company.dto.CompanyPostDto;
import com.preonboding.work.company.dto.CompanyResponseDto;
import com.preonboding.work.company.entity.Company;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    Company companyPostDtoToCompany(CompanyPostDto companyPostDto);

    Company companyToResponseDto(Company company);
}
