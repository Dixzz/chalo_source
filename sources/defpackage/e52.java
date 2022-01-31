package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import defpackage.x22;

/* renamed from: e52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public interface e52 {
    void a();

    <A extends x22.b, T extends l32<? extends f32, A>> T b(T t);

    boolean c();

    void d();

    <A extends x22.b, R extends f32, T extends l32<R, A>> T e(T t);

    void f(Bundle bundle);

    void g(int i);

    void h(ConnectionResult connectionResult, x22<?> x22, boolean z);
}
