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
@Table(name = "SECTIONAL_TITLE")
public class SectionalTitle {

    @Id
    @Column(name = "ID")
    private String id;



    @Column(name = "SCHEME_NAME")
    private String schemeName;


    @Column(name = "SCHEME_NUMBER")
    private String schemaNumber;

    @Column(name = "SG_NO")
    private String sgNumber;


    @Column(name = "DOCUMENT_NUMBER")
    private String documentNumber;

    @Column(name = "DEEDS_REGISTRATION_NUMBER")
    private String deedsRegistrationNumber;



    @Column(name = "PROV_CODE")
    private String provinceCode;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "REGION")
    private String region;

    @Column(name = "PARCEL")
    private String parcel;


    @Column(name = "PORTION")
    private String portion;

    @Column(name = "LPI")
    private String lpi;


    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "PAGENO")
    private String pageNumber;

    @Column(name = "URL")
    private String url;

    @Column(name = "FTP_SITE_URL")
    private String ftpSiteUrl;

    @Column(name = "FILE_SIZE")
    private String fileSize;

    @Column(name = "DIAGRAM_TYPE")
    private String diagramType;

    @Column(name = "PREVIEW")
    private String preview;


}
