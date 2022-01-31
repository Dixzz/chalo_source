package defpackage;

import defpackage.n00;
import java.util.HashMap;

/* renamed from: z00  reason: default package */
/* compiled from: ChaloConfigFeature */
public class z00 implements n00.z0 {
    public z00(d10 d10) {
    }

    @Override // defpackage.n00.z0
    public void a(dk1 dk1) {
        xt.f3961a.i().put("chaloConfigFetchCallSuccessful", "false");
        HashMap hashMap = new HashMap();
        hashMap.put("event description", dk1.toString());
        hashMap.put("error type", "chaloConfig volley error occurred");
        hashMap.put("chaloConfig volley response error occurred at", String.valueOf(ui1.Q()));
        d10.m("chalo config normal fetch event etagVersion", hashMap);
    }
}
