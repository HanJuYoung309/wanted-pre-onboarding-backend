package com.preonboding.work.jobnotice.mapper;


import com.preonboding.work.jobnotice.dto.JobNoticePatchDto;
import com.preonboding.work.jobnotice.dto.JobNoticePostDto;
import com.preonboding.work.jobnotice.entity.JobNotice;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface JobNoticeMapper {
    JobNotice companyPostDtoToCompany(JobNoticePostDto noticePostDto);

    JobNotice companyToResponseDto(JobNotice jobNotice);

    JobNotice companyPatchDtoToCompany(JobNoticePatchDto companyPatchDto);
}
