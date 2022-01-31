package defpackage;

import app.zophop.R;

/* renamed from: n61  reason: default package */
/* compiled from: InputFieldType */
public enum n61 {
    AGENCY,
    ROUTE,
    FROM,
    TO,
    TICKET_COUNT,
    NO_DAYS,
    PASSENGER_TYPE,
    PASS_TYPE,
    SPECAIL_FEAUTURE_MODE,
    TICKET_FARE_VIEW,
    START_DATE;

    public static int getHintResource(n61 n61) {
        switch (n61.ordinal()) {
            case 0:
                return R.string.agency;
            case 1:
                return R.string.route_number;
            case 2:
                return R.string.start_stop;
            case 3:
                return R.string.end_stop;
            case 4:
                return R.string.total_ticket;
            case 5:
                return R.string.number_of_days;
            case 6:
                return R.string.passenger_type;
            case 7:
                return R.string.pass_type;
            case 8:
            case 9:
                return R.string.fare;
            case 10:
                return R.string.start_date;
            default:
                return 0;
        }
    }
}
