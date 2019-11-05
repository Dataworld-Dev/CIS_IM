package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Deeds;
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
public interface DeedsRepository extends JpaRepository<Deeds, UUID> {


    @Query( value = "SELECT u.* FROM DEED u WHERE u.DEEDNO = :DEEDNO and u.prov_code = :prov_code", nativeQuery = true)
    List<Deeds> searchByDeedsNumberProvinceCode(@Param("DEEDNO") String DEEDNO, @Param("prov_code") String prov_code);


}
