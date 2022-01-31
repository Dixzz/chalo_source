package defpackage;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.UUID;

/* renamed from: ob3  reason: default package */
public final class ob3 extends iz1<ob3> {

    /* renamed from: a  reason: collision with root package name */
    public String f2674a;
    public int b;
    public int c;
    public String d;
    public String e;
    public boolean f;
    public boolean g;

    public ob3() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            leastSignificantBits = Integer.MAX_VALUE;
        }
        if (leastSignificantBits != 0) {
            this.b = leastSignificantBits;
            this.g = false;
            return;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(ob3 ob3) {
        ob3 ob32 = ob3;
        if (!TextUtils.isEmpty(this.f2674a)) {
            ob32.f2674a = this.f2674a;
        }
        int i = this.b;
        if (i != 0) {
            ob32.b = i;
        }
        int i2 = this.c;
        if (i2 != 0) {
            ob32.c = i2;
        }
        if (!TextUtils.isEmpty(this.d)) {
            ob32.d = this.d;
        }
        if (!TextUtils.isEmpty(this.e)) {
            String str = this.e;
            if (TextUtils.isEmpty(str)) {
                ob32.e = null;
            } else {
                ob32.e = str;
            }
        }
        boolean z = this.f;
        if (z) {
            ob32.f = z;
        }
        boolean z2 = this.g;
        if (z2) {
            ob32.g = z2;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.f2674a);
        hashMap.put("interstitial", Boolean.valueOf(this.f));
        hashMap.put("automatic", Boolean.valueOf(this.g));
        hashMap.put("screenId", Integer.valueOf(this.b));
        hashMap.put("referrerScreenId", Integer.valueOf(this.c));
        hashMap.put("referrerScreenName", this.d);
        hashMap.put("referrerUri", this.e);
        return iz1.a(hashMap);
    }
}
