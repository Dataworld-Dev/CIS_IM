package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Deeds;
import com.dw.ngms.cis.search.entity.Filling;
import com.dw.ngms.cis.search.service.DeedsService;
import com.dw.ngms.cis.search.service.FillingService;
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
public class DeedsController extends MessageController {

    @Autowired
    private DeedsService deedsService;




    @GetMapping("/searchByDeedsNumberProvinceCode")
    public ResponseEntity<?> searchByDeedsSGNumberProvinceCode(HttpServletRequest request,
                                                   @RequestParam String deedNumber,
                                                   @RequestParam String provinceCode
    ) {
        try {
            List<Deeds> deedsList = this.deedsService.searchByDeedsNumberProvinceCode(deedNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(deedsList)) ? ResponseEntity.status(HttpStatus.OK).body(deedsList)
                    : ResponseEntity.status(HttpStatus.OK).body(deedsList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchByDeedsNumberProvinceCode





}
