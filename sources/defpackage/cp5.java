package defpackage;

import java.util.ArrayList;
import java.util.List;

/* renamed from: cp5  reason: default package */
/* compiled from: AudienceHistorian */
public class cp5 {

    /* renamed from: a  reason: collision with root package name */
    public final hy5 f742a;
    public final kp5 b;
    public final up5 c;
    public final List<a<jq5>> d = new ArrayList();
    public final List<a<qp5>> e = new ArrayList();

    /* renamed from: cp5$a */
    /* compiled from: AudienceHistorian */
    public static class a<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f743a;
        public final long b;
        public final T c;
        public final String d;

        public a(int i, String str, long j, T t) {
            this.f743a = i;
            this.b = j;
            this.d = str;
            this.c = t;
        }
    }

    public cp5(kp5 kp5, up5 up5, hy5 hy5) {
        this.b = kp5;
        this.c = up5;
        this.f742a = hy5;
    }

    public final <T> List<T> a(List<a<T>> list, long j) {
        ArrayList arrayList = new ArrayList();
        String j2 = this.c.j();
        for (a<T> aVar : list) {
            if (aVar.b >= j && (aVar.f743a == 0 || aVar.d.equals(j2))) {
                arrayList.add(aVar.c);
            }
        }
        return arrayList;
    }
}
