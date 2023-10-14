package com.preonboding.work.jobnotice.service;



import com.preonboding.work.jobnotice.entity.JobNotice;
import com.preonboding.work.jobnotice.repository.JobNoticeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobNoticeService {

    private final JobNoticeRepository noticeRepository;

    public JobNoticeService(JobNoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    //채용공고 등록
    public JobNotice createCompany(JobNotice notice){

        return noticeRepository.save(notice);

    }


    //채용공고 수정
    public JobNotice updateCompany(JobNotice notice) throws Exception {

        JobNotice companyId= findVerifiedCompany(notice.getCompanyId());


        Optional.ofNullable(companyId.getPostion()).
                ifPresent(postion->companyId.setPostion(postion));
        Optional.ofNullable(companyId.getCompanyCost()).
                ifPresent(cost->companyId.setCompanyCost(cost));

        Optional.ofNullable(companyId.getContent()).
                ifPresent(content->companyId.setContent(content));

        Optional.ofNullable(companyId.getTechnology()).
                ifPresent(technology->companyId.setTechnology(technology));

        return noticeRepository.save(companyId);

    }
     //회사 id 체크
    public  JobNotice findVerifiedCompany(Long companyId) throws Exception {

           Optional<JobNotice> companyOptional= noticeRepository.findById(companyId);
        JobNotice findCompanyId= companyOptional.orElseThrow(()->new Exception("존재하지 않는 Id입니다!"));

           return findCompanyId;

          }

    public void deleteCompany(long companyId) throws  Exception{

        JobNotice company= findCompany(companyId);

        noticeRepository.delete(company);
    }

    public JobNotice findCompany(long companyId) throws Exception{

        return findVerifiedCompany(companyId);
    }

    public List<JobNotice> getCompanyList() {

        List<JobNotice> companyList= noticeRepository.findAll();

        return noticeRepository.saveAll(companyList);

    }

    //채용공고 검색
    //페이징 추가
    public Page<JobNotice> getSearchCompany(String search, Pageable pageable) {

     return noticeRepository.findByPostionContainingOrTechnologyContaining(search,search,pageable);
    }

    public JobNotice getCompany(long companyId) throws Exception {

        JobNotice findCompanyId= findVerifiedCompany(companyId);

        return noticeRepository.save(findCompanyId);


    }
}
