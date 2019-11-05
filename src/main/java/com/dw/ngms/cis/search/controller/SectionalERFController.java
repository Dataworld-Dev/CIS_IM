package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.SectionalErf;
import com.dw.ngms.cis.search.service.ErfService;
import com.dw.ngms.cis.search.service.SectionalErfService;
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
public class SectionalERFController extends MessageController {

    @Autowired
    private SectionalErfService sectionalErfService;





/*
    @GetMapping("/searchSectionalPortionByERF")
    public ResponseEntity<?> searchParcelByERF(
            HttpServletRequest request,
            @RequestParam(required = false) String minorRegion,
            @RequestParam(required = false) String erfNumber,
            @RequestParam(required = false) String portionNumber,
            @RequestParam(required = false) String provinceCode){

        try {
            List<SectionalErf> sectionalErfList = this.sectionalErfService.searchSectionalPortionByERF(minorRegion, erfNumber, portionNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(sectionalErfList)) ? ResponseEntity.status(HttpStatus.OK).body(sectionalErfList)
                    : ResponseEntity.status(HttpStatus.OK).body(sectionalErfList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm

*/



    @GetMapping("/searchSectionalPortionByERF")
    public ResponseEntity<?> searchParcelByERF(
            HttpServletRequest request,
            @RequestParam(required = false) String townShipName,
            @RequestParam(required = false) String erfNumber,
            @RequestParam(required = false) String portionNumber,
            @RequestParam(required = false) String provinceCode){

        try {
            List<SectionalErf> sectionalErfList = this.sectionalErfService.searchSectionalPortionByERF(townShipName, erfNumber, portionNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(sectionalErfList)) ? ResponseEntity.status(HttpStatus.OK).body(sectionalErfList)
                    : ResponseEntity.status(HttpStatus.OK).body(sectionalErfList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm


    @GetMapping("/getPortionTownShipName")
    public ResponseEntity<?> getPortionTownShipName(
            HttpServletRequest request,
            @RequestParam String provinceCode) {

        try {
            List<SectionalErf> farmList = this.sectionalErfService.getPortionTownShipName(provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//getPortionTownShipName





}
