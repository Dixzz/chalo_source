package defpackage;

import defpackage.n00;
import java.util.HashMap;

/* renamed from: b10  reason: default package */
/* compiled from: ChaloConfigFeature */
public class b10 implements n00.z0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d10 f363a;

    public b10(d10 d10) {
        this.f363a = d10;
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        HashMap hashMap = new HashMap();
        hashMap.put("event description", dk1.toString());
        hashMap.put("error type", "chaloConfig volley error occurred");
        hashMap.put("chaloConfig volley response error occurred at", String.valueOf(ui1.Q()));
        d10.m("chalo config fetch and activate event etagVersion", hashMap);
        this.f363a.k(xt.f3961a.h().h.optString("chaloConfigLastUpdatedDate", null));
    }
}
