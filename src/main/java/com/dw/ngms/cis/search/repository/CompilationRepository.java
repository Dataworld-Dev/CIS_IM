package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Compilation;
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
public interface CompilationRepository extends JpaRepository<Compilation, UUID> {


    @Query( value = "SELECT u.* FROM COMPILATION u WHERE u.COMPILATION_NUMBER = :COMPILATION_NUMBER and u.prov_code = :prov_code", nativeQuery = true)
    List<Compilation> searchByCompilationNumberProvinceCode(@Param("COMPILATION_NUMBER") String COMPILATION_NUMBER, @Param("prov_code") String prov_code);


    @Query( value = "SELECT u.* FROM COMPILATION u WHERE u.id = :id", nativeQuery = true)
    Compilation findByCompilationId(@Param("id") String id);



}
