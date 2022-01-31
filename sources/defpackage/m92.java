package defpackage;

import android.content.Context;
import android.util.SparseIntArray;
import defpackage.x22;
import java.util.Objects;

/* renamed from: m92  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class m92 {

    /* renamed from: a  reason: collision with root package name */
    public final SparseIntArray f2341a = new SparseIntArray();
    public r22 b;

    public m92(r22 r22) {
        Objects.requireNonNull(r22, "null reference");
        this.b = r22;
    }

    public final int a(Context context, x22.f fVar) {
        Objects.requireNonNull(context, "null reference");
        Objects.requireNonNull(fVar, "null reference");
        int i = 0;
        if (!fVar.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = fVar.getMinApkVersion();
        int i2 = this.f2341a.get(minApkVersion, -1);
        if (i2 == -1) {
            int i3 = 0;
            while (true) {
                if (i3 >= this.f2341a.size()) {
                    i = -1;
                    break;
                }
                int keyAt = this.f2341a.keyAt(i3);
                if (keyAt > minApkVersion && this.f2341a.get(keyAt) == 0) {
                    break;
                }
                i3++;
            }
            i2 = i == -1 ? this.b.c(context, minApkVersion) : i;
            this.f2341a.put(minApkVersion, i2);
        }
        return i2;
    }
}
