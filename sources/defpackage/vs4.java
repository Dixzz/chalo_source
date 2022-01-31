package defpackage;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/* renamed from: vs4  reason: default package */
public final /* synthetic */ class vs4 implements ct4 {

    /* renamed from: a  reason: collision with root package name */
    public final dt4 f3679a;
    public final String b;
    public final int c;
    public final long d;

    public vs4(dt4 dt4, String str, int i, long j) {
        this.f3679a = dt4;
        this.b = str;
        this.c = i;
        this.d = j;
    }

    @Override // defpackage.ct4
    public final Object a() {
        dt4 dt4 = this.f3679a;
        String str = this.b;
        int i = this.c;
        long j = this.d;
        Objects.requireNonNull(dt4);
        at4 at4 = (at4) ((Map) dt4.b(new xs4(dt4, Arrays.asList(str)))).get(str);
        if (at4 == null || mt4.e(at4.c.c)) {
            dt4.g.b(6, String.format("Could not find pack %s while trying to complete it", str), new Object[0]);
        }
        bs4 bs4 = dt4.f888a;
        if (bs4.e(str, i, j).exists()) {
            bs4.h(bs4.e(str, i, j));
        }
        at4.c.c = 4;
        return null;
    }
}
