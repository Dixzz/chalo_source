package defpackage;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import defpackage.zg;

/* renamed from: uh  reason: default package */
/* compiled from: ProcessLifecycleOwner */
public class uh extends ug {
    public final /* synthetic */ th this$0;

    /* renamed from: uh$a */
    /* compiled from: ProcessLifecycleOwner */
    public class a extends ug {
        public a() {
        }

        public void onActivityPostResumed(Activity activity) {
            uh.this.this$0.a();
        }

        public void onActivityPostStarted(Activity activity) {
            uh.this.this$0.b();
        }
    }

    public uh(th thVar) {
        this.this$0 = thVar;
    }

    @Override // defpackage.ug
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (Build.VERSION.SDK_INT < 29) {
            int i = vh.g;
            ((vh) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag")).f = this.this$0.m;
        }
    }

    @Override // defpackage.ug
    public void onActivityPaused(Activity activity) {
        th thVar = this.this$0;
        int i = thVar.g - 1;
        thVar.g = i;
        if (i == 0) {
            thVar.j.postDelayed(thVar.l, 700);
        }
    }

    public void onActivityPreCreated(Activity activity, Bundle bundle) {
        activity.registerActivityLifecycleCallbacks(new a());
    }

    @Override // defpackage.ug
    public void onActivityStopped(Activity activity) {
        th thVar = this.this$0;
        int i = thVar.f - 1;
        thVar.f = i;
        if (i == 0 && thVar.h) {
            thVar.k.e(zg.a.ON_STOP);
            thVar.i = true;
        }
    }
}
