package com.preonboding.work.jobnotice.repository;


import com.preonboding.work.jobnotice.entity.JobNotice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobNoticeRepository extends JpaRepository<JobNotice,Long>
{
      Page<JobNotice> findByPostionContainingOrTechnologyContaining(String postion, String technology, Pageable pageable);
}
