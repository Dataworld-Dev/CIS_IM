package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Deeds;
import com.dw.ngms.cis.search.entity.Lease;
import com.dw.ngms.cis.search.service.DeedsService;
import com.dw.ngms.cis.search.service.LeaseService;
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
public class LeaseController extends MessageController {

    @Autowired
    private LeaseService leaseService;




    @GetMapping("/searchByLeaseNumberProvinceCode")
    public ResponseEntity<?> searchByLeaseSGNumberProvinceCode(HttpServletRequest request,
                                                   @RequestParam String leaseNumber,
                                                   @RequestParam String provinceCode
    ) {
        try {
            List<Lease> leaseList = this.leaseService.searchByLeaseNumberProvinceCode(leaseNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(leaseList)) ? ResponseEntity.status(HttpStatus.OK).body(leaseList)
                    : ResponseEntity.status(HttpStatus.OK).body(leaseList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchByLeaseNumberProvinceCode





}
