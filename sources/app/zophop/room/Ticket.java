package app.zophop.room;

import app.zophop.models.mTicketing.MTicket;

public class Ticket {
    public MTicket mTicket;
    public String ticketId;

    public String getTicketId() {
        return this.ticketId;
    }

    public MTicket getmTicket() {
        return this.mTicket;
    }

    public void setTicketId(String str) {
        this.ticketId = str;
    }

    public void setmTicket(MTicket mTicket2) {
        this.mTicket = mTicket2;
    }
}
