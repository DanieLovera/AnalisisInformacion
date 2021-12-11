package com.aninfo.model;

import com.aninfo.model.ticket.Type;

public class TicketParams {

    private Boolean outOfTime;
    private Type type;

    public Boolean getOutOfTime() {
        return outOfTime;
    }

    public void setOutOfTime(Boolean outOfTime) {
        this.outOfTime = outOfTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
