package defpackage;

import android.os.Bundle;
import android.util.Log;

/* renamed from: e22  reason: default package */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
public abstract class e22<T> {

    /* renamed from: a  reason: collision with root package name */
    public final int f915a;
    public final zi4<T> b = new zi4<>();
    public final int c;
    public final Bundle d;

    public e22(int i, int i2, Bundle bundle) {
        this.f915a = i;
        this.c = i2;
        this.d = bundle;
    }

    public abstract void a(Bundle bundle);

    public final void b(d22 d22) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(d22);
            valueOf.length();
            valueOf2.length();
        }
        this.b.f4178a.u(d22);
    }

    public final void c(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(t);
            valueOf.length();
            valueOf2.length();
        }
        this.b.f4178a.t(t);
    }

    public abstract boolean d();

    public String toString() {
        int i = this.c;
        int i2 = this.f915a;
        boolean d2 = d();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        sb.append(d2);
        sb.append("}");
        return sb.toString();
    }
}
