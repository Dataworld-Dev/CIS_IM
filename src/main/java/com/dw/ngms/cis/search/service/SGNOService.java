package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Sgno;
import com.dw.ngms.cis.search.repository.SGNORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@Service
public class SGNOService {

    @Autowired
    private SGNORepository searchRepository;


    public List<Sgno> searchByNumberProvinceCode(String sGNumber, String provinceCode) {
        return this.searchRepository.searchByNumberProvinceCode(sGNumber,provinceCode);
    }//searchByNumberProvinceCode






}
