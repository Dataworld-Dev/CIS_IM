package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Deeds;
import com.dw.ngms.cis.search.entity.Lease;
import com.dw.ngms.cis.search.repository.DeedsRepository;
import com.dw.ngms.cis.search.repository.LeaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@Service
public class LeaseService {

    @Autowired
    private LeaseRepository leaseRepository;


    public List<Lease> searchByLeaseNumberProvinceCode(String leaseNumber, String provinceCode) {
        return this.leaseRepository.searchByLeaseNumberProvinceCode(leaseNumber,provinceCode);
    }//searchByLeaseSGNumberProvinceCode






}
