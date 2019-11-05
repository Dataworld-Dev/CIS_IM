package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Deeds;
import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.Farm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by swaroop on 2019/04/19.
 */

    @Repository
    public interface ErfRepository extends JpaRepository<Erf, Long>,JpaSpecificationExecutor<Erf> {

    List<Erf> findAll(Specification<Erf> specification);

    @Query("SELECT DISTINCT(u.townShipName) FROM Erf u WHERE u.provCode = :provCode")
    List<Erf>  getTownShipName(@Param("provCode") String provCode);





}
