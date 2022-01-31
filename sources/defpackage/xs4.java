package defpackage;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* renamed from: xs4  reason: default package */
public final /* synthetic */ class xs4 implements ct4 {

    /* renamed from: a  reason: collision with root package name */
    public final dt4 f3959a;
    public final List b;

    public xs4(dt4 dt4, List list) {
        this.f3959a = dt4;
        this.b = list;
    }

    @Override // defpackage.ct4
    public final Object a() {
        dt4 dt4 = this.f3959a;
        List list = this.b;
        Objects.requireNonNull(dt4);
        HashMap hashMap = new HashMap();
        for (at4 at4 : dt4.e.values()) {
            String str = at4.c.f4206a;
            if (list.contains(str)) {
                at4 at42 = (at4) hashMap.get(str);
                if ((at42 == null ? -1 : at42.f329a) < at4.f329a) {
                    hashMap.put(str, at4);
                }
            }
        }
        return hashMap;
    }
}
