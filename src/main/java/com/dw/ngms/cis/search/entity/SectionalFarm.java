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
@Table(name = "SECTIONAL_FARM")
public class SectionalFarm {

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "SCHEME_NAME")
    private String schemeName;

    @Column(name = "SCHEME_NUMBER")
    private String schemaNumber;

    @Column(name = "SG_NO")
    private String sgNumber;

    @Column(name = " DOCUMENT_NUMBER")
    private String doumentNumber;

    @Column(name = "IMAGE_NUMBER")
    private String imageNumber;

    @Column(name = "DEEDS_REGISTRATION_NUMBER")
    private String deedsRegistrationNumber;

    @Column(name = "PROV_CODE")
    private String provCode;

    @Column(name = "PROVINCE")
    private String province;

    @Column(name = "FARM_NUMBER")
    private String farmNumber;

    @Column(name = "FARM_NAME")
    private String farmName;

    @Column(name = "REGISTRATION_DIVISION")
    private String registrationDivision;

    @Column(name = "FARM_REGION")
    private String farmRegion;

    @Column(name = "REGION")
    private String region;


    @Column(name = "PARCEL")
    private String parcel;

    @Column(name = "PORTION_NUMBER")
    private String portionNumber;


    @Column(name = " LPI_CODE")
    private String lpi;

    @Column(name = "PARCEL_TYPE")
    private String parcelType;

    @Column(name = "DOCUMENT_TYPE")
    private String documentType;



    @Column(name = "NOTE")
    private String note;

    @Column(name = "PAGENO")
    private String pageNo;

    @Column(name = "URL")
    private String url;

    @Column(name = "FTP_SITE_URL", length = 2000)
    private String ftpSiteUrl;

    @Column(name = "FIE_SIZE", length = 2000)
    private String fileSize;

    @Column(name = "DIAGRAM_TYPE")
    private String diagramType;

    @Column(name = "PREVIEW")
    private String preview;


}
