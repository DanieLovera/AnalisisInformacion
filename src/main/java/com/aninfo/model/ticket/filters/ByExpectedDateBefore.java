package com.aninfo.model.ticket.filters;

import com.aninfo.model.ticket.Ticket;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;

public class ByExpectedDateBefore implements Specification<Ticket> {

    private Boolean outOfTime;

    public ByExpectedDateBefore(Boolean outOfTime) {
        this.outOfTime = outOfTime;
    }

    @Override
    public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        if (this.outOfTime == Boolean.TRUE) {
            return criteriaBuilder.lessThanOrEqualTo(root.get("expectedDate"), LocalDate.now());
        }
        return criteriaBuilder.isTrue(criteriaBuilder.literal(true));
    }
}
