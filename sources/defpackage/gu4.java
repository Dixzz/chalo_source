package defpackage;

import com.rabbitmq.client.ConnectionFactory;
import java.util.Arrays;

/* renamed from: gu4  reason: default package */
public final class gu4 {

    /* renamed from: a  reason: collision with root package name */
    public final String f1305a;
    public final long b;
    public final int c;
    public final boolean d;
    public final boolean e;
    public final byte[] f;

    public gu4() {
    }

    public gu4(String str, long j, int i, boolean z, boolean z2, byte[] bArr) {
        this.f1305a = str;
        this.b = j;
        this.c = i;
        this.d = z;
        this.e = z2;
        this.f = bArr;
    }

    public final boolean a() {
        String str = this.f1305a;
        if (str == null) {
            return false;
        }
        return str.endsWith(ConnectionFactory.DEFAULT_VHOST);
    }

    public final boolean b() {
        return this.c == 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof gu4) {
            gu4 gu4 = (gu4) obj;
            String str = this.f1305a;
            if (str != null ? str.equals(gu4.f1305a) : gu4.f1305a == null) {
                return this.b == gu4.b && this.c == gu4.c && this.d == gu4.d && this.e == gu4.e && Arrays.equals(this.f, gu4.f);
            }
        }
    }

    public int hashCode() {
        String str = this.f1305a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.b;
        int i = 1237;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.c) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003;
        if (true == this.e) {
            i = 1231;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f);
    }

    public String toString() {
        String str = this.f1305a;
        long j = this.b;
        int i = this.c;
        boolean z = this.d;
        boolean z2 = this.e;
        String arrays = Arrays.toString(this.f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        return hj1.b0(sb, ", headerBytes=", arrays, "}");
    }
}
