package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import com.mixpanel.android.R;
import com.mixpanel.android.mpmetrics.InAppNotification;
import com.mixpanel.android.mpmetrics.UpdateDisplayState;
import com.mixpanel.android.takeoverinapp.TakeoverInAppActivity;
import defpackage.nc5;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: pc5  reason: default package */
/* compiled from: MixpanelAPI */
public class pc5 implements Runnable {
    public final /* synthetic */ InAppNotification f;
    public final /* synthetic */ Activity g;
    public final /* synthetic */ nc5.e h;

    public pc5(nc5.e eVar, InAppNotification inAppNotification, Activity activity) {
        this.h = eVar;
        this.f = inAppNotification;
        this.g = activity;
    }

    @TargetApi(16)
    public void run() {
        int i;
        ReentrantLock reentrantLock = UpdateDisplayState.i;
        reentrantLock.lock();
        try {
            if (!UpdateDisplayState.b()) {
                InAppNotification inAppNotification = this.f;
                if (inAppNotification == null) {
                    inAppNotification = this.h.d();
                }
                if (inAppNotification == null) {
                    reentrantLock.unlock();
                    return;
                }
                InAppNotification.b b = inAppNotification.b();
                if (b != InAppNotification.b.TAKEOVER || cc5.b(this.g.getApplicationContext())) {
                    UpdateDisplayState.DisplayState.InAppNotificationState inAppNotificationState = new UpdateDisplayState.DisplayState.InAppNotificationState(inAppNotification, hd3.m1(this.g));
                    String c = this.h.c();
                    String str = nc5.this.d;
                    if (reentrantLock.isHeldByCurrentThread()) {
                        if (!UpdateDisplayState.b()) {
                            UpdateDisplayState.j = System.currentTimeMillis();
                            UpdateDisplayState.k = new UpdateDisplayState(inAppNotificationState, c, str);
                            i = UpdateDisplayState.l + 1;
                            UpdateDisplayState.l = i;
                        } else {
                            i = -1;
                        }
                        if (i <= 0) {
                            reentrantLock.unlock();
                            return;
                        }
                        int ordinal = b.ordinal();
                        if (ordinal == 1) {
                            UpdateDisplayState a2 = UpdateDisplayState.a(i);
                            if (a2 == null) {
                                reentrantLock.unlock();
                                return;
                            }
                            gc5 gc5 = new gc5();
                            gc5.f = nc5.this;
                            gc5.j = i;
                            gc5.k = (UpdateDisplayState.DisplayState.InAppNotificationState) a2.h;
                            gc5.setRetainInstance(true);
                            FragmentTransaction beginTransaction = this.g.getFragmentManager().beginTransaction();
                            beginTransaction.setCustomAnimations(0, R.animator.com_mixpanel_android_slide_down);
                            beginTransaction.add(16908290, gc5);
                            try {
                                beginTransaction.commit();
                            } catch (IllegalStateException unused) {
                                ec5 ec5 = nc5.this.j;
                                synchronized (ec5) {
                                    if (!jc5.E) {
                                        if (inAppNotification.c()) {
                                            ec5.e.add(inAppNotification);
                                        } else {
                                            ec5.d.add(inAppNotification);
                                        }
                                    }
                                }
                            }
                        } else if (ordinal != 2) {
                            String str2 = "Unrecognized notification type " + b + " can't be shown";
                        } else {
                            Intent intent = new Intent(this.g.getApplicationContext(), TakeoverInAppActivity.class);
                            intent.addFlags(268435456);
                            intent.addFlags(131072);
                            intent.putExtra("com.mixpanel.android.takeoverinapp.TakeoverInAppActivity.INTENT_ID_KEY", i);
                            this.g.startActivity(intent);
                        }
                        nc5.e eVar = this.h;
                        if (!nc5.this.c.f) {
                            eVar.l(inAppNotification);
                        }
                        reentrantLock.unlock();
                        return;
                    }
                    throw new AssertionError();
                }
                reentrantLock.unlock();
            }
        } finally {
            reentrantLock.unlock();
        }
    }
}
