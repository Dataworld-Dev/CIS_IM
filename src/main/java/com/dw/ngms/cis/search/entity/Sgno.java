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
@Table(name = "SGNO")
public class Sgno {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "SGNO")
    private String sgNo;

    @Column(name = "PROV_CODE")
    private String provCode;


    @Column(name = "DOCUMENTNO", length = 2000, unique = true)
    private String documentNumber;


    @Column(name = "REGION", length = 2000)
    private String region;

    @Column(name = "PARCEL", length = 2000)
    private String parcel;

    @Column(name = "PORTION", length = 2000)
    private String portion;


    @Column(name = "LPI", length = 2000)
    private String lpi;


    @Column(name = "PARCEL TYPE", length = 2000)
    private String parcelType;


    @Column(name = "DOCUMENT TYPE", length = 2000)
    private String documentType;

    @Column(name = "DESCRIPTION", length = 2000)
    private String description;

    @Column(name = "PAGENO", length = 2000)
    private String pageNumber;


    @Column(name = "URL", length = 2000)
    private String url;

    @Column(name = "FTP_SITE_URL", length = 2000)
    private String ftpSiteUrl;

    @Column(name = "FILE_SIZE", length = 2000)
    private String fileSize;


    @Column(name = "PROVINCE", length = 255)
    private String province;

    @Column(name = "DIAGRAM_TYPE")
    private String diagramType;

    @Column(name = "PREVIEW")
    private String preview;

}
