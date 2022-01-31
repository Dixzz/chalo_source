package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.RecentlyNonNull;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public class LifecycleCallback {
    @RecentlyNonNull
    public final s32 f;

    public LifecycleCallback(@RecentlyNonNull s32 s32) {
        this.f = s32;
    }

    @RecentlyNonNull
    public static s32 c(@RecentlyNonNull r32 r32) {
        j72 j72;
        l72 l72;
        Object obj = r32.f3033a;
        if (obj instanceof ve) {
            ve veVar = (ve) obj;
            WeakHashMap<ve, WeakReference<l72>> weakHashMap = l72.i;
            WeakReference<l72> weakReference = weakHashMap.get(veVar);
            if (weakReference == null || (l72 = weakReference.get()) == null) {
                try {
                    l72 = (l72) veVar.getSupportFragmentManager().I("SupportLifecycleFragmentImpl");
                    if (l72 == null || l72.isRemoving()) {
                        l72 = new l72();
                        ke keVar = new ke(veVar.getSupportFragmentManager());
                        keVar.f(0, l72, "SupportLifecycleFragmentImpl", 1);
                        keVar.i();
                    }
                    weakHashMap.put(veVar, new WeakReference<>(l72));
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
                }
            }
            return l72;
        } else if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            WeakHashMap<Activity, WeakReference<j72>> weakHashMap2 = j72.i;
            WeakReference<j72> weakReference2 = weakHashMap2.get(activity);
            if (weakReference2 == null || (j72 = weakReference2.get()) == null) {
                try {
                    j72 = (j72) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                    if (j72 == null || j72.isRemoving()) {
                        j72 = new j72();
                        activity.getFragmentManager().beginTransaction().add(j72, "LifecycleFragmentImpl").commitAllowingStateLoss();
                    }
                    weakHashMap2.put(activity, new WeakReference<>(j72));
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
                }
            }
            return j72;
        } else {
            throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
        }
    }

    @Keep
    private static s32 getChimeraLifecycleFragmentImpl(r32 r32) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    public void a(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr) {
    }

    @RecentlyNonNull
    public Activity b() {
        return this.f.c();
    }

    public void d(int i, int i2, @RecentlyNonNull Intent intent) {
    }

    public void e(Bundle bundle) {
    }

    public void f() {
    }

    public void g(@RecentlyNonNull Bundle bundle) {
    }

    public void h() {
    }

    public void i() {
    }
}
