package com.aninfo.model.ticket.filters;

import com.aninfo.model.ticket.Ticket;
import com.aninfo.model.ticket.Type;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class ByType implements Specification<Ticket> {

    private Type type;

    public ByType(Type type) {
        this.type = type;
    }

    @Override
    public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (this.type != null) {
            return criteriaBuilder.equal(root.get("type"), this.type);
        }
        return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
}
