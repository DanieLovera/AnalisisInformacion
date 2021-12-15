package com.aninfo.model.ticket.filters;

import com.aninfo.model.ticket.Ticket;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByProductVersion implements Specification<Ticket> {

    private String productVersion;

    public ByProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    @Override
    public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (this.productVersion != null) {
            return criteriaBuilder.equal(root.get("productVersion"), this.productVersion);
        }
        return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
}
