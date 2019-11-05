package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Filling;
import com.dw.ngms.cis.search.entity.Survey;
import com.dw.ngms.cis.search.repository.FillingRepository;
import com.dw.ngms.cis.search.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@Service
public class FillingService {

    @Autowired
    private FillingRepository fillingRepository;


    public List<Filling> searchByFillingCode(String fillingNumber, String provinceCode) {
        return this.fillingRepository.searchByFillingCode(fillingNumber,provinceCode);
    }//searchByFillingCode






}
