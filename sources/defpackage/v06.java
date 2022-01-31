package defpackage;

/* renamed from: v06  reason: default package */
/* compiled from: Priority */
public enum v06 {
    LOW,
    NORMAL,
    HIGH,
    IMMEDIATE;

    public static <Y> int compareTo(y06 y06, Y y) {
        v06 v06;
        if (y instanceof y06) {
            v06 = y.getPriority();
        } else {
            v06 = NORMAL;
        }
        return v06.ordinal() - y06.getPriority().ordinal();
    }
}
