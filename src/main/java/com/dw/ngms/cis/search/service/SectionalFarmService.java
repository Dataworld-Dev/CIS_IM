package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.entity.SectionalFarm;
import com.dw.ngms.cis.search.repository.SectionalFarmRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by swaroop on 2019/04/19.
 */
@Service
public class SectionalFarmService {

    @Autowired
    private SectionalFarmRepository sectionalFarmRepository;




    public List<SectionalFarm> searchSectionalPortionByFarm(String registrationDivision,String  farmNumber,String  portionNumber,String  provinceCode) {
        return this.sectionalFarmRepository.findAll(new Specification<SectionalFarm>() {
            @Override
            public Predicate toPredicate(Root<SectionalFarm> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (registrationDivision != null && !StringUtils.isEmpty(registrationDivision)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("registrationDivision"), registrationDivision)));
                }
                if (farmNumber != null && !StringUtils.isEmpty(farmNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("farmNumber"), farmNumber)));
                }
                if (portionNumber != null && !StringUtils.isEmpty(portionNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("portionNumber"), portionNumber)));
                }

                if (provinceCode != null && !StringUtils.isEmpty(provinceCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provinceCode"), provinceCode)));
                }



                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchSectionalPortionByFarm



    public List<SectionalFarm>  getPortionRegistrationDivision(String provinceCode) {
        return this.sectionalFarmRepository.getPortionRegistrationDivision(provinceCode);
    }








}
