package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/* renamed from: xr1  reason: default package */
/* compiled from: RequestManagerRetriever */
public class xr1 implements Handler.Callback {
    public static final b f = new a();

    /* renamed from: a  reason: collision with root package name */
    public volatile nl1 f3957a;
    public final Map<FragmentManager, wr1> b = new HashMap();
    public final Map<androidx.fragment.app.FragmentManager, as1> c = new HashMap();
    public final Handler d;
    public final b e;

    /* renamed from: xr1$a */
    /* compiled from: RequestManagerRetriever */
    public static class a implements b {
    }

    /* renamed from: xr1$b */
    /* compiled from: RequestManagerRetriever */
    public interface b {
    }

    public xr1(b bVar) {
        new Bundle();
        this.e = bVar == null ? f : bVar;
        this.d = new Handler(Looper.getMainLooper(), this);
    }

    public final nl1 a(Context context, FragmentManager fragmentManager, Fragment fragment) {
        wr1 e2 = e(fragmentManager, fragment);
        nl1 nl1 = e2.i;
        if (nl1 != null) {
            return nl1;
        }
        gl1 b2 = gl1.b(context);
        b bVar = this.e;
        mr1 mr1 = e2.f;
        yr1 yr1 = e2.g;
        Objects.requireNonNull((a) bVar);
        nl1 nl12 = new nl1(b2, mr1, yr1);
        e2.i = nl12;
        return nl12;
    }

    public nl1 b(Activity activity) {
        if (rt1.g()) {
            return c(activity.getApplicationContext());
        }
        if (!activity.isDestroyed()) {
            return a(activity, activity.getFragmentManager(), null);
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public nl1 c(Context context) {
        if (context != null) {
            if (rt1.h() && !(context instanceof Application)) {
                if (context instanceof ve) {
                    return d((ve) context);
                }
                if (context instanceof Activity) {
                    return b((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    return c(((ContextWrapper) context).getBaseContext());
                }
            }
            if (this.f3957a == null) {
                synchronized (this) {
                    if (this.f3957a == null) {
                        gl1 b2 = gl1.b(context);
                        b bVar = this.e;
                        nr1 nr1 = new nr1();
                        sr1 sr1 = new sr1();
                        Objects.requireNonNull((a) bVar);
                        this.f3957a = new nl1(b2, nr1, sr1);
                    }
                }
            }
            return this.f3957a;
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public nl1 d(ve veVar) {
        if (rt1.g()) {
            return c(veVar.getApplicationContext());
        }
        if (!veVar.isDestroyed()) {
            as1 f2 = f(veVar.getSupportFragmentManager(), null);
            nl1 nl1 = f2.j;
            if (nl1 != null) {
                return nl1;
            }
            gl1 b2 = gl1.b(veVar);
            b bVar = this.e;
            mr1 mr1 = f2.f;
            yr1 yr1 = f2.g;
            Objects.requireNonNull((a) bVar);
            nl1 nl12 = new nl1(b2, mr1, yr1);
            f2.j = nl12;
            return nl12;
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    @TargetApi(17)
    public wr1 e(FragmentManager fragmentManager, Fragment fragment) {
        wr1 wr1 = (wr1) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (wr1 == null && (wr1 = this.b.get(fragmentManager)) == null) {
            wr1 = new wr1();
            wr1.k = fragment;
            if (!(fragment == null || fragment.getActivity() == null)) {
                wr1.a(fragment.getActivity());
            }
            this.b.put(fragmentManager, wr1);
            fragmentManager.beginTransaction().add(wr1, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.d.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return wr1;
    }

    public as1 f(androidx.fragment.app.FragmentManager fragmentManager, androidx.fragment.app.Fragment fragment) {
        as1 as1 = (as1) fragmentManager.I("com.bumptech.glide.manager");
        if (as1 == null && (as1 = this.c.get(fragmentManager)) == null) {
            as1 = new as1();
            as1.k = fragment;
            if (!(fragment == null || fragment.c() == null)) {
                as1.d(fragment.c());
            }
            this.c.put(fragmentManager, as1);
            ke keVar = new ke(fragmentManager);
            keVar.f(0, as1, "com.bumptech.glide.manager", 1);
            keVar.i();
            this.d.obtainMessage(2, fragmentManager).sendToTarget();
        }
        return as1;
    }

    public boolean handleMessage(Message message) {
        Object obj;
        Object obj2;
        Object obj3;
        int i = message.what;
        Object obj4 = null;
        boolean z = true;
        if (i == 1) {
            obj3 = (FragmentManager) message.obj;
            obj2 = this.b.remove(obj3);
        } else if (i != 2) {
            z = false;
            obj = null;
            if (z && obj4 == null && Log.isLoggable("RMRetriever", 5)) {
                String str = "Failed to remove expected request manager fragment, manager: " + obj;
            }
            return z;
        } else {
            obj3 = (androidx.fragment.app.FragmentManager) message.obj;
            obj2 = this.c.remove(obj3);
        }
        obj4 = obj2;
        obj = obj3;
        String str2 = "Failed to remove expected request manager fragment, manager: " + obj;
        return z;
    }
}
