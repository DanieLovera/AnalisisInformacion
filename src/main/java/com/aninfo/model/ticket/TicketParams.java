package com.aninfo.model.ticket;

import com.aninfo.model.ticket.Type;

public class TicketParams {

    private boolean outOfTime;
    private Type type;

    public boolean getOutOfTime() {
        return outOfTime;
    }

    public void setOutOfTime(boolean outOfTime) {
        this.outOfTime = outOfTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
