package defpackage;

import com.google.android.gms.common.ConnectionResult;
import defpackage.x22;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: y52  reason: default package */
/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
public interface y52 {
    void a();

    <A extends x22.b, T extends l32<? extends f32, A>> T b(T t);

    void c();

    void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends x22.b, R extends f32, T extends l32<R, A>> T e(T t);

    ConnectionResult f();

    boolean g(a42 a42);

    void h();

    boolean i();
}
