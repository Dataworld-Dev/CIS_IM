package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.SectionalErf;
import com.dw.ngms.cis.search.entity.SectionalTitle;
import com.dw.ngms.cis.search.repository.SectionalErfRepository;
import com.dw.ngms.cis.search.repository.SectionalTitleRepository;
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
public class SectionalTitleService {

    @Autowired
    private SectionalTitleRepository sectionalTitleRepository;


    public List<SectionalTitle> searchSectionalPortionByTitle(String schemaNumber, String schemeName,String deedsRegistrationNumber,String sgNumber,String provinceCode) {
        return this.sectionalTitleRepository.findAll(new Specification<SectionalTitle>() {
            @Override
            public Predicate toPredicate(Root<SectionalTitle> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();

                if (schemaNumber != null && !StringUtils.isEmpty(schemaNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("schemaNumber"), schemaNumber)));
                }
                if (schemeName != null && !StringUtils.isEmpty(schemeName)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("schemeName"), schemeName)));
                }
                if (deedsRegistrationNumber != null && !StringUtils.isEmpty(deedsRegistrationNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("deedsRegistrationNumber"), deedsRegistrationNumber)));
                }
                if (sgNumber != null && !StringUtils.isEmpty(sgNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("sgNumber"), sgNumber)));
                }

                if (provinceCode != null && !StringUtils.isEmpty(provinceCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(criteriaBuilder.trim(root.get("provinceCode")), provinceCode.trim())));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchSectionalPortionByTitle


}
