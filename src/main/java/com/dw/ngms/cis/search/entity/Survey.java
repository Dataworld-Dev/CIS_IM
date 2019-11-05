package com.dw.ngms.cis.search.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by swaroop on 2019/04/16.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "SURVEY")
public class Survey {





    @Id
    @Column(name = "SGNO")
    private String sgNo;

    @Column(name = "PROV_CODE")
    private String provCode;


    @Column(name = "SURVEY_RECORD_NUMBER")
    private String surveyRecordNumber;


    @Column(name = "REGION")
    private String region;

    @Column(name = "PARCEL")
    private String parcel;

    @Column(name = "PORTION")
    private String portion;


    @Column(name = "LPI")
    private String lpi;


    @Column(name = "PARCEL TYPE")
    private String parcelType;


    @Column(name = "DOCUMENT TYPE")
    private String documentType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PAGENO")
    private String pageNumber;


    @Column(name = "URL")
    private String url;

    @Column(name = "FTP_SITE_URL")
    private String ftpSiteUrl;

    @Column(name = "FILE_SIZE")
    private String fileSize;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "PREVIEW")
    private String preview;


}
