package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Sgno;
import com.dw.ngms.cis.search.entity.Survey;
import com.dw.ngms.cis.search.service.SGNOService;
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
public class SurveyController extends MessageController {

    @Autowired
    private SurveyService surveyService;




    @GetMapping("/searchBySurveySGNumberProvinceCode")
    public ResponseEntity<?> searchBySurveySGNumberProvinceCode(HttpServletRequest request,
                                                   @RequestParam String surveyRecordNumber,
                                                   @RequestParam String provinceCode
    ) {
        try {
            List<Survey> surveyList = this.surveyService.searchBySurveySGNumberProvinceCode(surveyRecordNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(surveyList)) ? ResponseEntity.status(HttpStatus.OK).body(surveyList)
                    : ResponseEntity.status(HttpStatus.OK).body(surveyList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchBySurveySGNumberProvinceCode





}
