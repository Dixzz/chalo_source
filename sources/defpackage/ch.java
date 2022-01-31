package defpackage;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: ch  reason: default package */
/* compiled from: LifecycleDispatcher */
public class ch {

    /* renamed from: a  reason: collision with root package name */
    public static AtomicBoolean f564a = new AtomicBoolean(false);

    /* renamed from: ch$a */
    /* compiled from: LifecycleDispatcher */
    public static class a extends ug {
        @Override // defpackage.ug
        public void onActivityCreated(Activity activity, Bundle bundle) {
            vh.c(activity);
        }

        @Override // defpackage.ug
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // defpackage.ug
        public void onActivityStopped(Activity activity) {
        }
    }
}
