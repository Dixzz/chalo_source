package defpackage;

import defpackage.vu1;
import java.util.Arrays;

/* renamed from: pu1  reason: default package */
/* compiled from: AutoValue_LogEvent */
public final class pu1 extends vu1 {

    /* renamed from: a  reason: collision with root package name */
    public final long f2852a;
    public final Integer b;
    public final long c;
    public final byte[] d;
    public final String e;
    public final long f;
    public final yu1 g;

    /* renamed from: pu1$b */
    /* compiled from: AutoValue_LogEvent */
    public static final class b extends vu1.a {

        /* renamed from: a  reason: collision with root package name */
        public Long f2853a;
        public Integer b;
        public Long c;
        public byte[] d;
        public String e;
        public Long f;
        public yu1 g;
    }

    public pu1(long j, Integer num, long j2, byte[] bArr, String str, long j3, yu1 yu1, a aVar) {
        this.f2852a = j;
        this.b = num;
        this.c = j2;
        this.d = bArr;
        this.e = str;
        this.f = j3;
        this.g = yu1;
    }

    @Override // defpackage.vu1
    public Integer a() {
        return this.b;
    }

    @Override // defpackage.vu1
    public long b() {
        return this.f2852a;
    }

    @Override // defpackage.vu1
    public long c() {
        return this.c;
    }

    @Override // defpackage.vu1
    public yu1 d() {
        return this.g;
    }

    @Override // defpackage.vu1
    public byte[] e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof vu1)) {
            return false;
        }
        vu1 vu1 = (vu1) obj;
        if (this.f2852a == vu1.b() && ((num = this.b) != null ? num.equals(vu1.a()) : vu1.a() == null) && this.c == vu1.c()) {
            if (Arrays.equals(this.d, vu1 instanceof pu1 ? ((pu1) vu1).d : vu1.e()) && ((str = this.e) != null ? str.equals(vu1.f()) : vu1.f() == null) && this.f == vu1.g()) {
                yu1 yu1 = this.g;
                if (yu1 == null) {
                    if (vu1.d() == null) {
                        return true;
                    }
                } else if (yu1.equals(vu1.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // defpackage.vu1
    public String f() {
        return this.e;
    }

    @Override // defpackage.vu1
    public long g() {
        return this.f;
    }

    public int hashCode() {
        long j = this.f2852a;
        int i = (((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.b;
        int i2 = 0;
        int hashCode = num == null ? 0 : num.hashCode();
        long j2 = this.c;
        int hashCode2 = (((((i ^ hashCode) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.d)) * 1000003;
        String str = this.e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j3 = this.f;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        yu1 yu1 = this.g;
        if (yu1 != null) {
            i2 = yu1.hashCode();
        }
        return i3 ^ i2;
    }

    public String toString() {
        StringBuilder i0 = hj1.i0("LogEvent{eventTimeMs=");
        i0.append(this.f2852a);
        i0.append(", eventCode=");
        i0.append(this.b);
        i0.append(", eventUptimeMs=");
        i0.append(this.c);
        i0.append(", sourceExtension=");
        i0.append(Arrays.toString(this.d));
        i0.append(", sourceExtensionJsonProto3=");
        i0.append(this.e);
        i0.append(", timezoneOffsetSeconds=");
        i0.append(this.f);
        i0.append(", networkConnectionInfo=");
        i0.append(this.g);
        i0.append("}");
        return i0.toString();
    }
}
