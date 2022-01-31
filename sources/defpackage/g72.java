package defpackage;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import defpackage.b32;

/* renamed from: g72  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public final class g72 implements b32.a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f1222a;
    public final /* synthetic */ f42 b;

    public g72(f42 f42, BasePendingResult basePendingResult) {
        this.b = f42;
        this.f1222a = basePendingResult;
    }

    @Override // defpackage.b32.a
    public final void a(Status status) {
        this.b.f1087a.remove(this.f1222a);
    }
}
