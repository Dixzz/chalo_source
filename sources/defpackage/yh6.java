package defpackage;

import defpackage.fi6;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* renamed from: yh6  reason: default package */
/* compiled from: FormBody.kt */
public final class yh6 extends mi6 {
    public static final fi6 c = fi6.a.a("application/x-www-form-urlencoded");

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f4048a;
    public final List<String> b;

    /* renamed from: yh6$a */
    /* compiled from: FormBody.kt */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f4049a = new ArrayList();
        public final List<String> b = new ArrayList();
        public final Charset c = null;
    }

    static {
        fi6.a aVar = fi6.f;
    }

    public yh6(List<String> list, List<String> list2) {
        n86.f(list, "encodedNames");
        n86.f(list2, "encodedValues");
        this.f4048a = vi6.y(list);
        this.b = vi6.y(list2);
    }

    public final long a(xm6 xm6, boolean z) {
        vm6 vm6;
        if (z) {
            vm6 = new vm6();
        } else if (xm6 != null) {
            vm6 = xm6.b();
        } else {
            n86.k();
            throw null;
        }
        int size = this.f4048a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                vm6.A(38);
            }
            vm6.P(this.f4048a.get(i));
            vm6.A(61);
            vm6.P(this.b.get(i));
        }
        if (!z) {
            return 0;
        }
        long j = vm6.g;
        vm6.d(j);
        return j;
    }

    @Override // defpackage.mi6
    public long contentLength() {
        return a(null, true);
    }

    @Override // defpackage.mi6
    public fi6 contentType() {
        return c;
    }

    @Override // defpackage.mi6
    public void writeTo(xm6 xm6) throws IOException {
        n86.f(xm6, "sink");
        a(xm6, false);
    }
}
