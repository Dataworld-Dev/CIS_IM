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
@Table(name = "FILING")
public class Filling {


    @Id
    @Column(name = "ID")
    private String id;


    @Column(name = "SGNO")
    private String sgNo;

    @Column(name = "PROV_CODE")
    private String provCode;

    @Column(name = "FILING_NO")
    private String filingNumber;

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

    @Column(name = "DIAGRAM_TYPE")
    private String diagramType;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PAGENO")
    private Integer pageNumber;


    @Column(name = "URL")
    private String url;

    @Column(name = "FTP_SITE_URL")
    private String ftpSiteUrl;

    @Column(name = "FILE_SIZE")
    private String fileSize;

    @Column(name = "PROVINCE", length = 255)
    private String province;

    @Column(name = "PREVIEW")
    private String preview;


}
