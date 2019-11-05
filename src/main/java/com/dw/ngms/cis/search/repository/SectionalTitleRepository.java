package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.SectionalTitle;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */

    @Repository
    public interface SectionalTitleRepository extends JpaRepository<SectionalTitle, Long>,JpaSpecificationExecutor<SectionalTitle> {

    List<SectionalTitle> findAll(Specification<SectionalTitle> specification);

}
