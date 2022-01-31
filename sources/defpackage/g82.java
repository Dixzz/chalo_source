package defpackage;

import androidx.annotation.RecentlyNonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: g82  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class g82 {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f1224a = new ArrayList();
    public final Object b;

    public g82(Object obj) {
        Objects.requireNonNull(obj, "null reference");
        this.b = obj;
    }

    @RecentlyNonNull
    public g82 a(@RecentlyNonNull String str, Object obj) {
        List<String> list = this.f1224a;
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(str.length() + 1 + valueOf.length());
        sb.append(str);
        sb.append("=");
        sb.append(valueOf);
        list.add(sb.toString());
        return this;
    }

    @RecentlyNonNull
    public String toString() {
        StringBuilder sb = new StringBuilder(100);
        sb.append(this.b.getClass().getSimpleName());
        sb.append('{');
        int size = this.f1224a.size();
        for (int i = 0; i < size; i++) {
            sb.append(this.f1224a.get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
