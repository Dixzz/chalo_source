package com.freshchat.consumer.sdk.f;

import android.app.Activity;
import android.app.Application;
import com.freshchat.consumer.sdk.e.f;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.cc;
import java.util.HashSet;
import java.util.Set;

public class c extends cc {
    private static c mR;
    private boolean mS;
    private Set<Integer> mT = new HashSet();
    private volatile boolean mU;

    private c(Application application) {
        application.registerActivityLifecycleCallbacks(this);
    }

    public static synchronized c a(Application application) {
        c cVar;
        synchronized (c.class) {
            if (mR == null) {
                synchronized (c.class) {
                    mR = new c(application);
                }
            }
            cVar = mR;
        }
        return cVar;
    }

    private void c(Activity activity) {
        boolean z = !this.mT.isEmpty() || activity.isChangingConfigurations();
        this.mS = z;
        if (z && this.mU) {
            f.bV(activity.getApplicationContext());
            this.mU = false;
        }
    }

    public boolean cE() {
        return this.mS;
    }

    public void m(boolean z) {
        ai.i("AppStateListener", " FreshchatInitApiDeferred called - is init Deferred : " + z);
        this.mU = z;
    }

    @Override // com.freshchat.consumer.sdk.j.cc
    public void onActivityStarted(Activity activity) {
        this.mT.add(Integer.valueOf(System.identityHashCode(activity)));
        c(activity);
        StringBuilder i0 = hj1.i0("onActivityStarted for activity : ");
        i0.append(activity.getLocalClassName());
        i0.append(" isForegound : ");
        i0.append(cE());
        ai.i("AppStateListener", i0.toString());
    }

    @Override // com.freshchat.consumer.sdk.j.cc
    public void onActivityStopped(Activity activity) {
        this.mT.remove(Integer.valueOf(System.identityHashCode(activity)));
        c(activity);
        StringBuilder i0 = hj1.i0("onActivityStopped for activity : ");
        i0.append(activity.getLocalClassName());
        i0.append(" isForegound : ");
        i0.append(cE());
        ai.i("AppStateListener", i0.toString());
    }
}
