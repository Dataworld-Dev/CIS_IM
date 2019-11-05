package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Filling;
import com.dw.ngms.cis.search.entity.Survey;
import com.dw.ngms.cis.search.service.FillingService;
import com.dw.ngms.cis.search.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@RestController
@RequestMapping("/cisorigin.search/api/v1")
@CrossOrigin(origins = "*")
public class FillingController extends MessageController {

    @Autowired
    private FillingService fillingService;




    @GetMapping("/searchByFilingNumberProvinceCode")
    public ResponseEntity<?> searchByFilingNumberProvinceCode(HttpServletRequest request,
                                                   @RequestParam String fillingNumber,
                                                   @RequestParam String provinceCode
    ) {
        try {
            System.out.println("Filling Number "+fillingNumber);
            System.out.println("provinceCode Number "+provinceCode);
            List<Filling> surveyList = this.fillingService.searchByFillingCode(fillingNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(surveyList)) ? ResponseEntity.status(HttpStatus.OK).body(surveyList)
                    : ResponseEntity.status(HttpStatus.OK).body(surveyList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchByFilingNumberProvinceCode





}
