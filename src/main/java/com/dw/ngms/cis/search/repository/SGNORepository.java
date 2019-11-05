package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Sgno;
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
public interface SGNORepository extends JpaRepository<Sgno, UUID> {


    @Query( value = "SELECT u.* FROM SGNO u WHERE u.sgNo = :sgNo and u.prov_code = :prov_code", nativeQuery = true)
    List<Sgno> searchByNumberProvinceCode(@Param("sgNo") String sgNo, @Param("prov_code") String prov_code);


}
