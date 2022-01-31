package defpackage;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzae;
import java.util.Objects;

/* renamed from: zc4  reason: default package */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
public final class zc4 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f4156a;
    public String b;
    public String c;
    public String d;
    public Boolean e;
    public long f;
    public zzae g;
    public boolean h = true;
    public Long i;

    public zc4(Context context, zzae zzae, Long l) {
        Context applicationContext = context.getApplicationContext();
        Objects.requireNonNull(applicationContext, "null reference");
        this.f4156a = applicationContext;
        this.i = l;
        if (zzae != null) {
            this.g = zzae;
            this.b = zzae.k;
            this.c = zzae.j;
            this.d = zzae.i;
            this.h = zzae.h;
            this.f = zzae.g;
            Bundle bundle = zzae.l;
            if (bundle != null) {
                this.e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
