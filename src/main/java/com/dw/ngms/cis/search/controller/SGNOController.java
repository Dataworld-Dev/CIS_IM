package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Sgno;
import com.dw.ngms.cis.search.service.SGNOService;
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
public class SGNOController extends MessageController {

    @Autowired
    private SGNOService SGNOService;




    @GetMapping("/searchByNumberProvinceCode")
    public ResponseEntity<?> searchByNumberProvinceCode(HttpServletRequest request,
                                                   @RequestParam String sGNumber,
                                                   @RequestParam String provinceCode
    ) {
        try {
            List<Sgno> searchEntityList = this.SGNOService.searchByNumberProvinceCode(sGNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(searchEntityList)) ? ResponseEntity.status(HttpStatus.OK).body(searchEntityList)
                    : ResponseEntity.status(HttpStatus.OK).body(searchEntityList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchByNumberProvincCode





}
