package defpackage;

import defpackage.nc5;

/* renamed from: oc5  reason: default package */
/* compiled from: MixpanelAPI */
public class oc5 extends nc5.e {
    public final /* synthetic */ String b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public oc5(nc5.e eVar, String str) {
        super(null);
        this.b = str;
    }

    @Override // defpackage.nc5.e, defpackage.nc5.d
    public void a(String str) {
        throw new RuntimeException("This MixpanelPeople object has a fixed, constant distinctId");
    }

    @Override // defpackage.nc5.e
    public String c() {
        return this.b;
    }
}
