package defpackage;

import android.annotation.SuppressLint;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import defpackage.km;
import defpackage.t4;
import defpackage.zg;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: ve  reason: default package */
/* compiled from: FragmentActivity */
public class ve extends ComponentActivity implements t4.b, t4.c {
    public static final String FRAGMENTS_TAG = "android:support:fragments";
    public boolean mCreated;
    public final gh mFragmentLifecycleRegistry = new gh(this);
    public final cf mFragments;
    public boolean mResumed;
    public boolean mStopped = true;

    /* renamed from: ve$a */
    /* compiled from: FragmentActivity */
    public class a implements km.b {
        public a() {
        }

        @Override // defpackage.km.b
        public Bundle a() {
            Bundle bundle = new Bundle();
            ve.this.markFragmentsCreated();
            ve.this.mFragmentLifecycleRegistry.e(zg.a.ON_STOP);
            Parcelable c0 = ve.this.mFragments.f559a.i.c0();
            if (c0 != null) {
                bundle.putParcelable(ve.FRAGMENTS_TAG, c0);
            }
            return bundle;
        }
    }

    /* renamed from: ve$b */
    /* compiled from: FragmentActivity */
    public class b implements p {
        public b() {
        }

        @Override // defpackage.p
        public void a(Context context) {
            ef<?> efVar = ve.this.mFragments.f559a;
            efVar.i.b(efVar, efVar, null);
            Bundle a2 = ve.this.getSavedStateRegistry().a(ve.FRAGMENTS_TAG);
            if (a2 != null) {
                Parcelable parcelable = a2.getParcelable(ve.FRAGMENTS_TAG);
                ef<?> efVar2 = ve.this.mFragments.f559a;
                if (efVar2 instanceof hi) {
                    efVar2.i.b0(parcelable);
                    return;
                }
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
        }
    }

    /* renamed from: ve$c */
    /* compiled from: FragmentActivity */
    public class c extends ef<ve> implements hi, n, s, jf {
        public c() {
            super(ve.this);
        }

        @Override // defpackage.jf
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            ve.this.onAttachFragment(fragment);
        }

        @Override // defpackage.bf
        public View b(int i) {
            return ve.this.findViewById(i);
        }

        @Override // defpackage.bf
        public boolean c() {
            Window window = ve.this.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        @Override // defpackage.ef
        public void d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            ve.this.dump(str, null, printWriter, strArr);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.ef
        public ve e() {
            return ve.this;
        }

        @Override // defpackage.ef
        public LayoutInflater f() {
            return ve.this.getLayoutInflater().cloneInContext(ve.this);
        }

        @Override // defpackage.ef
        public boolean g(Fragment fragment) {
            return !ve.this.isFinishing();
        }

        @Override // defpackage.s
        public ActivityResultRegistry getActivityResultRegistry() {
            return ve.this.getActivityResultRegistry();
        }

        @Override // defpackage.fh
        public zg getLifecycle() {
            return ve.this.mFragmentLifecycleRegistry;
        }

        @Override // defpackage.n
        public OnBackPressedDispatcher getOnBackPressedDispatcher() {
            return ve.this.getOnBackPressedDispatcher();
        }

        @Override // defpackage.hi
        public gi getViewModelStore() {
            return ve.this.getViewModelStore();
        }

        @Override // defpackage.ef
        public boolean h(String str) {
            return t4.d(ve.this, str);
        }

        @Override // defpackage.ef
        public void i() {
            ve.this.supportInvalidateOptionsMenu();
        }
    }

    public ve() {
        c cVar = new c();
        h.o(cVar, "callbacks == null");
        this.mFragments = new cf(cVar);
        init();
    }

    private void init() {
        getSavedStateRegistry().b(FRAGMENTS_TAG, new a());
        addOnContextAvailableListener(new b());
    }

    private static boolean markState(FragmentManager fragmentManager, zg.b bVar) {
        boolean z = false;
        for (Fragment fragment : fragmentManager.L()) {
            if (fragment != null) {
                if (fragment.getHost() != null) {
                    z |= markState(fragment.getChildFragmentManager(), bVar);
                }
                yf yfVar = fragment.mViewLifecycleOwner;
                if (yfVar != null) {
                    yfVar.b();
                    if (yfVar.g.c.isAtLeast(zg.b.STARTED)) {
                        gh ghVar = fragment.mViewLifecycleOwner.g;
                        ghVar.d("setCurrentState");
                        ghVar.g(bVar);
                        z = true;
                    }
                }
                if (fragment.mLifecycleRegistry.c.isAtLeast(zg.b.STARTED)) {
                    gh ghVar2 = fragment.mLifecycleRegistry;
                    ghVar2.d("setCurrentState");
                    ghVar2.g(bVar);
                    z = true;
                }
            }
        }
        return z;
    }

    public final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.f559a.i.f.onCreateView(view, str, context, attributeSet);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        printWriter.print(str);
        printWriter.print("Local FragmentActivity ");
        printWriter.print(Integer.toHexString(System.identityHashCode(this)));
        printWriter.println(" State:");
        String str2 = str + "  ";
        printWriter.print(str2);
        printWriter.print("mCreated=");
        printWriter.print(this.mCreated);
        printWriter.print(" mResumed=");
        printWriter.print(this.mResumed);
        printWriter.print(" mStopped=");
        printWriter.print(this.mStopped);
        if (getApplication() != null) {
            ii.b(this).a(str2, fileDescriptor, printWriter, strArr);
        }
        this.mFragments.f559a.i.y(str, fileDescriptor, printWriter, strArr);
    }

    public FragmentManager getSupportFragmentManager() {
        return this.mFragments.f559a.i;
    }

    @Deprecated
    public ii getSupportLoaderManager() {
        return ii.b(this);
    }

    public void markFragmentsCreated() {
        do {
        } while (markState(getSupportFragmentManager(), zg.b.CREATED));
    }

    @Override // androidx.activity.ComponentActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.a();
        super.onActivityResult(i, i2, intent);
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mFragments.a();
        super.onConfigurationChanged(configuration);
        this.mFragments.f559a.i.k(configuration);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.y4
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mFragmentLifecycleRegistry.e(zg.a.ON_CREATE);
        this.mFragments.f559a.i.m();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        boolean onCreatePanelMenu = super.onCreatePanelMenu(i, menu);
        cf cfVar = this.mFragments;
        return onCreatePanelMenu | cfVar.f559a.i.n(menu, getMenuInflater());
    }

    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(view, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(view, str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void onDestroy() {
        super.onDestroy();
        this.mFragments.f559a.i.o();
        this.mFragmentLifecycleRegistry.e(zg.a.ON_DESTROY);
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.f559a.i.p();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.mFragments.f559a.i.r(menuItem);
        }
        if (i != 6) {
            return false;
        }
        return this.mFragments.f559a.i.l(menuItem);
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.f559a.i.q(z);
    }

    public void onNewIntent(@SuppressLint({"UnknownNullness"}) Intent intent) {
        this.mFragments.a();
        super.onNewIntent(intent);
    }

    public void onPanelClosed(int i, Menu menu) {
        if (i == 0) {
            this.mFragments.f559a.i.s(menu);
        }
        super.onPanelClosed(i, menu);
    }

    public void onPause() {
        super.onPause();
        this.mResumed = false;
        this.mFragments.f559a.i.w(5);
        this.mFragmentLifecycleRegistry.e(zg.a.ON_PAUSE);
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.f559a.i.u(z);
    }

    public void onPostResume() {
        super.onPostResume();
        onResumeFragments();
    }

    @Deprecated
    public boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i == 0) {
            return onPrepareOptionsPanel(view, menu) | this.mFragments.f559a.i.v(menu);
        }
        return super.onPreparePanel(i, view, menu);
    }

    @Override // androidx.activity.ComponentActivity, defpackage.t4.b
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        this.mFragments.a();
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public void onResume() {
        this.mFragments.a();
        super.onResume();
        this.mResumed = true;
        this.mFragments.f559a.i.C(true);
    }

    public void onResumeFragments() {
        this.mFragmentLifecycleRegistry.e(zg.a.ON_RESUME);
        FragmentManager fragmentManager = this.mFragments.f559a.i;
        fragmentManager.B = false;
        fragmentManager.C = false;
        fragmentManager.J.h = false;
        fragmentManager.w(7);
    }

    public void onStart() {
        this.mFragments.a();
        super.onStart();
        this.mStopped = false;
        if (!this.mCreated) {
            this.mCreated = true;
            FragmentManager fragmentManager = this.mFragments.f559a.i;
            fragmentManager.B = false;
            fragmentManager.C = false;
            fragmentManager.J.h = false;
            fragmentManager.w(4);
        }
        this.mFragments.f559a.i.C(true);
        this.mFragmentLifecycleRegistry.e(zg.a.ON_START);
        FragmentManager fragmentManager2 = this.mFragments.f559a.i;
        fragmentManager2.B = false;
        fragmentManager2.C = false;
        fragmentManager2.J.h = false;
        fragmentManager2.w(5);
    }

    public void onStateNotSaved() {
        this.mFragments.a();
    }

    public void onStop() {
        super.onStop();
        this.mStopped = true;
        markFragmentsCreated();
        FragmentManager fragmentManager = this.mFragments.f559a.i;
        fragmentManager.C = true;
        fragmentManager.J.h = true;
        fragmentManager.w(4);
        this.mFragmentLifecycleRegistry.e(zg.a.ON_STOP);
    }

    public void setEnterSharedElementCallback(o5 o5Var) {
        int i = t4.c;
        setEnterSharedElementCallback((SharedElementCallback) null);
    }

    public void setExitSharedElementCallback(o5 o5Var) {
        int i = t4.c;
        setExitSharedElementCallback((SharedElementCallback) null);
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            int i2 = t4.c;
            startActivityForResult(intent, -1, bundle);
            return;
        }
        fragment.startActivityForResult(intent, i, bundle);
    }

    @Deprecated
    public void startIntentSenderFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (i == -1) {
            int i5 = t4.c;
            startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
            return;
        }
        fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void supportFinishAfterTransition() {
        int i = t4.c;
        finishAfterTransition();
    }

    @Deprecated
    public void supportInvalidateOptionsMenu() {
        invalidateOptionsMenu();
    }

    public void supportPostponeEnterTransition() {
        int i = t4.c;
        postponeEnterTransition();
    }

    public void supportStartPostponedEnterTransition() {
        int i = t4.c;
        startPostponedEnterTransition();
    }

    @Override // defpackage.t4.c
    @Deprecated
    public final void validateRequestPermissionsRequestCode(int i) {
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        View dispatchFragmentsOnCreateView = dispatchFragmentsOnCreateView(null, str, context, attributeSet);
        return dispatchFragmentsOnCreateView == null ? super.onCreateView(str, context, attributeSet) : dispatchFragmentsOnCreateView;
    }

    public void startActivityFromFragment(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i) {
        startActivityFromFragment(fragment, intent, i, null);
    }

    public ve(int i) {
        super(i);
        c cVar = new c();
        h.o(cVar, "callbacks == null");
        this.mFragments = new cf(cVar);
        init();
    }
}
