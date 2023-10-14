package com.preonboding.work.jobnotice.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class JobNotice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId; //회사 Id

    private String postion;

    private String companyCost;

    private String content;

    private String technology;







}