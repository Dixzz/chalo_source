package defpackage;

import app.zophop.engagement.airship.AirshipAutoPilot;
import java.util.Objects;

/* renamed from: yz  reason: default package */
/* compiled from: AirshipAutoPilot.kt */
public final class yz implements tv5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AirshipAutoPilot f4101a;

    public yz(AirshipAutoPilot airshipAutoPilot) {
        this.f4101a = airshipAutoPilot;
    }

    @Override // defpackage.tv5
    public void a(qv5 qv5) {
        n86.e(qv5, "notificationInfo");
        qv5.f2995a.c();
        Objects.requireNonNull(this.f4101a);
        ed1 ed1 = new ed1("airship notification posted", Long.MIN_VALUE);
        ed1.a("airship notification id", Integer.valueOf(qv5.b));
        ed1.a("airship notification tag", qv5.c);
        String d = qv5.f2995a.d("campaignId", new String());
        n86.d(d, "lNotificationInfo.messag…TE_CAMPAIGN_ID, String())");
        ed1.a("campaignId", d);
        ui1.m0(ed1);
    }

    @Override // defpackage.tv5
    public void b(qv5 qv5, pv5 pv5) {
        n86.e(qv5, "notificationInfo");
        n86.e(pv5, "actionButtonInfo");
    }

    @Override // defpackage.tv5
    public boolean c(qv5 qv5) {
        n86.e(qv5, "notificationInfo");
        qv5.f2995a.c();
        Objects.requireNonNull(this.f4101a);
        ed1 ed1 = new ed1("airship notification clicked", Long.MIN_VALUE);
        ed1.a("airship notification id", Integer.valueOf(qv5.b));
        ed1.a("airship notification tag", qv5.c);
        String d = qv5.f2995a.d("campaignId", new String());
        n86.d(d, "lNotificationInfo.messag…TE_CAMPAIGN_ID, String())");
        ed1.a("campaignId", d);
        ui1.m0(ed1);
        return false;
    }

    @Override // defpackage.tv5
    public void d(qv5 qv5) {
        n86.e(qv5, "notificationInfo");
        qv5.f2995a.c();
        Objects.requireNonNull(this.f4101a);
        ed1 ed1 = new ed1("airship notification dismissed", Long.MIN_VALUE);
        ed1.a("airship notification id", Integer.valueOf(qv5.b));
        ed1.a("airship notification tag", qv5.c);
        String d = qv5.f2995a.d("campaignId", new String());
        n86.d(d, "lNotificationInfo.messag…TE_CAMPAIGN_ID, String())");
        ed1.a("campaignId", d);
        ui1.m0(ed1);
    }

    @Override // defpackage.tv5
    public boolean e(qv5 qv5, pv5 pv5) {
        n86.e(qv5, "notificationInfo");
        n86.e(pv5, "actionButtonInfo");
        Objects.requireNonNull(this.f4101a);
        ed1 ed1 = new ed1("airship notification action btn clicked", Long.MIN_VALUE);
        ed1.a("airship notification id", Integer.valueOf(qv5.b));
        ed1.a("airship notification tag", qv5.c);
        ed1.a("airship notification btn id", pv5.f2860a);
        ed1.a("airship notification btn description", pv5.d);
        String d = qv5.f2995a.d("campaignId", new String());
        n86.d(d, "lNotificationInfo.messag…TE_CAMPAIGN_ID, String())");
        ed1.a("campaignId", d);
        ui1.m0(ed1);
        return false;
    }
}
