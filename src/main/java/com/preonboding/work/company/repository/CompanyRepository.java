package com.preonboding.work.company.repository;


import com.preonboding.work.company.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company,Long>
{
      Page<Company> findByPostionContainingOrTechnologyContaining(String postion, String technology, Pageable pageable);
}
