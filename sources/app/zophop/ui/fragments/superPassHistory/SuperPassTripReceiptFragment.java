package app.zophop.ui.fragments.superPassHistory;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import app.zophop.R;
import app.zophop.models.mTicketing.digitalTripReceipt.DigitalTripReceiptJsonKeys;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import com.google.android.material.textview.MaterialTextView;

/* compiled from: SuperPassTripReceiptFragment.kt */
public final class SuperPassTripReceiptFragment extends ul0<rx> {
    public static final /* synthetic */ int j = 0;
    public final j56 g = h.B(this, z86.a(u91.class), new d(this), new e(this));
    public w91 h;
    public final xi i = new xi(z86.a(l01.class), new f(this));

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

    /* compiled from: SuperPassTripReceiptFragment.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassTripReceiptFragment f;
        public final /* synthetic */ String g;
        public final /* synthetic */ String h;
        public final /* synthetic */ SuperPassSubType i;
        public final /* synthetic */ long j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SuperPassTripReceiptFragment superPassTripReceiptFragment, String str, String str2, SuperPassSubType superPassSubType, long j2) {
            super(0);
            this.f = superPassTripReceiptFragment;
            this.g = str;
            this.h = str2;
            this.i = superPassSubType;
            this.j = j2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            return new xh(this.f.requireActivity().getApplication(), this.f, h.j(new m56("keySource", this.g), new m56("keySuperPassId", this.h), new m56("keySuperPassSubType", this.i), new m56("keySuperPassActivationTimeStamp", Long.valueOf(this.j))));
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
        View inflate = getLayoutInflater().inflate(R.layout.fragment_super_pass_trip_info, (ViewGroup) null, false);
        int i2 = R.id.conductor_id;
        MaterialTextView materialTextView = (MaterialTextView) inflate.findViewById(R.id.conductor_id);
        if (materialTextView != null) {
            i2 = R.id.conductor_id_title;
            MaterialTextView materialTextView2 = (MaterialTextView) inflate.findViewById(R.id.conductor_id_title);
            if (materialTextView2 != null) {
                i2 = R.id.conductor_info_layout;
                LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.conductor_info_layout);
                if (linearLayout != null) {
                    i2 = R.id.fare_info_layout;
                    LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.fare_info_layout);
                    if (linearLayout2 != null) {
                        i2 = R.id.info_not_available_layout;
                        LinearLayout linearLayout3 = (LinearLayout) inflate.findViewById(R.id.info_not_available_layout);
                        if (linearLayout3 != null) {
                            i2 = R.id.main_layout;
                            ScrollView scrollView = (ScrollView) inflate.findViewById(R.id.main_layout);
                            if (scrollView != null) {
                                i2 = R.id.ticket_count;
                                MaterialTextView materialTextView3 = (MaterialTextView) inflate.findViewById(R.id.ticket_count);
                                if (materialTextView3 != null) {
                                    i2 = R.id.ticket_count_layout;
                                    LinearLayout linearLayout4 = (LinearLayout) inflate.findViewById(R.id.ticket_count_layout);
                                    if (linearLayout4 != null) {
                                        i2 = R.id.ticket_count_title;
                                        MaterialTextView materialTextView4 = (MaterialTextView) inflate.findViewById(R.id.ticket_count_title);
                                        if (materialTextView4 != null) {
                                            i2 = R.id.ticket_fare;
                                            MaterialTextView materialTextView5 = (MaterialTextView) inflate.findViewById(R.id.ticket_fare);
                                            if (materialTextView5 != null) {
                                                i2 = R.id.ticket_fare_title;
                                                MaterialTextView materialTextView6 = (MaterialTextView) inflate.findViewById(R.id.ticket_fare_title);
                                                if (materialTextView6 != null) {
                                                    i2 = R.id.trip_details;
                                                    View findViewById = inflate.findViewById(R.id.trip_details);
                                                    if (findViewById != null) {
                                                        cz b2 = cz.b(findViewById);
                                                        i2 = R.id.trip_details_layout;
                                                        LinearLayout linearLayout5 = (LinearLayout) inflate.findViewById(R.id.trip_details_layout);
                                                        if (linearLayout5 != null) {
                                                            i2 = R.id.used_on_text;
                                                            MaterialTextView materialTextView7 = (MaterialTextView) inflate.findViewById(R.id.used_on_text);
                                                            if (materialTextView7 != null) {
                                                                i2 = R.id.used_on_title;
                                                                MaterialTextView materialTextView8 = (MaterialTextView) inflate.findViewById(R.id.used_on_title);
                                                                if (materialTextView8 != null) {
                                                                    i2 = R.id.user_details;
                                                                    View findViewById2 = inflate.findViewById(R.id.user_details);
                                                                    if (findViewById2 != null) {
                                                                        pz b3 = pz.b(findViewById2);
                                                                        i2 = R.id.vehicle_info_layout;
                                                                        LinearLayout linearLayout6 = (LinearLayout) inflate.findViewById(R.id.vehicle_info_layout);
                                                                        if (linearLayout6 != null) {
                                                                            i2 = R.id.vehicle_no;
                                                                            MaterialTextView materialTextView9 = (MaterialTextView) inflate.findViewById(R.id.vehicle_no);
                                                                            if (materialTextView9 != null) {
                                                                                i2 = R.id.vehicle_no_title;
                                                                                MaterialTextView materialTextView10 = (MaterialTextView) inflate.findViewById(R.id.vehicle_no_title);
                                                                                if (materialTextView10 != null) {
                                                                                    rx rxVar = new rx((ConstraintLayout) inflate, materialTextView, materialTextView2, linearLayout, linearLayout2, linearLayout3, scrollView, materialTextView3, linearLayout4, materialTextView4, materialTextView5, materialTextView6, b2, linearLayout5, materialTextView7, materialTextView8, b3, linearLayout6, materialTextView9, materialTextView10);
                                                                                    n86.d(rxVar, "inflate(layoutInflater)");
                                                                                    return rxVar;
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // defpackage.ul0
    public void f() {
        String b2 = j().b();
        n86.d(b2, "args.argSource");
        long a2 = j().a();
        SuperPassSubType d2 = j().d();
        n86.d(d2, "args.argSuperPassSubType");
        String c2 = j().c();
        n86.d(c2, "args.argSuperPassId");
        this.h = (w91) ((ai) h.B(this, z86.a(w91.class), new b(new a(this)), new c(this, b2, c2, d2, a2))).getValue();
    }

    @Override // defpackage.ul0
    public void g() {
        w91 w91 = this.h;
        if (w91 != null) {
            w91.k.f(getViewLifecycleOwner(), new xz0(this));
            w91 w912 = this.h;
            if (w912 != null) {
                w912.l.f(getViewLifecycleOwner(), new zz0(this));
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
        T t = this.f;
        n86.c(t);
        MaterialTextView materialTextView = ((rx) t).i;
        f71 f71 = f71.f1097a;
        w91 w91 = this.h;
        if (w91 != null) {
            materialTextView.setText(f71.c(w91.h));
            T t2 = this.f;
            n86.c(t2);
            LinearLayout linearLayout = ((rx) t2).d;
            n86.d(linearLayout, "viewBinding.fareInfoLayout");
            linearLayout.setVisibility(8);
            T t3 = this.f;
            n86.c(t3);
            LinearLayout linearLayout2 = ((rx) t3).f;
            n86.d(linearLayout2, "viewBinding.ticketCountLayout");
            linearLayout2.setVisibility(8);
            return;
        }
        n86.l("viewModel");
        throw null;
    }

    public final void i(ed1 ed1) {
        w91 w91 = this.h;
        if (w91 != null) {
            ed1.a("source", w91.e);
            ed1.a("isSuperPass", Boolean.TRUE);
            w91 w912 = this.h;
            if (w912 != null) {
                ed1.a(DigitalTripReceiptJsonKeys.KEY_ACTIVATION_TIME, jh1.g(w912.h));
            } else {
                n86.l("viewModel");
                throw null;
            }
        } else {
            n86.l("viewModel");
            throw null;
        }
    }

    public final l01 j() {
        return (l01) this.i.getValue();
    }
}
