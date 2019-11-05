package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@RestController
@RequestMapping("/cisorigin.search/api/v1")
@CrossOrigin(origins = "*")
public class FarmController extends MessageController {

    @Autowired
    private FarmService farmService;


    @GetMapping("/searchParcelByFarm")
    public ResponseEntity<?> searchParcelByFarm(
            HttpServletRequest request,
            @RequestParam(required = false) String provinceCode,
            @RequestParam(required = false) String parcelType,
            @RequestParam(required = false) String registrationDivision,
            @RequestParam(required = false) String farmNumber,
            @RequestParam(required = false) String portionNumber){

        try {
            List<Farm> farmList = this.farmService.searchParcelByFarm(provinceCode, parcelType, registrationDivision,farmNumber,portionNumber);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchBySurveySGNumberProvinceCode



    @GetMapping("/getRegistrationDivision")
    public ResponseEntity<?> getRegistrationDivision(
            HttpServletRequest request,
            @RequestParam String provinceCode) {

        try {
            List<Farm> farmList = this.farmService.getRegistrationDivision(provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchBySurveySGNumberProvinceCode





}


