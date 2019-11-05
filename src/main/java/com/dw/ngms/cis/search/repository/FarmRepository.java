package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.entity.Survey;
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
public interface FarmRepository extends JpaRepository<Farm, Long>,JpaSpecificationExecutor<Farm> {


    List<Farm> findAll(Specification<Farm> specification);

    @Query("SELECT DISTINCT u.registrationDivision FROM Farm u WHERE u.provinceCode = :provinceCode order by u.registrationDivision ")
    List<Farm>  getRegistrationDivision(@Param("provinceCode") String provinceCode);


}
