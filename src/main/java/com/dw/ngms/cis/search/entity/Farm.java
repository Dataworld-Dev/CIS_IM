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
@Table(name = "FARM")
public class Farm {


    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "FARM_NUMBER")
    private String farmNumber;


    @Column(name = "FARM_NAME")
    private String farmName;


    @Column(name = "FARM_REGION")
    private String farmRegion;

    @Column(name = "REGISTRATION_DIVISION")
    private String registrationDivision;

    @Column(name = "PROV_CODE")
    private String provinceCode;


    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "SG_NO")
    private String sgNumber;


    @Column(name = "REGION")
    private String region;

    @Column(name = "PARCEL")
    private String parcelNumber;

    @Column(name = "PORTION_NUMBER")
    private String portionNumber;

    @Column(name = "LPI_CODE")
    private String lpi;

    @Column(name = "PARCEL_TYPE")
    private String parcel;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;

    @Column(name = "DIAGRAM_TYPE")
    private String diagramType;

    @Column(name = "NOTE")
    private String note;

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
