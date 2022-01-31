package defpackage;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import defpackage.zg;

/* renamed from: vh  reason: default package */
/* compiled from: ReportFragment */
public class vh extends Fragment {
    public static final /* synthetic */ int g = 0;
    public a f;

    /* renamed from: vh$a */
    /* compiled from: ReportFragment */
    public interface a {
    }

    /* renamed from: vh$b */
    /* compiled from: ReportFragment */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            vh.a(activity, zg.a.ON_CREATE);
        }

        public void onActivityPostResumed(Activity activity) {
            vh.a(activity, zg.a.ON_RESUME);
        }

        public void onActivityPostStarted(Activity activity) {
            vh.a(activity, zg.a.ON_START);
        }

        public void onActivityPreDestroyed(Activity activity) {
            vh.a(activity, zg.a.ON_DESTROY);
        }

        public void onActivityPrePaused(Activity activity) {
            vh.a(activity, zg.a.ON_PAUSE);
        }

        public void onActivityPreStopped(Activity activity) {
            vh.a(activity, zg.a.ON_STOP);
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }
    }

    public static void a(Activity activity, zg.a aVar) {
        if (activity instanceof hh) {
            gh lifecycle = ((hh) activity).getLifecycle();
            lifecycle.d("handleLifecycleEvent");
            lifecycle.g(aVar.getTargetState());
        } else if (activity instanceof fh) {
            zg lifecycle2 = ((fh) activity).getLifecycle();
            if (lifecycle2 instanceof gh) {
                gh ghVar = (gh) lifecycle2;
                ghVar.d("handleLifecycleEvent");
                ghVar.g(aVar.getTargetState());
            }
        }
    }

    public static void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new vh(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void b(zg.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), aVar);
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        b(zg.a.ON_CREATE);
    }

    public void onDestroy() {
        super.onDestroy();
        b(zg.a.ON_DESTROY);
        this.f = null;
    }

    public void onPause() {
        super.onPause();
        b(zg.a.ON_PAUSE);
    }

    public void onResume() {
        super.onResume();
        a aVar = this.f;
        if (aVar != null) {
            th.this.a();
        }
        b(zg.a.ON_RESUME);
    }

    public void onStart() {
        super.onStart();
        a aVar = this.f;
        if (aVar != null) {
            th.this.b();
        }
        b(zg.a.ON_START);
    }

    public void onStop() {
        super.onStop();
        b(zg.a.ON_STOP);
    }
}
