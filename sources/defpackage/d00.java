package defpackage;

/* renamed from: d00  reason: default package */
/* compiled from: InvalidCustomNotificationException */
public class d00 extends Exception {
    public final lf1 f;
    public final String g;

    public d00(lf1 lf1, String str) {
        this.g = str;
        this.f = lf1;
    }

    public String getMessage() {
        StringBuilder i0 = hj1.i0("Invalid custom notification sent of type ");
        i0.append(this.f.name());
        i0.append("; error = ");
        i0.append(this.g);
        return i0.toString();
    }
}
