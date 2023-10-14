package com.preonboding.work.jobnotice.controller;



import com.preonboding.work.jobnotice.dto.JobNoticePatchDto;
import com.preonboding.work.jobnotice.dto.JobNoticePostDto;
import com.preonboding.work.jobnotice.entity.JobNotice;
import com.preonboding.work.jobnotice.mapper.JobNoticeMapper;
import com.preonboding.work.jobnotice.service.JobNoticeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class JobNoticeController {

    private final JobNoticeService jobNoticeService;

    private final JobNoticeMapper jobNoticeMapper;

    public JobNoticeController(JobNoticeService jobNoticeService, JobNoticeMapper jobNoticeMapper) {
        this.jobNoticeService = jobNoticeService;
        this.jobNoticeMapper = jobNoticeMapper;
    }

    //채용공고 등록
    @PostMapping
    public ResponseEntity createCompany(@RequestBody JobNoticePostDto jobNoticePostDto){

        JobNotice jobNotice= jobNoticeService.createCompany(jobNoticeMapper.companyPostDtoToCompany(jobNoticePostDto));

        return new ResponseEntity(jobNoticeMapper.companyToResponseDto(jobNotice), HttpStatus.CREATED);


    }

    //채용공고 수정
    @PatchMapping("/{company-id}")
    public ResponseEntity updateCompany(@PathVariable("company-id") long companyId,
                                        @RequestBody JobNoticePatchDto companyPatchDto) throws Exception {

        companyPatchDto.setCompanyId(companyId);

        JobNotice updateNotice= jobNoticeService.updateCompany(jobNoticeMapper.companyPatchDtoToCompany(companyPatchDto));

        return new ResponseEntity(jobNoticeMapper.companyToResponseDto(updateNotice),HttpStatus.OK);
    }

    //채용공고 삭제
    @DeleteMapping("/{company-id}")
    public ResponseEntity deleteCompany(@PathVariable("company-id") long companyId) throws Exception{


        jobNoticeService.deleteCompany(companyId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //채용공고 목록 가져오기
    @GetMapping
    public ResponseEntity getCompanyList(){

        List<JobNotice> companyList= jobNoticeService.getCompanyList();

        return new ResponseEntity(companyList,HttpStatus.OK);
    }

    //체용공고 검색
    //페이징 추가
    @GetMapping("/search")
    public ResponseEntity<Page<JobNotice>> search(@RequestParam("search")String search
         ,@RequestParam(name="page", defaultValue = "0")    int page
         ,@RequestParam(name = "size", defaultValue = "10") int size) throws Exception {

        Pageable pageable= PageRequest.of(page,size);
        Page<JobNotice> companyPageSearch= jobNoticeService.getSearchCompany(search,pageable);

        return new ResponseEntity<>(companyPageSearch,HttpStatus.OK);


    }

    //채용공고 상세보기
    @GetMapping("/{company-id}")
    public  ResponseEntity getCompany(@PathVariable("company-id")long companyId) throws Exception {

        JobNotice getNotice= jobNoticeService.getCompany(companyId);

        return new ResponseEntity(getNotice,HttpStatus.OK);
    }


}
