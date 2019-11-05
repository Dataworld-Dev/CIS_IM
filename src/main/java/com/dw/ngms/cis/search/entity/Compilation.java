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
@Table(name = "COMPILATION")
public class Compilation {

    @Id

    @Column(name = "ID")
    private Long id;


    @Column(name = "SGNO")
    private String sgNo;

    @Column(name = "COMPILATION_NUMBER")
    private String compilation;

    @Column(name = "DOCUMENTNO")
    private String documentNumber;


    @Column(name = "REGION")
    private String region;

    @Column(name = "PARCEL")
    private String parcel;

    @Column(name = "PORTION")
    private String portion;


    @Column(name = "LPI")
    private String lpi;

    @Column(name = "PROV_CODE")
    private String provCode;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PAGENO")
    private String pageNumber;


    @Column(name = "URL")
    private String url;

    @Column(name = "FTP_SITE_URL")
    private String ftpSiteUrl;

    @Column(name = "PREVIEW")
    private String preview;

    @Column(name = "FILE_SIZE")
    private String fileSize;




}
