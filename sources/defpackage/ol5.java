package defpackage;

import com.razorpay.AnalyticsConstants;
import defpackage.zt5;

/* renamed from: ol5  reason: default package */
/* compiled from: ScreenTrackingEvent */
public class ol5 extends ll5 {
    public final String h;
    public final long i;
    public final long j;
    public final String k;

    public ol5(String str, String str2, long j2, long j3) {
        this.h = str;
        this.i = j2;
        this.j = j3;
        this.k = str2;
    }

    @Override // defpackage.ll5
    public final zt5 d() {
        zt5.b s = zt5.s();
        s.f(AnalyticsConstants.SCREEN, this.h);
        s.f("entered_time", ll5.h(this.i));
        s.f("exited_time", ll5.h(this.j));
        s.f("duration", ll5.h(this.j - this.i));
        s.f("previous_screen", this.k);
        return s.a();
    }

    @Override // defpackage.ll5
    public String f() {
        return "screen_tracking";
    }

    @Override // defpackage.ll5
    public boolean g() {
        if (this.h.length() > 255 || this.h.length() <= 0) {
            yj5.c("Screen identifier string must be between 1 and 255 characters long.", new Object[0]);
            return false;
        } else if (this.i <= this.j) {
            return true;
        } else {
            yj5.c("Screen tracking duration must be positive or zero.", new Object[0]);
            return false;
        }
    }
}
