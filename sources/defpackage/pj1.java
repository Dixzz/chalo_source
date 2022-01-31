package defpackage;

import android.text.TextUtils;

/* renamed from: pj1  reason: default package */
/* compiled from: Header */
public final class pj1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2812a;
    public final String b;

    public pj1(String str, String str2) {
        this.f2812a = str;
        this.b = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || pj1.class != obj.getClass()) {
            return false;
        }
        pj1 pj1 = (pj1) obj;
        if (!TextUtils.equals(this.f2812a, pj1.f2812a) || !TextUtils.equals(this.b, pj1.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.b.hashCode() + (this.f2812a.hashCode() * 31);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Header[name=");
        i0.append(this.f2812a);
        i0.append(",value=");
        return hj1.a0(i0, this.b, "]");
    }
}
