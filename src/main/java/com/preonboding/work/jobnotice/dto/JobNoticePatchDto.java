package com.preonboding.work.jobnotice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobNoticePatchDto {

    private long companyId;

    private String postion;
    private String companyCost;
    private String content;
    private String technology;



}
