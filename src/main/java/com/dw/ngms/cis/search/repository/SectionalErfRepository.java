package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.SectionalErf;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */

    @Repository
    public interface SectionalErfRepository extends JpaRepository<SectionalErf, Long>,JpaSpecificationExecutor<SectionalErf> {

    List<SectionalErf> findAll(Specification<SectionalErf> specification);


    @Query("SELECT DISTINCT(u.townShipName) FROM SectionalErf u WHERE u.provCode = :provCode")
    List<SectionalErf>  getPortionTownShipName(@Param("provCode") String provCode);


}
