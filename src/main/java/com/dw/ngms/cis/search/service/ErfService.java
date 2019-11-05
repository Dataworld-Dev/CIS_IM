package com.dw.ngms.cis.search.service;

import com.dw.ngms.cis.search.entity.Erf;
import com.dw.ngms.cis.search.entity.Farm;
import com.dw.ngms.cis.search.repository.ErfRepository;
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
public class ErfService {

    @Autowired
    private ErfRepository erfRepository;




    public List<Erf> searchParcelByERF(String provCode, String  parcel, String townShipName, String  erfNumber, String portionNumber) {
        return this.erfRepository.findAll(new Specification<Erf>() {
            @Override
            public Predicate toPredicate(Root<Erf> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (provCode != null && !StringUtils.isEmpty(provCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provCode"), provCode)));
                }
                if (parcel != null && !StringUtils.isEmpty(parcel)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("parcel"), parcel)));
                }
                if (townShipName != null && !StringUtils.isEmpty(townShipName)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("townShipName"), townShipName)));
                }
                if (erfNumber != null && !StringUtils.isEmpty(erfNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("erfNumber"), erfNumber)));
                }
                if (portionNumber != null && !StringUtils.isEmpty(portionNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("portionNumber"), portionNumber)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchParcelByERF




    public List<Erf> searchParcelByHoldings(String provCode,String  parcel, String townShipName, String erfNumber, String portionNumber) {
        return this.erfRepository.findAll(new Specification<Erf>() {
            @Override
            public Predicate toPredicate(Root<Erf> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (provCode != null && !StringUtils.isEmpty(provCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provCode"), provCode)));
                }
                if (parcel != null && !StringUtils.isEmpty(parcel)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("parcel"), parcel)));
                }
                if (townShipName != null && !StringUtils.isEmpty(townShipName)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("townShipName"), townShipName)));
                }
                if (erfNumber != null && !StringUtils.isEmpty(erfNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("erfNumber"), erfNumber)));
                }
                if (portionNumber != null && !StringUtils.isEmpty(portionNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("portionNumber"), portionNumber)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchParcelByHoldings


   /* public List<Erf> searchParcelByHoldings(String provinceCode,String  holdings, String minorRegion, String parcel, String portionNumber) {
        return this.erfRepository.findAll(new Specification<Erf>() {
            @Override
            public Predicate toPredicate(Root<Erf> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (provinceCode != null && !StringUtils.isEmpty(provinceCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provinceCode"), provinceCode)));
                }
                if (holdings != null && !StringUtils.isEmpty(holdings)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("holdings"), holdings)));
                }
                if (minorRegion != null && !StringUtils.isEmpty(minorRegion)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("minorRegion"), minorRegion)));
                }
                if (parcel != null && !StringUtils.isEmpty(parcel)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("parcel"), parcel)));
                }
                if (portionNumber != null && !StringUtils.isEmpty(portionNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("portionNumber"), portionNumber)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchParcelByHoldings
*/

    public List<Erf> searchParcelByLPI(String provCode,String  lpi) {
        return this.erfRepository.findAll(new Specification<Erf>() {
            @Override
            public Predicate toPredicate(Root<Erf> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (provCode != null && !StringUtils.isEmpty(provCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("provCode"), provCode)));
                }
                if (lpi != null && !StringUtils.isEmpty(lpi)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("lpi"), lpi)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchParcelByLPI


    /*public List<Erf> searchParcelByLPI(String province,String  parcelType, String townShipName, String lpiCode, String portionNumber) {
        return this.erfRepository.findAll(new Specification<Erf>() {
            @Override
            public Predicate toPredicate(Root<Erf> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                if (province != null && !StringUtils.isEmpty(province)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("province"), province)));
                }
                if (parcelType != null && !StringUtils.isEmpty(parcelType)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("parcelType"), parcelType)));
                }
                if (townShipName != null && !StringUtils.isEmpty(townShipName)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("townShipName"), townShipName)));
                }
                if (lpiCode != null && !StringUtils.isEmpty(lpiCode)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("lpiCode"), lpiCode)));
                }
                if (portionNumber != null && !StringUtils.isEmpty(portionNumber)) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.equal(root.get("portionNumber"), portionNumber)));
                }

                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        });
    }//searchParcelByLPI
*/


    public List<Erf>  getTownShipName(String provCode) {
        return this.erfRepository.getTownShipName(provCode);
    }









}
