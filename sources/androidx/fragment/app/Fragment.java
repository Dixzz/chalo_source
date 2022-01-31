package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.runtime.R;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import defpackage.ji;
import defpackage.q5;
import defpackage.zg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, fh, hi, mm {
    public static final int ACTIVITY_CREATED = 4;
    public static final int ATTACHED = 0;
    public static final int AWAITING_ENTER_EFFECTS = 6;
    public static final int AWAITING_EXIT_EFFECTS = 3;
    public static final int CREATED = 1;
    public static final int INITIALIZING = -1;
    public static final int RESUMED = 7;
    public static final int STARTED = 5;
    public static final Object USE_DEFAULT_TRANSITION = new Object();
    public static final int VIEW_CREATED = 2;
    public boolean mAdded;
    public i mAnimationInfo;
    public Bundle mArguments;
    public int mBackStackNesting;
    private boolean mCalled;
    public FragmentManager mChildFragmentManager;
    public ViewGroup mContainer;
    public int mContainerId;
    private int mContentLayoutId;
    public ci mDefaultFactory;
    public boolean mDeferStart;
    public boolean mDetached;
    public int mFragmentId;
    public FragmentManager mFragmentManager;
    public boolean mFromLayout;
    public boolean mHasMenu;
    public boolean mHidden;
    public boolean mHiddenChanged;
    public ef<?> mHost;
    public boolean mInLayout;
    public boolean mIsCreated;
    public boolean mIsNewlyAdded;
    private Boolean mIsPrimaryNavigationFragment;
    public LayoutInflater mLayoutInflater;
    public gh mLifecycleRegistry;
    public zg.b mMaxState;
    public boolean mMenuVisible;
    private final AtomicInteger mNextLocalRequestCode;
    private final ArrayList<k> mOnPreAttachedListeners;
    public Fragment mParentFragment;
    public boolean mPerformedCreateView;
    public float mPostponedAlpha;
    public Runnable mPostponedDurationRunnable;
    public boolean mRemoving;
    public boolean mRestored;
    public boolean mRetainInstance;
    public boolean mRetainInstanceChangedWhileDetached;
    public Bundle mSavedFragmentState;
    public lm mSavedStateRegistryController;
    public Boolean mSavedUserVisibleHint;
    public Bundle mSavedViewRegistryState;
    public SparseArray<Parcelable> mSavedViewState;
    public int mState;
    public String mTag;
    public Fragment mTarget;
    public int mTargetRequestCode;
    public String mTargetWho;
    public boolean mUserVisibleHint;
    public View mView;
    public yf mViewLifecycleOwner;
    public oh<fh> mViewLifecycleOwnerLiveData;
    public String mWho;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Fragment.this.callStartTransitionListener(false);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ bg f;

        public c(Fragment fragment, bg bgVar) {
            this.f = bgVar;
        }

        public void run() {
            this.f.c();
        }
    }

    public class d extends bf {
        public d() {
        }

        @Override // defpackage.bf
        public View b(int i) {
            View view = Fragment.this.mView;
            if (view != null) {
                return view.findViewById(i);
            }
            throw new IllegalStateException(hj1.Y(hj1.i0("Fragment "), Fragment.this, " does not have a view"));
        }

        @Override // defpackage.bf
        public boolean c() {
            return Fragment.this.mView != null;
        }
    }

    public class e implements h2<Void, ActivityResultRegistry> {
        public e() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.h2
        public ActivityResultRegistry apply(Void r3) {
            Fragment fragment = Fragment.this;
            ef<?> efVar = fragment.mHost;
            if (efVar instanceof s) {
                return ((s) efVar).getActivityResultRegistry();
            }
            return fragment.requireActivity().getActivityResultRegistry();
        }
    }

    public class f implements h2<Void, ActivityResultRegistry> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ActivityResultRegistry f210a;

        public f(Fragment fragment, ActivityResultRegistry activityResultRegistry) {
            this.f210a = activityResultRegistry;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.h2
        public ActivityResultRegistry apply(Void r1) {
            return this.f210a;
        }
    }

    public class g extends k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ h2 f211a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ t c;
        public final /* synthetic */ q d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(h2 h2Var, AtomicReference atomicReference, t tVar, q qVar) {
            super(null);
            this.f211a = h2Var;
            this.b = atomicReference;
            this.c = tVar;
            this.d = qVar;
        }

        @Override // androidx.fragment.app.Fragment.k
        public void a() {
            this.b.set(((ActivityResultRegistry) this.f211a.apply(null)).d(Fragment.this.generateActivityResultKey(), Fragment.this, this.c, this.d));
        }
    }

    public class h extends r<I> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AtomicReference f212a;

        public h(Fragment fragment, AtomicReference atomicReference, t tVar) {
            this.f212a = atomicReference;
        }

        @Override // defpackage.r
        public void a(I i, v4 v4Var) {
            r rVar = (r) this.f212a.get();
            if (rVar != null) {
                rVar.a(i, v4Var);
                return;
            }
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }

        @Override // defpackage.r
        public void b() {
            r rVar = (r) this.f212a.getAndSet(null);
            if (rVar != null) {
                rVar.b();
            }
        }
    }

    public static class i {

        /* renamed from: a  reason: collision with root package name */
        public View f213a;
        public Animator b;
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public ArrayList<String> i;
        public ArrayList<String> j;
        public Object k = null;
        public Object l;
        public Object m;
        public Object n;
        public Object o;
        public Object p;
        public Boolean q;
        public Boolean r;
        public float s;
        public View t;
        public boolean u;
        public l v;
        public boolean w;

        public i() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.l = obj;
            this.m = null;
            this.n = obj;
            this.o = null;
            this.p = obj;
            this.s = 1.0f;
            this.t = null;
        }
    }

    public static class j extends RuntimeException {
        public j(String str, Exception exc) {
            super(str, exc);
        }
    }

    public static abstract class k {
        public k() {
        }

        public abstract void a();

        public k(a aVar) {
        }
    }

    public interface l {
    }

    public Fragment() {
        this.mState = -1;
        this.mWho = UUID.randomUUID().toString();
        this.mTargetWho = null;
        this.mIsPrimaryNavigationFragment = null;
        this.mChildFragmentManager = new hf();
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mPostponedDurationRunnable = new a();
        this.mMaxState = zg.b.RESUMED;
        this.mViewLifecycleOwnerLiveData = new oh<>();
        this.mNextLocalRequestCode = new AtomicInteger();
        this.mOnPreAttachedListeners = new ArrayList<>();
        initLifecycle();
    }

    private i ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new i();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        zg.b bVar = this.mMaxState;
        if (bVar == zg.b.INITIALIZED || this.mParentFragment == null) {
            return bVar.ordinal();
        }
        return Math.min(bVar.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new gh(this);
        this.mSavedStateRegistryController = new lm(this);
        this.mDefaultFactory = null;
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    private <I, O> r<I> prepareCallInternal(t<I, O> tVar, h2<Void, ActivityResultRegistry> h2Var, q<O> qVar) {
        if (this.mState <= 1) {
            AtomicReference atomicReference = new AtomicReference();
            registerOnPreAttachListener(new g(h2Var, atomicReference, tVar, qVar));
            return new h(this, atomicReference, tVar);
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
    }

    private void registerOnPreAttachListener(k kVar) {
        if (this.mState >= 0) {
            kVar.a();
        } else {
            this.mOnPreAttachedListeners.add(kVar);
        }
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        i iVar = this.mAnimationInfo;
        Object obj = null;
        if (iVar != null) {
            iVar.u = false;
            Object obj2 = iVar.v;
            iVar.v = null;
            obj = obj2;
        }
        if (obj != null) {
            FragmentManager.n nVar = (FragmentManager.n) obj;
            int i2 = nVar.c - 1;
            nVar.c = i2;
            if (i2 == 0) {
                nVar.b.q.d0();
            }
        } else if (this.mView != null && (viewGroup = this.mContainer) != null && (fragmentManager = this.mFragmentManager) != null) {
            bg f2 = bg.f(viewGroup, fragmentManager);
            f2.h();
            if (z) {
                this.mHost.h.post(new c(this, f2));
            } else {
                f2.c();
            }
        }
    }

    public bf createFragmentContainer() {
        return new d();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            ii.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ProductDiscountsObject.KEY_DELIMITER);
        this.mChildFragmentManager.y(hj1.S(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Fragment findFragmentByWho(String str) {
        if (str.equals(this.mWho)) {
            return this;
        }
        return this.mChildFragmentManager.c.e(str);
    }

    public String generateActivityResultKey() {
        StringBuilder i0 = hj1.i0("fragment_");
        i0.append(this.mWho);
        i0.append("_rq#");
        i0.append(this.mNextLocalRequestCode.getAndIncrement());
        return i0.toString();
    }

    /* renamed from: getActivity */
    public final ve c() {
        ef<?> efVar = this.mHost;
        if (efVar == null) {
            return null;
        }
        return (ve) efVar.f;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.r) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (bool = iVar.q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.f213a;
    }

    public Animator getAnimator() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.b;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        ef<?> efVar = this.mHost;
        if (efVar == null) {
            return null;
        }
        return efVar.g;
    }

    public ci getDefaultViewModelProviderFactory() {
        if (this.mFragmentManager != null) {
            if (this.mDefaultFactory == null) {
                Application application = null;
                Context applicationContext = requireContext().getApplicationContext();
                while (true) {
                    if (!(applicationContext instanceof ContextWrapper)) {
                        break;
                    } else if (applicationContext instanceof Application) {
                        application = (Application) applicationContext;
                        break;
                    } else {
                        applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                    }
                }
                if (application == null && FragmentManager.O(3)) {
                    StringBuilder i0 = hj1.i0("Could not find Application instance from Context ");
                    i0.append(requireContext().getApplicationContext());
                    i0.append(", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
                    i0.toString();
                }
                this.mDefaultFactory = new xh(application, this, getArguments());
            }
            return this.mDefaultFactory;
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public int getEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.d;
    }

    public Object getEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.k;
    }

    public o5 getEnterTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Objects.requireNonNull(iVar);
        return null;
    }

    public int getExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.e;
    }

    public Object getExitTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.m;
    }

    public o5 getExitTransitionCallback() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Objects.requireNonNull(iVar);
        return null;
    }

    public View getFocusedView() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.t;
    }

    @Deprecated
    public final FragmentManager getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        ef<?> efVar = this.mHost;
        if (efVar == null) {
            return null;
        }
        return efVar.e();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // defpackage.fh
    public zg getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public ii getLoaderManager() {
        return ii.b(this);
    }

    public int getNextTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.h;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.c;
    }

    public int getPopEnterAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.f;
    }

    public int getPopExitAnim() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 0;
        }
        return iVar.g;
    }

    public float getPostOnViewCreatedAlpha() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return 1.0f;
        }
        return iVar.s;
    }

    public Object getReenterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.n;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.l;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // defpackage.mm
    public final km getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b;
    }

    public Object getSharedElementEnterTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        return iVar.o;
    }

    public Object getSharedElementReturnTransition() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return null;
        }
        Object obj = iVar.p;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (arrayList = iVar.i) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        i iVar = this.mAnimationInfo;
        if (iVar == null || (arrayList = iVar.j) == null) {
            return new ArrayList<>();
        }
        return arrayList;
    }

    public final String getString(int i2) {
        return getResources().getString(i2);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final Fragment getTargetFragment() {
        String str;
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.G(str);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i2) {
        return getResources().getText(i2);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public fh getViewLifecycleOwner() {
        yf yfVar = this.mViewLifecycleOwner;
        if (yfVar != null) {
            return yfVar;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public LiveData<fh> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // defpackage.hi
    public gi getViewModelStore() {
        if (this.mFragmentManager != null) {
            int minimumMaxLifecycleState = getMinimumMaxLifecycleState();
            zg.b bVar = zg.b.INITIALIZED;
            if (minimumMaxLifecycleState != 1) {
                Cif ifVar = this.mFragmentManager.J;
                gi giVar = ifVar.e.get(this.mWho);
                if (giVar != null) {
                    return giVar;
                }
                gi giVar2 = new gi();
                ifVar.e.put(this.mWho, giVar2);
                return giVar2;
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    @SuppressLint({"KotlinPropertyAccess"})
    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        initLifecycle();
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new hf();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    public boolean isHideReplaced() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.w;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        return this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.Q(this.mParentFragment));
    }

    public boolean isPostponed() {
        i iVar = this.mAnimationInfo;
        if (iVar == null) {
            return false;
        }
        return iVar.u;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isRemovingParent() {
        Fragment parentFragment = getParentFragment();
        return parentFragment != null && (parentFragment.isRemoving() || parentFragment.isRemovingParent());
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.S();
    }

    public final boolean isVisible() {
        View view;
        return isAdded() && !isHidden() && (view = this.mView) != null && view.getWindowToken() != null && this.mView.getVisibility() == 0;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.V();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (FragmentManager.O(2)) {
            String str = "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i2 + " resultCode: " + i3 + " data: " + intent;
        }
    }

    public void onAttach(Context context) {
        Activity activity;
        this.mCalled = true;
        ef<?> efVar = this.mHost;
        if (efVar == null) {
            activity = null;
        } else {
            activity = efVar.f;
        }
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        boolean z = true;
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        FragmentManager fragmentManager = this.mChildFragmentManager;
        if (fragmentManager.p < 1) {
            z = false;
        }
        if (!z) {
            fragmentManager.m();
        }
    }

    public Animation onCreateAnimation(int i2, boolean z, int i3) {
        return null;
    }

    public Animator onCreateAnimator(int i2, boolean z, int i3) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2 = this.mContentLayoutId;
        if (i2 != 0) {
            return layoutInflater.inflate(i2, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        Activity activity;
        this.mCalled = true;
        ef<?> efVar = this.mHost;
        if (efVar == null) {
            activity = null;
        } else {
            activity = efVar.f;
        }
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.V();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            restoreViewState();
            FragmentManager fragmentManager = this.mChildFragmentManager;
            fragmentManager.B = false;
            fragmentManager.C = false;
            fragmentManager.J.h = false;
            fragmentManager.w(4);
            return;
        }
        throw new dg(hj1.O("Fragment ", this, " did not call through to super.onActivityCreated()"));
    }

    public void performAttach() {
        Iterator<k> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.g);
        if (this.mCalled) {
            FragmentManager fragmentManager = this.mFragmentManager;
            Iterator<jf> it2 = fragmentManager.o.iterator();
            while (it2.hasNext()) {
                it2.next().a(fragmentManager, this);
            }
            FragmentManager fragmentManager2 = this.mChildFragmentManager;
            fragmentManager2.B = false;
            fragmentManager2.C = false;
            fragmentManager2.J.h = false;
            fragmentManager2.w(0);
            return;
        }
        throw new dg(hj1.O("Fragment ", this, " did not call through to super.onAttach()"));
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        this.mChildFragmentManager.k(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.l(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.V();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new dh() {
            /* class androidx.fragment.app.Fragment.AnonymousClass5 */

            @Override // defpackage.dh
            public void c(fh fhVar, zg.a aVar) {
                View view;
                if (aVar == zg.a.ON_STOP && (view = Fragment.this.mView) != null) {
                    view.cancelPendingInputEvents();
                }
            }
        });
        this.mSavedStateRegistryController.a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.e(zg.a.ON_CREATE);
            return;
        }
        throw new dg(hj1.O("Fragment ", this, " did not call through to super.onCreate()"));
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return z | this.mChildFragmentManager.n(menu, menuInflater);
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.V();
        boolean z = true;
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new yf(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView != null) {
            this.mViewLifecycleOwner.b();
            this.mView.setTag(R.id.view_tree_lifecycle_owner, this.mViewLifecycleOwner);
            this.mView.setTag(androidx.lifecycle.viewmodel.R.id.view_tree_view_model_store_owner, this.mViewLifecycleOwner);
            this.mView.setTag(androidx.savedstate.R.id.view_tree_saved_state_registry_owner, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.l(this.mViewLifecycleOwner);
            return;
        }
        if (this.mViewLifecycleOwner.g == null) {
            z = false;
        }
        if (!z) {
            this.mViewLifecycleOwner = null;
            return;
        }
        throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
    }

    public void performDestroy() {
        this.mChildFragmentManager.o();
        this.mLifecycleRegistry.e(zg.a.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new dg(hj1.O("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.w(1);
        if (this.mView != null) {
            yf yfVar = this.mViewLifecycleOwner;
            yfVar.b();
            if (yfVar.g.c.isAtLeast(zg.b.CREATED)) {
                this.mViewLifecycleOwner.a(zg.a.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            ji.c cVar = ((ji) ii.b(this)).b;
            int h2 = cVar.c.h();
            for (int i2 = 0; i2 < h2; i2++) {
                cVar.c.i(i2).n();
            }
            this.mPerformedCreateView = false;
            return;
        }
        throw new dg(hj1.O("Fragment ", this, " did not call through to super.onDestroyView()"));
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            FragmentManager fragmentManager = this.mChildFragmentManager;
            if (!fragmentManager.D) {
                fragmentManager.o();
                this.mChildFragmentManager = new hf();
                return;
            }
            return;
        }
        throw new dg(hj1.O("Fragment ", this, " did not call through to super.onDetach()"));
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
        this.mChildFragmentManager.p();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        this.mChildFragmentManager.q(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (!this.mHasMenu || !this.mMenuVisible || !onOptionsItemSelected(menuItem)) {
            return this.mChildFragmentManager.r(menuItem);
        }
        return true;
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            this.mChildFragmentManager.s(menu);
        }
    }

    public void performPause() {
        this.mChildFragmentManager.w(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(zg.a.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(zg.a.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new dg(hj1.O("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        this.mChildFragmentManager.u(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return z | this.mChildFragmentManager.v(menu);
    }

    public void performPrimaryNavigationFragmentChanged() {
        boolean R = this.mFragmentManager.R(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != R) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(R);
            onPrimaryNavigationFragmentChanged(R);
            FragmentManager fragmentManager = this.mChildFragmentManager;
            fragmentManager.l0();
            fragmentManager.t(fragmentManager.t);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.V();
        this.mChildFragmentManager.C(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (this.mCalled) {
            gh ghVar = this.mLifecycleRegistry;
            zg.a aVar = zg.a.ON_RESUME;
            ghVar.e(aVar);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(aVar);
            }
            FragmentManager fragmentManager = this.mChildFragmentManager;
            fragmentManager.B = false;
            fragmentManager.C = false;
            fragmentManager.J.h = false;
            fragmentManager.w(7);
            return;
        }
        throw new dg(hj1.O("Fragment ", this, " did not call through to super.onResume()"));
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        Parcelable c0 = this.mChildFragmentManager.c0();
        if (c0 != null) {
            bundle.putParcelable(ve.FRAGMENTS_TAG, c0);
        }
    }

    public void performStart() {
        this.mChildFragmentManager.V();
        this.mChildFragmentManager.C(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            gh ghVar = this.mLifecycleRegistry;
            zg.a aVar = zg.a.ON_START;
            ghVar.e(aVar);
            if (this.mView != null) {
                this.mViewLifecycleOwner.a(aVar);
            }
            FragmentManager fragmentManager = this.mChildFragmentManager;
            fragmentManager.B = false;
            fragmentManager.C = false;
            fragmentManager.J.h = false;
            fragmentManager.w(5);
            return;
        }
        throw new dg(hj1.O("Fragment ", this, " did not call through to super.onStart()"));
    }

    public void performStop() {
        FragmentManager fragmentManager = this.mChildFragmentManager;
        fragmentManager.C = true;
        fragmentManager.J.h = true;
        fragmentManager.w(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(zg.a.ON_STOP);
        }
        this.mLifecycleRegistry.e(zg.a.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new dg(hj1.O("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.w(2);
    }

    public void postponeEnterTransition() {
        ensureAnimationInfo().u = true;
    }

    public final <I, O> r<I> registerForActivityResult(t<I, O> tVar, q<O> qVar) {
        return prepareCallInternal(tVar, new e(), qVar);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i2) {
        if (this.mHost != null) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.y != null) {
                parentFragmentManager.z.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i2));
                parentFragmentManager.y.a(strArr, null);
                return;
            }
            Objects.requireNonNull(parentFragmentManager.q);
            return;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not attached to Activity"));
    }

    public final ve requireActivity() {
        ve activity = c();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final FragmentManager requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not attached to a host."));
    }

    public final Fragment requireParentFragment() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(hj1.O("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle != null && (parcelable = bundle.getParcelable(ve.FRAGMENTS_TAG)) != null) {
            this.mChildFragmentManager.b0(parcelable);
            this.mChildFragmentManager.m();
        }
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            yf yfVar = this.mViewLifecycleOwner;
            yfVar.h.a(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new dg(hj1.O("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        } else if (this.mView != null) {
            this.mViewLifecycleOwner.a(zg.a.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        ensureAnimationInfo().r = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        ensureAnimationInfo().q = Boolean.valueOf(z);
    }

    public void setAnimatingAway(View view) {
        ensureAnimationInfo().f213a = view;
    }

    public void setAnimations(int i2, int i3, int i4, int i5) {
        if (this.mAnimationInfo != null || i2 != 0 || i3 != 0 || i4 != 0 || i5 != 0) {
            ensureAnimationInfo().d = i2;
            ensureAnimationInfo().e = i3;
            ensureAnimationInfo().f = i4;
            ensureAnimationInfo().g = i5;
        }
    }

    public void setAnimator(Animator animator) {
        ensureAnimationInfo().b = animator;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager == null || !isStateSaved()) {
            this.mArguments = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added and state has been saved");
    }

    public void setEnterSharedElementCallback(o5 o5Var) {
        Objects.requireNonNull(ensureAnimationInfo());
    }

    public void setEnterTransition(Object obj) {
        ensureAnimationInfo().k = obj;
    }

    public void setExitSharedElementCallback(o5 o5Var) {
        Objects.requireNonNull(ensureAnimationInfo());
    }

    public void setExitTransition(Object obj) {
        ensureAnimationInfo().m = obj;
    }

    public void setFocusedView(View view) {
        ensureAnimationInfo().t = view;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.i();
            }
        }
    }

    public void setHideReplaced(boolean z) {
        ensureAnimationInfo().w = z;
    }

    public void setInitialSavedState(SavedState savedState) {
        Bundle bundle;
        if (this.mFragmentManager == null) {
            if (savedState == null || (bundle = savedState.f) == null) {
                bundle = null;
            }
            this.mSavedFragmentState = bundle;
            return;
        }
        throw new IllegalStateException("Fragment already added");
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.i();
            }
        }
    }

    public void setNextTransition(int i2) {
        if (this.mAnimationInfo != null || i2 != 0) {
            ensureAnimationInfo();
            this.mAnimationInfo.h = i2;
        }
    }

    public void setOnStartEnterTransitionListener(l lVar) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        l lVar2 = iVar.v;
        if (lVar != lVar2) {
            if (lVar == null || lVar2 == null) {
                if (iVar.u) {
                    iVar.v = lVar;
                }
                if (lVar != null) {
                    ((FragmentManager.n) lVar).c++;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Trying to set a replacement startPostponedEnterTransition on " + this);
        }
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo != null) {
            ensureAnimationInfo().c = z;
        }
    }

    public void setPostOnViewCreatedAlpha(float f2) {
        ensureAnimationInfo().s = f2;
    }

    public void setReenterTransition(Object obj) {
        ensureAnimationInfo().n = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            fragmentManager.J.d(this);
        } else {
            fragmentManager.J.e(this);
        }
    }

    public void setReturnTransition(Object obj) {
        ensureAnimationInfo().l = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        ensureAnimationInfo().o = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        i iVar = this.mAnimationInfo;
        iVar.i = arrayList;
        iVar.j = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        ensureAnimationInfo().p = obj;
    }

    @Deprecated
    public void setTargetFragment(Fragment fragment, int i2) {
        FragmentManager fragmentManager = this.mFragmentManager;
        FragmentManager fragmentManager2 = fragment != null ? fragment.mFragmentManager : null;
        if (fragmentManager == null || fragmentManager2 == null || fragmentManager == fragmentManager2) {
            for (Fragment fragment2 = fragment; fragment2 != null; fragment2 = fragment2.getTargetFragment()) {
                if (fragment2.equals(this)) {
                    throw new IllegalArgumentException("Setting " + fragment + " as the target of " + this + " would create a target cycle");
                }
            }
            if (fragment == null) {
                this.mTargetWho = null;
                this.mTarget = null;
            } else if (this.mFragmentManager == null || fragment.mFragmentManager == null) {
                this.mTargetWho = null;
                this.mTarget = fragment;
            } else {
                this.mTargetWho = fragment.mWho;
                this.mTarget = null;
            }
            this.mTargetRequestCode = i2;
            return;
        }
        throw new IllegalArgumentException(hj1.O("Fragment ", fragment, " must share the same FragmentManager to be set as a target fragment"));
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            FragmentManager fragmentManager = this.mFragmentManager;
            fragmentManager.W(fragmentManager.h(this));
        }
        this.mUserVisibleHint = z;
        this.mDeferStart = this.mState < 5 && !z;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        ef<?> efVar = this.mHost;
        if (efVar != null) {
            return efVar.h(str);
        }
        return false;
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2) {
        startActivityForResult(intent, i2, null);
    }

    @Deprecated
    public void startIntentSenderForResult(@SuppressLint({"UnknownNullness"}) IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        Intent intent2 = intent;
        if (this.mHost != null) {
            if (FragmentManager.O(2)) {
                String str = "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i2 + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle;
            }
            FragmentManager parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.x != null) {
                if (bundle != null) {
                    if (intent2 == null) {
                        intent2 = new Intent();
                        intent2.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
                    }
                    if (FragmentManager.O(2)) {
                        String str2 = "ActivityOptions " + bundle + " were added to fillInIntent " + intent2 + " for fragment " + this;
                    }
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                IntentSenderRequest intentSenderRequest = new IntentSenderRequest(intentSender, intent2, i3, i4);
                parentFragmentManager.z.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i2));
                if (FragmentManager.O(2)) {
                    String str3 = "Fragment " + this + "is launching an IntentSender for result ";
                }
                parentFragmentManager.x.a(intentSenderRequest, null);
                return;
            }
            ef<?> efVar = parentFragmentManager.q;
            Objects.requireNonNull(efVar);
            if (i2 == -1) {
                Activity activity = efVar.f;
                int i6 = t4.c;
                activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
                return;
            }
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not attached to Activity"));
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo != null && ensureAnimationInfo().u) {
            if (this.mHost == null) {
                ensureAnimationInfo().u = false;
            } else if (Looper.myLooper() != this.mHost.h.getLooper()) {
                this.mHost.h.postAtFrontOfQueue(new b());
            } else {
                callStartTransitionListener(true);
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @SuppressLint({"BanParcelableUsage, ParcelClassLoader"})
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public final Bundle f;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        }

        public SavedState(Bundle bundle) {
            this.f = bundle;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            Bundle readBundle = parcel.readBundle();
            this.f = readBundle;
            if (classLoader != null && readBundle != null) {
                readBundle.setClassLoader(classLoader);
            }
        }
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment fragment = (Fragment) df.c(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(fragment.getClass().getClassLoader());
                fragment.setArguments(bundle);
            }
            return fragment;
        } catch (InstantiationException e2) {
            throw new j(hj1.T("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (IllegalAccessException e3) {
            throw new j(hj1.T("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e3);
        } catch (NoSuchMethodException e4) {
            throw new j(hj1.T("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e4);
        } catch (InvocationTargetException e5) {
            throw new j(hj1.T("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e5);
        }
    }

    public final String getString(int i2, Object... objArr) {
        return getResources().getString(i2, objArr);
    }

    public final void postponeEnterTransition(long j2, TimeUnit timeUnit) {
        Handler handler;
        ensureAnimationInfo().u = true;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            handler = fragmentManager.q.h;
        } else {
            handler = new Handler(Looper.getMainLooper());
        }
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j2));
    }

    public final <I, O> r<I> registerForActivityResult(t<I, O> tVar, ActivityResultRegistry activityResultRegistry, q<O> qVar) {
        return prepareCallInternal(tVar, new f(this, activityResultRegistry), qVar);
    }

    public void startActivity(@SuppressLint({"UnknownNullness"}) Intent intent, Bundle bundle) {
        ef<?> efVar = this.mHost;
        if (efVar != null) {
            Context context = efVar.g;
            Object obj = q5.f2896a;
            q5.a.b(context, intent, bundle);
            return;
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i2, Bundle bundle) {
        if (this.mHost != null) {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            if (parentFragmentManager.w != null) {
                parentFragmentManager.z.addLast(new FragmentManager.LaunchedFragmentInfo(this.mWho, i2));
                if (!(intent == null || bundle == null)) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
                }
                parentFragmentManager.w.a(intent, null);
                return;
            }
            ef<?> efVar = parentFragmentManager.q;
            Objects.requireNonNull(efVar);
            if (i2 == -1) {
                Context context = efVar.g;
                Object obj = q5.f2896a;
                q5.a.b(context, intent, bundle);
                return;
            }
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        throw new IllegalStateException(hj1.O("Fragment ", this, " not attached to Activity"));
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        ef<?> efVar = this.mHost;
        if (efVar != null) {
            LayoutInflater f2 = efVar.f();
            f2.setFactory2(this.mChildFragmentManager.f);
            return f2;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    private void restoreViewState() {
        if (FragmentManager.O(3)) {
            String str = "moveto RESTORE_VIEW_STATE: " + this;
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }

    public Fragment(int i2) {
        this();
        this.mContentLayoutId = i2;
    }
}
