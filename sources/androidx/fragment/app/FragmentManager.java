package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultRegistry;
import androidx.activity.result.IntentSenderRequest;
import androidx.fragment.R;
import androidx.fragment.app.Fragment;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.razorpay.AnalyticsConstants;
import defpackage.Cif;
import defpackage.mf;
import defpackage.tf;
import defpackage.zg;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class FragmentManager {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public ArrayList<ke> F;
    public ArrayList<Boolean> G;
    public ArrayList<Fragment> H;
    public ArrayList<n> I;
    public Cif J;
    public Runnable K = new g();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<l> f214a = new ArrayList<>();
    public boolean b;
    public final lf c = new lf();
    public ArrayList<ke> d;
    public ArrayList<Fragment> e;
    public final ff f = new ff(this);
    public OnBackPressedDispatcher g;
    public final defpackage.l h = new c(false);
    public final AtomicInteger i = new AtomicInteger();
    public final Map<String, Bundle> j = DesugarCollections.synchronizedMap(new HashMap());
    public final Map<String, Object> k = DesugarCollections.synchronizedMap(new HashMap());
    public Map<Fragment, HashSet<t6>> l = DesugarCollections.synchronizedMap(new HashMap());
    public final tf.a m = new d();
    public final gf n = new gf(this);
    public final CopyOnWriteArrayList<jf> o = new CopyOnWriteArrayList<>();
    public int p = -1;
    public ef<?> q;
    public bf r;
    public Fragment s;
    public Fragment t;
    public df u = new e();
    public cg v = new f(this);
    public r<Intent> w;
    public r<IntentSenderRequest> x;
    public r<String[]> y;
    public ArrayDeque<LaunchedFragmentInfo> z = new ArrayDeque<>();

    /* renamed from: androidx.fragment.app.FragmentManager$6  reason: invalid class name */
    public class AnonymousClass6 implements dh {
        @Override // defpackage.dh
        public void c(fh fhVar, zg.a aVar) {
            if (aVar == zg.a.ON_START) {
                throw null;
            } else if (aVar == zg.a.ON_DESTROY) {
                throw null;
            }
        }
    }

    public class a implements q<ActivityResult> {
        public a() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.q
        public void a(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            LaunchedFragmentInfo pollFirst = FragmentManager.this.z.pollFirst();
            if (pollFirst == null) {
                String str = "No IntentSenders were started for " + this;
                return;
            }
            String str2 = pollFirst.f;
            int i = pollFirst.g;
            Fragment e = FragmentManager.this.c.e(str2);
            if (e != null) {
                e.onActivityResult(i, activityResult2.f, activityResult2.g);
            }
        }
    }

    public class b implements q<Map<String, Boolean>> {
        public b() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.q
        @SuppressLint({"SyntheticAccessor"})
        public void a(Map<String, Boolean> map) {
            Map<String, Boolean> map2 = map;
            String[] strArr = (String[]) map2.keySet().toArray(new String[0]);
            ArrayList arrayList = new ArrayList(map2.values());
            int[] iArr = new int[arrayList.size()];
            for (int i = 0; i < arrayList.size(); i++) {
                iArr[i] = ((Boolean) arrayList.get(i)).booleanValue() ? 0 : -1;
            }
            LaunchedFragmentInfo pollFirst = FragmentManager.this.z.pollFirst();
            if (pollFirst == null) {
                String str = "No permissions were requested for " + this;
                return;
            }
            String str2 = pollFirst.f;
            int i2 = pollFirst.g;
            Fragment e = FragmentManager.this.c.e(str2);
            if (e != null) {
                e.onRequestPermissionsResult(i2, strArr, iArr);
            }
        }
    }

    public class c extends defpackage.l {
        public c(boolean z) {
            super(z);
        }

        @Override // defpackage.l
        public void a() {
            FragmentManager fragmentManager = FragmentManager.this;
            fragmentManager.C(true);
            if (fragmentManager.h.f2142a) {
                fragmentManager.X();
            } else {
                fragmentManager.g.b();
            }
        }
    }

    public class d implements tf.a {
        public d() {
        }

        public void a(Fragment fragment, t6 t6Var) {
            boolean z;
            synchronized (t6Var) {
                z = t6Var.f3312a;
            }
            if (!z) {
                FragmentManager fragmentManager = FragmentManager.this;
                HashSet<t6> hashSet = fragmentManager.l.get(fragment);
                if (hashSet != null && hashSet.remove(t6Var) && hashSet.isEmpty()) {
                    fragmentManager.l.remove(fragment);
                    if (fragment.mState < 5) {
                        fragmentManager.i(fragment);
                        fragmentManager.U(fragment, fragmentManager.p);
                    }
                }
            }
        }

        public void b(Fragment fragment, t6 t6Var) {
            FragmentManager fragmentManager = FragmentManager.this;
            if (fragmentManager.l.get(fragment) == null) {
                fragmentManager.l.put(fragment, new HashSet<>());
            }
            fragmentManager.l.get(fragment).add(t6Var);
        }
    }

    public class e extends df {
        public e() {
        }

        @Override // defpackage.df
        public Fragment a(ClassLoader classLoader, String str) {
            ef<?> efVar = FragmentManager.this.q;
            Context context = efVar.g;
            Objects.requireNonNull(efVar);
            return Fragment.instantiate(context, str, null);
        }
    }

    public class f implements cg {
        public f(FragmentManager fragmentManager) {
        }
    }

    public class g implements Runnable {
        public g() {
        }

        public void run() {
            FragmentManager.this.C(true);
        }
    }

    public class h implements jf {
        public final /* synthetic */ Fragment f;

        public h(FragmentManager fragmentManager, Fragment fragment) {
            this.f = fragment;
        }

        @Override // defpackage.jf
        public void a(FragmentManager fragmentManager, Fragment fragment) {
            this.f.onAttachFragment(fragment);
        }
    }

    public class i implements q<ActivityResult> {
        public i() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // defpackage.q
        public void a(ActivityResult activityResult) {
            ActivityResult activityResult2 = activityResult;
            LaunchedFragmentInfo pollFirst = FragmentManager.this.z.pollFirst();
            if (pollFirst == null) {
                String str = "No Activities were started for result for " + this;
                return;
            }
            String str2 = pollFirst.f;
            int i = pollFirst.g;
            Fragment e = FragmentManager.this.c.e(str2);
            if (e != null) {
                e.onActivityResult(i, activityResult2.f, activityResult2.g);
            }
        }
    }

    public static class j extends t<IntentSenderRequest, ActivityResult> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.content.Context, java.lang.Object] */
        @Override // defpackage.t
        public Intent a(Context context, IntentSenderRequest intentSenderRequest) {
            Bundle bundleExtra;
            IntentSenderRequest intentSenderRequest2 = intentSenderRequest;
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent intent2 = intentSenderRequest2.g;
            if (!(intent2 == null || (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) == null)) {
                intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                    intentSenderRequest2 = new IntentSenderRequest(intentSenderRequest2.f, null, intentSenderRequest2.h, intentSenderRequest2.i);
                }
            }
            intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", intentSenderRequest2);
            if (FragmentManager.O(2)) {
                String str = "CreateIntent created the following intent: " + intent;
            }
            return intent;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.t
        public ActivityResult c(int i, Intent intent) {
            return new ActivityResult(i, intent);
        }
    }

    public static abstract class k {
    }

    public interface l {
        boolean a(ArrayList<ke> arrayList, ArrayList<Boolean> arrayList2);
    }

    public class m implements l {

        /* renamed from: a  reason: collision with root package name */
        public final String f219a;
        public final int b;
        public final int c;

        public m(String str, int i, int i2) {
            this.f219a = str;
            this.b = i;
            this.c = i2;
        }

        @Override // androidx.fragment.app.FragmentManager.l
        public boolean a(ArrayList<ke> arrayList, ArrayList<Boolean> arrayList2) {
            Fragment fragment = FragmentManager.this.t;
            if (fragment == null || this.b >= 0 || this.f219a != null || !fragment.getChildFragmentManager().X()) {
                return FragmentManager.this.Y(arrayList, arrayList2, this.f219a, this.b, this.c);
            }
            return false;
        }
    }

    public static class n implements Fragment.l {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f220a;
        public final ke b;
        public int c;

        public void a() {
            boolean z = this.c > 0;
            for (Fragment fragment : this.b.q.L()) {
                fragment.setOnStartEnterTransitionListener(null);
                if (z && fragment.isPostponed()) {
                    fragment.startPostponedEnterTransition();
                }
            }
            ke keVar = this.b;
            keVar.q.g(keVar, this.f220a, !z, true);
        }
    }

    public static boolean O(int i2) {
        return Log.isLoggable("FragmentManager", i2);
    }

    public void A(l lVar, boolean z2) {
        if (!z2) {
            if (this.q == null) {
                if (this.D) {
                    throw new IllegalStateException("FragmentManager has been destroyed");
                }
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            } else if (S()) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.f214a) {
            if (this.q != null) {
                this.f214a.add(lVar);
                d0();
            } else if (!z2) {
                throw new IllegalStateException("Activity has been destroyed");
            }
        }
    }

    public final void B(boolean z2) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (this.q == null) {
            if (this.D) {
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        } else if (Looper.myLooper() != this.q.h.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else if (z2 || !S()) {
            if (this.F == null) {
                this.F = new ArrayList<>();
                this.G = new ArrayList<>();
            }
            this.b = true;
            try {
                F(null, null);
            } finally {
                this.b = false;
            }
        } else {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean C(boolean z2) {
        boolean z3;
        B(z2);
        boolean z4 = false;
        while (true) {
            ArrayList<ke> arrayList = this.F;
            ArrayList<Boolean> arrayList2 = this.G;
            synchronized (this.f214a) {
                if (this.f214a.isEmpty()) {
                    z3 = false;
                } else {
                    int size = this.f214a.size();
                    z3 = false;
                    for (int i2 = 0; i2 < size; i2++) {
                        z3 |= this.f214a.get(i2).a(arrayList, arrayList2);
                    }
                    this.f214a.clear();
                    this.q.h.removeCallbacks(this.K);
                }
            }
            if (z3) {
                this.b = true;
                try {
                    a0(this.F, this.G);
                    e();
                    z4 = true;
                } catch (Throwable th) {
                    e();
                    throw th;
                }
            } else {
                l0();
                x();
                this.c.b();
                return z4;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public void D(l lVar, boolean z2) {
        if (!z2 || (this.q != null && !this.D)) {
            B(z2);
            ((ke) lVar).a(this.F, this.G);
            this.b = true;
            try {
                a0(this.F, this.G);
                e();
                l0();
                x();
                this.c.b();
            } catch (Throwable th) {
                e();
                throw th;
            }
        }
    }

    public final void E(ArrayList<ke> arrayList, ArrayList<Boolean> arrayList2, int i2, int i3) {
        ViewGroup viewGroup;
        int i4;
        int i5;
        ArrayList<Boolean> arrayList3 = arrayList2;
        boolean z2 = arrayList.get(i2).p;
        ArrayList<Fragment> arrayList4 = this.H;
        if (arrayList4 == null) {
            this.H = new ArrayList<>();
        } else {
            arrayList4.clear();
        }
        this.H.addAll(this.c.i());
        Fragment fragment = this.t;
        int i6 = i2;
        boolean z3 = false;
        while (true) {
            int i7 = 1;
            if (i6 < i3) {
                ke keVar = arrayList.get(i6);
                int i8 = 3;
                if (!arrayList3.get(i6).booleanValue()) {
                    ArrayList<Fragment> arrayList5 = this.H;
                    int i9 = 0;
                    while (i9 < keVar.f2365a.size()) {
                        mf.a aVar = keVar.f2365a.get(i9);
                        int i10 = aVar.f2366a;
                        if (i10 != i7) {
                            if (i10 == 2) {
                                Fragment fragment2 = aVar.b;
                                int i11 = fragment2.mContainerId;
                                int size = arrayList5.size() - 1;
                                boolean z4 = false;
                                while (size >= 0) {
                                    Fragment fragment3 = arrayList5.get(size);
                                    if (fragment3.mContainerId != i11) {
                                        i5 = i11;
                                    } else if (fragment3 == fragment2) {
                                        i5 = i11;
                                        z4 = true;
                                    } else {
                                        if (fragment3 == fragment) {
                                            i5 = i11;
                                            keVar.f2365a.add(i9, new mf.a(9, fragment3));
                                            i9++;
                                            fragment = null;
                                        } else {
                                            i5 = i11;
                                        }
                                        mf.a aVar2 = new mf.a(3, fragment3);
                                        aVar2.c = aVar.c;
                                        aVar2.e = aVar.e;
                                        aVar2.d = aVar.d;
                                        aVar2.f = aVar.f;
                                        keVar.f2365a.add(i9, aVar2);
                                        arrayList5.remove(fragment3);
                                        i9++;
                                    }
                                    size--;
                                    i11 = i5;
                                }
                                if (z4) {
                                    keVar.f2365a.remove(i9);
                                    i9--;
                                } else {
                                    i4 = 1;
                                    aVar.f2366a = 1;
                                    arrayList5.add(fragment2);
                                    i9 += i4;
                                    i7 = 1;
                                    i8 = 3;
                                }
                            } else if (i10 == i8 || i10 == 6) {
                                arrayList5.remove(aVar.b);
                                Fragment fragment4 = aVar.b;
                                if (fragment4 == fragment) {
                                    keVar.f2365a.add(i9, new mf.a(9, fragment4));
                                    i9++;
                                    i4 = 1;
                                    fragment = null;
                                    i9 += i4;
                                    i7 = 1;
                                    i8 = 3;
                                }
                            } else if (i10 != 7) {
                                if (i10 == 8) {
                                    keVar.f2365a.add(i9, new mf.a(9, fragment));
                                    i9++;
                                    fragment = aVar.b;
                                }
                            }
                            i4 = 1;
                            i9 += i4;
                            i7 = 1;
                            i8 = 3;
                        }
                        i4 = 1;
                        arrayList5.add(aVar.b);
                        i9 += i4;
                        i7 = 1;
                        i8 = 3;
                    }
                } else {
                    int i12 = 1;
                    ArrayList<Fragment> arrayList6 = this.H;
                    int size2 = keVar.f2365a.size() - 1;
                    while (size2 >= 0) {
                        mf.a aVar3 = keVar.f2365a.get(size2);
                        int i13 = aVar3.f2366a;
                        if (i13 != i12) {
                            if (i13 != 3) {
                                switch (i13) {
                                    case 8:
                                        fragment = null;
                                        break;
                                    case 9:
                                        fragment = aVar3.b;
                                        break;
                                    case 10:
                                        aVar3.h = aVar3.g;
                                        break;
                                }
                                size2--;
                                i12 = 1;
                            }
                            arrayList6.add(aVar3.b);
                            size2--;
                            i12 = 1;
                        }
                        arrayList6.remove(aVar3.b);
                        size2--;
                        i12 = 1;
                    }
                }
                z3 = z3 || keVar.g;
                i6++;
                arrayList3 = arrayList2;
            } else {
                this.H.clear();
                if (!z2 && this.p >= 1) {
                    for (int i14 = i2; i14 < i3; i14++) {
                        Iterator<mf.a> it = arrayList.get(i14).f2365a.iterator();
                        while (it.hasNext()) {
                            Fragment fragment5 = it.next().b;
                            if (!(fragment5 == null || fragment5.mFragmentManager == null)) {
                                this.c.j(h(fragment5));
                            }
                        }
                    }
                }
                int i15 = i2;
                while (i15 < i3) {
                    ke keVar2 = arrayList.get(i15);
                    if (arrayList2.get(i15).booleanValue()) {
                        keVar2.h(-1);
                        keVar2.m(i15 == i3 + -1);
                    } else {
                        keVar2.h(1);
                        keVar2.l();
                    }
                    i15++;
                }
                boolean booleanValue = arrayList2.get(i3 - 1).booleanValue();
                for (int i16 = i2; i16 < i3; i16++) {
                    ke keVar3 = arrayList.get(i16);
                    if (booleanValue) {
                        for (int size3 = keVar3.f2365a.size() - 1; size3 >= 0; size3--) {
                            Fragment fragment6 = keVar3.f2365a.get(size3).b;
                            if (fragment6 != null) {
                                h(fragment6).k();
                            }
                        }
                    } else {
                        Iterator<mf.a> it2 = keVar3.f2365a.iterator();
                        while (it2.hasNext()) {
                            Fragment fragment7 = it2.next().b;
                            if (fragment7 != null) {
                                h(fragment7).k();
                            }
                        }
                    }
                }
                T(this.p, true);
                HashSet hashSet = new HashSet();
                for (int i17 = i2; i17 < i3; i17++) {
                    Iterator<mf.a> it3 = arrayList.get(i17).f2365a.iterator();
                    while (it3.hasNext()) {
                        Fragment fragment8 = it3.next().b;
                        if (!(fragment8 == null || (viewGroup = fragment8.mContainer) == null)) {
                            hashSet.add(bg.g(viewGroup, M()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    bg bgVar = (bg) it4.next();
                    bgVar.d = booleanValue;
                    bgVar.h();
                    bgVar.c();
                }
                for (int i18 = i2; i18 < i3; i18++) {
                    ke keVar4 = arrayList.get(i18);
                    if (arrayList2.get(i18).booleanValue() && keVar4.s >= 0) {
                        keVar4.s = -1;
                    }
                    Objects.requireNonNull(keVar4);
                }
                return;
            }
        }
    }

    public final void F(ArrayList<ke> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<n> arrayList3 = this.I;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i2 = 0;
        while (i2 < size) {
            n nVar = this.I.get(i2);
            if (arrayList == null || nVar.f220a || (indexOf2 = arrayList.indexOf(nVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf2).booleanValue()) {
                if ((nVar.c == 0) || (arrayList != null && nVar.b.o(arrayList, 0, arrayList.size()))) {
                    this.I.remove(i2);
                    i2--;
                    size--;
                    if (arrayList == null || nVar.f220a || (indexOf = arrayList.indexOf(nVar.b)) == -1 || arrayList2 == null || !arrayList2.get(indexOf).booleanValue()) {
                        nVar.a();
                    } else {
                        ke keVar = nVar.b;
                        keVar.q.g(keVar, nVar.f220a, false, false);
                    }
                }
            } else {
                this.I.remove(i2);
                i2--;
                size--;
                ke keVar2 = nVar.b;
                keVar2.q.g(keVar2, nVar.f220a, false, false);
            }
            i2++;
        }
    }

    public Fragment G(String str) {
        return this.c.d(str);
    }

    public Fragment H(int i2) {
        lf lfVar = this.c;
        int size = lfVar.f2206a.size();
        while (true) {
            size--;
            if (size >= 0) {
                Fragment fragment = lfVar.f2206a.get(size);
                if (fragment != null && fragment.mFragmentId == i2) {
                    return fragment;
                }
            } else {
                for (kf kfVar : lfVar.b.values()) {
                    if (kfVar != null) {
                        Fragment fragment2 = kfVar.c;
                        if (fragment2.mFragmentId == i2) {
                            return fragment2;
                        }
                    }
                }
                return null;
            }
        }
    }

    public Fragment I(String str) {
        lf lfVar = this.c;
        Objects.requireNonNull(lfVar);
        if (str != null) {
            int size = lfVar.f2206a.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                }
                Fragment fragment = lfVar.f2206a.get(size);
                if (fragment != null && str.equals(fragment.mTag)) {
                    return fragment;
                }
            }
        }
        if (str != null) {
            for (kf kfVar : lfVar.b.values()) {
                if (kfVar != null) {
                    Fragment fragment2 = kfVar.c;
                    if (str.equals(fragment2.mTag)) {
                        return fragment2;
                    }
                }
            }
        }
        return null;
    }

    public final ViewGroup J(Fragment fragment) {
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.mContainerId > 0 && this.r.c()) {
            View b2 = this.r.b(fragment.mContainerId);
            if (b2 instanceof ViewGroup) {
                return (ViewGroup) b2;
            }
        }
        return null;
    }

    public df K() {
        Fragment fragment = this.s;
        if (fragment != null) {
            return fragment.mFragmentManager.K();
        }
        return this.u;
    }

    public List<Fragment> L() {
        return this.c.i();
    }

    public cg M() {
        Fragment fragment = this.s;
        if (fragment != null) {
            return fragment.mFragmentManager.M();
        }
        return this.v;
    }

    public void N(Fragment fragment) {
        if (O(2)) {
            String str = "hide: " + fragment;
        }
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            fragment.mHiddenChanged = true ^ fragment.mHiddenChanged;
            h0(fragment);
        }
    }

    public final boolean P(Fragment fragment) {
        boolean z2;
        if (fragment.mHasMenu && fragment.mMenuVisible) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mChildFragmentManager;
        Iterator it = ((ArrayList) fragmentManager.c.g()).iterator();
        boolean z3 = false;
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Fragment fragment2 = (Fragment) it.next();
            if (fragment2 != null) {
                z3 = fragmentManager.P(fragment2);
                continue;
            }
            if (z3) {
                z2 = true;
                break;
            }
        }
        if (z2) {
            return true;
        }
        return false;
    }

    public boolean Q(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        return fragment.isMenuVisible();
    }

    public boolean R(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        FragmentManager fragmentManager = fragment.mFragmentManager;
        if (!fragment.equals(fragmentManager.t) || !R(fragmentManager.s)) {
            return false;
        }
        return true;
    }

    public boolean S() {
        return this.B || this.C;
    }

    public void T(int i2, boolean z2) {
        ef<?> efVar;
        if (this.q == null && i2 != -1) {
            throw new IllegalStateException("No activity");
        } else if (z2 || i2 != this.p) {
            this.p = i2;
            lf lfVar = this.c;
            Iterator<Fragment> it = lfVar.f2206a.iterator();
            while (it.hasNext()) {
                kf kfVar = lfVar.b.get(it.next().mWho);
                if (kfVar != null) {
                    kfVar.k();
                }
            }
            Iterator<kf> it2 = lfVar.b.values().iterator();
            while (true) {
                boolean z3 = false;
                if (!it2.hasNext()) {
                    break;
                }
                kf next = it2.next();
                if (next != null) {
                    next.k();
                    Fragment fragment = next.c;
                    if (fragment.mRemoving && !fragment.isInBackStack()) {
                        z3 = true;
                    }
                    if (z3) {
                        lfVar.k(next);
                    }
                }
            }
            j0();
            if (this.A && (efVar = this.q) != null && this.p == 7) {
                efVar.i();
                this.A = false;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005a, code lost:
        if (r1 != 5) goto L_0x01ad;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U(androidx.fragment.app.Fragment r17, int r18) {
        /*
        // Method dump skipped, instructions count: 477
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.U(androidx.fragment.app.Fragment, int):void");
    }

    public void V() {
        if (this.q != null) {
            this.B = false;
            this.C = false;
            this.J.h = false;
            for (Fragment fragment : this.c.i()) {
                if (fragment != null) {
                    fragment.noteStateNotSaved();
                }
            }
        }
    }

    public void W(kf kfVar) {
        Fragment fragment = kfVar.c;
        if (!fragment.mDeferStart) {
            return;
        }
        if (this.b) {
            this.E = true;
            return;
        }
        fragment.mDeferStart = false;
        kfVar.k();
    }

    public boolean X() {
        C(false);
        B(true);
        Fragment fragment = this.t;
        if (fragment != null && fragment.getChildFragmentManager().X()) {
            return true;
        }
        boolean Y = Y(this.F, this.G, null, -1, 0);
        if (Y) {
            this.b = true;
            try {
                a0(this.F, this.G);
            } finally {
                e();
            }
        }
        l0();
        x();
        this.c.b();
        return Y;
    }

    public boolean Y(ArrayList<ke> arrayList, ArrayList<Boolean> arrayList2, String str, int i2, int i3) {
        Boolean bool = Boolean.TRUE;
        ArrayList<ke> arrayList3 = this.d;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i2 < 0 && (i3 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.d.remove(size));
            arrayList2.add(bool);
        } else {
            int i4 = -1;
            if (str != null || i2 >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    ke keVar = this.d.get(size2);
                    if ((str != null && str.equals(keVar.i)) || (i2 >= 0 && i2 == keVar.s)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i3 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        ke keVar2 = this.d.get(size2);
                        if ((str == null || !str.equals(keVar2.i)) && (i2 < 0 || i2 != keVar2.s)) {
                            break;
                        }
                    }
                }
                i4 = size2;
            }
            if (i4 == this.d.size() - 1) {
                return false;
            }
            for (int size3 = this.d.size() - 1; size3 > i4; size3--) {
                arrayList.add(this.d.remove(size3));
                arrayList2.add(bool);
            }
        }
        return true;
    }

    public void Z(Fragment fragment) {
        if (O(2)) {
            String str = "remove: " + fragment + " nesting=" + fragment.mBackStackNesting;
        }
        boolean z2 = !fragment.isInBackStack();
        if (!fragment.mDetached || z2) {
            this.c.l(fragment);
            if (P(fragment)) {
                this.A = true;
            }
            fragment.mRemoving = true;
            h0(fragment);
        }
    }

    public kf a(Fragment fragment) {
        if (O(2)) {
            String str = "add: " + fragment;
        }
        kf h2 = h(fragment);
        fragment.mFragmentManager = this;
        this.c.j(h2);
        if (!fragment.mDetached) {
            this.c.a(fragment);
            fragment.mRemoving = false;
            if (fragment.mView == null) {
                fragment.mHiddenChanged = false;
            }
            if (P(fragment)) {
                this.A = true;
            }
        }
        return h2;
    }

    public final void a0(ArrayList<ke> arrayList, ArrayList<Boolean> arrayList2) {
        if (!arrayList.isEmpty()) {
            if (arrayList.size() == arrayList2.size()) {
                F(arrayList, arrayList2);
                int size = arrayList.size();
                int i2 = 0;
                int i3 = 0;
                while (i2 < size) {
                    if (!arrayList.get(i2).p) {
                        if (i3 != i2) {
                            E(arrayList, arrayList2, i3, i2);
                        }
                        i3 = i2 + 1;
                        if (arrayList2.get(i2).booleanValue()) {
                            while (i3 < size && arrayList2.get(i3).booleanValue() && !arrayList.get(i3).p) {
                                i3++;
                            }
                        }
                        E(arrayList, arrayList2, i2, i3);
                        i2 = i3 - 1;
                    }
                    i2++;
                }
                if (i3 != size) {
                    E(arrayList, arrayList2, i3, size);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Internal error with the back stack records");
        }
    }

    @SuppressLint({"SyntheticAccessor"})
    public void b(ef<?> efVar, bf bfVar, Fragment fragment) {
        zh zhVar;
        if (this.q == null) {
            this.q = efVar;
            this.r = bfVar;
            this.s = fragment;
            if (fragment != null) {
                this.o.add(new h(this, fragment));
            } else if (efVar instanceof jf) {
                this.o.add((jf) efVar);
            }
            if (this.s != null) {
                l0();
            }
            if (efVar instanceof defpackage.n) {
                defpackage.n nVar = (defpackage.n) efVar;
                OnBackPressedDispatcher onBackPressedDispatcher = nVar.getOnBackPressedDispatcher();
                this.g = onBackPressedDispatcher;
                fh fhVar = nVar;
                if (fragment != null) {
                    fhVar = fragment;
                }
                onBackPressedDispatcher.a(fhVar, this.h);
            }
            if (fragment != null) {
                Cif ifVar = fragment.mFragmentManager.J;
                Cif ifVar2 = ifVar.d.get(fragment.mWho);
                if (ifVar2 == null) {
                    ifVar2 = new Cif(ifVar.f);
                    ifVar.d.put(fragment.mWho, ifVar2);
                }
                this.J = ifVar2;
            } else if (efVar instanceof hi) {
                gi viewModelStore = ((hi) efVar).getViewModelStore();
                ci ciVar = Cif.i;
                String canonicalName = Cif.class.getCanonicalName();
                if (canonicalName != null) {
                    String S = hj1.S("androidx.lifecycle.ViewModelProvider.DefaultKey:", canonicalName);
                    zh zhVar2 = viewModelStore.f1264a.get(S);
                    if (!Cif.class.isInstance(zhVar2)) {
                        if (ciVar instanceof di) {
                            zhVar = ((di) ciVar).c(S, Cif.class);
                        } else {
                            zhVar = ((Cif.a) ciVar).a(Cif.class);
                        }
                        zhVar2 = zhVar;
                        zh put = viewModelStore.f1264a.put(S, zhVar2);
                        if (put != null) {
                            put.b();
                        }
                    } else if (ciVar instanceof fi) {
                        ((fi) ciVar).b(zhVar2);
                    }
                    this.J = (Cif) zhVar2;
                } else {
                    throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
                }
            } else {
                this.J = new Cif(false);
            }
            this.J.h = S();
            this.c.c = this.J;
            ef<?> efVar2 = this.q;
            if (efVar2 instanceof s) {
                ActivityResultRegistry activityResultRegistry = ((s) efVar2).getActivityResultRegistry();
                String S2 = hj1.S("FragmentManager:", fragment != null ? hj1.a0(new StringBuilder(), fragment.mWho, ProductDiscountsObject.KEY_DELIMITER) : "");
                this.w = activityResultRegistry.c(hj1.S(S2, "StartActivityForResult"), new w(), new i());
                this.x = activityResultRegistry.c(hj1.S(S2, "StartIntentSenderForResult"), new j(), new a());
                this.y = activityResultRegistry.c(hj1.S(S2, "RequestPermissions"), new u(), new b());
                return;
            }
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    public void b0(Parcelable parcelable) {
        kf kfVar;
        if (parcelable != null) {
            FragmentManagerState fragmentManagerState = (FragmentManagerState) parcelable;
            if (fragmentManagerState.f != null) {
                this.c.b.clear();
                Iterator<FragmentState> it = fragmentManagerState.f.iterator();
                while (it.hasNext()) {
                    FragmentState next = it.next();
                    if (next != null) {
                        Fragment fragment = this.J.c.get(next.g);
                        if (fragment != null) {
                            if (O(2)) {
                                String str = "restoreSaveState: re-attaching retained " + fragment;
                            }
                            kfVar = new kf(this.n, this.c, fragment, next);
                        } else {
                            kfVar = new kf(this.n, this.c, this.q.g.getClassLoader(), K(), next);
                        }
                        Fragment fragment2 = kfVar.c;
                        fragment2.mFragmentManager = this;
                        if (O(2)) {
                            StringBuilder i0 = hj1.i0("restoreSaveState: active (");
                            i0.append(fragment2.mWho);
                            i0.append("): ");
                            i0.append(fragment2);
                            i0.toString();
                        }
                        kfVar.m(this.q.g.getClassLoader());
                        this.c.j(kfVar);
                        kfVar.e = this.p;
                    }
                }
                Cif ifVar = this.J;
                Objects.requireNonNull(ifVar);
                Iterator it2 = new ArrayList(ifVar.c.values()).iterator();
                while (it2.hasNext()) {
                    Fragment fragment3 = (Fragment) it2.next();
                    if (!this.c.c(fragment3.mWho)) {
                        if (O(2)) {
                            String str2 = "Discarding retained Fragment " + fragment3 + " that was not found in the set of active Fragments " + fragmentManagerState.f;
                        }
                        this.J.e(fragment3);
                        fragment3.mFragmentManager = this;
                        kf kfVar2 = new kf(this.n, this.c, fragment3);
                        kfVar2.e = 1;
                        kfVar2.k();
                        fragment3.mRemoving = true;
                        kfVar2.k();
                    }
                }
                lf lfVar = this.c;
                ArrayList<String> arrayList = fragmentManagerState.g;
                lfVar.f2206a.clear();
                if (arrayList != null) {
                    for (String str3 : arrayList) {
                        Fragment d2 = lfVar.d(str3);
                        if (d2 != null) {
                            if (O(2)) {
                                String str4 = "restoreSaveState: added (" + str3 + "): " + d2;
                            }
                            lfVar.a(d2);
                        } else {
                            throw new IllegalStateException(hj1.T("No instantiated fragment for (", str3, ")"));
                        }
                    }
                }
                if (fragmentManagerState.h != null) {
                    this.d = new ArrayList<>(fragmentManagerState.h.length);
                    int i2 = 0;
                    while (true) {
                        BackStackState[] backStackStateArr = fragmentManagerState.h;
                        if (i2 >= backStackStateArr.length) {
                            break;
                        }
                        BackStackState backStackState = backStackStateArr[i2];
                        Objects.requireNonNull(backStackState);
                        ke keVar = new ke(this);
                        int i3 = 0;
                        int i4 = 0;
                        while (true) {
                            int[] iArr = backStackState.f;
                            if (i3 >= iArr.length) {
                                break;
                            }
                            mf.a aVar = new mf.a();
                            int i5 = i3 + 1;
                            aVar.f2366a = iArr[i3];
                            if (O(2)) {
                                String str5 = "Instantiate " + keVar + " op #" + i4 + " base fragment #" + backStackState.f[i5];
                            }
                            String str6 = backStackState.g.get(i4);
                            if (str6 != null) {
                                aVar.b = this.c.d(str6);
                            } else {
                                aVar.b = null;
                            }
                            aVar.g = zg.b.values()[backStackState.h[i4]];
                            aVar.h = zg.b.values()[backStackState.i[i4]];
                            int[] iArr2 = backStackState.f;
                            int i6 = i5 + 1;
                            int i7 = iArr2[i5];
                            aVar.c = i7;
                            int i8 = i6 + 1;
                            int i9 = iArr2[i6];
                            aVar.d = i9;
                            int i10 = i8 + 1;
                            int i11 = iArr2[i8];
                            aVar.e = i11;
                            int i12 = iArr2[i10];
                            aVar.f = i12;
                            keVar.b = i7;
                            keVar.c = i9;
                            keVar.d = i11;
                            keVar.e = i12;
                            keVar.b(aVar);
                            i4++;
                            i3 = i10 + 1;
                        }
                        keVar.f = backStackState.j;
                        keVar.i = backStackState.k;
                        keVar.s = backStackState.l;
                        keVar.g = true;
                        keVar.j = backStackState.m;
                        keVar.k = backStackState.n;
                        keVar.l = backStackState.o;
                        keVar.m = backStackState.p;
                        keVar.n = backStackState.q;
                        keVar.o = backStackState.r;
                        keVar.p = backStackState.s;
                        keVar.h(1);
                        if (O(2)) {
                            StringBuilder j0 = hj1.j0("restoreAllState: back stack #", i2, " (index ");
                            j0.append(keVar.s);
                            j0.append("): ");
                            j0.append(keVar);
                            j0.toString();
                            PrintWriter printWriter = new PrintWriter(new ag("FragmentManager"));
                            keVar.k("  ", printWriter, false);
                            printWriter.close();
                        }
                        this.d.add(keVar);
                        i2++;
                    }
                } else {
                    this.d = null;
                }
                this.i.set(fragmentManagerState.i);
                String str7 = fragmentManagerState.j;
                if (str7 != null) {
                    Fragment G2 = G(str7);
                    this.t = G2;
                    t(G2);
                }
                ArrayList<String> arrayList2 = fragmentManagerState.k;
                if (arrayList2 != null) {
                    for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                        Bundle bundle = fragmentManagerState.l.get(i13);
                        bundle.setClassLoader(this.q.g.getClassLoader());
                        this.j.put(arrayList2.get(i13), bundle);
                    }
                }
                this.z = new ArrayDeque<>(fragmentManagerState.m);
            }
        }
    }

    public void c(Fragment fragment) {
        if (O(2)) {
            String str = "attach: " + fragment;
        }
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                this.c.a(fragment);
                if (O(2)) {
                    String str2 = "add from attach: " + fragment;
                }
                if (P(fragment)) {
                    this.A = true;
                }
            }
        }
    }

    public Parcelable c0() {
        int i2;
        ArrayList<String> arrayList;
        int size;
        Iterator it = ((HashSet) f()).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            bg bgVar = (bg) it.next();
            if (bgVar.e) {
                bgVar.e = false;
                bgVar.c();
            }
        }
        z();
        C(true);
        this.B = true;
        this.J.h = true;
        lf lfVar = this.c;
        Objects.requireNonNull(lfVar);
        ArrayList<FragmentState> arrayList2 = new ArrayList<>(lfVar.b.size());
        for (kf kfVar : lfVar.b.values()) {
            if (kfVar != null) {
                Fragment fragment = kfVar.c;
                FragmentState fragmentState = new FragmentState(fragment);
                Fragment fragment2 = kfVar.c;
                if (fragment2.mState <= -1 || fragmentState.r != null) {
                    fragmentState.r = fragment2.mSavedFragmentState;
                } else {
                    Bundle o2 = kfVar.o();
                    fragmentState.r = o2;
                    if (kfVar.c.mTargetWho != null) {
                        if (o2 == null) {
                            fragmentState.r = new Bundle();
                        }
                        fragmentState.r.putString("android:target_state", kfVar.c.mTargetWho);
                        int i3 = kfVar.c.mTargetRequestCode;
                        if (i3 != 0) {
                            fragmentState.r.putInt("android:target_req_state", i3);
                        }
                    }
                }
                arrayList2.add(fragmentState);
                if (O(2)) {
                    String str = "Saved state of " + fragment + ": " + fragmentState.r;
                }
            }
        }
        BackStackState[] backStackStateArr = null;
        if (arrayList2.isEmpty()) {
            return null;
        }
        lf lfVar2 = this.c;
        synchronized (lfVar2.f2206a) {
            if (lfVar2.f2206a.isEmpty()) {
                arrayList = null;
            } else {
                arrayList = new ArrayList<>(lfVar2.f2206a.size());
                Iterator<Fragment> it2 = lfVar2.f2206a.iterator();
                while (it2.hasNext()) {
                    Fragment next = it2.next();
                    arrayList.add(next.mWho);
                    if (O(2)) {
                        String str2 = "saveAllState: adding fragment (" + next.mWho + "): " + next;
                    }
                }
            }
        }
        ArrayList<ke> arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            backStackStateArr = new BackStackState[size];
            for (i2 = 0; i2 < size; i2++) {
                backStackStateArr[i2] = new BackStackState(this.d.get(i2));
                if (O(2)) {
                    StringBuilder j0 = hj1.j0("saveAllState: adding back stack #", i2, ": ");
                    j0.append(this.d.get(i2));
                    j0.toString();
                }
            }
        }
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.f = arrayList2;
        fragmentManagerState.g = arrayList;
        fragmentManagerState.h = backStackStateArr;
        fragmentManagerState.i = this.i.get();
        Fragment fragment3 = this.t;
        if (fragment3 != null) {
            fragmentManagerState.j = fragment3.mWho;
        }
        fragmentManagerState.k.addAll(this.j.keySet());
        fragmentManagerState.l.addAll(this.j.values());
        fragmentManagerState.m = new ArrayList<>(this.z);
        return fragmentManagerState;
    }

    public final void d(Fragment fragment) {
        HashSet<t6> hashSet = this.l.get(fragment);
        if (hashSet != null) {
            Iterator<t6> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            hashSet.clear();
            i(fragment);
            this.l.remove(fragment);
        }
    }

    public void d0() {
        synchronized (this.f214a) {
            ArrayList<n> arrayList = this.I;
            boolean z2 = false;
            boolean z3 = arrayList != null && !arrayList.isEmpty();
            if (this.f214a.size() == 1) {
                z2 = true;
            }
            if (z3 || z2) {
                this.q.h.removeCallbacks(this.K);
                this.q.h.post(this.K);
                l0();
            }
        }
    }

    public final void e() {
        this.b = false;
        this.G.clear();
        this.F.clear();
    }

    public void e0(Fragment fragment, boolean z2) {
        ViewGroup J2 = J(fragment);
        if (J2 != null && (J2 instanceof FragmentContainerView)) {
            ((FragmentContainerView) J2).setDrawDisappearingViewsLast(!z2);
        }
    }

    public final Set<bg> f() {
        HashSet hashSet = new HashSet();
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((kf) it.next()).c.mContainer;
            if (viewGroup != null) {
                hashSet.add(bg.g(viewGroup, M()));
            }
        }
        return hashSet;
    }

    public void f0(Fragment fragment, zg.b bVar) {
        if (!fragment.equals(G(fragment.mWho)) || !(fragment.mHost == null || fragment.mFragmentManager == this)) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        fragment.mMaxState = bVar;
    }

    public void g(ke keVar, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            keVar.m(z4);
        } else {
            keVar.l();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(keVar);
        arrayList2.add(Boolean.valueOf(z2));
        if (z3 && this.p >= 1) {
            tf.q(this.q.g, this.r, arrayList, arrayList2, 0, 1, true, this.m);
        }
        if (z4) {
            T(this.p, true);
        }
        Iterator it = ((ArrayList) this.c.g()).iterator();
        while (it.hasNext()) {
            Fragment fragment = (Fragment) it.next();
            if (fragment != null && fragment.mView != null && fragment.mIsNewlyAdded && keVar.n(fragment.mContainerId)) {
                float f2 = fragment.mPostponedAlpha;
                if (f2 > 0.0f) {
                    fragment.mView.setAlpha(f2);
                }
                if (z4) {
                    fragment.mPostponedAlpha = 0.0f;
                } else {
                    fragment.mPostponedAlpha = -1.0f;
                    fragment.mIsNewlyAdded = false;
                }
            }
        }
    }

    public void g0(Fragment fragment) {
        if (fragment == null || (fragment.equals(G(fragment.mWho)) && (fragment.mHost == null || fragment.mFragmentManager == this))) {
            Fragment fragment2 = this.t;
            this.t = fragment;
            t(fragment2);
            t(this.t);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    public kf h(Fragment fragment) {
        kf h2 = this.c.h(fragment.mWho);
        if (h2 != null) {
            return h2;
        }
        kf kfVar = new kf(this.n, this.c, fragment);
        kfVar.m(this.q.g.getClassLoader());
        kfVar.e = this.p;
        return kfVar;
    }

    public final void h0(Fragment fragment) {
        ViewGroup J2 = J(fragment);
        if (J2 != null) {
            if (fragment.getPopExitAnim() + fragment.getPopEnterAnim() + fragment.getExitAnim() + fragment.getEnterAnim() > 0) {
                int i2 = R.id.visible_removing_fragment_view_tag;
                if (J2.getTag(i2) == null) {
                    J2.setTag(i2, fragment);
                }
                ((Fragment) J2.getTag(i2)).setPopDirection(fragment.getPopDirection());
            }
        }
    }

    public final void i(Fragment fragment) {
        fragment.performDestroyView();
        this.n.n(fragment, false);
        fragment.mContainer = null;
        fragment.mView = null;
        fragment.mViewLifecycleOwner = null;
        fragment.mViewLifecycleOwnerLiveData.l(null);
        fragment.mInLayout = false;
    }

    public void i0(Fragment fragment) {
        if (O(2)) {
            String str = "show: " + fragment;
        }
        if (fragment.mHidden) {
            fragment.mHidden = false;
            fragment.mHiddenChanged = !fragment.mHiddenChanged;
        }
    }

    public void j(Fragment fragment) {
        if (O(2)) {
            String str = "detach: " + fragment;
        }
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                if (O(2)) {
                    String str2 = "remove from detach: " + fragment;
                }
                this.c.l(fragment);
                if (P(fragment)) {
                    this.A = true;
                }
                h0(fragment);
            }
        }
    }

    public final void j0() {
        Iterator it = ((ArrayList) this.c.f()).iterator();
        while (it.hasNext()) {
            W((kf) it.next());
        }
    }

    public void k(Configuration configuration) {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performConfigurationChanged(configuration);
            }
        }
    }

    public final void k0(RuntimeException runtimeException) {
        runtimeException.getMessage();
        PrintWriter printWriter = new PrintWriter(new ag("FragmentManager"));
        ef<?> efVar = this.q;
        if (efVar != null) {
            try {
                efVar.d("  ", null, printWriter, new String[0]);
            } catch (Exception unused) {
            }
        } else {
            y("  ", null, printWriter, new String[0]);
        }
        throw runtimeException;
    }

    public boolean l(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && fragment.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        if (r1 == null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001a, code lost:
        r1 = r1.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
        if (r1 <= 0) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (R(r4.s) == false) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r0.f2142a = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        r0 = r4.h;
        r1 = r4.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void l0() {
        /*
            r4 = this;
            java.util.ArrayList<androidx.fragment.app.FragmentManager$l> r0 = r4.f214a
            monitor-enter(r0)
            java.util.ArrayList<androidx.fragment.app.FragmentManager$l> r1 = r4.f214a     // Catch:{ all -> 0x002f }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x002f }
            r2 = 1
            if (r1 != 0) goto L_0x0012
            l r1 = r4.h     // Catch:{ all -> 0x002f }
            r1.f2142a = r2     // Catch:{ all -> 0x002f }
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            l r0 = r4.h
            java.util.ArrayList<ke> r1 = r4.d
            r3 = 0
            if (r1 == 0) goto L_0x001f
            int r1 = r1.size()
            goto L_0x0020
        L_0x001f:
            r1 = 0
        L_0x0020:
            if (r1 <= 0) goto L_0x002b
            androidx.fragment.app.Fragment r1 = r4.s
            boolean r1 = r4.R(r1)
            if (r1 == 0) goto L_0x002b
            goto L_0x002c
        L_0x002b:
            r2 = 0
        L_0x002c:
            r0.f2142a = r2
            return
        L_0x002f:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.FragmentManager.l0():void");
    }

    public void m() {
        this.B = false;
        this.C = false;
        this.J.h = false;
        w(1);
    }

    public boolean n(Menu menu, MenuInflater menuInflater) {
        if (this.p < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z2 = false;
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && Q(fragment) && fragment.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z2 = true;
            }
        }
        if (this.e != null) {
            for (int i2 = 0; i2 < this.e.size(); i2++) {
                Fragment fragment2 = this.e.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z2;
    }

    public void o() {
        this.D = true;
        C(true);
        z();
        w(-1);
        this.q = null;
        this.r = null;
        this.s = null;
        if (this.g != null) {
            this.h.b();
            this.g = null;
        }
        r<Intent> rVar = this.w;
        if (rVar != null) {
            rVar.b();
            this.x.b();
            this.y.b();
        }
    }

    public void p() {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performLowMemory();
            }
        }
    }

    public void q(boolean z2) {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performMultiWindowModeChanged(z2);
            }
        }
    }

    public boolean r(MenuItem menuItem) {
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && fragment.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void s(Menu menu) {
        if (this.p >= 1) {
            for (Fragment fragment : this.c.i()) {
                if (fragment != null) {
                    fragment.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public final void t(Fragment fragment) {
        if (fragment != null && fragment.equals(G(fragment.mWho))) {
            fragment.performPrimaryNavigationFragmentChanged();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.s;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.s)));
            sb.append("}");
        } else {
            ef<?> efVar = this.q;
            if (efVar != null) {
                sb.append(efVar.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.q)));
                sb.append("}");
            } else {
                sb.append(AnalyticsConstants.NULL);
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public void u(boolean z2) {
        for (Fragment fragment : this.c.i()) {
            if (fragment != null) {
                fragment.performPictureInPictureModeChanged(z2);
            }
        }
    }

    public boolean v(Menu menu) {
        boolean z2 = false;
        if (this.p < 1) {
            return false;
        }
        for (Fragment fragment : this.c.i()) {
            if (fragment != null && Q(fragment) && fragment.performPrepareOptionsMenu(menu)) {
                z2 = true;
            }
        }
        return z2;
    }

    /* JADX INFO: finally extract failed */
    public final void w(int i2) {
        try {
            this.b = true;
            for (kf kfVar : this.c.b.values()) {
                if (kfVar != null) {
                    kfVar.e = i2;
                }
            }
            T(i2, false);
            Iterator it = ((HashSet) f()).iterator();
            while (it.hasNext()) {
                ((bg) it.next()).e();
            }
            this.b = false;
            C(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final void x() {
        if (this.E) {
            this.E = false;
            j0();
        }
    }

    public void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String S = hj1.S(str, "    ");
        lf lfVar = this.c;
        Objects.requireNonNull(lfVar);
        String str2 = str + "    ";
        if (!lfVar.b.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (kf kfVar : lfVar.b.values()) {
                printWriter.print(str);
                if (kfVar != null) {
                    Fragment fragment = kfVar.c;
                    printWriter.println(fragment);
                    fragment.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println(AnalyticsConstants.NULL);
                }
            }
        }
        int size3 = lfVar.f2206a.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size3; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(lfVar.f2206a.get(i2).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.e;
        if (arrayList != null && (size2 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size2; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.e.get(i3).toString());
            }
        }
        ArrayList<ke> arrayList2 = this.d;
        if (arrayList2 != null && (size = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size; i4++) {
                ke keVar = this.d.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(keVar.toString());
                keVar.k(S, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.f214a) {
            int size4 = this.f214a.size();
            if (size4 > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                for (int i5 = 0; i5 < size4; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((l) this.f214a.get(i5));
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.q);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.r);
        if (this.s != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.s);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.p);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.B);
        printWriter.print(" mStopped=");
        printWriter.print(this.C);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.D);
        if (this.A) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.A);
        }
    }

    public final void z() {
        Iterator it = ((HashSet) f()).iterator();
        while (it.hasNext()) {
            ((bg) it.next()).e();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    public static class LaunchedFragmentInfo implements Parcelable {
        public static final Parcelable.Creator<LaunchedFragmentInfo> CREATOR = new a();
        public String f;
        public int g;

        public class a implements Parcelable.Creator<LaunchedFragmentInfo> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo createFromParcel(Parcel parcel) {
                return new LaunchedFragmentInfo(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public LaunchedFragmentInfo[] newArray(int i) {
                return new LaunchedFragmentInfo[i];
            }
        }

        public LaunchedFragmentInfo(String str, int i) {
            this.f = str;
            this.g = i;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f);
            parcel.writeInt(this.g);
        }

        public LaunchedFragmentInfo(Parcel parcel) {
            this.f = parcel.readString();
            this.g = parcel.readInt();
        }
    }
}
