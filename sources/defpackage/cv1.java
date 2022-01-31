package defpackage;

import defpackage.jv1;
import java.util.Arrays;
import java.util.Objects;

/* renamed from: cv1  reason: default package */
/* compiled from: AutoValue_TransportContext */
public final class cv1 extends jv1 {

    /* renamed from: a  reason: collision with root package name */
    public final String f756a;
    public final byte[] b;
    public final bu1 c;

    /* renamed from: cv1$b */
    /* compiled from: AutoValue_TransportContext */
    public static final class b extends jv1.a {

        /* renamed from: a  reason: collision with root package name */
        public String f757a;
        public byte[] b;
        public bu1 c;

        @Override // defpackage.jv1.a
        public jv1 a() {
            String str = this.f757a == null ? " backendName" : "";
            if (this.c == null) {
                str = hj1.S(str, " priority");
            }
            if (str.isEmpty()) {
                return new cv1(this.f757a, this.b, this.c, null);
            }
            throw new IllegalStateException(hj1.S("Missing required properties:", str));
        }

        @Override // defpackage.jv1.a
        public jv1.a b(String str) {
            Objects.requireNonNull(str, "Null backendName");
            this.f757a = str;
            return this;
        }

        @Override // defpackage.jv1.a
        public jv1.a c(bu1 bu1) {
            Objects.requireNonNull(bu1, "Null priority");
            this.c = bu1;
            return this;
        }
    }

    public cv1(String str, byte[] bArr, bu1 bu1, a aVar) {
        this.f756a = str;
        this.b = bArr;
        this.c = bu1;
    }

    @Override // defpackage.jv1
    public String b() {
        return this.f756a;
    }

    @Override // defpackage.jv1
    public byte[] c() {
        return this.b;
    }

    @Override // defpackage.jv1
    public bu1 d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jv1)) {
            return false;
        }
        jv1 jv1 = (jv1) obj;
        if (this.f756a.equals(jv1.b())) {
            if (!Arrays.equals(this.b, jv1 instanceof cv1 ? ((cv1) jv1).b : jv1.c()) || !this.c.equals(jv1.d())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((((this.f756a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b)) * 1000003) ^ this.c.hashCode();
    }
}
