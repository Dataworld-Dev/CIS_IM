package com.dw.ngms.cis.im.controller;

import com.dw.ngms.cis.im.entity.FormatTypes;
import com.dw.ngms.cis.im.entity.GazetteTypes;
import com.dw.ngms.cis.im.service.FormatTypeService;
import com.dw.ngms.cis.im.service.GazetteTypeService;
import com.dw.ngms.cis.uam.controller.MessageController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@RestController
@RequestMapping("/cisorigin.im/api/v1")
@CrossOrigin(origins = "*")
public class GazetteTypeController extends MessageController {

    @Autowired
    private GazetteTypeService gazetteTypeService;


    @PostMapping("/createGazzetteType")
    public ResponseEntity<?> createGazzetteType(HttpServletRequest request, @RequestBody @Valid GazetteTypes gazetteTypes) {
        try {
            Long gazetteTypeId = this.gazetteTypeService.getGazetteType();
            System.out.println("gazetteTypeId is "+gazetteTypeId);
            gazetteTypes.setGazetteTypeCode("GZT" + Long.toString(gazetteTypeId));
            GazetteTypes gazetteTypeSave = this.gazetteTypeService.saveGazetteType(gazetteTypes);
            return ResponseEntity.status(HttpStatus.OK).body(gazetteTypeSave);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//createCategory


    @GetMapping("/getGazzetteTypes")
    public ResponseEntity<?> getGazzetteTypes(HttpServletRequest request) {
        try {
            List<GazetteTypes> gazetteTypesList = gazetteTypeService.getAllGazetteTypes();
            return (CollectionUtils.isEmpty(gazetteTypesList)) ? generateEmptyResponse(request, "GazetteType(s) not found")
                    : ResponseEntity.status(HttpStatus.OK).body(gazetteTypesList);
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }//getFormatTypes



}
