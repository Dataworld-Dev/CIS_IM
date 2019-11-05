package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.SectionalFarm;
import com.dw.ngms.cis.search.entity.SectionalTitle;
import com.dw.ngms.cis.search.service.SectionalFarmService;
import com.dw.ngms.cis.search.service.SectionalTitleService;
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
public class SectionalTitleController extends MessageController {

    @Autowired
    private SectionalTitleService sectionalTitleService;





    @GetMapping("/searchSectionalPortionByTitle")
    public ResponseEntity<?> searchSectionalPortionByTitle(
            HttpServletRequest request,
            @RequestParam(required = false) String schemaNumber,
            @RequestParam(required = false) String schemeName,
            @RequestParam(required = false) String deedsRegistrationNumber,
            @RequestParam(required = false) String sgNumber,
            @RequestParam(required = false) String provinceCode){

        try {
            List<SectionalTitle> sectionalTitleList = this.sectionalTitleService.searchSectionalPortionByTitle(schemaNumber, schemeName,deedsRegistrationNumber,sgNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(sectionalTitleList)) ? ResponseEntity.status(HttpStatus.OK).body(sectionalTitleList)
                    : ResponseEntity.status(HttpStatus.OK).body(sectionalTitleList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm





}
