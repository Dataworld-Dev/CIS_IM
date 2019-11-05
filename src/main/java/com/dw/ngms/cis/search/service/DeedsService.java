package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Deeds;
import com.dw.ngms.cis.search.entity.Survey;
import com.dw.ngms.cis.search.repository.DeedsRepository;
import com.dw.ngms.cis.search.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@Service
public class DeedsService {

    @Autowired
    private DeedsRepository deedsRepository;


    public List<Deeds> searchByDeedsNumberProvinceCode(String deedNumber, String provinceCode) {
        return this.deedsRepository.searchByDeedsNumberProvinceCode(deedNumber,provinceCode);
    }//searchByDeedsNumberProvinceCode






}
