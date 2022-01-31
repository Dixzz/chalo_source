package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentState;
import defpackage.bg;
import defpackage.zg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: kf  reason: default package */
/* compiled from: FragmentStateManager */
public class kf {

    /* renamed from: a  reason: collision with root package name */
    public final gf f2049a;
    public final lf b;
    public final Fragment c;
    public boolean d = false;
    public int e = -1;

    /* renamed from: kf$a */
    /* compiled from: FragmentStateManager */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ View f;

        public a(kf kfVar, View view) {
            this.f = view;
        }

        public void onViewAttachedToWindow(View view) {
            this.f.removeOnAttachStateChangeListener(this);
            View view2 = this.f;
            AtomicInteger atomicInteger = r8.f3055a;
            view2.requestApplyInsets();
        }

        public void onViewDetachedFromWindow(View view) {
        }
    }

    public kf(gf gfVar, lf lfVar, Fragment fragment) {
        this.f2049a = gfVar;
        this.b = lfVar;
        this.c = fragment;
    }

    public void a() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("moveto ACTIVITY_CREATED: ");
            i0.append(this.c);
            i0.toString();
        }
        Fragment fragment = this.c;
        fragment.performActivityCreated(fragment.mSavedFragmentState);
        gf gfVar = this.f2049a;
        Fragment fragment2 = this.c;
        gfVar.a(fragment2, fragment2.mSavedFragmentState, false);
    }

    public void b() {
        View view;
        View view2;
        lf lfVar = this.b;
        Fragment fragment = this.c;
        Objects.requireNonNull(lfVar);
        ViewGroup viewGroup = fragment.mContainer;
        int i = -1;
        if (viewGroup != null) {
            int indexOf = lfVar.f2206a.indexOf(fragment);
            int i2 = indexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= lfVar.f2206a.size()) {
                            break;
                        }
                        Fragment fragment2 = lfVar.f2206a.get(indexOf);
                        if (fragment2.mContainer == viewGroup && (view = fragment2.mView) != null) {
                            i = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    Fragment fragment3 = lfVar.f2206a.get(i2);
                    if (fragment3.mContainer == viewGroup && (view2 = fragment3.mView) != null) {
                        i = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        Fragment fragment4 = this.c;
        fragment4.mContainer.addView(fragment4.mView, i);
    }

    public void c() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("moveto ATTACHED: ");
            i0.append(this.c);
            i0.toString();
        }
        Fragment fragment = this.c;
        Fragment fragment2 = fragment.mTarget;
        kf kfVar = null;
        if (fragment2 != null) {
            kf h = this.b.h(fragment2.mWho);
            if (h != null) {
                Fragment fragment3 = this.c;
                fragment3.mTargetWho = fragment3.mTarget.mWho;
                fragment3.mTarget = null;
                kfVar = h;
            } else {
                StringBuilder i02 = hj1.i0("Fragment ");
                i02.append(this.c);
                i02.append(" declared target fragment ");
                throw new IllegalStateException(hj1.Y(i02, this.c.mTarget, " that does not belong to this FragmentManager!"));
            }
        } else {
            String str = fragment.mTargetWho;
            if (str != null && (kfVar = this.b.h(str)) == null) {
                StringBuilder i03 = hj1.i0("Fragment ");
                i03.append(this.c);
                i03.append(" declared target fragment ");
                throw new IllegalStateException(hj1.a0(i03, this.c.mTargetWho, " that does not belong to this FragmentManager!"));
            }
        }
        if (kfVar != null) {
            kfVar.k();
        }
        Fragment fragment4 = this.c;
        FragmentManager fragmentManager = fragment4.mFragmentManager;
        fragment4.mHost = fragmentManager.q;
        fragment4.mParentFragment = fragmentManager.s;
        this.f2049a.g(fragment4, false);
        this.c.performAttach();
        this.f2049a.b(this.c, false);
    }

    public int d() {
        Fragment fragment = this.c;
        if (fragment.mFragmentManager == null) {
            return fragment.mState;
        }
        int i = this.e;
        int ordinal = fragment.mMaxState.ordinal();
        if (ordinal == 1) {
            i = Math.min(i, 0);
        } else if (ordinal == 2) {
            i = Math.min(i, 1);
        } else if (ordinal == 3) {
            i = Math.min(i, 5);
        } else if (ordinal != 4) {
            i = Math.min(i, -1);
        }
        Fragment fragment2 = this.c;
        if (fragment2.mFromLayout) {
            if (fragment2.mInLayout) {
                i = Math.max(this.e, 2);
                View view = this.c.mView;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.e < 4 ? Math.min(i, fragment2.mState) : Math.min(i, 1);
            }
        }
        if (!this.c.mAdded) {
            i = Math.min(i, 1);
        }
        Fragment fragment3 = this.c;
        ViewGroup viewGroup = fragment3.mContainer;
        bg.d.b bVar = null;
        bg.d dVar = null;
        if (viewGroup != null) {
            bg f = bg.f(viewGroup, fragment3.getParentFragmentManager());
            Objects.requireNonNull(f);
            bg.d d2 = f.d(this.c);
            bg.d.b bVar2 = d2 != null ? d2.b : null;
            Fragment fragment4 = this.c;
            Iterator<bg.d> it = f.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                bg.d next = it.next();
                if (next.c.equals(fragment4) && !next.f) {
                    dVar = next;
                    break;
                }
            }
            bVar = (dVar == null || !(bVar2 == null || bVar2 == bg.d.b.NONE)) ? bVar2 : dVar.b;
        }
        if (bVar == bg.d.b.ADDING) {
            i = Math.min(i, 6);
        } else if (bVar == bg.d.b.REMOVING) {
            i = Math.max(i, 3);
        } else {
            Fragment fragment5 = this.c;
            if (fragment5.mRemoving) {
                if (fragment5.isInBackStack()) {
                    i = Math.min(i, 1);
                } else {
                    i = Math.min(i, -1);
                }
            }
        }
        Fragment fragment6 = this.c;
        if (fragment6.mDeferStart && fragment6.mState < 5) {
            i = Math.min(i, 4);
        }
        if (FragmentManager.O(2)) {
            StringBuilder j0 = hj1.j0("computeExpectedState() of ", i, " for ");
            j0.append(this.c);
            j0.toString();
        }
        return i;
    }

    public void e() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("moveto CREATED: ");
            i0.append(this.c);
            i0.toString();
        }
        Fragment fragment = this.c;
        if (!fragment.mIsCreated) {
            this.f2049a.h(fragment, fragment.mSavedFragmentState, false);
            Fragment fragment2 = this.c;
            fragment2.performCreate(fragment2.mSavedFragmentState);
            gf gfVar = this.f2049a;
            Fragment fragment3 = this.c;
            gfVar.c(fragment3, fragment3.mSavedFragmentState, false);
            return;
        }
        fragment.restoreChildFragmentState(fragment.mSavedFragmentState);
        this.c.mState = 1;
    }

    public void f() {
        String str;
        if (!this.c.mFromLayout) {
            if (FragmentManager.O(3)) {
                StringBuilder i0 = hj1.i0("moveto CREATE_VIEW: ");
                i0.append(this.c);
                i0.toString();
            }
            Fragment fragment = this.c;
            LayoutInflater performGetLayoutInflater = fragment.performGetLayoutInflater(fragment.mSavedFragmentState);
            ViewGroup viewGroup = null;
            Fragment fragment2 = this.c;
            ViewGroup viewGroup2 = fragment2.mContainer;
            if (viewGroup2 != null) {
                viewGroup = viewGroup2;
            } else {
                int i = fragment2.mContainerId;
                if (i != 0) {
                    if (i != -1) {
                        viewGroup = (ViewGroup) fragment2.mFragmentManager.r.b(i);
                        if (viewGroup == null) {
                            Fragment fragment3 = this.c;
                            if (!fragment3.mRestored) {
                                try {
                                    str = fragment3.getResources().getResourceName(this.c.mContainerId);
                                } catch (Resources.NotFoundException unused) {
                                    str = "unknown";
                                }
                                StringBuilder i02 = hj1.i0("No view found for id 0x");
                                i02.append(Integer.toHexString(this.c.mContainerId));
                                i02.append(" (");
                                i02.append(str);
                                i02.append(") for fragment ");
                                i02.append(this.c);
                                throw new IllegalArgumentException(i02.toString());
                            }
                        }
                    } else {
                        throw new IllegalArgumentException(hj1.Y(hj1.i0("Cannot create fragment "), this.c, " for a container view with no id"));
                    }
                }
            }
            Fragment fragment4 = this.c;
            fragment4.mContainer = viewGroup;
            fragment4.performCreateView(performGetLayoutInflater, viewGroup, fragment4.mSavedFragmentState);
            View view = this.c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment5 = this.c;
                fragment5.mView.setTag(R.id.fragment_container_view_tag, fragment5);
                if (viewGroup != null) {
                    b();
                }
                Fragment fragment6 = this.c;
                if (fragment6.mHidden) {
                    fragment6.mView.setVisibility(8);
                }
                View view2 = this.c.mView;
                AtomicInteger atomicInteger = r8.f3055a;
                if (view2.isAttachedToWindow()) {
                    this.c.mView.requestApplyInsets();
                } else {
                    View view3 = this.c.mView;
                    view3.addOnAttachStateChangeListener(new a(this, view3));
                }
                this.c.performViewCreated();
                gf gfVar = this.f2049a;
                Fragment fragment7 = this.c;
                gfVar.m(fragment7, fragment7.mView, fragment7.mSavedFragmentState, false);
                int visibility = this.c.mView.getVisibility();
                this.c.setPostOnViewCreatedAlpha(this.c.mView.getAlpha());
                Fragment fragment8 = this.c;
                if (fragment8.mContainer != null && visibility == 0) {
                    View findFocus = fragment8.mView.findFocus();
                    if (findFocus != null) {
                        this.c.setFocusedView(findFocus);
                        if (FragmentManager.O(2)) {
                            String str2 = "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.c;
                        }
                    }
                    this.c.mView.setAlpha(0.0f);
                }
            }
            this.c.mState = 2;
        }
    }

    public void g() {
        Fragment d2;
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("movefrom CREATED: ");
            i0.append(this.c);
            i0.toString();
        }
        Fragment fragment = this.c;
        boolean z = true;
        boolean z2 = fragment.mRemoving && !fragment.isInBackStack();
        if (z2 || this.b.c.f(this.c)) {
            ef<?> efVar = this.c.mHost;
            if (efVar instanceof hi) {
                z = this.b.c.g;
            } else {
                Context context = efVar.g;
                if (context instanceof Activity) {
                    z = true ^ ((Activity) context).isChangingConfigurations();
                }
            }
            if (z2 || z) {
                Cif ifVar = this.b.c;
                Fragment fragment2 = this.c;
                Objects.requireNonNull(ifVar);
                if (FragmentManager.O(3)) {
                    String str = "Clearing non-config state for " + fragment2;
                }
                Cif ifVar2 = ifVar.d.get(fragment2.mWho);
                if (ifVar2 != null) {
                    ifVar2.b();
                    ifVar.d.remove(fragment2.mWho);
                }
                gi giVar = ifVar.e.get(fragment2.mWho);
                if (giVar != null) {
                    giVar.a();
                    ifVar.e.remove(fragment2.mWho);
                }
            }
            this.c.performDestroy();
            this.f2049a.d(this.c, false);
            Iterator it = ((ArrayList) this.b.f()).iterator();
            while (it.hasNext()) {
                kf kfVar = (kf) it.next();
                if (kfVar != null) {
                    Fragment fragment3 = kfVar.c;
                    if (this.c.mWho.equals(fragment3.mTargetWho)) {
                        fragment3.mTarget = this.c;
                        fragment3.mTargetWho = null;
                    }
                }
            }
            Fragment fragment4 = this.c;
            String str2 = fragment4.mTargetWho;
            if (str2 != null) {
                fragment4.mTarget = this.b.d(str2);
            }
            this.b.k(this);
            return;
        }
        String str3 = this.c.mTargetWho;
        if (!(str3 == null || (d2 = this.b.d(str3)) == null || !d2.mRetainInstance)) {
            this.c.mTarget = d2;
        }
        this.c.mState = 0;
    }

    public void h() {
        View view;
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("movefrom CREATE_VIEW: ");
            i0.append(this.c);
            i0.toString();
        }
        Fragment fragment = this.c;
        ViewGroup viewGroup = fragment.mContainer;
        if (!(viewGroup == null || (view = fragment.mView) == null)) {
            viewGroup.removeView(view);
        }
        this.c.performDestroyView();
        this.f2049a.n(this.c, false);
        Fragment fragment2 = this.c;
        fragment2.mContainer = null;
        fragment2.mView = null;
        fragment2.mViewLifecycleOwner = null;
        fragment2.mViewLifecycleOwnerLiveData.l(null);
        this.c.mInLayout = false;
    }

    public void i() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("movefrom ATTACHED: ");
            i0.append(this.c);
            i0.toString();
        }
        this.c.performDetach();
        boolean z = false;
        this.f2049a.e(this.c, false);
        Fragment fragment = this.c;
        fragment.mState = -1;
        fragment.mHost = null;
        fragment.mParentFragment = null;
        fragment.mFragmentManager = null;
        if (fragment.mRemoving && !fragment.isInBackStack()) {
            z = true;
        }
        if (z || this.b.c.f(this.c)) {
            if (FragmentManager.O(3)) {
                StringBuilder i02 = hj1.i0("initState called for fragment: ");
                i02.append(this.c);
                i02.toString();
            }
            this.c.initState();
        }
    }

    public void j() {
        Fragment fragment = this.c;
        if (fragment.mFromLayout && fragment.mInLayout && !fragment.mPerformedCreateView) {
            if (FragmentManager.O(3)) {
                StringBuilder i0 = hj1.i0("moveto CREATE_VIEW: ");
                i0.append(this.c);
                i0.toString();
            }
            Fragment fragment2 = this.c;
            fragment2.performCreateView(fragment2.performGetLayoutInflater(fragment2.mSavedFragmentState), null, this.c.mSavedFragmentState);
            View view = this.c.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                Fragment fragment3 = this.c;
                fragment3.mView.setTag(R.id.fragment_container_view_tag, fragment3);
                Fragment fragment4 = this.c;
                if (fragment4.mHidden) {
                    fragment4.mView.setVisibility(8);
                }
                this.c.performViewCreated();
                gf gfVar = this.f2049a;
                Fragment fragment5 = this.c;
                gfVar.m(fragment5, fragment5.mView, fragment5.mSavedFragmentState, false);
                this.c.mState = 2;
            }
        }
    }

    public void k() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (!this.d) {
            boolean z = false;
            boolean z2 = true;
            try {
                while (true) {
                    int d2 = d();
                    Fragment fragment = this.c;
                    int i = fragment.mState;
                    if (d2 == i) {
                        if (fragment.mHiddenChanged) {
                            if (!(fragment.mView == null || (viewGroup = fragment.mContainer) == null)) {
                                bg f = bg.f(viewGroup, fragment.getParentFragmentManager());
                                if (this.c.mHidden) {
                                    Objects.requireNonNull(f);
                                    if (FragmentManager.O(2)) {
                                        String str = "SpecialEffectsController: Enqueuing hide operation for fragment " + this.c;
                                    }
                                    f.a(bg.d.c.GONE, bg.d.b.NONE, this);
                                } else {
                                    Objects.requireNonNull(f);
                                    if (FragmentManager.O(2)) {
                                        String str2 = "SpecialEffectsController: Enqueuing show operation for fragment " + this.c;
                                    }
                                    f.a(bg.d.c.VISIBLE, bg.d.b.NONE, this);
                                }
                            }
                            Fragment fragment2 = this.c;
                            FragmentManager fragmentManager = fragment2.mFragmentManager;
                            if (fragmentManager != null && fragment2.mAdded && fragmentManager.P(fragment2)) {
                                fragmentManager.A = z2;
                            }
                            Fragment fragment3 = this.c;
                            fragment3.mHiddenChanged = z;
                            fragment3.onHiddenChanged(fragment3.mHidden);
                        }
                        this.d = z;
                        return;
                    } else if (d2 > i) {
                        switch (i + 1) {
                            case 0:
                                c();
                                continue;
                            case 1:
                                e();
                                continue;
                            case 2:
                                j();
                                f();
                                continue;
                            case 3:
                                a();
                                continue;
                            case 4:
                                if (!(fragment.mView == null || (viewGroup3 = fragment.mContainer) == null)) {
                                    bg f2 = bg.f(viewGroup3, fragment.getParentFragmentManager());
                                    bg.d.c from = bg.d.c.from(this.c.mView.getVisibility());
                                    Objects.requireNonNull(f2);
                                    if (FragmentManager.O(2)) {
                                        String str3 = "SpecialEffectsController: Enqueuing add operation for fragment " + this.c;
                                    }
                                    f2.a(from, bg.d.b.ADDING, this);
                                }
                                this.c.mState = 4;
                                continue;
                            case 5:
                                q();
                                continue;
                            case 6:
                                fragment.mState = 6;
                                continue;
                            case 7:
                                n();
                                continue;
                            default:
                                continue;
                        }
                    } else {
                        switch (i - 1) {
                            case -1:
                                i();
                                continue;
                            case 0:
                                g();
                                continue;
                            case 1:
                                h();
                                this.c.mState = z2 ? 1 : 0;
                                continue;
                            case 2:
                                fragment.mInLayout = z;
                                fragment.mState = 2;
                                continue;
                            case 3:
                                if (FragmentManager.O(3)) {
                                    String str4 = "movefrom ACTIVITY_CREATED: " + this.c;
                                }
                                Fragment fragment4 = this.c;
                                if (fragment4.mView != null && fragment4.mSavedViewState == null) {
                                    p();
                                }
                                Fragment fragment5 = this.c;
                                if (!(fragment5.mView == null || (viewGroup2 = fragment5.mContainer) == null)) {
                                    bg f3 = bg.f(viewGroup2, fragment5.getParentFragmentManager());
                                    Objects.requireNonNull(f3);
                                    if (FragmentManager.O(2)) {
                                        String str5 = "SpecialEffectsController: Enqueuing remove operation for fragment " + this.c;
                                    }
                                    f3.a(bg.d.c.REMOVED, bg.d.b.REMOVING, this);
                                }
                                this.c.mState = 3;
                                continue;
                            case 4:
                                r();
                                continue;
                            case 5:
                                fragment.mState = 5;
                                continue;
                            case 6:
                                l();
                                continue;
                            default:
                                continue;
                        }
                    }
                }
            } finally {
                this.d = z;
            }
        } else if (FragmentManager.O(2)) {
            StringBuilder i0 = hj1.i0("Ignoring re-entrant call to moveToExpectedState() for ");
            i0.append(this.c);
            i0.toString();
        }
    }

    public void l() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("movefrom RESUMED: ");
            i0.append(this.c);
            i0.toString();
        }
        this.c.performPause();
        this.f2049a.f(this.c, false);
    }

    public void m(ClassLoader classLoader) {
        Bundle bundle = this.c.mSavedFragmentState;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
            Fragment fragment = this.c;
            fragment.mSavedViewState = fragment.mSavedFragmentState.getSparseParcelableArray("android:view_state");
            Fragment fragment2 = this.c;
            fragment2.mSavedViewRegistryState = fragment2.mSavedFragmentState.getBundle("android:view_registry_state");
            Fragment fragment3 = this.c;
            fragment3.mTargetWho = fragment3.mSavedFragmentState.getString("android:target_state");
            Fragment fragment4 = this.c;
            if (fragment4.mTargetWho != null) {
                fragment4.mTargetRequestCode = fragment4.mSavedFragmentState.getInt("android:target_req_state", 0);
            }
            Fragment fragment5 = this.c;
            Boolean bool = fragment5.mSavedUserVisibleHint;
            if (bool != null) {
                fragment5.mUserVisibleHint = bool.booleanValue();
                this.c.mSavedUserVisibleHint = null;
            } else {
                fragment5.mUserVisibleHint = fragment5.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
            }
            Fragment fragment6 = this.c;
            if (!fragment6.mUserVisibleHint) {
                fragment6.mDeferStart = true;
            }
        }
    }

    public void n() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("moveto RESUMED: ");
            i0.append(this.c);
            i0.toString();
        }
        View focusedView = this.c.getFocusedView();
        if (focusedView != null) {
            boolean z = true;
            if (focusedView != this.c.mView) {
                ViewParent parent = focusedView.getParent();
                while (true) {
                    if (parent == null) {
                        z = false;
                        break;
                    } else if (parent == this.c.mView) {
                        break;
                    } else {
                        parent = parent.getParent();
                    }
                }
            }
            if (z) {
                boolean requestFocus = focusedView.requestFocus();
                if (FragmentManager.O(2)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("requestFocus: Restoring focused view ");
                    sb.append(focusedView);
                    sb.append(" ");
                    sb.append(requestFocus ? "succeeded" : "failed");
                    sb.append(" on Fragment ");
                    sb.append(this.c);
                    sb.append(" resulting in focused view ");
                    sb.append(this.c.mView.findFocus());
                    sb.toString();
                }
            }
        }
        this.c.setFocusedView(null);
        this.c.performResume();
        this.f2049a.i(this.c, false);
        Fragment fragment = this.c;
        fragment.mSavedFragmentState = null;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
    }

    public final Bundle o() {
        Bundle bundle = new Bundle();
        this.c.performSaveInstanceState(bundle);
        this.f2049a.j(this.c, bundle, false);
        if (bundle.isEmpty()) {
            bundle = null;
        }
        if (this.c.mView != null) {
            p();
        }
        if (this.c.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", this.c.mSavedViewState);
        }
        if (this.c.mSavedViewRegistryState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("android:view_registry_state", this.c.mSavedViewRegistryState);
        }
        if (!this.c.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", this.c.mUserVisibleHint);
        }
        return bundle;
    }

    public void p() {
        if (this.c.mView != null) {
            SparseArray<Parcelable> sparseArray = new SparseArray<>();
            this.c.mView.saveHierarchyState(sparseArray);
            if (sparseArray.size() > 0) {
                this.c.mSavedViewState = sparseArray;
            }
            Bundle bundle = new Bundle();
            this.c.mViewLifecycleOwner.h.b(bundle);
            if (!bundle.isEmpty()) {
                this.c.mSavedViewRegistryState = bundle;
            }
        }
    }

    public void q() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("moveto STARTED: ");
            i0.append(this.c);
            i0.toString();
        }
        this.c.performStart();
        this.f2049a.k(this.c, false);
    }

    public void r() {
        if (FragmentManager.O(3)) {
            StringBuilder i0 = hj1.i0("movefrom STARTED: ");
            i0.append(this.c);
            i0.toString();
        }
        this.c.performStop();
        this.f2049a.l(this.c, false);
    }

    public kf(gf gfVar, lf lfVar, ClassLoader classLoader, df dfVar, FragmentState fragmentState) {
        this.f2049a = gfVar;
        this.b = lfVar;
        Fragment a2 = dfVar.a(classLoader, fragmentState.f);
        this.c = a2;
        Bundle bundle = fragmentState.o;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        a2.setArguments(fragmentState.o);
        a2.mWho = fragmentState.g;
        a2.mFromLayout = fragmentState.h;
        a2.mRestored = true;
        a2.mFragmentId = fragmentState.i;
        a2.mContainerId = fragmentState.j;
        a2.mTag = fragmentState.k;
        a2.mRetainInstance = fragmentState.l;
        a2.mRemoving = fragmentState.m;
        a2.mDetached = fragmentState.n;
        a2.mHidden = fragmentState.p;
        a2.mMaxState = zg.b.values()[fragmentState.q];
        Bundle bundle2 = fragmentState.r;
        if (bundle2 != null) {
            a2.mSavedFragmentState = bundle2;
        } else {
            a2.mSavedFragmentState = new Bundle();
        }
        if (FragmentManager.O(2)) {
            String str = "Instantiated fragment " + a2;
        }
    }

    public kf(gf gfVar, lf lfVar, Fragment fragment, FragmentState fragmentState) {
        this.f2049a = gfVar;
        this.b = lfVar;
        this.c = fragment;
        fragment.mSavedViewState = null;
        fragment.mSavedViewRegistryState = null;
        fragment.mBackStackNesting = 0;
        fragment.mInLayout = false;
        fragment.mAdded = false;
        Fragment fragment2 = fragment.mTarget;
        fragment.mTargetWho = fragment2 != null ? fragment2.mWho : null;
        fragment.mTarget = null;
        Bundle bundle = fragmentState.r;
        if (bundle != null) {
            fragment.mSavedFragmentState = bundle;
        } else {
            fragment.mSavedFragmentState = new Bundle();
        }
    }
}
