package defpackage;

import java.util.Objects;

/* renamed from: lq5  reason: default package */
/* compiled from: AirshipUrlConfig */
public class lq5 {

    /* renamed from: a  reason: collision with root package name */
    public final String f2257a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    /* renamed from: lq5$b */
    /* compiled from: AirshipUrlConfig */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f2258a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
    }

    /* renamed from: lq5$c */
    /* compiled from: AirshipUrlConfig */
    public interface c {
        void a();
    }

    public lq5(b bVar, a aVar) {
        this.f2257a = bVar.f2258a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
        this.e = bVar.e;
        this.f = bVar.f;
    }

    public oq5 a() {
        return new oq5(this.f2257a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || lq5.class != obj.getClass()) {
            return false;
        }
        lq5 lq5 = (lq5) obj;
        if (!Objects.equals(this.b, lq5.b) || !Objects.equals(this.f2257a, lq5.f2257a) || !Objects.equals(this.d, lq5.d) || !Objects.equals(this.c, lq5.c) || !Objects.equals(this.e, lq5.e) || !Objects.equals(this.f, lq5.f)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hash(this.b, this.f2257a, this.d, this.c, this.e, this.f);
    }
}
