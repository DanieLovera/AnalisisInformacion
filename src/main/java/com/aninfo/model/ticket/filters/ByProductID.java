package com.aninfo.model.ticket.filters;

import com.aninfo.model.ticket.Ticket;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByProductID implements Specification<Ticket> {

    private Long productID;

    public ByProductID(Long productID) {
        this.productID = productID;
    }

    @Override
    public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (this.productID != null) {
            return criteriaBuilder.equal(root.get("productID"), this.productID);
        }
        return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
}
