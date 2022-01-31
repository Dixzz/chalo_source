package defpackage;

/* renamed from: xz  reason: default package */
/* compiled from: AirshipAutoPilot.kt */
public final class xz implements mp5 {
    @Override // defpackage.mp5
    public void a(String str) {
        n86.e(str, "channelId");
        n86.j("onAirshipChannelCreated: channelId = ", str);
        ed1 ed1 = new ed1("airship notification channel id created", Long.MIN_VALUE);
        ed1.a("airship channel id", str);
        ui1.m0(ed1);
    }

    @Override // defpackage.mp5
    public void b(String str) {
        n86.e(str, "channelId");
        n86.j("onAirshipChannelUpdated: channelId = ", str);
        ed1 ed1 = new ed1("airship notification channel id updated", Long.MIN_VALUE);
        ed1.a("airship channel id", str);
        ui1.m0(ed1);
    }
}
