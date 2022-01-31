package defpackage;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;

/* renamed from: pe3  reason: default package */
public final class pe3 extends iz1<pe3> {

    /* renamed from: a  reason: collision with root package name */
    public String f2796a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(pe3 pe3) {
        pe3 pe32 = pe3;
        if (!TextUtils.isEmpty(this.f2796a)) {
            pe32.f2796a = this.f2796a;
        }
        if (!TextUtils.isEmpty(this.b)) {
            pe32.b = this.b;
        }
        if (!TextUtils.isEmpty(this.c)) {
            pe32.c = this.c;
        }
        if (!TextUtils.isEmpty(this.d)) {
            pe32.d = this.d;
        }
        if (!TextUtils.isEmpty(this.e)) {
            pe32.e = this.e;
        }
        if (!TextUtils.isEmpty(this.f)) {
            pe32.f = this.f;
        }
        if (!TextUtils.isEmpty(this.g)) {
            pe32.g = this.g;
        }
        if (!TextUtils.isEmpty(this.h)) {
            pe32.h = this.h;
        }
        if (!TextUtils.isEmpty(this.i)) {
            pe32.i = this.i;
        }
        if (!TextUtils.isEmpty(this.j)) {
            pe32.j = this.j;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("name", this.f2796a);
        hashMap.put("source", this.b);
        hashMap.put("medium", this.c);
        hashMap.put("keyword", this.d);
        hashMap.put("content", this.e);
        hashMap.put("id", this.f);
        hashMap.put("adNetworkId", this.g);
        hashMap.put("gclid", this.h);
        hashMap.put("dclid", this.i);
        hashMap.put(FirebaseAnalytics.Param.ACLID, this.j);
        return iz1.a(hashMap);
    }
}
