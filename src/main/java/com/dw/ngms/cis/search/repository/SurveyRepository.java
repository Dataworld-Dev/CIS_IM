package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Sgno;
import com.dw.ngms.cis.search.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by swaroop on 2019/04/19.
 */
@Repository
public interface SurveyRepository extends JpaRepository<Survey, UUID> {


    @Query( value = "SELECT u.* FROM SURVEY u WHERE u.SURVEY_RECORD_NUMBER = :SURVEY_RECORD_NUMBER and u.prov_code = :prov_code", nativeQuery = true)
    List<Survey> searchBySurveySGNumberProvinceCode(@Param("SURVEY_RECORD_NUMBER") String SURVEY_RECORD_NUMBER, @Param("prov_code") String prov_code);


}
