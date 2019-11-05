package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.entity.SectionalFarm;
import com.dw.ngms.cis.search.service.SectionalFarmService;
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
public class SectionalFarmController extends MessageController {

    @Autowired
    private SectionalFarmService sectionalFarmService;





   /* @GetMapping("/searchSectionalPortionByFarm")
    public ResponseEntity<?> searchParcelByERF(
            HttpServletRequest request,
            @RequestParam(required = false) String majorRegion,
            @RequestParam(required = false) String farmNumber,
            @RequestParam(required = false) String portionNumber,
            @RequestParam(required = false) String farmName,
            @RequestParam(required = false) String provinceCode){

        try {
            List<SectionalFarm> sectionalFarmList = this.sectionalFarmService.searchSectionalPortionByFarm(majorRegion, farmNumber, portionNumber,farmName,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(sectionalFarmList)) ? ResponseEntity.status(HttpStatus.OK).body(sectionalFarmList)
                    : ResponseEntity.status(HttpStatus.OK).body(sectionalFarmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm
*/


/*
    @GetMapping("/searchSectionalPortionByFarm")
    public ResponseEntity<?> searchParcelByERF(
            HttpServletRequest request,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String parcelType,
            @RequestParam(required = false) String registrationDivision,
            @RequestParam(required = false) String farmNumber,
            @RequestParam(required = false) String provCode){

        try {
            List<SectionalFarm> sectionalFarmList = this.sectionalFarmService.searchSectionalPortionByFarm(province, parcelType, registrationDivision,farmNumber,provCode);
            return (org.springframework.util.CollectionUtils.isEmpty(sectionalFarmList)) ? ResponseEntity.status(HttpStatus.OK).body(sectionalFarmList)
                    : ResponseEntity.status(HttpStatus.OK).body(sectionalFarmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm

*/


    @GetMapping("/searchSectionalPortionByFarm")
    public ResponseEntity<?> searchSectionalPortionByFarm(
            HttpServletRequest request,
            @RequestParam(required = false) String registrationDivision,
            @RequestParam(required = false) String farmNumber,
            @RequestParam(required = false) String portionNumber,
            @RequestParam(required = false) String provinceCode){

        try {
            List<SectionalFarm> sectionalFarmList = this.sectionalFarmService.searchSectionalPortionByFarm(registrationDivision, farmNumber, portionNumber,provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(sectionalFarmList)) ? ResponseEntity.status(HttpStatus.OK).body(sectionalFarmList)
                    : ResponseEntity.status(HttpStatus.OK).body(sectionalFarmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm



    @GetMapping("/getPortionRegistrationDivision")
    public ResponseEntity<?> getRegistrationDivision(
            HttpServletRequest request,
            @RequestParam String provinceCode) {

        try {
            List<SectionalFarm> farmList = this.sectionalFarmService.getPortionRegistrationDivision(provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchBySurveySGNumberProvinceCode




}
