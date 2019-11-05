package com.dw.ngms.cis.search.repository;


import com.dw.ngms.cis.search.entity.Deeds;
import com.dw.ngms.cis.search.entity.Lease;
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
public interface LeaseRepository extends JpaRepository<Lease, UUID> {


    @Query( value = "SELECT u.* FROM LEASE u WHERE u.LEASENO = :LEASENO and u.prov_code = :prov_code", nativeQuery = true)
    List<Lease> searchByLeaseNumberProvinceCode(@Param("LEASENO") String LEASENO, @Param("prov_code") String prov_code);


}
