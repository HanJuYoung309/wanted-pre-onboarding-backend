package com.preonboding.work.company.repository;


import com.preonboding.work.company.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company,Long>
{
}
