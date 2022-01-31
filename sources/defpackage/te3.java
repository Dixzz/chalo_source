package defpackage;

import android.text.TextUtils;
import java.util.HashMap;

/* renamed from: te3  reason: default package */
public final class te3 extends iz1<te3> {

    /* renamed from: a  reason: collision with root package name */
    public String f3340a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(te3 te3) {
        te3 te32 = te3;
        int i = this.b;
        if (i != 0) {
            te32.b = i;
        }
        int i2 = this.c;
        if (i2 != 0) {
            te32.c = i2;
        }
        int i3 = this.d;
        if (i3 != 0) {
            te32.d = i3;
        }
        int i4 = this.e;
        if (i4 != 0) {
            te32.e = i4;
        }
        int i5 = this.f;
        if (i5 != 0) {
            te32.f = i5;
        }
        if (!TextUtils.isEmpty(this.f3340a)) {
            te32.f3340a = this.f3340a;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("language", this.f3340a);
        hashMap.put("screenColors", Integer.valueOf(this.b));
        hashMap.put("screenWidth", Integer.valueOf(this.c));
        hashMap.put("screenHeight", Integer.valueOf(this.d));
        hashMap.put("viewportWidth", Integer.valueOf(this.e));
        hashMap.put("viewportHeight", Integer.valueOf(this.f));
        return iz1.a(hashMap);
    }
}
