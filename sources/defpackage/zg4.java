package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;

/* renamed from: zg4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zg4 {

    /* renamed from: a  reason: collision with root package name */
    public final vb4 f4169a;

    public zg4(vb4 vb4) {
        this.f4169a = vb4;
    }

    public final void a(String str, Bundle bundle) {
        String str2;
        this.f4169a.f().b();
        if (!this.f4169a.d()) {
            if (bundle == null || bundle.isEmpty()) {
                str2 = null;
            } else {
                if (str == null || str.isEmpty()) {
                    str = "auto";
                }
                Uri.Builder builder = new Uri.Builder();
                builder.path(str);
                for (String str3 : bundle.keySet()) {
                    builder.appendQueryParameter(str3, bundle.getString(str3));
                }
                str2 = builder.build().toString();
            }
            if (!TextUtils.isEmpty(str2)) {
                this.f4169a.n().A.b(str2);
                ib4 ib4 = this.f4169a.n().B;
                Objects.requireNonNull((db2) this.f4169a.n);
                ib4.b(System.currentTimeMillis());
            }
        }
    }

    public final boolean b() {
        if (!c()) {
            return false;
        }
        Objects.requireNonNull((db2) this.f4169a.n);
        if (System.currentTimeMillis() - this.f4169a.n().B.a() > this.f4169a.g.k(null, q64.E0)) {
            return true;
        }
        return false;
    }

    public final boolean c() {
        return this.f4169a.n().B.a() > 0;
    }
}
