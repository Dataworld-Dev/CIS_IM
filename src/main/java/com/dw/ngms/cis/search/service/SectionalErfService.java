package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.SectionalErf;
import com.dw.ngms.cis.search.repository.ErfRepository;
import com.dw.ngms.cis.search.repository.SectionalErfRepository;
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
public class SectionalErfService {

    @Autowired
    private SectionalErfRepository sectionalErfRepository;



    public List<SectionalErf> searchSectionalPortionByERF(String townShipName, String  erfNumber, String portionNumber,String provCode) {
        return this.sectionalErfRepository.findAll(new Specification<SectionalErf>() {
            @Override
            public Predicate toPredicate(Root<SectionalErf> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (townShipName != null && !StringUtils.isEmpty(townShipName)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("townShipName"), townShipName)));
                }
                if (erfNumber != null && !StringUtils.isEmpty(erfNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("erfNumber"), erfNumber)));
                }
                if (portionNumber != null && !StringUtils.isEmpty(portionNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("portionNumber"), portionNumber)));
                }
                if (provCode != null && !StringUtils.isEmpty(provCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provCode"), provCode)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchSectionalPortionByERF



    public List<SectionalErf>  getPortionTownShipName(String provCode) {
        return this.sectionalErfRepository.getPortionTownShipName(provCode);
    }









}
