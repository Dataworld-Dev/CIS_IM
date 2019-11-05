package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Filling;
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
public interface FillingRepository extends JpaRepository<Filling, UUID> {


    @Query( value = "SELECT u.* FROM FILING u WHERE u.FILING_NO = :FILING_NO and u.prov_code = :prov_code", nativeQuery = true)
    List<Filling> searchByFillingCode(@Param("FILING_NO") String FILING_NO, @Param("prov_code") String prov_code);


}
