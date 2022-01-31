package defpackage;

import android.util.Base64;
import java.util.List;
import java.util.Objects;

/* renamed from: d7  reason: default package */
/* compiled from: FontRequest */
public final class d7 {

    /* renamed from: a  reason: collision with root package name */
    public final String f799a;
    public final String b;
    public final String c;
    public final List<List<byte[]>> d;
    public final String e;

    public d7(String str, String str2, String str3, List<List<byte[]>> list) {
        this.f799a = str;
        this.b = str2;
        this.c = str3;
        Objects.requireNonNull(list);
        this.d = list;
        this.e = str + "-" + str2 + "-" + str3;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder i0 = hj1.i0("FontRequest {mProviderAuthority: ");
        i0.append(this.f799a);
        i0.append(", mProviderPackage: ");
        i0.append(this.b);
        i0.append(", mQuery: ");
        i0.append(this.c);
        i0.append(", mCertificates:");
        sb.append(i0.toString());
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        return hj1.a0(sb, "}", "mCertificatesArray: 0");
    }
}
