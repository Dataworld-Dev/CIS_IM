package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.entity.Survey;
import com.dw.ngms.cis.search.repository.FarmRepository;
import com.dw.ngms.cis.search.repository.SurveyRepository;
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
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;



    public List<Farm> searchParcelByFarm(String provinceCode,String  parcel,String  registrationDivision,String  farmNumber, String portionNumber) {
        return this.farmRepository.findAll(new Specification<Farm>() {
            @Override
            public Predicate toPredicate(Root<Farm> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (provinceCode != null && !StringUtils.isEmpty(provinceCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provinceCode"), provinceCode)));
                }
                if (parcel != null && !StringUtils.isEmpty(parcel)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("parcel"), parcel)));
                }
                if (registrationDivision != null && !StringUtils.isEmpty(registrationDivision)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("registrationDivision"), registrationDivision)));
                }
                if (farmNumber != null && !StringUtils.isEmpty(farmNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("farmNumber"), farmNumber)));
                }
                if (portionNumber != null && !StringUtils.isEmpty(portionNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("portionNumber"), portionNumber)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchParcelByFarm


    public List<Farm> searchParcelByLPIFarm(String provinceCode, String  lpi) {
        return this.farmRepository.findAll(new Specification<Farm>() {
            @Override
            public Predicate toPredicate(Root<Farm> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (provinceCode != null && !org.apache.commons.lang.StringUtils.isEmpty(provinceCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provinceCode"), provinceCode)));
                }
                if (lpi != null && !org.apache.commons.lang.StringUtils.isEmpty(lpi)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("lpi"), lpi)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchParcelByLPI



    public List<Farm>  getRegistrationDivision(String provinceCode) {
        return this.farmRepository.getRegistrationDivision(provinceCode);
    }







}
