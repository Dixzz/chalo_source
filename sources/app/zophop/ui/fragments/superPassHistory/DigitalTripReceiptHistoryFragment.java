package app.zophop.ui.fragments.superPassHistory;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import com.google.android.material.textview.MaterialTextView;

/* compiled from: DigitalTripReceiptHistoryFragment.kt */
public final class DigitalTripReceiptHistoryFragment extends ul0<mx> {
    public static final /* synthetic */ int k = 0;
    public final j56 g = h.B(this, z86.a(u91.class), new d(this), new e(this));
    public r91 h;
    public nu i;
    public final xi j = new xi(z86.a(b01.class), new f(this));

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class a extends o86 implements h76<Fragment> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Fragment invoke() {
            return this.f;
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class b extends o86 implements h76<gi> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(h76 h76) {
            super(0);
            this.f = h76;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            gi viewModelStore = ((hi) this.f.invoke()).getViewModelStore();
            n86.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: DigitalTripReceiptHistoryFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ DigitalTripReceiptHistoryFragment f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ SuperPassSubType i;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DigitalTripReceiptHistoryFragment digitalTripReceiptHistoryFragment, String str, String str2, SuperPassSubType superPassSubType) {
            super(0);
            this.f = digitalTripReceiptHistoryFragment;
            this.g = str;
            this.h = str2;
            this.i = superPassSubType;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.requireActivity().getApplication(), this.f, h.j(new m56("keySource", this.g), new m56("keySuperPassId", this.h), new m56("keySuperPassSubType", this.i)));
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class d extends o86 implements h76<gi> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            return hj1.j(this.f, "requireActivity()", "requireActivity().viewModelStore");
        }
    }

    /* compiled from: FragmentViewModelLazy.kt */
    public static final class e extends o86 implements h76<ci> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            ve requireActivity = this.f.requireActivity();
            n86.d(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    }

    /* compiled from: FragmentNavArgsLazy.kt */
    public static final class f extends o86 implements h76<Bundle> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Bundle invoke() {
            Bundle arguments = this.f.getArguments();
            if (arguments != null) {
                return arguments;
            }
            throw new IllegalStateException(hj1.Y(hj1.i0("Fragment "), this.f, " has null arguments"));
        }
    }

    @Override // defpackage.rl0
    public qo e() {
        View inflate = getLayoutInflater().inflate(R.layout.fragment_digital_trip_receipt_history, (ViewGroup) null, false);
        int i2 = R.id.trip_error_text;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.trip_error_text);
        if (materialTextView != null) {
            i2 = R.id.trip_error_title;
            MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.trip_error_title);
            if (materialTextView2 != null) {
                i2 = R.id.trip_receipt_history_recycler_view;
                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.trip_receipt_history_recycler_view);
                if (recyclerView != null) {
                    mx mxVar = new mx((ConstraintLayout) inflate, materialTextView, materialTextView2, recyclerView);
                    n86.d(mxVar, "inflate(layoutInflater)");
                    return mxVar;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // defpackage.ul0
    public void f() {
        String a2 = j().a();
        n86.d(a2, "args.argSource");
        String b2 = j().b();
        n86.d(b2, "args.argSuperPassId");
        SuperPassSubType c2 = j().c();
        n86.d(c2, "args.argSuperPassSubType");
        this.h = (r91) ((ai) h.B(this, z86.a(r91.class), new b(new a(this)), new c(this, a2, b2, c2))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        r91 r91 = this.h;
        if (r91 != null) {
            LiveData<SuperPass> liveData = r91.g;
            fh viewLifecycleOwner = getViewLifecycleOwner();
            n86.d(viewLifecycleOwner, "viewLifecycleOwner");
            xy0 xy0 = new xy0(this);
            n86.e(liveData, "<this>");
            n86.e(viewLifecycleOwner, "lifecycleOwner");
            n86.e(xy0, "observer");
            liveData.f(viewLifecycleOwner, new th1(xy0, liveData));
            r91 r912 = this.h;
            if (r912 != null) {
                r912.h.f(getViewLifecycleOwner(), new wy0(this));
            } else {
                n86.l("viewModel");
                throw null;
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }

    @Override // defpackage.ul0
    public void h() {
        this.i = new nu(new a01(this));
        T t = this.f;
        n86.c(t);
        RecyclerView recyclerView = ((mx) t).b;
        nu nuVar = this.i;
        if (nuVar != null) {
            recyclerView.setAdapter(nuVar);
        } else {
            n86.l("digitalTripReceiptsAdapter");
            throw null;
        }
    }

    public final void i(ed1 ed1) {
        r91 r91 = this.h;
        if (r91 != null) {
            ed1.a("source", r91.d);
            ed1.a("isSuperPass", Boolean.TRUE);
            return;
        }
        n86.l("viewModel");
        throw null;
    }

    public final b01 j() {
        return (b01) this.j.getValue();
    }
}
