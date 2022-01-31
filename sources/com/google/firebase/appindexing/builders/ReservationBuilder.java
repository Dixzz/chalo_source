package com.google.firebase.appindexing.builders;

import java.util.Date;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-appindexing@@19.1.0 */
public final class ReservationBuilder extends IndexableBuilder<ReservationBuilder> {
    public ReservationBuilder() {
        super("Reservation");
    }

    public final ReservationBuilder setPartySize(long j) {
        return (ReservationBuilder) put("partySize", j);
    }

    public final ReservationBuilder setReservationFor(LocalBusinessBuilder localBusinessBuilder) {
        return (ReservationBuilder) put("reservationFor", localBusinessBuilder);
    }

    public final ReservationBuilder setStartDate(Date date) {
        Objects.requireNonNull(date, "null reference");
        return (ReservationBuilder) put("startDate", date.getTime());
    }
}
