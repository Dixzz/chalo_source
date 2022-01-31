package defpackage;

import android.content.Context;
import com.urbanairship.UAirship;
import defpackage.hk5;
import java.util.concurrent.Executor;

/* renamed from: oj5  reason: default package */
/* compiled from: AirshipComponent */
public abstract class oj5 {

    /* renamed from: a  reason: collision with root package name */
    public final hk5 f2698a;
    public final String b;
    public final Context c;
    public final Executor d = pj5.a();

    /* renamed from: oj5$a */
    /* compiled from: AirshipComponent */
    public class a implements hk5.b {
        public a() {
        }

        @Override // defpackage.hk5.b
        public void a(String str) {
            if (str.equals(oj5.this.b)) {
                oj5 oj5 = oj5.this;
                oj5.e(oj5.c());
            }
        }
    }

    public oj5(Context context, hk5 hk5) {
        this.c = context.getApplicationContext();
        this.f2698a = hk5;
        StringBuilder i0 = hj1.i0("airshipComponent.enable_");
        i0.append(getClass().getName());
        this.b = i0.toString();
    }

    public int a() {
        return -1;
    }

    public void b() {
        hk5 hk5 = this.f2698a;
        a aVar = new a();
        synchronized (hk5.e) {
            hk5.e.add(aVar);
        }
    }

    public boolean c() {
        return this.f2698a.b(this.b, true);
    }

    public void d(UAirship uAirship) {
    }

    public void e(boolean z) {
    }

    public void f(zt5 zt5) {
    }

    public int g(UAirship uAirship, rt5 rt5) {
        return 0;
    }

    public void h() {
    }
}
