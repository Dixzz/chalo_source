package defpackage;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.perf.FirebasePerformance;
import defpackage.ci6;
import defpackage.di6;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: ji6  reason: default package */
/* compiled from: Request.kt */
public final class ji6 {

    /* renamed from: a  reason: collision with root package name */
    public hh6 f1930a;
    public final di6 b;
    public final String c;
    public final ci6 d;
    public final mi6 e;
    public final Map<Class<?>, Object> f;

    public ji6(di6 di6, String str, ci6 ci6, mi6 mi6, Map<Class<?>, ? extends Object> map) {
        n86.f(di6, "url");
        n86.f(str, "method");
        n86.f(ci6, "headers");
        n86.f(map, "tags");
        this.b = di6;
        this.c = str;
        this.d = ci6;
        this.e = mi6;
        this.f = map;
    }

    public final hh6 a() {
        hh6 hh6 = this.f1930a;
        if (hh6 != null) {
            return hh6;
        }
        hh6 b2 = hh6.o.b(this.d);
        this.f1930a = b2;
        return b2;
    }

    public final String b(String str) {
        n86.f(str, "name");
        return this.d.b(str);
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("Request{method=");
        i0.append(this.c);
        i0.append(", url=");
        i0.append(this.b);
        if (this.d.size() != 0) {
            i0.append(", headers=[");
            int i = 0;
            for (Object obj : this.d) {
                int i2 = i + 1;
                if (i >= 0) {
                    m56 m56 = (m56) obj;
                    A a2 = m56.f;
                    B b2 = m56.g;
                    if (i > 0) {
                        i0.append(", ");
                    }
                    hj1.U0(i0, a2, ':', b2);
                    i = i2;
                } else {
                    y56.w();
                    throw null;
                }
            }
            i0.append(']');
        }
        if (!this.f.isEmpty()) {
            i0.append(", tags=");
            i0.append(this.f);
        }
        i0.append('}');
        String sb = i0.toString();
        n86.b(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }

    /* renamed from: ji6$a */
    /* compiled from: Request.kt */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public di6 f1931a;
        public String b;
        public ci6.a c;
        public mi6 d;
        public Map<Class<?>, Object> e;

        public a() {
            this.e = new LinkedHashMap();
            this.b = FirebasePerformance.HttpMethod.GET;
            this.c = new ci6.a();
        }

        public a a(String str, String str2) {
            n86.f(str, "name");
            n86.f(str2, FirebaseAnalytics.Param.VALUE);
            this.c.a(str, str2);
            return this;
        }

        public ji6 b() {
            Map map;
            di6 di6 = this.f1931a;
            if (di6 != null) {
                String str = this.b;
                ci6 d2 = this.c.d();
                mi6 mi6 = this.d;
                Map<Class<?>, Object> map2 = this.e;
                byte[] bArr = vi6.f3652a;
                n86.f(map2, "$this$toImmutableMap");
                if (map2.isEmpty()) {
                    map = c66.f;
                } else {
                    map = Collections.unmodifiableMap(new LinkedHashMap(map2));
                    n86.b(map, "Collections.unmodifiableMap(LinkedHashMap(this))");
                }
                return new ji6(di6, str, d2, mi6, map);
            }
            throw new IllegalStateException("url == null".toString());
        }

        public a c(hh6 hh6) {
            n86.f(hh6, "cacheControl");
            String hh62 = hh6.toString();
            if (hh62.length() == 0) {
                g("Cache-Control");
            } else {
                d("Cache-Control", hh62);
            }
            return this;
        }

        public a d(String str, String str2) {
            n86.f(str, "name");
            n86.f(str2, FirebaseAnalytics.Param.VALUE);
            ci6.a aVar = this.c;
            Objects.requireNonNull(aVar);
            n86.f(str, "name");
            n86.f(str2, FirebaseAnalytics.Param.VALUE);
            ci6.b bVar = ci6.g;
            bVar.a(str);
            bVar.b(str2, str);
            aVar.f(str);
            aVar.c(str, str2);
            return this;
        }

        public a e(ci6 ci6) {
            n86.f(ci6, "headers");
            this.c = ci6.e();
            return this;
        }

        public a f(String str, mi6 mi6) {
            n86.f(str, "method");
            boolean z = false;
            if (str.length() > 0) {
                if (mi6 == null) {
                    n86.f(str, "method");
                    if (n86.a(str, FirebasePerformance.HttpMethod.POST) || n86.a(str, FirebasePerformance.HttpMethod.PUT) || n86.a(str, FirebasePerformance.HttpMethod.PATCH) || n86.a(str, "PROPPATCH") || n86.a(str, "REPORT")) {
                        z = true;
                    }
                    if (!(!z)) {
                        throw new IllegalArgumentException(hj1.T("method ", str, " must have a request body.").toString());
                    }
                } else if (!dk6.a(str)) {
                    throw new IllegalArgumentException(hj1.T("method ", str, " must not have a request body.").toString());
                }
                this.b = str;
                this.d = mi6;
                return this;
            }
            throw new IllegalArgumentException("method.isEmpty() == true".toString());
        }

        public a g(String str) {
            n86.f(str, "name");
            this.c.f(str);
            return this;
        }

        public <T> a h(Class<? super T> cls, T t) {
            n86.f(cls, "type");
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                Map<Class<?>, Object> map = this.e;
                Object cast = cls.cast(t);
                if (cast != null) {
                    map.put(cls, cast);
                } else {
                    n86.k();
                    throw null;
                }
            }
            return this;
        }

        public a i(String str) {
            n86.f(str, "url");
            if (ea6.D(str, "ws:", true)) {
                StringBuilder i0 = hj1.i0("http:");
                String substring = str.substring(3);
                n86.b(substring, "(this as java.lang.String).substring(startIndex)");
                i0.append(substring);
                str = i0.toString();
            } else if (ea6.D(str, "wss:", true)) {
                StringBuilder i02 = hj1.i0("https:");
                String substring2 = str.substring(4);
                n86.b(substring2, "(this as java.lang.String).substring(startIndex)");
                i02.append(substring2);
                str = i02.toString();
            }
            n86.f(str, "$this$toHttpUrl");
            di6.a aVar = new di6.a();
            aVar.f(null, str);
            j(aVar.c());
            return this;
        }

        public a j(di6 di6) {
            n86.f(di6, "url");
            this.f1931a = di6;
            return this;
        }

        public a(ji6 ji6) {
            Map<Class<?>, Object> map;
            n86.f(ji6, "request");
            this.e = new LinkedHashMap();
            this.f1931a = ji6.b;
            this.b = ji6.c;
            this.d = ji6.e;
            if (ji6.f.isEmpty()) {
                map = new LinkedHashMap<>();
            } else {
                map = y56.C(ji6.f);
            }
            this.e = map;
            this.c = ji6.d.e();
        }
    }
}
