package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Sgno;
import com.dw.ngms.cis.search.entity.Survey;
import com.dw.ngms.cis.search.repository.SGNORepository;
import com.dw.ngms.cis.search.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;


    public List<Survey> searchBySurveySGNumberProvinceCode(String surveyRecordNumber, String provinceCode) {
        return this.surveyRepository.searchBySurveySGNumberProvinceCode(surveyRecordNumber,provinceCode);
    }//searchBySurveySGNumberProvinceCode






}
