package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.perf.util.Constants;
import defpackage.dl;
import defpackage.e9;
import defpackage.el;
import defpackage.ik;
import defpackage.lk;
import defpackage.sj;
import defpackage.xj;
import defpackage.zk;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class RecyclerView extends ViewGroup implements h8 {
    public static final int[] H0 = {16843830};
    public static final boolean I0 = (Build.VERSION.SDK_INT >= 23);
    public static final boolean J0 = true;
    public static final boolean K0 = true;
    public static final Class<?>[] L0;
    public static final Interpolator M0 = new c();
    public boolean A;
    public final int[] A0;
    public int B;
    public final List<a0> B0;
    public boolean C;
    public Runnable C0;
    public boolean D;
    public boolean D0;
    public boolean E;
    public int E0;
    public int F;
    public int F0;
    public boolean G;
    public final el.b G0;
    public final AccessibilityManager H;
    public List<o> I;
    public boolean J;
    public boolean K;
    public int L;
    public int M;
    public i N;
    public EdgeEffect O;
    public EdgeEffect P;
    public EdgeEffect Q;
    public EdgeEffect R;
    public j S;
    public int T;
    public int U;
    public VelocityTracker V;
    public int W;
    public int a0;
    public int b0;
    public int c0;
    public int d0;
    public p e0;
    public final v f;
    public final int f0;
    public final t g;
    public final int g0;
    public SavedState h;
    public float h0;
    public sj i;
    public float i0;
    public xj j;
    public boolean j0;
    public final el k;
    public final z k0;
    public boolean l;
    public lk l0;
    public final Runnable m;
    public lk.b m0;
    public final Rect n;
    public final x n0;
    public final Rect o;
    public r o0;
    public final RectF p;
    public List<r> p0;
    public e q;
    public boolean q0;
    public m r;
    public boolean r0;
    public u s;
    public j.b s0;
    public final List<u> t;
    public boolean t0;
    public final ArrayList<l> u;
    public zk u0;
    public final ArrayList<q> v;
    public h v0;
    public q w;
    public final int[] w0;
    public boolean x;
    public i8 x0;
    public boolean y;
    public final int[] y0;
    public boolean z;
    public final int[] z0;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.A && !recyclerView.isLayoutRequested()) {
                RecyclerView recyclerView2 = RecyclerView.this;
                if (!recyclerView2.x) {
                    recyclerView2.requestLayout();
                } else if (recyclerView2.D) {
                    recyclerView2.C = true;
                } else {
                    recyclerView2.m();
                }
            }
        }
    }

    public static abstract class a0 {
        public static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        public static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        public static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        public static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        public static final int FLAG_BOUND = 1;
        public static final int FLAG_IGNORE = 128;
        public static final int FLAG_INVALID = 4;
        public static final int FLAG_MOVED = 2048;
        public static final int FLAG_NOT_RECYCLABLE = 16;
        public static final int FLAG_REMOVED = 8;
        public static final int FLAG_RETURNED_FROM_SCRAP = 32;
        public static final int FLAG_TMP_DETACHED = 256;
        public static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        public static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        public e<? extends a0> mBindingAdapter;
        public int mFlags;
        public boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        public long mItemId = -1;
        public int mItemViewType = -1;
        public WeakReference<RecyclerView> mNestedRecyclerView;
        public int mOldPosition = -1;
        public RecyclerView mOwnerRecyclerView;
        public List<Object> mPayloads = null;
        public int mPendingAccessibilityState = -1;
        public int mPosition = -1;
        public int mPreLayoutPosition = -1;
        public t mScrapContainer = null;
        public a0 mShadowedHolder = null;
        public a0 mShadowingHolder = null;
        public List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public a0(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        public void addFlags(int i) {
            this.mFlags = i | this.mFlags;
        }

        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        public boolean doesTransientStatePreventRecycling() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                AtomicInteger atomicInteger = r8.f3055a;
                if (view.hasTransientState()) {
                    return true;
                }
            }
            return false;
        }

        public void flagRemovedAndOffsetPosition(int i, int i2, boolean z) {
            addFlags(8);
            offsetPosition(i2, z);
            this.mPosition = i;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.G(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final e<? extends a0> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            e adapter;
            int G;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (G = this.mOwnerRecyclerView.G(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, G);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i = this.mPreLayoutPosition;
            return i == -1 ? this.mPosition : i;
        }

        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            if (list == null || list.size() == 0) {
                return FULLUPDATE_PAYLOADS;
            }
            return this.mUnmodifiedPayloads;
        }

        public boolean hasAnyOfTheFlags(int i) {
            return (i & this.mFlags) != 0;
        }

        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            if ((this.mFlags & 16) == 0) {
                View view = this.itemView;
                AtomicInteger atomicInteger = r8.f3055a;
                if (!view.hasTransientState()) {
                    return true;
                }
            }
            return false;
        }

        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        public void offsetPosition(int i, boolean z) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z) {
                this.mPreLayoutPosition += i;
            }
            this.mPosition += i;
            if (this.itemView.getLayoutParams() != null) {
                ((n) this.itemView.getLayoutParams()).h = true;
            }
        }

        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i = this.mPendingAccessibilityState;
            if (i != -1) {
                this.mWasImportantForAccessibilityBeforeHidden = i;
            } else {
                View view = this.itemView;
                AtomicInteger atomicInteger = r8.f3055a;
                this.mWasImportantForAccessibilityBeforeHidden = view.getImportantForAccessibility();
            }
            recyclerView.j0(this, 4);
        }

        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.j0(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.j(this);
        }

        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        public void setFlags(int i, int i2) {
            this.mFlags = (i & i2) | (this.mFlags & (~i2));
        }

        public final void setIsRecyclable(boolean z) {
            int i = this.mIsRecyclableCount;
            int i2 = z ? i - 1 : i + 1;
            this.mIsRecyclableCount = i2;
            if (i2 < 0) {
                this.mIsRecyclableCount = 0;
                String str = "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this;
            } else if (!z && i2 == 1) {
                this.mFlags |= 16;
            } else if (z && i2 == 0) {
                this.mFlags &= -17;
            }
        }

        public void setScrapContainer(t tVar, boolean z) {
            this.mScrapContainer = tVar;
            this.mInChangeScrap = z;
        }

        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            StringBuilder k0 = hj1.k0(getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName(), "{");
            k0.append(Integer.toHexString(hashCode()));
            k0.append(" position=");
            k0.append(this.mPosition);
            k0.append(" id=");
            k0.append(this.mItemId);
            k0.append(", oldPos=");
            k0.append(this.mOldPosition);
            k0.append(", pLpos:");
            k0.append(this.mPreLayoutPosition);
            StringBuilder sb = new StringBuilder(k0.toString());
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                StringBuilder i0 = hj1.i0(" not recyclable(");
                i0.append(this.mIsRecyclableCount);
                i0.append(")");
                sb.append(i0.toString());
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public void unScrap() {
            this.mScrapContainer.l(this);
        }

        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            j jVar = RecyclerView.this.S;
            if (jVar != null) {
                ik ikVar = (ik) jVar;
                boolean z = !ikVar.h.isEmpty();
                boolean z2 = !ikVar.j.isEmpty();
                boolean z3 = !ikVar.k.isEmpty();
                boolean z4 = !ikVar.i.isEmpty();
                if (z || z2 || z4 || z3) {
                    Iterator<a0> it = ikVar.h.iterator();
                    while (it.hasNext()) {
                        a0 next = it.next();
                        View view = next.itemView;
                        ViewPropertyAnimator animate = view.animate();
                        ikVar.q.add(next);
                        animate.setDuration(ikVar.d).alpha(0.0f).setListener(new dk(ikVar, next, animate, view)).start();
                    }
                    ikVar.h.clear();
                    if (z2) {
                        ArrayList<ik.b> arrayList = new ArrayList<>();
                        arrayList.addAll(ikVar.j);
                        ikVar.m.add(arrayList);
                        ikVar.j.clear();
                        ak akVar = new ak(ikVar, arrayList);
                        if (z) {
                            View view2 = arrayList.get(0).f1526a.itemView;
                            long j = ikVar.d;
                            AtomicInteger atomicInteger = r8.f3055a;
                            view2.postOnAnimationDelayed(akVar, j);
                        } else {
                            akVar.run();
                        }
                    }
                    if (z3) {
                        ArrayList<ik.a> arrayList2 = new ArrayList<>();
                        arrayList2.addAll(ikVar.k);
                        ikVar.n.add(arrayList2);
                        ikVar.k.clear();
                        bk bkVar = new bk(ikVar, arrayList2);
                        if (z) {
                            View view3 = arrayList2.get(0).f1525a.itemView;
                            long j2 = ikVar.d;
                            AtomicInteger atomicInteger2 = r8.f3055a;
                            view3.postOnAnimationDelayed(bkVar, j2);
                        } else {
                            bkVar.run();
                        }
                    }
                    if (z4) {
                        ArrayList<a0> arrayList3 = new ArrayList<>();
                        arrayList3.addAll(ikVar.i);
                        ikVar.l.add(arrayList3);
                        ikVar.i.clear();
                        ck ckVar = new ck(ikVar, arrayList3);
                        if (z || z2 || z3) {
                            long j3 = 0;
                            long j4 = z ? ikVar.d : 0;
                            long j5 = z2 ? ikVar.e : 0;
                            if (z3) {
                                j3 = ikVar.f;
                            }
                            View view4 = arrayList3.get(0).itemView;
                            AtomicInteger atomicInteger3 = r8.f3055a;
                            view4.postOnAnimationDelayed(ckVar, Math.max(j5, j3) + j4);
                        } else {
                            ckVar.run();
                        }
                    }
                }
            }
            RecyclerView.this.t0 = false;
        }
    }

    public class c implements Interpolator {
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    public class d implements el.b {
        public d() {
        }

        public void a(a0 a0Var, j.c cVar, j.c cVar2) {
            boolean z;
            int i;
            int i2;
            RecyclerView recyclerView = RecyclerView.this;
            Objects.requireNonNull(recyclerView);
            a0Var.setIsRecyclable(false);
            al alVar = (al) recyclerView.S;
            Objects.requireNonNull(alVar);
            if (cVar == null || ((i = cVar.f233a) == (i2 = cVar2.f233a) && cVar.b == cVar2.b)) {
                ik ikVar = (ik) alVar;
                ikVar.n(a0Var);
                a0Var.itemView.setAlpha(0.0f);
                ikVar.i.add(a0Var);
                z = true;
            } else {
                z = alVar.i(a0Var, i, cVar.b, i2, cVar2.b);
            }
            if (z) {
                recyclerView.Z();
            }
        }

        public void b(a0 a0Var, j.c cVar, j.c cVar2) {
            boolean z;
            RecyclerView.this.g.l(a0Var);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.e(a0Var);
            a0Var.setIsRecyclable(false);
            al alVar = (al) recyclerView.S;
            Objects.requireNonNull(alVar);
            int i = cVar.f233a;
            int i2 = cVar.b;
            View view = a0Var.itemView;
            int left = cVar2 == null ? view.getLeft() : cVar2.f233a;
            int top = cVar2 == null ? view.getTop() : cVar2.b;
            if (a0Var.isRemoved() || (i == left && i2 == top)) {
                ik ikVar = (ik) alVar;
                ikVar.n(a0Var);
                ikVar.h.add(a0Var);
                z = true;
            } else {
                view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                z = alVar.i(a0Var, i, i2, left, top);
            }
            if (z) {
                recyclerView.Z();
            }
        }
    }

    public static class f extends Observable<g> {
        public boolean a() {
            return !((Observable) this).mObservers.isEmpty();
        }

        public void b() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).a();
            }
        }

        public void c(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).e(i, i2, 1);
            }
        }

        public void d(int i, int i2, Object obj) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).c(i, i2, obj);
            }
        }

        public void e(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).d(i, i2);
            }
        }

        public void f(int i, int i2) {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).f(i, i2);
            }
        }

        public void g() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((g) ((Observable) this).mObservers.get(size)).g();
            }
        }
    }

    public static abstract class g {
        public void a() {
        }

        public void b(int i, int i2) {
        }

        public void c(int i, int i2, Object obj) {
            b(i, i2);
        }

        public void d(int i, int i2) {
        }

        public void e(int i, int i2, int i3) {
        }

        public void f(int i, int i2) {
        }

        public void g() {
        }
    }

    public interface h {
        int a(int i, int i2);
    }

    public static class i {
        public EdgeEffect a(RecyclerView recyclerView) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class j {

        /* renamed from: a  reason: collision with root package name */
        public b f232a = null;
        public ArrayList<a> b = new ArrayList<>();
        public long c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        public interface a {
            void a();
        }

        public interface b {
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f233a;
            public int b;
        }

        public static int b(a0 a0Var) {
            int i = a0Var.mFlags & 14;
            if (a0Var.isInvalid()) {
                return 4;
            }
            if ((i & 4) != 0) {
                return i;
            }
            int oldPosition = a0Var.getOldPosition();
            int absoluteAdapterPosition = a0Var.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i : i | 2048;
        }

        public abstract boolean a(a0 a0Var, a0 a0Var2, c cVar, c cVar2);

        public final void c(a0 a0Var) {
            b bVar = this.f232a;
            if (bVar != null) {
                k kVar = (k) bVar;
                Objects.requireNonNull(kVar);
                boolean z = true;
                a0Var.setIsRecyclable(true);
                if (a0Var.mShadowedHolder != null && a0Var.mShadowingHolder == null) {
                    a0Var.mShadowedHolder = null;
                }
                a0Var.mShadowingHolder = null;
                if (!a0Var.shouldBeKeptAsChild()) {
                    RecyclerView recyclerView = RecyclerView.this;
                    View view = a0Var.itemView;
                    recyclerView.m0();
                    xj xjVar = recyclerView.j;
                    int indexOfChild = ((xk) xjVar.f3930a).f3935a.indexOfChild(view);
                    if (indexOfChild == -1) {
                        xjVar.m(view);
                    } else if (xjVar.b.d(indexOfChild)) {
                        xjVar.b.f(indexOfChild);
                        xjVar.m(view);
                        ((xk) xjVar.f3930a).c(indexOfChild);
                    } else {
                        z = false;
                    }
                    if (z) {
                        a0 K = RecyclerView.K(view);
                        recyclerView.g.l(K);
                        recyclerView.g.i(K);
                    }
                    recyclerView.o0(!z);
                    if (!z && a0Var.isTmpDetached()) {
                        RecyclerView.this.removeDetachedView(a0Var.itemView, false);
                    }
                }
            }
        }

        public final void d() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).a();
            }
            this.b.clear();
        }

        public abstract void e(a0 a0Var);

        public abstract void f();

        public abstract boolean g();

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView$x;Landroidx/recyclerview/widget/RecyclerView$a0;ILjava/util/List<Ljava/lang/Object;>;)Landroidx/recyclerview/widget/RecyclerView$j$c; */
        public c h(a0 a0Var) {
            c cVar = new c();
            View view = a0Var.itemView;
            cVar.f233a = view.getLeft();
            cVar.b = view.getTop();
            view.getRight();
            view.getBottom();
            return cVar;
        }
    }

    public class k implements j.b {
        public k() {
        }
    }

    public static abstract class l {
        @Deprecated
        public void getItemOffsets(Rect rect, int i, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, x xVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, x xVar) {
            onDrawOver(canvas, recyclerView);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, x xVar) {
            getItemOffsets(rect, ((n) view.getLayoutParams()).a(), recyclerView);
        }
    }

    public static abstract class m {
        public xj f;
        public RecyclerView g;
        public final dl.b h;
        public final dl.b i;
        public dl j;
        public dl k;
        public w l;
        public boolean m = false;
        public boolean n = false;
        public boolean o = false;
        public boolean p = true;
        public boolean q = true;
        public int r;
        public boolean s;
        public int t;
        public int u;
        public int v;
        public int w;

        public class a implements dl.b {
            public a() {
            }

            @Override // defpackage.dl.b
            public int a(View view) {
                return m.this.P(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).leftMargin;
            }

            @Override // defpackage.dl.b
            public int b() {
                return m.this.getPaddingLeft();
            }

            @Override // defpackage.dl.b
            public int c() {
                m mVar = m.this;
                return mVar.v - mVar.getPaddingRight();
            }

            @Override // defpackage.dl.b
            public View d(int i) {
                return m.this.J(i);
            }

            @Override // defpackage.dl.b
            public int e(View view) {
                return m.this.S(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).rightMargin;
            }
        }

        public class b implements dl.b {
            public b() {
            }

            @Override // defpackage.dl.b
            public int a(View view) {
                return m.this.T(view) - ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).topMargin;
            }

            @Override // defpackage.dl.b
            public int b() {
                return m.this.getPaddingTop();
            }

            @Override // defpackage.dl.b
            public int c() {
                m mVar = m.this;
                return mVar.w - mVar.getPaddingBottom();
            }

            @Override // defpackage.dl.b
            public View d(int i) {
                return m.this.J(i);
            }

            @Override // defpackage.dl.b
            public int e(View view) {
                return m.this.N(view) + ((ViewGroup.MarginLayoutParams) ((n) view.getLayoutParams())).bottomMargin;
            }
        }

        public interface c {
        }

        public static class d {

            /* renamed from: a  reason: collision with root package name */
            public int f237a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public m() {
            a aVar = new a();
            this.h = aVar;
            b bVar = new b();
            this.i = bVar;
            this.j = new dl(aVar);
            this.k = new dl(bVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int L(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m.L(int, int, int, int, boolean):int");
        }

        public static d b0(Context context, AttributeSet attributeSet, int i2, int i3) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, i3);
            dVar.f237a = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            dVar.b = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            dVar.c = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            dVar.d = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }

        public static boolean j0(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        public static int s(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i3, i4) : size;
            }
            return Math.min(size, Math.max(i3, i4));
        }

        public int A(x xVar) {
            return 0;
        }

        public void A0(RecyclerView recyclerView, int i2, int i3) {
        }

        public void B(t tVar) {
            int K = K();
            while (true) {
                K--;
                if (K >= 0) {
                    View J = J(K);
                    a0 K2 = RecyclerView.K(J);
                    if (!K2.shouldIgnore()) {
                        if (!K2.isInvalid() || K2.isRemoved() || this.g.q.hasStableIds()) {
                            J(K);
                            C(K);
                            tVar.j(J);
                            this.g.k.f(K2);
                        } else {
                            if (J(K) != null) {
                                this.f.l(K);
                            }
                            tVar.i(K2);
                        }
                    }
                } else {
                    return;
                }
            }
        }

        public void B0(RecyclerView recyclerView) {
        }

        public final void C(int i2) {
            this.f.c(i2);
        }

        public void C0(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public View D(View view) {
            View B;
            RecyclerView recyclerView = this.g;
            if (recyclerView == null || (B = recyclerView.B(view)) == null || this.f.c.contains(B)) {
                return null;
            }
            return B;
        }

        public void D0(RecyclerView recyclerView, int i2, int i3) {
        }

        public View E(int i2) {
            int K = K();
            for (int i3 = 0; i3 < K; i3++) {
                View J = J(i3);
                a0 K2 = RecyclerView.K(J);
                if (K2 != null && K2.getLayoutPosition() == i2 && !K2.shouldIgnore() && (this.g.n0.g || !K2.isRemoved())) {
                    return J;
                }
            }
            return null;
        }

        public void E0(RecyclerView recyclerView, int i2, int i3) {
        }

        public abstract n F();

        public void F0(RecyclerView recyclerView, int i2, int i3, Object obj) {
            E0(recyclerView, i2, i3);
        }

        public n G(Context context, AttributeSet attributeSet) {
            return new n(context, attributeSet);
        }

        public void G0(t tVar, x xVar) {
        }

        public n H(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof n) {
                return new n((n) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new n((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new n(layoutParams);
        }

        public void H0(x xVar) {
        }

        public int I(View view) {
            return ((n) view.getLayoutParams()).g.bottom;
        }

        public void I0(int i2, int i3) {
            this.g.n(i2, i3);
        }

        public View J(int i2) {
            xj xjVar = this.f;
            if (xjVar == null) {
                return null;
            }
            return ((xk) xjVar.f3930a).a(xjVar.f(i2));
        }

        @Deprecated
        public boolean J0(RecyclerView recyclerView) {
            w wVar = this.l;
            if ((wVar != null && wVar.e) || recyclerView.O()) {
                return true;
            }
            return false;
        }

        public int K() {
            xj xjVar = this.f;
            if (xjVar != null) {
                return xjVar.e();
            }
            return 0;
        }

        public boolean K0(RecyclerView recyclerView, View view, View view2) {
            return J0(recyclerView);
        }

        public void L0(Parcelable parcelable) {
        }

        public int M(t tVar, x xVar) {
            return -1;
        }

        public Parcelable M0() {
            return null;
        }

        public int N(View view) {
            return I(view) + view.getBottom();
        }

        public void N0(int i2) {
        }

        public void O(View view, Rect rect) {
            int[] iArr = RecyclerView.H0;
            n nVar = (n) view.getLayoutParams();
            Rect rect2 = nVar.g;
            rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) nVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) nVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) nVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean O0(androidx.recyclerview.widget.RecyclerView.t r8, androidx.recyclerview.widget.RecyclerView.x r9, int r10, android.os.Bundle r11) {
            /*
            // Method dump skipped, instructions count: 122
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m.O0(androidx.recyclerview.widget.RecyclerView$t, androidx.recyclerview.widget.RecyclerView$x, int, android.os.Bundle):boolean");
        }

        public int P(View view) {
            return view.getLeft() - X(view);
        }

        public boolean P0() {
            return false;
        }

        public int Q(View view) {
            Rect rect = ((n) view.getLayoutParams()).g;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public void Q0() {
            int K = K();
            while (true) {
                K--;
                if (K >= 0) {
                    this.f.l(K);
                } else {
                    return;
                }
            }
        }

        public int R(View view) {
            Rect rect = ((n) view.getLayoutParams()).g;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void R0(t tVar) {
            for (int K = K() - 1; K >= 0; K--) {
                if (!RecyclerView.K(J(K)).shouldIgnore()) {
                    U0(K, tVar);
                }
            }
        }

        public int S(View view) {
            return c0(view) + view.getRight();
        }

        public void S0(t tVar) {
            int size = tVar.f240a.size();
            for (int i2 = size - 1; i2 >= 0; i2--) {
                View view = tVar.f240a.get(i2).itemView;
                a0 K = RecyclerView.K(view);
                if (!K.shouldIgnore()) {
                    K.setIsRecyclable(false);
                    if (K.isTmpDetached()) {
                        this.g.removeDetachedView(view, false);
                    }
                    j jVar = this.g.S;
                    if (jVar != null) {
                        jVar.e(K);
                    }
                    K.setIsRecyclable(true);
                    a0 K2 = RecyclerView.K(view);
                    K2.mScrapContainer = null;
                    K2.mInChangeScrap = false;
                    K2.clearReturnedFromScrapFlag();
                    tVar.i(K2);
                }
            }
            tVar.f240a.clear();
            ArrayList<a0> arrayList = tVar.b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.g.invalidate();
            }
        }

        public int T(View view) {
            return view.getTop() - f0(view);
        }

        public void T0(View view, t tVar) {
            xj xjVar = this.f;
            int indexOfChild = ((xk) xjVar.f3930a).f3935a.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (xjVar.b.f(indexOfChild)) {
                    xjVar.m(view);
                }
                ((xk) xjVar.f3930a).c(indexOfChild);
            }
            tVar.h(view);
        }

        public View U() {
            View focusedChild;
            RecyclerView recyclerView = this.g;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f.c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void U0(int i2, t tVar) {
            View J = J(i2);
            if (J(i2) != null) {
                this.f.l(i2);
            }
            tVar.h(J);
        }

        public int V() {
            RecyclerView recyclerView = this.g;
            e adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b8, code lost:
            if (r1 == false) goto L_0x00bf;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean V0(androidx.recyclerview.widget.RecyclerView r19, android.view.View r20, android.graphics.Rect r21, boolean r22, boolean r23) {
            /*
            // Method dump skipped, instructions count: 213
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.m.V0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public int W() {
            RecyclerView recyclerView = this.g;
            AtomicInteger atomicInteger = r8.f3055a;
            return recyclerView.getLayoutDirection();
        }

        public void W0() {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public int X(View view) {
            return ((n) view.getLayoutParams()).g.left;
        }

        public int X0(int i2, t tVar, x xVar) {
            return 0;
        }

        public int Y() {
            RecyclerView recyclerView = this.g;
            AtomicInteger atomicInteger = r8.f3055a;
            return recyclerView.getMinimumHeight();
        }

        public void Y0(int i2) {
        }

        public int Z() {
            RecyclerView recyclerView = this.g;
            AtomicInteger atomicInteger = r8.f3055a;
            return recyclerView.getMinimumWidth();
        }

        public int Z0(int i2, t tVar, x xVar) {
            return 0;
        }

        public int a0(View view) {
            return ((n) view.getLayoutParams()).a();
        }

        public void a1(RecyclerView recyclerView) {
            b1(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), CommonUtils.BYTES_IN_A_GIGABYTE), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), CommonUtils.BYTES_IN_A_GIGABYTE));
        }

        public void b1(int i2, int i3) {
            this.v = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.t = mode;
            if (mode == 0 && !RecyclerView.I0) {
                this.v = 0;
            }
            this.w = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.u = mode2;
            if (mode2 == 0 && !RecyclerView.I0) {
                this.w = 0;
            }
        }

        public int c0(View view) {
            return ((n) view.getLayoutParams()).g.right;
        }

        public void c1(Rect rect, int i2, int i3) {
            int paddingRight = getPaddingRight() + getPaddingLeft() + rect.width();
            int paddingBottom = getPaddingBottom() + getPaddingTop() + rect.height();
            this.g.setMeasuredDimension(s(i2, paddingRight, Z()), s(i3, paddingBottom, Y()));
        }

        public int d0(t tVar, x xVar) {
            return -1;
        }

        public void d1(int i2, int i3) {
            int K = K();
            if (K == 0) {
                this.g.n(i2, i3);
                return;
            }
            int i4 = RtlSpacingHelper.UNDEFINED;
            int i5 = RtlSpacingHelper.UNDEFINED;
            int i6 = Integer.MAX_VALUE;
            int i7 = Integer.MAX_VALUE;
            for (int i8 = 0; i8 < K; i8++) {
                View J = J(i8);
                Rect rect = this.g.n;
                O(J, rect);
                int i9 = rect.left;
                if (i9 < i6) {
                    i6 = i9;
                }
                int i10 = rect.right;
                if (i10 > i4) {
                    i4 = i10;
                }
                int i11 = rect.top;
                if (i11 < i7) {
                    i7 = i11;
                }
                int i12 = rect.bottom;
                if (i12 > i5) {
                    i5 = i12;
                }
            }
            this.g.n.set(i6, i7, i4, i5);
            c1(this.g.n, i2, i3);
        }

        public int e0() {
            return 0;
        }

        public void e1(RecyclerView recyclerView) {
            if (recyclerView == null) {
                this.g = null;
                this.f = null;
                this.v = 0;
                this.w = 0;
            } else {
                this.g = recyclerView;
                this.f = recyclerView.j;
                this.v = recyclerView.getWidth();
                this.w = recyclerView.getHeight();
            }
            this.t = CommonUtils.BYTES_IN_A_GIGABYTE;
            this.u = CommonUtils.BYTES_IN_A_GIGABYTE;
        }

        public int f0(View view) {
            return ((n) view.getLayoutParams()).g.top;
        }

        public boolean f1(View view, int i2, int i3, n nVar) {
            return view.isLayoutRequested() || !this.p || !j0(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) nVar).width) || !j0(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) nVar).height);
        }

        public void g0(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((n) view.getLayoutParams()).g;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.g == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.g.p;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public boolean g1() {
            return false;
        }

        public int getPaddingBottom() {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public int getPaddingEnd() {
            RecyclerView recyclerView = this.g;
            if (recyclerView == null) {
                return 0;
            }
            AtomicInteger atomicInteger = r8.f3055a;
            return recyclerView.getPaddingEnd();
        }

        public int getPaddingLeft() {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int getPaddingRight() {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int getPaddingStart() {
            RecyclerView recyclerView = this.g;
            if (recyclerView == null) {
                return 0;
            }
            AtomicInteger atomicInteger = r8.f3055a;
            return recyclerView.getPaddingStart();
        }

        public int getPaddingTop() {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public boolean h0() {
            return this.o;
        }

        public boolean h1(View view, int i2, int i3, n nVar) {
            return !this.p || !j0(view.getMeasuredWidth(), i2, ((ViewGroup.MarginLayoutParams) nVar).width) || !j0(view.getMeasuredHeight(), i3, ((ViewGroup.MarginLayoutParams) nVar).height);
        }

        public boolean i0() {
            return false;
        }

        public void i1(RecyclerView recyclerView, x xVar, int i2) {
        }

        public void j1(w wVar) {
            w wVar2 = this.l;
            if (!(wVar2 == null || wVar == wVar2 || !wVar2.e)) {
                wVar2.c();
            }
            this.l = wVar;
            RecyclerView recyclerView = this.g;
            Objects.requireNonNull(wVar);
            recyclerView.k0.c();
            if (wVar.h) {
                wVar.getClass().getSimpleName();
                wVar.getClass().getSimpleName();
            }
            wVar.b = recyclerView;
            wVar.c = this;
            int i2 = wVar.f242a;
            if (i2 != -1) {
                recyclerView.n0.f244a = i2;
                wVar.e = true;
                wVar.d = true;
                wVar.f = recyclerView.r.E(i2);
                wVar.b.k0.a();
                wVar.h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public boolean k0(View view, boolean z) {
            boolean z2 = this.j.b(view, 24579) && this.k.b(view, 24579);
            return z ? z2 : !z2;
        }

        public boolean k1() {
            return false;
        }

        public void l(View view) {
            m(view, -1, false);
        }

        public void l0(View view, int i2, int i3, int i4, int i5) {
            n nVar = (n) view.getLayoutParams();
            Rect rect = nVar.g;
            view.layout(i2 + rect.left + ((ViewGroup.MarginLayoutParams) nVar).leftMargin, i3 + rect.top + ((ViewGroup.MarginLayoutParams) nVar).topMargin, (i4 - rect.right) - ((ViewGroup.MarginLayoutParams) nVar).rightMargin, (i5 - rect.bottom) - ((ViewGroup.MarginLayoutParams) nVar).bottomMargin);
        }

        public final void m(View view, int i2, boolean z) {
            a0 K = RecyclerView.K(view);
            if (z || K.isRemoved()) {
                this.g.k.a(K);
            } else {
                this.g.k.f(K);
            }
            n nVar = (n) view.getLayoutParams();
            if (K.wasReturnedFromScrap() || K.isScrap()) {
                if (K.isScrap()) {
                    K.unScrap();
                } else {
                    K.clearReturnedFromScrapFlag();
                }
                this.f.b(view, i2, view.getLayoutParams(), false);
            } else {
                int i3 = -1;
                if (view.getParent() == this.g) {
                    int j2 = this.f.j(view);
                    if (i2 == -1) {
                        i2 = this.f.e();
                    }
                    if (j2 == -1) {
                        StringBuilder i0 = hj1.i0("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        i0.append(this.g.indexOfChild(view));
                        throw new IllegalStateException(hj1.A(this.g, i0));
                    } else if (j2 != i2) {
                        m mVar = this.g.r;
                        View J = mVar.J(j2);
                        if (J != null) {
                            mVar.J(j2);
                            mVar.C(j2);
                            n nVar2 = (n) J.getLayoutParams();
                            a0 K2 = RecyclerView.K(J);
                            if (K2.isRemoved()) {
                                mVar.g.k.a(K2);
                            } else {
                                mVar.g.k.f(K2);
                            }
                            mVar.f.b(J, i2, nVar2, K2.isRemoved());
                        } else {
                            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j2 + mVar.g.toString());
                        }
                    }
                } else {
                    this.f.a(view, i2, false);
                    nVar.h = true;
                    w wVar = this.l;
                    if (wVar != null && wVar.e) {
                        Objects.requireNonNull(wVar.b);
                        a0 K3 = RecyclerView.K(view);
                        if (K3 != null) {
                            i3 = K3.getLayoutPosition();
                        }
                        if (i3 == wVar.f242a) {
                            wVar.f = view;
                        }
                    }
                }
            }
            if (nVar.i) {
                K.itemView.invalidate();
                nVar.i = false;
            }
        }

        public void m0(int i2) {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                int e = recyclerView.j.e();
                for (int i3 = 0; i3 < e; i3++) {
                    recyclerView.j.d(i3).offsetLeftAndRight(i2);
                }
            }
        }

        public void n(String str) {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                recyclerView.h(str);
            }
        }

        public void n0(int i2) {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null) {
                int e = recyclerView.j.e();
                for (int i3 = 0; i3 < e; i3++) {
                    recyclerView.j.d(i3).offsetTopAndBottom(i2);
                }
            }
        }

        public void o(View view, Rect rect) {
            RecyclerView recyclerView = this.g;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.L(view));
            }
        }

        public void o0(e eVar, e eVar2) {
        }

        public boolean p() {
            return false;
        }

        /* JADX WARN: Incorrect args count in method signature: (Landroidx/recyclerview/widget/RecyclerView;Ljava/util/ArrayList<Landroid/view/View;>;II)Z */
        public boolean p0() {
            return false;
        }

        public boolean q() {
            return false;
        }

        public void q0(RecyclerView recyclerView) {
        }

        public boolean r(n nVar) {
            return nVar != null;
        }

        @Deprecated
        public void r0() {
        }

        public void s0(RecyclerView recyclerView, t tVar) {
            r0();
        }

        public void t(int i2, int i3, x xVar, c cVar) {
        }

        public View t0(View view, int i2, t tVar, x xVar) {
            return null;
        }

        public void u(int i2, c cVar) {
        }

        public void u0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.g;
            t tVar = recyclerView.g;
            x xVar = recyclerView.n0;
            v0(accessibilityEvent);
        }

        public int v(x xVar) {
            return 0;
        }

        public void v0(AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.g;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z = true;
                if (!recyclerView.canScrollVertically(1) && !this.g.canScrollVertically(-1) && !this.g.canScrollHorizontally(-1) && !this.g.canScrollHorizontally(1)) {
                    z = false;
                }
                accessibilityEvent.setScrollable(z);
                e eVar = this.g.q;
                if (eVar != null) {
                    accessibilityEvent.setItemCount(eVar.getItemCount());
                }
            }
        }

        public int w(x xVar) {
            return 0;
        }

        public void w0(t tVar, x xVar, e9 e9Var) {
            if (this.g.canScrollVertically(-1) || this.g.canScrollHorizontally(-1)) {
                e9Var.f942a.addAction(a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                e9Var.f942a.setScrollable(true);
            }
            if (this.g.canScrollVertically(1) || this.g.canScrollHorizontally(1)) {
                e9Var.f942a.addAction(4096);
                e9Var.f942a.setScrollable(true);
            }
            e9Var.m(e9.b.a(d0(tVar, xVar), M(tVar, xVar), i0(), e0()));
        }

        public int x(x xVar) {
            return 0;
        }

        public void x0(View view, e9 e9Var) {
            a0 K = RecyclerView.K(view);
            if (K != null && !K.isRemoved() && !this.f.k(K.itemView)) {
                RecyclerView recyclerView = this.g;
                y0(recyclerView.g, recyclerView.n0, view, e9Var);
            }
        }

        public int y(x xVar) {
            return 0;
        }

        public void y0(t tVar, x xVar, View view, e9 e9Var) {
        }

        public int z(x xVar) {
            return 0;
        }

        public View z0() {
            return null;
        }
    }

    public interface o {
        void a(View view);

        void b(View view);
    }

    public static abstract class p {
    }

    public interface q {
        void a(RecyclerView recyclerView, MotionEvent motionEvent);

        boolean b(RecyclerView recyclerView, MotionEvent motionEvent);

        void c(boolean z);
    }

    public static abstract class r {
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        }

        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        }
    }

    public static class s {

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<a> f238a = new SparseArray<>();
        public int b = 0;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public final ArrayList<a0> f239a = new ArrayList<>();
            public int b = 5;
            public long c = 0;
            public long d = 0;
        }

        public final a a(int i) {
            a aVar = this.f238a.get(i);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f238a.put(i, aVar2);
            return aVar2;
        }

        public long b(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }
    }

    public final class t {

        /* renamed from: a  reason: collision with root package name */
        public final ArrayList<a0> f240a;
        public ArrayList<a0> b = null;
        public final ArrayList<a0> c = new ArrayList<>();
        public final List<a0> d;
        public int e;
        public int f;
        public s g;

        public t() {
            ArrayList<a0> arrayList = new ArrayList<>();
            this.f240a = arrayList;
            this.d = Collections.unmodifiableList(arrayList);
            this.e = 2;
            this.f = 2;
        }

        public void a(a0 a0Var, boolean z) {
            RecyclerView.j(a0Var);
            View view = a0Var.itemView;
            zk zkVar = RecyclerView.this.u0;
            if (zkVar != null) {
                zk.a aVar = zkVar.e;
                r8.v(view, aVar instanceof zk.a ? aVar.e.remove(view) : null);
            }
            if (z) {
                u uVar = RecyclerView.this.s;
                if (uVar != null) {
                    uVar.a(a0Var);
                }
                int size = RecyclerView.this.t.size();
                for (int i = 0; i < size; i++) {
                    RecyclerView.this.t.get(i).a(a0Var);
                }
                e eVar = RecyclerView.this.q;
                if (eVar != null) {
                    eVar.onViewRecycled(a0Var);
                }
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.n0 != null) {
                    recyclerView.k.g(a0Var);
                }
            }
            a0Var.mBindingAdapter = null;
            a0Var.mOwnerRecyclerView = null;
            s d2 = d();
            Objects.requireNonNull(d2);
            int itemViewType = a0Var.getItemViewType();
            ArrayList<a0> arrayList = d2.a(itemViewType).f239a;
            if (d2.f238a.get(itemViewType).b > arrayList.size()) {
                a0Var.resetInternal();
                arrayList.add(a0Var);
            }
        }

        public void b() {
            this.f240a.clear();
            f();
        }

        public int c(int i) {
            if (i < 0 || i >= RecyclerView.this.n0.b()) {
                StringBuilder j0 = hj1.j0("invalid position ", i, ". State item count is ");
                j0.append(RecyclerView.this.n0.b());
                throw new IndexOutOfBoundsException(hj1.A(RecyclerView.this, j0));
            }
            RecyclerView recyclerView = RecyclerView.this;
            if (!recyclerView.n0.g) {
                return i;
            }
            return recyclerView.i.f(i, 0);
        }

        public s d() {
            if (this.g == null) {
                this.g = new s();
            }
            return this.g;
        }

        public View e(int i) {
            return k(i, false, Long.MAX_VALUE).itemView;
        }

        public void f() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                g(size);
            }
            this.c.clear();
            if (RecyclerView.K0) {
                lk.b bVar = RecyclerView.this.m0;
                int[] iArr = bVar.c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.d = 0;
            }
        }

        public void g(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        public void h(View view) {
            a0 K = RecyclerView.K(view);
            if (K.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (K.isScrap()) {
                K.unScrap();
            } else if (K.wasReturnedFromScrap()) {
                K.clearReturnedFromScrapFlag();
            }
            i(K);
            if (RecyclerView.this.S != null && !K.isRecyclable()) {
                RecyclerView.this.S.e(K);
            }
        }

        public void i(a0 a0Var) {
            boolean z = false;
            boolean z2 = true;
            if (a0Var.isScrap() || a0Var.itemView.getParent() != null) {
                StringBuilder i0 = hj1.i0("Scrapped or attached views may not be recycled. isScrap:");
                i0.append(a0Var.isScrap());
                i0.append(" isAttached:");
                if (a0Var.itemView.getParent() != null) {
                    z = true;
                }
                i0.append(z);
                throw new IllegalArgumentException(hj1.A(RecyclerView.this, i0));
            } else if (a0Var.isTmpDetached()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(a0Var);
                throw new IllegalArgumentException(hj1.A(RecyclerView.this, sb));
            } else if (!a0Var.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = a0Var.doesTransientStatePreventRecycling();
                e eVar = RecyclerView.this.q;
                if ((eVar != null && doesTransientStatePreventRecycling && eVar.onFailedToRecycleView(a0Var)) || a0Var.isRecyclable()) {
                    if (this.f <= 0 || a0Var.hasAnyOfTheFlags(526)) {
                        z = false;
                    } else {
                        int size = this.c.size();
                        if (size >= this.f && size > 0) {
                            g(0);
                            size--;
                        }
                        if (RecyclerView.K0 && size > 0 && !RecyclerView.this.m0.c(a0Var.mPosition)) {
                            do {
                                size--;
                                if (size < 0) {
                                    break;
                                }
                            } while (RecyclerView.this.m0.c(this.c.get(size).mPosition));
                            size++;
                        }
                        this.c.add(size, a0Var);
                        z = true;
                    }
                    if (!z) {
                        a(a0Var, true);
                        RecyclerView.this.k.g(a0Var);
                        if (!z && !z2 && doesTransientStatePreventRecycling) {
                            a0Var.mBindingAdapter = null;
                            a0Var.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                }
                z2 = false;
                RecyclerView.this.k.g(a0Var);
                if (!z) {
                }
            } else {
                throw new IllegalArgumentException(hj1.A(RecyclerView.this, hj1.i0("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void j(android.view.View r5) {
            /*
            // Method dump skipped, instructions count: 137
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.t.j(android.view.View):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:156:0x0318, code lost:
            r7 = r14;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:160:0x0323, code lost:
            r7 = null;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:224:0x047a, code lost:
            if ((r8 == 0 || r8 + r5 < r21) == false) goto L_0x047c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:124:0x025d  */
        /* JADX WARNING: Removed duplicated region for block: B:204:0x040f  */
        /* JADX WARNING: Removed duplicated region for block: B:218:0x0463  */
        /* JADX WARNING: Removed duplicated region for block: B:233:0x04af  */
        /* JADX WARNING: Removed duplicated region for block: B:247:0x04e5  */
        /* JADX WARNING: Removed duplicated region for block: B:251:0x04f0  */
        /* JADX WARNING: Removed duplicated region for block: B:252:0x04fe  */
        /* JADX WARNING: Removed duplicated region for block: B:258:0x051a A[ADDED_TO_REGION] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x008f  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0096  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.a0 k(int r19, boolean r20, long r21) {
            /*
            // Method dump skipped, instructions count: 1363
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.t.k(int, boolean, long):androidx.recyclerview.widget.RecyclerView$a0");
        }

        public void l(a0 a0Var) {
            if (a0Var.mInChangeScrap) {
                this.b.remove(a0Var);
            } else {
                this.f240a.remove(a0Var);
            }
            a0Var.mScrapContainer = null;
            a0Var.mInChangeScrap = false;
            a0Var.clearReturnedFromScrapFlag();
        }

        public void m() {
            m mVar = RecyclerView.this.r;
            this.f = this.e + (mVar != null ? mVar.r : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                g(size);
            }
        }
    }

    public interface u {
        void a(a0 a0Var);
    }

    public class v extends g {
        public v() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void a() {
            RecyclerView.this.h(null);
            RecyclerView recyclerView = RecyclerView.this;
            recyclerView.n0.f = true;
            recyclerView.b0(true);
            if (!RecyclerView.this.i.g()) {
                RecyclerView.this.requestLayout();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void c(int i, int i2, Object obj) {
            RecyclerView.this.h(null);
            sj sjVar = RecyclerView.this.i;
            Objects.requireNonNull(sjVar);
            boolean z = false;
            if (i2 >= 1) {
                sjVar.b.add(sjVar.h(4, i, i2, obj));
                sjVar.f |= 4;
                if (sjVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void d(int i, int i2) {
            RecyclerView.this.h(null);
            sj sjVar = RecyclerView.this.i;
            Objects.requireNonNull(sjVar);
            boolean z = false;
            if (i2 >= 1) {
                sjVar.b.add(sjVar.h(1, i, i2, null));
                sjVar.f |= 1;
                if (sjVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void e(int i, int i2, int i3) {
            RecyclerView.this.h(null);
            sj sjVar = RecyclerView.this.i;
            Objects.requireNonNull(sjVar);
            boolean z = false;
            if (i != i2) {
                if (i3 == 1) {
                    sjVar.b.add(sjVar.h(8, i, i2, null));
                    sjVar.f |= 8;
                    if (sjVar.b.size() == 1) {
                        z = true;
                    }
                } else {
                    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void f(int i, int i2) {
            RecyclerView.this.h(null);
            sj sjVar = RecyclerView.this.i;
            Objects.requireNonNull(sjVar);
            boolean z = false;
            if (i2 >= 1) {
                sjVar.b.add(sjVar.h(2, i, i2, null));
                sjVar.f |= 2;
                if (sjVar.b.size() == 1) {
                    z = true;
                }
            }
            if (z) {
                h();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void g() {
            e eVar;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.h != null && (eVar = recyclerView.q) != null && eVar.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void h() {
            if (RecyclerView.J0) {
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.y && recyclerView.x) {
                    Runnable runnable = recyclerView.m;
                    AtomicInteger atomicInteger = r8.f3055a;
                    recyclerView.postOnAnimation(runnable);
                    return;
                }
            }
            RecyclerView recyclerView2 = RecyclerView.this;
            recyclerView2.G = true;
            recyclerView2.requestLayout();
        }
    }

    public static abstract class w {

        /* renamed from: a  reason: collision with root package name */
        public int f242a = -1;
        public RecyclerView b;
        public m c;
        public boolean d;
        public boolean e;
        public View f;
        public final a g = new a(0, 0);
        public boolean h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public int f243a;
            public int b;
            public int c;
            public int d = -1;
            public Interpolator e;
            public boolean f = false;
            public int g = 0;

            public a(int i, int i2) {
                this.f243a = i;
                this.b = i2;
                this.c = RtlSpacingHelper.UNDEFINED;
                this.e = null;
            }

            public void a(RecyclerView recyclerView) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    recyclerView.P(i);
                    this.f = false;
                } else if (this.f) {
                    Interpolator interpolator = this.e;
                    if (interpolator == null || this.c >= 1) {
                        int i2 = this.c;
                        if (i2 >= 1) {
                            recyclerView.k0.b(this.f243a, this.b, i2, interpolator);
                            this.g++;
                            this.f = false;
                            return;
                        }
                        throw new IllegalStateException("Scroll duration must be a positive number");
                    }
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else {
                    this.g = 0;
                }
            }

            public void b(int i, int i2, int i3, Interpolator interpolator) {
                this.f243a = i;
                this.b = i2;
                this.c = i3;
                this.e = interpolator;
                this.f = true;
            }
        }

        public interface b {
            PointF a(int i);
        }

        public void a(int i, int i2) {
            m mVar;
            RecyclerView recyclerView = this.b;
            int i3 = -1;
            if (this.f242a == -1 || recyclerView == null) {
                c();
            }
            PointF pointF = null;
            if (this.d && this.f == null && (mVar = this.c) != null) {
                PointF a2 = mVar instanceof b ? ((b) mVar).a(this.f242a) : null;
                if (a2 != null) {
                    float f2 = a2.x;
                    if (!(f2 == 0.0f && a2.y == 0.0f)) {
                        recyclerView.h0((int) Math.signum(f2), (int) Math.signum(a2.y), null);
                    }
                }
            }
            boolean z = false;
            this.d = false;
            View view = this.f;
            if (view != null) {
                Objects.requireNonNull(this.b);
                a0 K = RecyclerView.K(view);
                if (K != null) {
                    i3 = K.getLayoutPosition();
                }
                if (i3 == this.f242a) {
                    b(this.f, recyclerView.n0, this.g);
                    this.g.a(recyclerView);
                    c();
                } else {
                    this.f = null;
                }
            }
            if (this.e) {
                x xVar = recyclerView.n0;
                a aVar = this.g;
                nk nkVar = (nk) this;
                if (nkVar.b.r.K() == 0) {
                    nkVar.c();
                } else {
                    int i4 = nkVar.o;
                    int i5 = i4 - i;
                    if (i4 * i5 <= 0) {
                        i5 = 0;
                    }
                    nkVar.o = i5;
                    int i6 = nkVar.p;
                    int i7 = i6 - i2;
                    if (i6 * i7 <= 0) {
                        i7 = 0;
                    }
                    nkVar.p = i7;
                    if (i5 == 0 && i7 == 0) {
                        int i8 = nkVar.f242a;
                        m mVar2 = nkVar.c;
                        if (mVar2 instanceof b) {
                            pointF = ((b) mVar2).a(i8);
                        }
                        if (pointF != null) {
                            float f3 = pointF.x;
                            if (!(f3 == 0.0f && pointF.y == 0.0f)) {
                                float f4 = pointF.y;
                                float sqrt = (float) Math.sqrt((double) ((f4 * f4) + (f3 * f3)));
                                float f5 = pointF.x / sqrt;
                                pointF.x = f5;
                                float f6 = pointF.y / sqrt;
                                pointF.y = f6;
                                nkVar.k = pointF;
                                nkVar.o = (int) (f5 * 10000.0f);
                                nkVar.p = (int) (f6 * 10000.0f);
                                aVar.b((int) (((float) nkVar.o) * 1.2f), (int) (((float) nkVar.p) * 1.2f), (int) (((float) nkVar.f(10000)) * 1.2f), nkVar.i);
                            }
                        }
                        aVar.d = nkVar.f242a;
                        nkVar.c();
                    }
                }
                a aVar2 = this.g;
                if (aVar2.d >= 0) {
                    z = true;
                }
                aVar2.a(recyclerView);
                if (z && this.e) {
                    this.d = true;
                    recyclerView.k0.a();
                }
            }
        }

        public abstract void b(View view, x xVar, a aVar);

        public final void c() {
            if (this.e) {
                this.e = false;
                nk nkVar = (nk) this;
                nkVar.p = 0;
                nkVar.o = 0;
                nkVar.k = null;
                this.b.n0.f244a = -1;
                this.f = null;
                this.f242a = -1;
                this.d = false;
                m mVar = this.c;
                if (mVar.l == this) {
                    mVar.l = null;
                }
                this.c = null;
                this.b = null;
            }
        }
    }

    public static class x {

        /* renamed from: a  reason: collision with root package name */
        public int f244a = -1;
        public int b = 0;
        public int c = 0;
        public int d = 1;
        public int e = 0;
        public boolean f = false;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public int l;
        public long m;
        public int n;

        public void a(int i2) {
            if ((this.d & i2) == 0) {
                StringBuilder i0 = hj1.i0("Layout state should be one of ");
                i0.append(Integer.toBinaryString(i2));
                i0.append(" but it is ");
                i0.append(Integer.toBinaryString(this.d));
                throw new IllegalStateException(i0.toString());
            }
        }

        public int b() {
            if (this.g) {
                return this.b - this.c;
            }
            return this.e;
        }

        public String toString() {
            StringBuilder i0 = hj1.i0("State{mTargetPosition=");
            i0.append(this.f244a);
            i0.append(", mData=");
            i0.append((Object) null);
            i0.append(", mItemCount=");
            i0.append(this.e);
            i0.append(", mIsMeasuring=");
            i0.append(this.i);
            i0.append(", mPreviousLayoutItemCount=");
            i0.append(this.b);
            i0.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            i0.append(this.c);
            i0.append(", mStructureChanged=");
            i0.append(this.f);
            i0.append(", mInPreLayout=");
            i0.append(this.g);
            i0.append(", mRunSimpleAnimations=");
            i0.append(this.j);
            i0.append(", mRunPredictiveAnimations=");
            i0.append(this.k);
            i0.append('}');
            return i0.toString();
        }
    }

    public static abstract class y {
    }

    public class z implements Runnable {
        public int f;
        public int g;
        public OverScroller h;
        public Interpolator i;
        public boolean j = false;
        public boolean k = false;

        public z() {
            Interpolator interpolator = RecyclerView.M0;
            this.i = interpolator;
            this.h = new OverScroller(RecyclerView.this.getContext(), interpolator);
        }

        public void a() {
            if (this.j) {
                this.k = true;
                return;
            }
            RecyclerView.this.removeCallbacks(this);
            RecyclerView recyclerView = RecyclerView.this;
            AtomicInteger atomicInteger = r8.f3055a;
            recyclerView.postOnAnimation(this);
        }

        public void b(int i2, int i3, int i4, Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                int abs = Math.abs(i2);
                int abs2 = Math.abs(i3);
                boolean z = abs > abs2;
                RecyclerView recyclerView = RecyclerView.this;
                int width = z ? recyclerView.getWidth() : recyclerView.getHeight();
                if (!z) {
                    abs = abs2;
                }
                i4 = Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), (int) Constants.MAX_URL_LENGTH);
            }
            if (interpolator == null) {
                interpolator = RecyclerView.M0;
            }
            if (this.i != interpolator) {
                this.i = interpolator;
                this.h = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.g = 0;
            this.f = 0;
            RecyclerView.this.setScrollState(2);
            this.h.startScroll(0, 0, i2, i3, i4);
            if (Build.VERSION.SDK_INT < 23) {
                this.h.computeScrollOffset();
            }
            a();
        }

        public void c() {
            RecyclerView.this.removeCallbacks(this);
            this.h.abortAnimation();
        }

        public void run() {
            int i2;
            int i3;
            RecyclerView recyclerView = RecyclerView.this;
            if (recyclerView.r == null) {
                c();
                return;
            }
            this.k = false;
            this.j = true;
            recyclerView.m();
            OverScroller overScroller = this.h;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.f;
                int i5 = currY - this.g;
                this.f = currX;
                this.g = currY;
                RecyclerView recyclerView2 = RecyclerView.this;
                int[] iArr = recyclerView2.A0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (recyclerView2.s(i4, i5, iArr, null, 1)) {
                    int[] iArr2 = RecyclerView.this.A0;
                    i4 -= iArr2[0];
                    i5 -= iArr2[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.l(i4, i5);
                }
                RecyclerView recyclerView3 = RecyclerView.this;
                if (recyclerView3.q != null) {
                    int[] iArr3 = recyclerView3.A0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    recyclerView3.h0(i4, i5, iArr3);
                    RecyclerView recyclerView4 = RecyclerView.this;
                    int[] iArr4 = recyclerView4.A0;
                    i2 = iArr4[0];
                    i3 = iArr4[1];
                    i4 -= i2;
                    i5 -= i3;
                    w wVar = recyclerView4.r.l;
                    if (wVar != null && !wVar.d && wVar.e) {
                        int b = recyclerView4.n0.b();
                        if (b == 0) {
                            wVar.c();
                        } else if (wVar.f242a >= b) {
                            wVar.f242a = b - 1;
                            wVar.a(i2, i3);
                        } else {
                            wVar.a(i2, i3);
                        }
                    }
                } else {
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.u.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView recyclerView5 = RecyclerView.this;
                int[] iArr5 = recyclerView5.A0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                recyclerView5.t(i2, i3, i4, i5, null, 1, iArr5);
                RecyclerView recyclerView6 = RecyclerView.this;
                int[] iArr6 = recyclerView6.A0;
                int i6 = i4 - iArr6[0];
                int i7 = i5 - iArr6[1];
                if (!(i2 == 0 && i3 == 0)) {
                    recyclerView6.u(i2, i3);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                RecyclerView recyclerView7 = RecyclerView.this;
                w wVar2 = recyclerView7.r.l;
                if ((wVar2 != null && wVar2.d) || !z) {
                    a();
                    RecyclerView recyclerView8 = RecyclerView.this;
                    lk lkVar = recyclerView8.l0;
                    if (lkVar != null) {
                        lkVar.a(recyclerView8, i2, i3);
                    }
                } else {
                    if (recyclerView7.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView recyclerView9 = RecyclerView.this;
                        Objects.requireNonNull(recyclerView9);
                        if (i8 < 0) {
                            recyclerView9.w();
                            if (recyclerView9.O.isFinished()) {
                                recyclerView9.O.onAbsorb(-i8);
                            }
                        } else if (i8 > 0) {
                            recyclerView9.x();
                            if (recyclerView9.Q.isFinished()) {
                                recyclerView9.Q.onAbsorb(i8);
                            }
                        }
                        if (currVelocity < 0) {
                            recyclerView9.y();
                            if (recyclerView9.P.isFinished()) {
                                recyclerView9.P.onAbsorb(-currVelocity);
                            }
                        } else if (currVelocity > 0) {
                            recyclerView9.v();
                            if (recyclerView9.R.isFinished()) {
                                recyclerView9.R.onAbsorb(currVelocity);
                            }
                        }
                        if (!(i8 == 0 && currVelocity == 0)) {
                            AtomicInteger atomicInteger = r8.f3055a;
                            recyclerView9.postInvalidateOnAnimation();
                        }
                    }
                    if (RecyclerView.K0) {
                        lk.b bVar = RecyclerView.this.m0;
                        int[] iArr7 = bVar.c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.d = 0;
                    }
                }
            }
            w wVar3 = RecyclerView.this.r.l;
            if (wVar3 != null && wVar3.d) {
                wVar3.a(0, 0);
            }
            this.j = false;
            if (this.k) {
                RecyclerView.this.removeCallbacks(this);
                RecyclerView recyclerView10 = RecyclerView.this;
                AtomicInteger atomicInteger2 = r8.f3055a;
                recyclerView10.postOnAnimation(this);
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.p0(1);
        }
    }

    static {
        Class<?> cls = Integer.TYPE;
        L0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public static RecyclerView E(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView E2 = E(viewGroup.getChildAt(i2));
            if (E2 != null) {
                return E2;
            }
        }
        return null;
    }

    public static a0 K(View view) {
        if (view == null) {
            return null;
        }
        return ((n) view.getLayoutParams()).f;
    }

    private i8 getScrollingChildHelper() {
        if (this.x0 == null) {
            this.x0 = new i8(this);
        }
        return this.x0;
    }

    public static void j(a0 a0Var) {
        WeakReference<RecyclerView> weakReference = a0Var.mNestedRecyclerView;
        if (weakReference != null) {
            RecyclerView recyclerView = weakReference.get();
            while (recyclerView != null) {
                if (recyclerView != a0Var.itemView) {
                    ViewParent parent = recyclerView.getParent();
                    recyclerView = parent instanceof View ? (View) parent : null;
                } else {
                    return;
                }
            }
            a0Var.mNestedRecyclerView = null;
        }
    }

    public final void A(x xVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.k0.h;
            overScroller.getFinalX();
            overScroller.getCurrX();
            Objects.requireNonNull(xVar);
            overScroller.getFinalY();
            overScroller.getCurrY();
            return;
        }
        Objects.requireNonNull(xVar);
    }

    public View B(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = (View) parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    public final boolean C(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            q qVar = this.v.get(i2);
            if (qVar.b(this, motionEvent) && action != 3) {
                this.w = qVar;
                return true;
            }
        }
        return false;
    }

    public final void D(int[] iArr) {
        int e2 = this.j.e();
        if (e2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MAX_VALUE;
        int i3 = RtlSpacingHelper.UNDEFINED;
        for (int i4 = 0; i4 < e2; i4++) {
            a0 K2 = K(this.j.d(i4));
            if (!K2.shouldIgnore()) {
                int layoutPosition = K2.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    public a0 F(int i2) {
        a0 a0Var = null;
        if (this.J) {
            return null;
        }
        int h2 = this.j.h();
        for (int i3 = 0; i3 < h2; i3++) {
            a0 K2 = K(this.j.g(i3));
            if (K2 != null && !K2.isRemoved() && G(K2) == i2) {
                if (!this.j.k(K2.itemView)) {
                    return K2;
                }
                a0Var = K2;
            }
        }
        return a0Var;
    }

    public int G(a0 a0Var) {
        if (!a0Var.hasAnyOfTheFlags(524) && a0Var.isBound()) {
            sj sjVar = this.i;
            int i2 = a0Var.mPosition;
            int size = sjVar.b.size();
            for (int i3 = 0; i3 < size; i3++) {
                sj.b bVar = sjVar.b.get(i3);
                int i4 = bVar.f3219a;
                if (i4 != 1) {
                    if (i4 == 2) {
                        int i5 = bVar.b;
                        if (i5 <= i2) {
                            int i6 = bVar.d;
                            if (i5 + i6 <= i2) {
                                i2 -= i6;
                            }
                        } else {
                            continue;
                        }
                    } else if (i4 == 8) {
                        int i7 = bVar.b;
                        if (i7 == i2) {
                            i2 = bVar.d;
                        } else {
                            if (i7 < i2) {
                                i2--;
                            }
                            if (bVar.d <= i2) {
                                i2++;
                            }
                        }
                    }
                } else if (bVar.b <= i2) {
                    i2 += bVar.d;
                }
            }
            return i2;
        }
        return -1;
    }

    public long H(a0 a0Var) {
        return this.q.hasStableIds() ? a0Var.getItemId() : (long) a0Var.mPosition;
    }

    public int I(View view) {
        a0 K2 = K(view);
        if (K2 != null) {
            return K2.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public a0 J(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return K(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public Rect L(View view) {
        n nVar = (n) view.getLayoutParams();
        if (!nVar.h) {
            return nVar.g;
        }
        if (this.n0.g && (nVar.b() || nVar.f.isInvalid())) {
            return nVar.g;
        }
        Rect rect = nVar.g;
        rect.set(0, 0, 0, 0);
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.n.set(0, 0, 0, 0);
            this.u.get(i2).getItemOffsets(this.n, view, this, this.n0);
            int i3 = rect.left;
            Rect rect2 = this.n;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        nVar.h = false;
        return rect;
    }

    public boolean M() {
        return !this.A || this.J || this.i.g();
    }

    public void N() {
        this.R = null;
        this.P = null;
        this.Q = null;
        this.O = null;
    }

    public boolean O() {
        return this.L > 0;
    }

    public void P(int i2) {
        if (this.r != null) {
            setScrollState(2);
            this.r.Y0(i2);
            awakenScrollBars();
        }
    }

    public void Q() {
        int h2 = this.j.h();
        for (int i2 = 0; i2 < h2; i2++) {
            ((n) this.j.g(i2).getLayoutParams()).h = true;
        }
        t tVar = this.g;
        int size = tVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            n nVar = (n) tVar.c.get(i3).itemView.getLayoutParams();
            if (nVar != null) {
                nVar.h = true;
            }
        }
    }

    public void R(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int h2 = this.j.h();
        for (int i5 = 0; i5 < h2; i5++) {
            a0 K2 = K(this.j.g(i5));
            if (K2 != null && !K2.shouldIgnore()) {
                int i6 = K2.mPosition;
                if (i6 >= i4) {
                    K2.offsetPosition(-i3, z2);
                    this.n0.f = true;
                } else if (i6 >= i2) {
                    K2.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                    this.n0.f = true;
                }
            }
        }
        t tVar = this.g;
        int size = tVar.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                a0 a0Var = tVar.c.get(size);
                if (a0Var != null) {
                    int i7 = a0Var.mPosition;
                    if (i7 >= i4) {
                        a0Var.offsetPosition(-i3, z2);
                    } else if (i7 >= i2) {
                        a0Var.addFlags(8);
                        tVar.g(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    public void S() {
    }

    public void T() {
    }

    public void U() {
        this.L++;
    }

    public void V(boolean z2) {
        int i2;
        boolean z3 = true;
        int i3 = this.L - 1;
        this.L = i3;
        if (i3 < 1) {
            this.L = 0;
            if (z2) {
                int i4 = this.F;
                this.F = 0;
                if (i4 != 0) {
                    AccessibilityManager accessibilityManager = this.H;
                    if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
                        z3 = false;
                    }
                    if (z3) {
                        AccessibilityEvent obtain = AccessibilityEvent.obtain();
                        obtain.setEventType(2048);
                        obtain.setContentChangeTypes(i4);
                        sendAccessibilityEventUnchecked(obtain);
                    }
                }
                for (int size = this.B0.size() - 1; size >= 0; size--) {
                    a0 a0Var = this.B0.get(size);
                    if (a0Var.itemView.getParent() == this && !a0Var.shouldIgnore() && (i2 = a0Var.mPendingAccessibilityState) != -1) {
                        View view = a0Var.itemView;
                        AtomicInteger atomicInteger = r8.f3055a;
                        view.setImportantForAccessibility(i2);
                        a0Var.mPendingAccessibilityState = -1;
                    }
                }
                this.B0.clear();
            }
        }
    }

    public final void W(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.U) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.U = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.b0 = x2;
            this.W = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.c0 = y2;
            this.a0 = y2;
        }
    }

    public void X() {
    }

    public void Y() {
    }

    public void Z() {
        if (!this.t0 && this.x) {
            Runnable runnable = this.C0;
            AtomicInteger atomicInteger = r8.f3055a;
            postOnAnimation(runnable);
            this.t0 = true;
        }
    }

    public final void a0() {
        boolean z2;
        boolean z3 = false;
        if (this.J) {
            sj sjVar = this.i;
            sjVar.l(sjVar.b);
            sjVar.l(sjVar.c);
            sjVar.f = 0;
            if (this.K) {
                this.r.B0(this);
            }
        }
        if (this.S != null && this.r.k1()) {
            this.i.j();
        } else {
            this.i.c();
        }
        boolean z4 = this.q0 || this.r0;
        this.n0.j = this.A && this.S != null && ((z2 = this.J) || z4 || this.r.m) && (!z2 || this.q.hasStableIds());
        x xVar = this.n0;
        if (xVar.j && z4 && !this.J) {
            if (this.S != null && this.r.k1()) {
                z3 = true;
            }
        }
        xVar.k = z3;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        m mVar = this.r;
        if (mVar == null || !mVar.p0()) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b0(boolean z2) {
        this.K = z2 | this.K;
        this.J = true;
        int h2 = this.j.h();
        for (int i2 = 0; i2 < h2; i2++) {
            a0 K2 = K(this.j.g(i2));
            if (K2 != null && !K2.shouldIgnore()) {
                K2.addFlags(6);
            }
        }
        Q();
        t tVar = this.g;
        int size = tVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            a0 a0Var = tVar.c.get(i3);
            if (a0Var != null) {
                a0Var.addFlags(6);
                a0Var.addChangePayload(null);
            }
        }
        e eVar = RecyclerView.this.q;
        if (eVar == null || !eVar.hasStableIds()) {
            tVar.f();
        }
    }

    public void c0(a0 a0Var, j.c cVar) {
        a0Var.setFlags(0, a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
        if (this.n0.h && a0Var.isUpdated() && !a0Var.isRemoved() && !a0Var.shouldIgnore()) {
            this.k.b.j(H(a0Var), a0Var);
        }
        this.k.c(a0Var, cVar);
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof n) && this.r.r((n) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        m mVar = this.r;
        if (mVar != null && mVar.p()) {
            return this.r.v(this.n0);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        m mVar = this.r;
        if (mVar != null && mVar.p()) {
            return this.r.w(this.n0);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        m mVar = this.r;
        if (mVar != null && mVar.p()) {
            return this.r.x(this.n0);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        m mVar = this.r;
        if (mVar != null && mVar.q()) {
            return this.r.y(this.n0);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        m mVar = this.r;
        if (mVar != null && mVar.q()) {
            return this.r.z(this.n0);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        m mVar = this.r;
        if (mVar != null && mVar.q()) {
            return this.r.A(this.n0);
        }
        return 0;
    }

    public void d0() {
        j jVar = this.S;
        if (jVar != null) {
            jVar.f();
        }
        m mVar = this.r;
        if (mVar != null) {
            mVar.R0(this.g);
            this.r.S0(this.g);
        }
        this.g.b();
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().b(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, 0);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().e(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.View, android.view.ViewGroup
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        int size = this.u.size();
        boolean z3 = false;
        for (int i2 = 0; i2 < size; i2++) {
            this.u.get(i2).onDrawOver(canvas, this, this.n0);
        }
        EdgeEffect edgeEffect = this.O;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.l ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.O;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.l) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.P;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.Q;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.l ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.Q;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.R;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.l) {
                canvas.translate((float) (getPaddingRight() + (-getWidth())), (float) (getPaddingBottom() + (-getHeight())));
            } else {
                canvas.translate((float) (-getWidth()), (float) (-getHeight()));
            }
            EdgeEffect edgeEffect8 = this.R;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.S == null || this.u.size() <= 0 || !this.S.g()) {
            z4 = z2;
        }
        if (z4) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public final void e(a0 a0Var) {
        View view = a0Var.itemView;
        boolean z2 = view.getParent() == this;
        this.g.l(J(view));
        if (a0Var.isTmpDetached()) {
            this.j.b(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.j.a(view, -1, true);
        } else {
            xj xjVar = this.j;
            int indexOfChild = ((xk) xjVar.f3930a).f3935a.indexOfChild(view);
            if (indexOfChild >= 0) {
                xjVar.b.h(indexOfChild);
                xjVar.i(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final void e0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.n.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof n) {
            n nVar = (n) layoutParams;
            if (!nVar.h) {
                Rect rect = nVar.g;
                Rect rect2 = this.n;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.n);
            offsetRectIntoDescendantCoords(view, this.n);
        }
        this.r.V0(this, view, this.n, !this.A, view2 == null);
    }

    public void f(l lVar) {
        m mVar = this.r;
        if (mVar != null) {
            mVar.n("Cannot add item decoration during a scroll  or layout");
        }
        if (this.u.isEmpty()) {
            setWillNotDraw(false);
        }
        this.u.add(lVar);
        Q();
        requestLayout();
    }

    public final void f0() {
        VelocityTracker velocityTracker = this.V;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z2 = false;
        p0(0);
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.O.isFinished();
        }
        EdgeEffect edgeEffect2 = this.P;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.P.isFinished();
        }
        EdgeEffect edgeEffect3 = this.Q;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.R.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x016b, code lost:
        if (r3 > 0) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0185, code lost:
        if (r6 > 0) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0188, code lost:
        if (r3 < 0) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x018b, code lost:
        if (r6 < 0) goto L_0x019f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0194, code lost:
        if ((r6 * r1) <= 0) goto L_0x01a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x019d, code lost:
        if ((r6 * r1) >= 0) goto L_0x01a1;
     */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:132:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View focusSearch(android.view.View r14, int r15) {
        /*
        // Method dump skipped, instructions count: 426
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public void g(r rVar) {
        if (this.p0 == null) {
            this.p0 = new ArrayList();
        }
        this.p0.add(rVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00f7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean g0(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
        // Method dump skipped, instructions count: 319
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.g0(int, int, android.view.MotionEvent, int):boolean");
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        m mVar = this.r;
        if (mVar != null) {
            return mVar.F();
        }
        throw new IllegalStateException(hj1.A(this, hj1.i0("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        m mVar = this.r;
        if (mVar != null) {
            return mVar.G(getContext(), attributeSet);
        }
        throw new IllegalStateException(hj1.A(this, hj1.i0("RecyclerView has no LayoutManager")));
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public e getAdapter() {
        return this.q;
    }

    public int getBaseline() {
        m mVar = this.r;
        if (mVar == null) {
            return super.getBaseline();
        }
        Objects.requireNonNull(mVar);
        return -1;
    }

    public int getChildDrawingOrder(int i2, int i3) {
        h hVar = this.v0;
        if (hVar == null) {
            return super.getChildDrawingOrder(i2, i3);
        }
        return hVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.l;
    }

    public zk getCompatAccessibilityDelegate() {
        return this.u0;
    }

    public i getEdgeEffectFactory() {
        return this.N;
    }

    public j getItemAnimator() {
        return this.S;
    }

    public int getItemDecorationCount() {
        return this.u.size();
    }

    public m getLayoutManager() {
        return this.r;
    }

    public int getMaxFlingVelocity() {
        return this.g0;
    }

    public int getMinFlingVelocity() {
        return this.f0;
    }

    public long getNanoTime() {
        if (K0) {
            return System.nanoTime();
        }
        return 0;
    }

    public p getOnFlingListener() {
        return this.e0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.j0;
    }

    public s getRecycledViewPool() {
        return this.g.d();
    }

    public int getScrollState() {
        return this.T;
    }

    public void h(String str) {
        if (O()) {
            if (str == null) {
                throw new IllegalStateException(hj1.A(this, hj1.i0("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.M > 0) {
            new IllegalStateException(hj1.A(this, hj1.i0("")));
        }
    }

    public void h0(int i2, int i3, int[] iArr) {
        a0 a0Var;
        m0();
        U();
        int i4 = y6.f4005a;
        Trace.beginSection("RV Scroll");
        A(this.n0);
        int X0 = i2 != 0 ? this.r.X0(i2, this.g, this.n0) : 0;
        int Z0 = i3 != 0 ? this.r.Z0(i3, this.g, this.n0) : 0;
        Trace.endSection();
        int e2 = this.j.e();
        for (int i5 = 0; i5 < e2; i5++) {
            View d2 = this.j.d(i5);
            a0 J2 = J(d2);
            if (!(J2 == null || (a0Var = J2.mShadowingHolder) == null)) {
                View view = a0Var.itemView;
                int left = d2.getLeft();
                int top = d2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        V(true);
        o0(false);
        if (iArr != null) {
            iArr[0] = X0;
            iArr[1] = Z0;
        }
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().h(0);
    }

    public final void i() {
        f0();
        setScrollState(0);
    }

    public void i0(int i2) {
        if (!this.D) {
            q0();
            m mVar = this.r;
            if (mVar != null) {
                mVar.Y0(i2);
                awakenScrollBars();
            }
        }
    }

    public boolean isAttachedToWindow() {
        return this.x;
    }

    public final boolean isLayoutSuppressed() {
        return this.D;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public boolean j0(a0 a0Var, int i2) {
        if (O()) {
            a0Var.mPendingAccessibilityState = i2;
            this.B0.add(a0Var);
            return false;
        }
        View view = a0Var.itemView;
        AtomicInteger atomicInteger = r8.f3055a;
        view.setImportantForAccessibility(i2);
        return true;
    }

    public void k() {
        int h2 = this.j.h();
        for (int i2 = 0; i2 < h2; i2++) {
            a0 K2 = K(this.j.g(i2));
            if (!K2.shouldIgnore()) {
                K2.clearOldPosition();
            }
        }
        t tVar = this.g;
        int size = tVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            tVar.c.get(i3).clearOldPosition();
        }
        int size2 = tVar.f240a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            tVar.f240a.get(i4).clearOldPosition();
        }
        ArrayList<a0> arrayList = tVar.b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                tVar.b.get(i5).clearOldPosition();
            }
        }
    }

    public void k0(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        m mVar = this.r;
        if (mVar != null && !this.D) {
            int i5 = 0;
            if (!mVar.p()) {
                i2 = 0;
            }
            if (!this.r.q()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        n0(i5, 1);
                    }
                    this.k0.b(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    public void l(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.O;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.O.onRelease();
            z2 = this.O.isFinished();
        }
        EdgeEffect edgeEffect2 = this.Q;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.Q.onRelease();
            z2 |= this.Q.isFinished();
        }
        EdgeEffect edgeEffect3 = this.P;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.P.onRelease();
            z2 |= this.P.isFinished();
        }
        EdgeEffect edgeEffect4 = this.R;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.R.onRelease();
            z2 |= this.R.isFinished();
        }
        if (z2) {
            AtomicInteger atomicInteger = r8.f3055a;
            postInvalidateOnAnimation();
        }
    }

    public void l0(int i2) {
        m mVar;
        if (!this.D && (mVar = this.r) != null) {
            mVar.i1(this, this.n0, i2);
        }
    }

    public void m() {
        if (!this.A || this.J) {
            int i2 = y6.f4005a;
            Trace.beginSection("RV FullInvalidate");
            p();
            Trace.endSection();
        } else if (this.i.g()) {
            sj sjVar = this.i;
            int i3 = sjVar.f;
            boolean z2 = false;
            if ((i3 & 4) != 0) {
                if (!((i3 & 11) != 0)) {
                    int i4 = y6.f4005a;
                    Trace.beginSection("RV PartialInvalidate");
                    m0();
                    U();
                    this.i.j();
                    if (!this.C) {
                        int e2 = this.j.e();
                        int i5 = 0;
                        while (true) {
                            if (i5 < e2) {
                                a0 K2 = K(this.j.d(i5));
                                if (K2 != null && !K2.shouldIgnore() && K2.isUpdated()) {
                                    z2 = true;
                                    break;
                                }
                                i5++;
                            } else {
                                break;
                            }
                        }
                        if (z2) {
                            p();
                        } else {
                            this.i.b();
                        }
                    }
                    o0(true);
                    V(true);
                    Trace.endSection();
                    return;
                }
            }
            if (sjVar.g()) {
                int i6 = y6.f4005a;
                Trace.beginSection("RV FullInvalidate");
                p();
                Trace.endSection();
            }
        }
    }

    public void m0() {
        int i2 = this.B + 1;
        this.B = i2;
        if (i2 == 1 && !this.D) {
            this.C = false;
        }
    }

    public void n(int i2, int i3) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        AtomicInteger atomicInteger = r8.f3055a;
        setMeasuredDimension(m.s(i2, paddingRight, getMinimumWidth()), m.s(i3, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    public boolean n0(int i2, int i3) {
        return getScrollingChildHelper().i(i2, i3);
    }

    public void o(View view) {
        a0 K2 = K(view);
        T();
        e eVar = this.q;
        if (!(eVar == null || K2 == null)) {
            eVar.onViewDetachedFromWindow(K2);
        }
        List<o> list = this.I;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.I.get(size).a(view);
            }
        }
    }

    public void o0(boolean z2) {
        if (this.B < 1) {
            this.B = 1;
        }
        if (!z2 && !this.D) {
            this.C = false;
        }
        if (this.B == 1) {
            if (z2 && this.C && !this.D && this.r != null && this.q != null) {
                p();
            }
            if (!this.D) {
                this.C = false;
            }
        }
        this.B--;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.L = 0;
        this.x = true;
        this.A = this.A && !isLayoutRequested();
        m mVar = this.r;
        if (mVar != null) {
            mVar.n = true;
            mVar.q0(this);
        }
        this.t0 = false;
        if (K0) {
            ThreadLocal<lk> threadLocal = lk.j;
            lk lkVar = threadLocal.get();
            this.l0 = lkVar;
            if (lkVar == null) {
                this.l0 = new lk();
                AtomicInteger atomicInteger = r8.f3055a;
                Display display = getDisplay();
                float f2 = 60.0f;
                if (!isInEditMode() && display != null) {
                    float refreshRate = display.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                lk lkVar2 = this.l0;
                lkVar2.h = (long) (1.0E9f / f2);
                threadLocal.set(lkVar2);
            }
            this.l0.f.add(this);
        }
    }

    public void onDetachedFromWindow() {
        lk lkVar;
        super.onDetachedFromWindow();
        j jVar = this.S;
        if (jVar != null) {
            jVar.f();
        }
        q0();
        this.x = false;
        m mVar = this.r;
        if (mVar != null) {
            t tVar = this.g;
            mVar.n = false;
            mVar.s0(this, tVar);
        }
        this.B0.clear();
        removeCallbacks(this.C0);
        Objects.requireNonNull(this.k);
        do {
        } while (el.a.d.b() != null);
        if (K0 && (lkVar = this.l0) != null) {
            lkVar.f.remove(this);
            this.l0 = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.u.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.u.get(i2).onDraw(canvas, this, this.n0);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
        // Method dump skipped, instructions count: 215
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.D) {
            return false;
        }
        this.w = null;
        if (C(motionEvent)) {
            i();
            return true;
        }
        m mVar = this.r;
        if (mVar == null) {
            return false;
        }
        boolean p2 = mVar.p();
        boolean q2 = this.r.q();
        if (this.V == null) {
            this.V = VelocityTracker.obtain();
        }
        this.V.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.E) {
                this.E = false;
            }
            this.U = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.b0 = x2;
            this.W = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.c0 = y2;
            this.a0 = y2;
            if (this.T == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                p0(1);
            }
            int[] iArr = this.z0;
            iArr[1] = 0;
            iArr[0] = 0;
            if (q2) {
                boolean z3 = p2 ? 1 : 0;
                char c2 = p2 ? 1 : 0;
                p2 = z3 | true;
            }
            int i2 = p2 ? 1 : 0;
            int i3 = p2 ? 1 : 0;
            int i4 = p2 ? 1 : 0;
            n0(i2, 0);
        } else if (actionMasked == 1) {
            this.V.clear();
            p0(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.U);
            if (findPointerIndex < 0) {
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.T != 1) {
                int i5 = x3 - this.W;
                int i6 = y3 - this.a0;
                if (!p2 || Math.abs(i5) <= this.d0) {
                    z2 = false;
                } else {
                    this.b0 = x3;
                    z2 = true;
                }
                if (q2 && Math.abs(i6) > this.d0) {
                    this.c0 = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            i();
        } else if (actionMasked == 5) {
            this.U = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.b0 = x4;
            this.W = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.c0 = y4;
            this.a0 = y4;
        } else if (actionMasked == 6) {
            W(motionEvent);
        }
        if (this.T == 1) {
            return true;
        }
        return false;
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6 = y6.f4005a;
        Trace.beginSection("RV OnLayout");
        p();
        Trace.endSection();
        this.A = true;
    }

    public void onMeasure(int i2, int i3) {
        m mVar = this.r;
        if (mVar == null) {
            n(i2, i3);
            return;
        }
        boolean z2 = false;
        if (mVar.h0()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.r.I0(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.D0 = z2;
            if (!z2 && this.q != null) {
                if (this.n0.d == 1) {
                    q();
                }
                this.r.b1(i2, i3);
                this.n0.i = true;
                r();
                this.r.d1(i2, i3);
                if (this.r.g1()) {
                    this.r.b1(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), CommonUtils.BYTES_IN_A_GIGABYTE), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), CommonUtils.BYTES_IN_A_GIGABYTE));
                    this.n0.i = true;
                    r();
                    this.r.d1(i2, i3);
                }
                this.E0 = getMeasuredWidth();
                this.F0 = getMeasuredHeight();
            }
        } else if (this.y) {
            this.r.I0(i2, i3);
        } else {
            if (this.G) {
                m0();
                U();
                a0();
                V(true);
                x xVar = this.n0;
                if (xVar.k) {
                    xVar.g = true;
                } else {
                    this.i.c();
                    this.n0.g = false;
                }
                this.G = false;
                o0(false);
            } else if (this.n0.k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            e eVar = this.q;
            if (eVar != null) {
                this.n0.e = eVar.getItemCount();
            } else {
                this.n0.e = 0;
            }
            m0();
            this.r.I0(i2, i3);
            o0(false);
            this.n0.g = false;
        }
    }

    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (O()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.h = savedState;
        super.onRestoreInstanceState(savedState.getSuperState());
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.h;
        if (savedState2 != null) {
            savedState.f = savedState2.f;
        } else {
            m mVar = this.r;
            if (mVar != null) {
                savedState.f = mVar.M0();
            } else {
                savedState.f = null;
            }
        }
        return savedState;
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            N();
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:203:0x030c */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:205:0x030f */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x02fe, code lost:
        if (r0 < r2) goto L_0x0301;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0382, code lost:
        if (r8 != false) goto L_0x0388;
     */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x026e  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0304  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0306  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x0311  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03b6  */
    /* JADX WARNING: Removed duplicated region for block: B:229:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r23) {
        /*
        // Method dump skipped, instructions count: 968
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:141:0x0341, code lost:
        if (r15.j.k(getFocusedChild()) == false) goto L_0x0414;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03da, code lost:
        r4 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void p() {
        /*
        // Method dump skipped, instructions count: 1054
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.p():void");
    }

    public void p0(int i2) {
        getScrollingChildHelper().j(i2);
    }

    public final void q() {
        int i2;
        View B2;
        this.n0.a(1);
        A(this.n0);
        this.n0.i = false;
        m0();
        el elVar = this.k;
        elVar.f987a.clear();
        elVar.b.b();
        U();
        a0();
        View focusedChild = (!this.j0 || !hasFocus() || this.q == null) ? null : getFocusedChild();
        a0 J2 = (focusedChild == null || (B2 = B(focusedChild)) == null) ? null : J(B2);
        long j2 = -1;
        if (J2 == null) {
            x xVar = this.n0;
            xVar.m = -1;
            xVar.l = -1;
            xVar.n = -1;
        } else {
            x xVar2 = this.n0;
            if (this.q.hasStableIds()) {
                j2 = J2.getItemId();
            }
            xVar2.m = j2;
            x xVar3 = this.n0;
            if (this.J) {
                i2 = -1;
            } else if (J2.isRemoved()) {
                i2 = J2.mOldPosition;
            } else {
                i2 = J2.getAbsoluteAdapterPosition();
            }
            xVar3.l = i2;
            x xVar4 = this.n0;
            View view = J2.itemView;
            int id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    id = view.getId();
                }
            }
            xVar4.n = id;
        }
        x xVar5 = this.n0;
        xVar5.h = xVar5.j && this.r0;
        this.r0 = false;
        this.q0 = false;
        xVar5.g = xVar5.k;
        xVar5.e = this.q.getItemCount();
        D(this.w0);
        if (this.n0.j) {
            int e2 = this.j.e();
            for (int i3 = 0; i3 < e2; i3++) {
                a0 K2 = K(this.j.d(i3));
                if (!K2.shouldIgnore() && (!K2.isInvalid() || this.q.hasStableIds())) {
                    j jVar = this.S;
                    j.b(K2);
                    K2.getUnmodifiedPayloads();
                    this.k.c(K2, jVar.h(K2));
                    if (this.n0.h && K2.isUpdated() && !K2.isRemoved() && !K2.shouldIgnore() && !K2.isInvalid()) {
                        this.k.b.j(H(K2), K2);
                    }
                }
            }
        }
        if (this.n0.k) {
            int h2 = this.j.h();
            for (int i4 = 0; i4 < h2; i4++) {
                a0 K3 = K(this.j.g(i4));
                if (!K3.shouldIgnore()) {
                    K3.saveOldPosition();
                }
            }
            x xVar6 = this.n0;
            boolean z2 = xVar6.f;
            xVar6.f = false;
            this.r.G0(this.g, xVar6);
            this.n0.f = z2;
            for (int i5 = 0; i5 < this.j.e(); i5++) {
                a0 K4 = K(this.j.d(i5));
                if (!K4.shouldIgnore()) {
                    el.a orDefault = this.k.f987a.getOrDefault(K4, null);
                    if (!((orDefault == null || (orDefault.f988a & 4) == 0) ? false : true)) {
                        j.b(K4);
                        boolean hasAnyOfTheFlags = K4.hasAnyOfTheFlags(a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
                        j jVar2 = this.S;
                        K4.getUnmodifiedPayloads();
                        j.c h3 = jVar2.h(K4);
                        if (hasAnyOfTheFlags) {
                            c0(K4, h3);
                        } else {
                            el elVar2 = this.k;
                            el.a orDefault2 = elVar2.f987a.getOrDefault(K4, null);
                            if (orDefault2 == null) {
                                orDefault2 = el.a.a();
                                elVar2.f987a.put(K4, orDefault2);
                            }
                            orDefault2.f988a |= 2;
                            orDefault2.b = h3;
                        }
                    }
                }
            }
            k();
        } else {
            k();
        }
        V(true);
        o0(false);
        this.n0.d = 2;
    }

    public void q0() {
        w wVar;
        setScrollState(0);
        this.k0.c();
        m mVar = this.r;
        if (mVar != null && (wVar = mVar.l) != null) {
            wVar.c();
        }
    }

    public final void r() {
        m0();
        U();
        this.n0.a(6);
        this.i.c();
        this.n0.e = this.q.getItemCount();
        this.n0.c = 0;
        if (this.h != null && this.q.canRestoreState()) {
            Parcelable parcelable = this.h.f;
            if (parcelable != null) {
                this.r.L0(parcelable);
            }
            this.h = null;
        }
        x xVar = this.n0;
        xVar.g = false;
        this.r.G0(this.g, xVar);
        x xVar2 = this.n0;
        xVar2.f = false;
        xVar2.j = xVar2.j && this.S != null;
        xVar2.d = 4;
        V(true);
        o0(false);
    }

    public void removeDetachedView(View view, boolean z2) {
        a0 K2 = K(view);
        if (K2 != null) {
            if (K2.isTmpDetached()) {
                K2.clearTmpDetachFlag();
            } else if (!K2.shouldIgnore()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(K2);
                throw new IllegalArgumentException(hj1.A(this, sb));
            }
        }
        view.clearAnimation();
        o(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.r.K0(this, view, view2) && view2 != null) {
            e0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.r.V0(this, view, rect, z2, false);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.v.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.v.get(i2).c(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.B != 0 || this.D) {
            this.C = true;
        } else {
            super.requestLayout();
        }
    }

    public boolean s(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().c(i2, i3, iArr, iArr2, i4);
    }

    public void scrollBy(int i2, int i3) {
        m mVar = this.r;
        if (mVar != null && !this.D) {
            boolean p2 = mVar.p();
            boolean q2 = this.r.q();
            if (p2 || q2) {
                if (!p2) {
                    i2 = 0;
                }
                if (!q2) {
                    i3 = 0;
                }
                g0(i2, i3, null, 0);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (O()) {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            if (contentChangeTypes != 0) {
                i2 = contentChangeTypes;
            }
            this.F |= i2;
            i2 = 1;
        }
        if (i2 == 0) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(zk zkVar) {
        this.u0 = zkVar;
        r8.v(this, zkVar);
    }

    public void setAdapter(e eVar) {
        setLayoutFrozen(false);
        e eVar2 = this.q;
        if (eVar2 != null) {
            eVar2.unregisterAdapterDataObserver(this.f);
            this.q.onDetachedFromRecyclerView(this);
        }
        d0();
        sj sjVar = this.i;
        sjVar.l(sjVar.b);
        sjVar.l(sjVar.c);
        sjVar.f = 0;
        e eVar3 = this.q;
        this.q = eVar;
        if (eVar != null) {
            eVar.registerAdapterDataObserver(this.f);
            eVar.onAttachedToRecyclerView(this);
        }
        m mVar = this.r;
        if (mVar != null) {
            mVar.o0(eVar3, this.q);
        }
        t tVar = this.g;
        e eVar4 = this.q;
        tVar.b();
        s d2 = tVar.d();
        Objects.requireNonNull(d2);
        if (eVar3 != null) {
            d2.b--;
        }
        if (d2.b == 0) {
            for (int i2 = 0; i2 < d2.f238a.size(); i2++) {
                d2.f238a.valueAt(i2).f239a.clear();
            }
        }
        if (eVar4 != null) {
            d2.b++;
        }
        this.n0.f = true;
        b0(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(h hVar) {
        if (hVar != this.v0) {
            this.v0 = hVar;
            setChildrenDrawingOrderEnabled(hVar != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.l) {
            N();
        }
        this.l = z2;
        super.setClipToPadding(z2);
        if (this.A) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(i iVar) {
        Objects.requireNonNull(iVar);
        this.N = iVar;
        N();
    }

    public void setHasFixedSize(boolean z2) {
        this.y = z2;
    }

    public void setItemAnimator(j jVar) {
        j jVar2 = this.S;
        if (jVar2 != null) {
            jVar2.f();
            this.S.f232a = null;
        }
        this.S = jVar;
        if (jVar != null) {
            jVar.f232a = this.s0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        t tVar = this.g;
        tVar.e = i2;
        tVar.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(m mVar) {
        if (mVar != this.r) {
            q0();
            if (this.r != null) {
                j jVar = this.S;
                if (jVar != null) {
                    jVar.f();
                }
                this.r.R0(this.g);
                this.r.S0(this.g);
                this.g.b();
                if (this.x) {
                    m mVar2 = this.r;
                    t tVar = this.g;
                    mVar2.n = false;
                    mVar2.s0(this, tVar);
                }
                this.r.e1(null);
                this.r = null;
            } else {
                this.g.b();
            }
            xj xjVar = this.j;
            xj.a aVar = xjVar.b;
            aVar.f3931a = 0;
            xj.a aVar2 = aVar.b;
            if (aVar2 != null) {
                aVar2.g();
            }
            int size = xjVar.c.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                xk xkVar = (xk) xjVar.f3930a;
                Objects.requireNonNull(xkVar);
                a0 K2 = K(xjVar.c.get(size));
                if (K2 != null) {
                    K2.onLeftHiddenState(xkVar.f3935a);
                }
                xjVar.c.remove(size);
            }
            xk xkVar2 = (xk) xjVar.f3930a;
            int b2 = xkVar2.b();
            for (int i2 = 0; i2 < b2; i2++) {
                View a2 = xkVar2.a(i2);
                xkVar2.f3935a.o(a2);
                a2.clearAnimation();
            }
            xkVar2.f3935a.removeAllViews();
            this.r = mVar;
            if (mVar != null) {
                if (mVar.g == null) {
                    mVar.e1(this);
                    if (this.x) {
                        m mVar3 = this.r;
                        mVar3.n = true;
                        mVar3.q0(this);
                    }
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append("LayoutManager ");
                    sb.append(mVar);
                    sb.append(" is already attached to a RecyclerView:");
                    throw new IllegalArgumentException(hj1.A(mVar.g, sb));
                }
            }
            this.g.m();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z2) {
        i8 scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            View view = scrollingChildHelper.c;
            AtomicInteger atomicInteger = r8.f3055a;
            view.stopNestedScroll();
        }
        scrollingChildHelper.d = z2;
    }

    public void setOnFlingListener(p pVar) {
        this.e0 = pVar;
    }

    @Deprecated
    public void setOnScrollListener(r rVar) {
        this.o0 = rVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.j0 = z2;
    }

    public void setRecycledViewPool(s sVar) {
        t tVar = this.g;
        s sVar2 = tVar.g;
        if (sVar2 != null) {
            sVar2.b--;
        }
        tVar.g = sVar;
        if (sVar != null && RecyclerView.this.getAdapter() != null) {
            tVar.g.b++;
        }
    }

    @Deprecated
    public void setRecyclerListener(u uVar) {
        this.s = uVar;
    }

    public void setScrollState(int i2) {
        w wVar;
        if (i2 != this.T) {
            this.T = i2;
            if (i2 != 2) {
                this.k0.c();
                m mVar = this.r;
                if (!(mVar == null || (wVar = mVar.l) == null)) {
                    wVar.c();
                }
            }
            m mVar2 = this.r;
            if (mVar2 != null) {
                mVar2.N0(i2);
            }
            X();
            r rVar = this.o0;
            if (rVar != null) {
                rVar.onScrollStateChanged(this, i2);
            }
            List<r> list = this.p0;
            if (list != null) {
                int size = list.size();
                while (true) {
                    size--;
                    if (size >= 0) {
                        this.p0.get(size).onScrollStateChanged(this, i2);
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 1) {
            this.d0 = viewConfiguration.getScaledTouchSlop();
        } else {
            this.d0 = viewConfiguration.getScaledPagingTouchSlop();
        }
    }

    public void setViewCacheExtension(y yVar) {
        Objects.requireNonNull(this.g);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().i(i2, 0);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().j(0);
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.D) {
            h("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.D = false;
                if (!(!this.C || this.r == null || this.q == null)) {
                    requestLayout();
                }
                this.C = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.D = true;
            this.E = true;
            q0();
        }
    }

    public final void t(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().f(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void u(int i2, int i3) {
        this.M++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        Y();
        r rVar = this.o0;
        if (rVar != null) {
            rVar.onScrolled(this, i2, i3);
        }
        List<r> list = this.p0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.p0.get(size).onScrolled(this, i2, i3);
            }
        }
        this.M--;
    }

    public void v() {
        if (this.R == null) {
            EdgeEffect a2 = this.N.a(this);
            this.R = a2;
            if (this.l) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public void w() {
        if (this.O == null) {
            EdgeEffect a2 = this.N.a(this);
            this.O = a2;
            if (this.l) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void x() {
        if (this.Q == null) {
            EdgeEffect a2 = this.N.a(this);
            this.Q = a2;
            if (this.l) {
                a2.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            } else {
                a2.setSize(getMeasuredHeight(), getMeasuredWidth());
            }
        }
    }

    public void y() {
        if (this.P == null) {
            EdgeEffect a2 = this.N.a(this);
            this.P = a2;
            if (this.l) {
                a2.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
            } else {
                a2.setSize(getMeasuredWidth(), getMeasuredHeight());
            }
        }
    }

    public String z() {
        StringBuilder i02 = hj1.i0(" ");
        i02.append(super.toString());
        i02.append(", adapter:");
        i02.append(this.q);
        i02.append(", layout:");
        i02.append(this.r);
        i02.append(", context:");
        i02.append(getContext());
        return i02.toString();
    }

    public static abstract class e<VH extends a0> {
        private boolean mHasStableIds = false;
        private final f mObservable = new f();
        private a mStateRestorationPolicy = a.ALLOW;

        public enum a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh, int i) {
            boolean z = vh.mBindingAdapter == null;
            if (z) {
                vh.mPosition = i;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i);
                }
                vh.setFlags(1, 519);
                int i2 = y6.f4005a;
                Trace.beginSection("RV OnBindView");
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i, vh.getUnmodifiedPayloads());
            if (z) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof n) {
                    ((n) layoutParams).h = true;
                }
                int i3 = y6.f4005a;
                Trace.endSection();
            }
        }

        public boolean canRestoreState() {
            int ordinal = this.mStateRestorationPolicy.ordinal();
            if (ordinal != 1) {
                return ordinal != 2;
            }
            if (getItemCount() > 0) {
                return true;
            }
            return false;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i) {
            try {
                int i2 = y6.f4005a;
                Trace.beginSection("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i;
                    Trace.endSection();
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                int i3 = y6.f4005a;
                Trace.endSection();
                throw th;
            }
        }

        public int findRelativeAdapterPositionIn(e<? extends a0> eVar, a0 a0Var, int i) {
            if (eVar == this) {
                return i;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i) {
            return -1;
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public final a getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i) {
            this.mObservable.d(i, 1, null);
        }

        public final void notifyItemInserted(int i) {
            this.mObservable.e(i, 1);
        }

        public final void notifyItemMoved(int i, int i2) {
            this.mObservable.c(i, i2);
        }

        public final void notifyItemRangeChanged(int i, int i2) {
            this.mObservable.d(i, i2, null);
        }

        public final void notifyItemRangeInserted(int i, int i2) {
            this.mObservable.e(i, i2);
        }

        public final void notifyItemRangeRemoved(int i, int i2) {
            this.mObservable.f(i, i2);
        }

        public final void notifyItemRemoved(int i) {
            this.mObservable.f(i, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i);

        public void onBindViewHolder(VH vh, int i, List<Object> list) {
            onBindViewHolder(vh, i);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(g gVar) {
            this.mObservable.registerObserver(gVar);
        }

        public void setHasStableIds(boolean z) {
            if (!hasObservers()) {
                this.mHasStableIds = z;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(a aVar) {
            this.mStateRestorationPolicy = aVar;
            this.mObservable.g();
        }

        public void unregisterAdapterDataObserver(g gVar) {
            this.mObservable.unregisterObserver(gVar);
        }

        public final void notifyItemChanged(int i, Object obj) {
            this.mObservable.d(i, 1, obj);
        }

        public final void notifyItemRangeChanged(int i, int i2, Object obj) {
            this.mObservable.d(i, i2, obj);
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        float f2;
        float f3;
        TypedArray typedArray;
        char c2;
        ClassLoader classLoader;
        Object[] objArr;
        Constructor<? extends U> constructor;
        this.f = new v();
        this.g = new t();
        this.k = new el();
        this.m = new a();
        this.n = new Rect();
        this.o = new Rect();
        this.p = new RectF();
        this.t = new ArrayList();
        this.u = new ArrayList<>();
        this.v = new ArrayList<>();
        this.B = 0;
        this.J = false;
        this.K = false;
        this.L = 0;
        this.M = 0;
        this.N = new i();
        this.S = new ik();
        this.T = 0;
        this.U = -1;
        this.h0 = Float.MIN_VALUE;
        this.i0 = Float.MIN_VALUE;
        this.j0 = true;
        this.k0 = new z();
        this.m0 = K0 ? new lk.b() : null;
        this.n0 = new x();
        this.q0 = false;
        this.r0 = false;
        this.s0 = new k();
        this.t0 = false;
        this.w0 = new int[2];
        this.y0 = new int[2];
        this.z0 = new int[2];
        this.A0 = new int[2];
        this.B0 = new ArrayList();
        this.C0 = new b();
        this.E0 = 0;
        this.F0 = 0;
        this.G0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.d0 = viewConfiguration.getScaledTouchSlop();
        Method method = x8.f3899a;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 26) {
            f2 = viewConfiguration.getScaledHorizontalScrollFactor();
        } else {
            f2 = x8.a(viewConfiguration, context);
        }
        this.h0 = f2;
        if (i3 >= 26) {
            f3 = viewConfiguration.getScaledVerticalScrollFactor();
        } else {
            f3 = x8.a(viewConfiguration, context);
        }
        this.i0 = f3;
        this.f0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.g0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.S.f232a = this.s0;
        this.i = new sj(new yk(this));
        this.j = new xj(new xk(this));
        AtomicInteger atomicInteger = r8.f3055a;
        if ((i3 >= 26 ? getImportantForAutofill() : 0) == 0 && i3 >= 26) {
            setImportantForAutofill(8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.H = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new zk(this));
        int[] iArr = R.styleable.RecyclerView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
        r8.u(this, context, iArr, attributeSet, obtainStyledAttributes, i2, 0);
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.l = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.z = z2;
        if (z2) {
            StateListDrawable stateListDrawable = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(hj1.A(this, hj1.i0("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c2 = 2;
            typedArray = obtainStyledAttributes;
            new kk(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
        } else {
            typedArray = obtainStyledAttributes;
            c2 = 2;
        }
        typedArray.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = RecyclerView.class.getPackage().getName() + '.' + trim;
                }
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(trim, false, classLoader).asSubclass(m.class);
                    try {
                        constructor = asSubclass.getConstructor(L0);
                        objArr = new Object[4];
                        objArr[0] = context;
                        objArr[1] = attributeSet;
                        objArr[c2] = Integer.valueOf(i2);
                        objArr[3] = 0;
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + trim, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((m) constructor.newInstance(objArr));
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + trim, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + trim, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + trim, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + trim, e8);
                }
            }
        }
        int[] iArr2 = H0;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr2, i2, 0);
        r8.u(this, context, iArr2, attributeSet, obtainStyledAttributes2, i2, 0);
        boolean z3 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z3);
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public Parcelable f;

        public class a implements Parcelable.ClassLoaderCreator<SavedState> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f = parcel.readParcelable(classLoader == null ? m.class.getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeParcelable(this.f, 0);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public static class n extends ViewGroup.MarginLayoutParams {
        public a0 f;
        public final Rect g = new Rect();
        public boolean h = true;
        public boolean i = false;

        public n(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public int a() {
            return this.f.getLayoutPosition();
        }

        public boolean b() {
            return this.f.isUpdated();
        }

        public boolean c() {
            return this.f.isRemoved();
        }

        public n(int i2, int i3) {
            super(i2, i3);
        }

        public n(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public n(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public n(n nVar) {
            super((ViewGroup.LayoutParams) nVar);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        m mVar = this.r;
        if (mVar != null) {
            return mVar.H(layoutParams);
        }
        throw new IllegalStateException(hj1.A(this, hj1.i0("RecyclerView has no LayoutManager")));
    }
}
