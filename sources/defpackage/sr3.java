package defpackage;

import android.content.Context;
import javax.annotation.Nullable;

/* renamed from: sr3  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class sr3 extends qs3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3247a;
    public final ws3<us3<es3>> b;

    public sr3(Context context, @Nullable ws3<us3<es3>> ws3) {
        this.f3247a = context;
        this.b = ws3;
    }

    @Override // defpackage.qs3
    public final Context a() {
        return this.f3247a;
    }

    @Override // defpackage.qs3
    @Nullable
    public final ws3<us3<es3>> b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        ws3<us3<es3>> ws3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof qs3) {
            qs3 qs3 = (qs3) obj;
            return this.f3247a.equals(qs3.a()) && ((ws3 = this.b) != null ? ws3.equals(qs3.b()) : qs3.b() == null);
        }
    }

    public final int hashCode() {
        int hashCode = (this.f3247a.hashCode() ^ 1000003) * 1000003;
        ws3<us3<es3>> ws3 = this.b;
        return hashCode ^ (ws3 == null ? 0 : ws3.hashCode());
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f3247a);
        String valueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(valueOf2.length() + valueOf.length() + 46);
        sb.append("FlagsContext{context=");
        sb.append(valueOf);
        sb.append(", hermeticFileOverrides=");
        sb.append(valueOf2);
        sb.append("}");
        return sb.toString();
    }
}
