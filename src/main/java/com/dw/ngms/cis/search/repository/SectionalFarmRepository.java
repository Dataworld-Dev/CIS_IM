package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.entity.SectionalErf;
import com.dw.ngms.cis.search.entity.SectionalFarm;
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
    public interface SectionalFarmRepository extends JpaRepository<SectionalFarm, Long>,JpaSpecificationExecutor<SectionalFarm> {

    List<SectionalFarm> findAll(Specification<SectionalFarm> specification);

    @Query("SELECT DISTINCT u.registrationDivision FROM SectionalFarm u WHERE u.provCode = :provCode order by u.registrationDivision")
    List<SectionalFarm>  getPortionRegistrationDivision(@Param("provCode") String provCode);



}
