package com.dw.ngms.cis.uam.controller;

import com.dw.ngms.cis.uam.dto.UserDTO;
import com.dw.ngms.cis.uam.entity.ExternalUser;
import com.dw.ngms.cis.uam.service.ExternalUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

import static org.springframework.util.StringUtils.isEmpty;

/**
 * Created by swaroop on 2019/03/28.
 */
@RestController
@RequestMapping("/cisorigin.uam/api/v1")
public class ExternalController extends MessageController {

    @Autowired
    private ExternalUserService externalUserService;

    @RequestMapping(value = "/updateSecurityQuestions", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSecurityQuestions(HttpServletRequest request, @RequestBody @Valid UserDTO userDTO) throws IOException {

        try {
            ExternalUser externalUser = this.externalUserService.findByUserCode(userDTO);
            if (isEmpty(externalUser)) {
                return generateEmptyResponse(request, "Users not found");
            }
            if (!isEmpty(externalUser)) {
                externalUser.setSecurityquestiontypecode1(userDTO.getQuestion().get(0).getCode());
                externalUser.setSecurityquestion1(userDTO.getQuestion().get(0).getQue());
                externalUser.setSecurityanswer1(userDTO.getQuestion().get(0).getAns());;
                externalUser.setSecurityquestiontypecode2(userDTO.getQuestion().get(1).getCode());
                externalUser.setSecurityquestion2(userDTO.getQuestion().get(1).getQue());
                externalUser.setSecurityanswer2(userDTO.getQuestion().get(1).getAns());
                externalUser.setSecurityquestiontypecode3(userDTO.getQuestion().get(2).getCode());
                externalUser.setSecurityquestion3(userDTO.getQuestion().get(2).getQue());
                externalUser.setSecurityanswer3(userDTO.getQuestion().get(2).getAns());
                System.out.println(" externalUser sec ans 3: " + externalUser.getSecurityanswer3());
                this.externalUserService.updateSecurityQuestions(externalUser);
            }
            return ResponseEntity.status(HttpStatus.OK).body("Security Questions updated successfully");
        } catch (Exception exception) {
            return generateFailureResponse(request, exception);
        }
    }

}