package defpackage;

import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* renamed from: qu1  reason: default package */
/* compiled from: AutoValue_LogRequest */
public final class qu1 extends wu1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f2991a;
    public final long b;
    public final uu1 c;
    public final Integer d;
    public final String e;
    public final List<vu1> f;
    public final zu1 g;

    public qu1(long j, long j2, uu1 uu1, Integer num, String str, List list, zu1 zu1, a aVar) {
        this.f2991a = j;
        this.b = j2;
        this.c = uu1;
        this.d = num;
        this.e = str;
        this.f = list;
        this.g = zu1;
    }

    @Override // defpackage.wu1
    public uu1 a() {
        return this.c;
    }

    @Override // defpackage.wu1
    @Encodable.Field(name = "logEvent")
    public List<vu1> b() {
        return this.f;
    }

    @Override // defpackage.wu1
    public Integer c() {
        return this.d;
    }

    @Override // defpackage.wu1
    public String d() {
        return this.e;
    }

    @Override // defpackage.wu1
    public zu1 e() {
        return this.g;
    }

    public boolean equals(Object obj) {
        uu1 uu1;
        Integer num;
        String str;
        List<vu1> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wu1)) {
            return false;
        }
        wu1 wu1 = (wu1) obj;
        if (this.f2991a == wu1.f() && this.b == wu1.g() && ((uu1 = this.c) != null ? uu1.equals(wu1.a()) : wu1.a() == null) && ((num = this.d) != null ? num.equals(wu1.c()) : wu1.c() == null) && ((str = this.e) != null ? str.equals(wu1.d()) : wu1.d() == null) && ((list = this.f) != null ? list.equals(wu1.b()) : wu1.b() == null)) {
            zu1 zu1 = this.g;
            if (zu1 == null) {
                if (wu1.e() == null) {
                    return true;
                }
            } else if (zu1.equals(wu1.e())) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.wu1
    public long f() {
        return this.f2991a;
    }

    @Override // defpackage.wu1
    public long g() {
        return this.b;
    }

    public int hashCode() {
        long j = this.f2991a;
        long j2 = this.b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003;
        uu1 uu1 = this.c;
        int i2 = 0;
        int hashCode = (i ^ (uu1 == null ? 0 : uu1.hashCode())) * 1000003;
        Integer num = this.d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<vu1> list = this.f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        zu1 zu1 = this.g;
        if (zu1 != null) {
            i2 = zu1.hashCode();
        }
        return hashCode4 ^ i2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("LogRequest{requestTimeMs=");
        i0.append(this.f2991a);
        i0.append(", requestUptimeMs=");
        i0.append(this.b);
        i0.append(", clientInfo=");
        i0.append(this.c);
        i0.append(", logSource=");
        i0.append(this.d);
        i0.append(", logSourceName=");
        i0.append(this.e);
        i0.append(", logEvents=");
        i0.append(this.f);
        i0.append(", qosTier=");
        i0.append(this.g);
        i0.append("}");
        return i0.toString();
    }
}
