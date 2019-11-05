package com.dw.ngms.cis.search.controller;

import com.dw.ngms.cis.search.entity.Deeds;
import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.service.DeedsService;
import com.dw.ngms.cis.search.service.ErfService;
import com.dw.ngms.cis.search.service.FarmService;
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
public class ERFController extends MessageController {

    @Autowired
    private ErfService erfService;

    @Autowired
    private FarmService farmService;





    @GetMapping("/searchParcelByERF")
    public ResponseEntity<?> searchParcelByERF(
            HttpServletRequest request,

            @RequestParam(required = false) String provinceCode,
            @RequestParam(required = false) String parcelType,
            @RequestParam(required = false) String townShipName,
            @RequestParam(required = false) String erfNumber,
            @RequestParam(required = false) String portionNumber){

        try {
            List<Erf> farmList = this.erfService.searchParcelByERF(provinceCode, parcelType, townShipName, erfNumber, portionNumber);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm


     @GetMapping("/searchParcelByHoldings")
    public ResponseEntity<?> searchParcelByHoldings(
            HttpServletRequest request,

            @RequestParam(required = false) String provinceCode,
            @RequestParam(required = false) String parcelType,
            @RequestParam(required = false) String townShipName,
            @RequestParam(required = false) String holdingNumber,
            @RequestParam(required = false) String portionNumber){

        try {
            List<Erf> farmList = this.erfService.searchParcelByHoldings(provinceCode, parcelType, townShipName, holdingNumber, portionNumber);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByHoldings




   /* @GetMapping("/searchParcelByHoldings")
    public ResponseEntity<?> searchParcelByHoldings(
            HttpServletRequest request,

            @RequestParam(required = false) String provinceCode,
            @RequestParam(required = false) String holdings,
            @RequestParam(required = false) String minorRegion,
            @RequestParam(required = false) String holdingNumber,
            @RequestParam(required = false) String portionNumber){

        try {
            List<Erf> farmList = this.erfService.searchParcelByHoldings(provinceCode, holdings, minorRegion, holdingNumber, portionNumber);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByHoldings

*/


    @GetMapping("/searchParcelByLPI")
    public ResponseEntity<?> searchParcelByLPI(
            HttpServletRequest request,

            @RequestParam(required = false) String provinceCode,
            @RequestParam(required = false) String lpiCode){

        try {
            List<Erf> erfList = this.erfService.searchParcelByLPI(provinceCode,lpiCode);

            if(erfList.size() >0){
                return ResponseEntity.status(HttpStatus.OK).body(erfList);
            }else{
                List<Farm> farmList = this.farmService.searchParcelByLPIFarm(provinceCode,lpiCode);
                return ResponseEntity.status(HttpStatus.OK).body(farmList);
            }
            /*return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);*/
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchParcelByFarm

//Province, LPI, LPI (enter text)



    @GetMapping("/getTownShipName")
    public ResponseEntity<?> getTownShipName(
            HttpServletRequest request,
            @RequestParam String provinceCode) {

        try {
            List<Erf> farmList = this.erfService.getTownShipName(provinceCode);
            return (org.springframework.util.CollectionUtils.isEmpty(farmList)) ? ResponseEntity.status(HttpStatus.OK).body(farmList)
                    : ResponseEntity.status(HttpStatus.OK).body(farmList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//searchBySurveySGNumberProvinceCode






}
