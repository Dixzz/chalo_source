package defpackage;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.pubsub.AutoLinkDeviceEvent;
import app.zophop.pubsub.eventbus.events.TransactionsFetchedOnlineEvent;
import app.zophop.ui.activities.WebViewActivity;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.android.material.textview.MaterialTextView;
import com.razorpay.AnalyticsConstants;
import defpackage.xt;
import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: kv0  reason: default package */
/* compiled from: ProductHistoryViewPagerFragment.kt */
public final class kv0 extends rl0<sy> {
    public static final /* synthetic */ int n = 0;
    public final j56 g = h.B(this, z86.a(c91.class), new d(new c(this)), new e(this));
    public final r<Intent> h;
    public final j56 i;
    public final j56 j;
    public String k;
    public rc6 l;
    public gv0 m;

    @y66(c = "app.zophop.ui.fragments.ProductHistoryViewPagerFragment$initSkeletonLayoutTimeoutAndUpdateEmptyView$1", f = "ProductHistoryViewPagerFragment.kt", l = {181}, m = "invokeSuspend")
    /* renamed from: kv0$a */
    /* compiled from: ProductHistoryViewPagerFragment.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public int f;
        public final /* synthetic */ kv0 g;

        @y66(c = "app.zophop.ui.fragments.ProductHistoryViewPagerFragment$initSkeletonLayoutTimeoutAndUpdateEmptyView$1$1", f = "ProductHistoryViewPagerFragment.kt", l = {182}, m = "invokeSuspend")
        /* renamed from: kv0$a$a  reason: collision with other inner class name */
        /* compiled from: ProductHistoryViewPagerFragment.kt */
        public static final class C0042a extends b76 implements w76<mb6, k66<? super s56>, Object> {
            public int f;

            public C0042a(k66<? super C0042a> k66) {
                super(2, k66);
            }

            @Override // defpackage.u66
            public final k66<s56> create(Object obj, k66<?> k66) {
                return new C0042a(k66);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // defpackage.w76
            public Object invoke(mb6 mb6, k66<? super s56> k66) {
                return new C0042a(k66).invokeSuspend(s56.f3190a);
            }

            @Override // defpackage.u66
            public final Object invokeSuspend(Object obj) {
                p66 p66 = p66.COROUTINE_SUSPENDED;
                int i = this.f;
                if (i == 0) {
                    hd3.Y2(obj);
                    this.f = 1;
                    if (hd3.C0(DefaultRefreshIntervals.ACTIVE_CONV_MIN_FETCH_INTERVAL, this) == p66) {
                        return p66;
                    }
                } else if (i == 1) {
                    hd3.Y2(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return s56.f3190a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(kv0 kv0, k66<? super a> k66) {
            super(2, k66);
            this.g = kv0;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            return new a(this.g, k66).invokeSuspend(s56.f3190a);
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            int i = this.f;
            if (i == 0) {
                hd3.Y2(obj);
                kb6 kb6 = xb6.b;
                C0042a aVar = new C0042a(null);
                this.f = 1;
                if (hd3.j3(kb6, aVar, this) == p66) {
                    return p66;
                }
            } else if (i == 1) {
                hd3.Y2(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kv0 kv0 = this.g;
            int i2 = kv0.n;
            kv0.j();
            return s56.f3190a;
        }
    }

    /* renamed from: kv0$b */
    /* compiled from: ProductHistoryViewPagerFragment.kt */
    public static final class b extends o86 implements h76<Integer> {
        public final /* synthetic */ kv0 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(kv0 kv0) {
            super(0);
            this.f = kv0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Integer invoke() {
            Bundle arguments = this.f.getArguments();
            return Integer.valueOf(arguments == null ? 0 : arguments.getInt("screenPosition"));
        }
    }

    /* renamed from: kv0$c */
    /* compiled from: FragmentViewModelLazy.kt */
    public static final class c extends o86 implements h76<Fragment> {
        public final /* synthetic */ Fragment f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Fragment fragment) {
            super(0);
            this.f = fragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public Fragment invoke() {
            return this.f;
        }
    }

    /* renamed from: kv0$d */
    /* compiled from: FragmentViewModelLazy.kt */
    public static final class d extends o86 implements h76<gi> {
        public final /* synthetic */ h76 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(h76 h76) {
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

    /* renamed from: kv0$e */
    /* compiled from: ProductHistoryViewPagerFragment.kt */
    public static final class e extends o86 implements h76<ci> {
        public final /* synthetic */ kv0 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(kv0 kv0) {
            super(0);
            this.f = kv0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            Application application = this.f.requireActivity().getApplication();
            kv0 kv0 = this.f;
            return new xh(application, kv0, h.j(new m56("screenPosition", Integer.valueOf(((Number) kv0.i.getValue()).intValue()))));
        }
    }

    /* renamed from: kv0$f */
    /* compiled from: ProductHistoryViewPagerFragment.kt */
    public static final class f extends o86 implements h76<dl0> {
        public final /* synthetic */ kv0 f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(kv0 kv0) {
            super(0);
            this.f = kv0;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public dl0 invoke() {
            Context requireContext = this.f.requireContext();
            n86.d(requireContext, "requireContext()");
            lv0 lv0 = new lv0(this.f);
            kv0 kv0 = this.f;
            int i = kv0.n;
            return new dl0(requireContext, lv0, kv0.g().d, "History screen");
        }
    }

    public kv0() {
        r<Intent> registerForActivityResult = registerForActivityResult(new w(), new tr0(this));
        n86.d(registerForActivityResult, "registerForActivityResul…      onRetry()\n        }");
        this.h = registerForActivityResult;
        this.i = hd3.a2(new b(this));
        this.j = hd3.a2(new f(this));
        this.k = new String();
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.rl0
    public sy e() {
        View inflate = getLayoutInflater().inflate(R.layout.product_history_viewpager_fragment, (ViewGroup) null, false);
        int i2 = R.id.empty_view;
        View findViewById = inflate.findViewById(R.id.empty_view);
        if (findViewById != null) {
            int i3 = R.id.book_ticket_button;
            MaterialTextView materialTextView = (MaterialTextView) findViewById.findViewById(R.id.book_ticket_button);
            if (materialTextView != null) {
                i3 = R.id.empty_my_bookings;
                ImageView imageView = (ImageView) findViewById.findViewById(R.id.empty_my_bookings);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById;
                    i3 = R.id.empty_view_description_text;
                    MaterialTextView materialTextView2 = (MaterialTextView) findViewById.findViewById(R.id.empty_view_description_text);
                    if (materialTextView2 != null) {
                        wx wxVar = new wx(constraintLayout, materialTextView, imageView, constraintLayout, materialTextView2);
                        i2 = R.id.reclaim_passes;
                        View findViewById2 = inflate.findViewById(R.id.reclaim_passes);
                        if (findViewById2 != null) {
                            int i4 = R.id.btn_reclaim_passes;
                            TextView textView = (TextView) findViewById2.findViewById(R.id.btn_reclaim_passes);
                            if (textView != null) {
                                i4 = R.id.dismiss_reclaim_passes;
                                TextView textView2 = (TextView) findViewById2.findViewById(R.id.dismiss_reclaim_passes);
                                if (textView2 != null) {
                                    i4 = R.id.reclaim_passes_card_view;
                                    CardView cardView = (CardView) findViewById2.findViewById(R.id.reclaim_passes_card_view);
                                    if (cardView != null) {
                                        i4 = R.id.reclaim_passes_info;
                                        TextView textView3 = (TextView) findViewById2.findViewById(R.id.reclaim_passes_info);
                                        if (textView3 != null) {
                                            i4 = R.id.reclaim_passes_title;
                                            TextView textView4 = (TextView) findViewById2.findViewById(R.id.reclaim_passes_title);
                                            if (textView4 != null) {
                                                FrameLayout frameLayout = (FrameLayout) findViewById2;
                                                my myVar = new my(frameLayout, textView, textView2, cardView, textView3, textView4, frameLayout);
                                                i2 = R.id.your_plans;
                                                RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.your_plans);
                                                if (recyclerView != null) {
                                                    i2 = R.id.your_plans_skeleton_loader;
                                                    View findViewById3 = inflate.findViewById(R.id.your_plans_skeleton_loader);
                                                    if (findViewById3 != null) {
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById3;
                                                        int i5 = R.id.view_1;
                                                        View findViewById4 = findViewById3.findViewById(R.id.view_1);
                                                        if (findViewById4 != null) {
                                                            rz b2 = rz.b(findViewById4);
                                                            i5 = R.id.view_2;
                                                            View findViewById5 = findViewById3.findViewById(R.id.view_2);
                                                            if (findViewById5 != null) {
                                                                rz b3 = rz.b(findViewById5);
                                                                i5 = R.id.view_3;
                                                                View findViewById6 = findViewById3.findViewById(R.id.view_3);
                                                                if (findViewById6 != null) {
                                                                    rz b4 = rz.b(findViewById6);
                                                                    i5 = R.id.view_4;
                                                                    View findViewById7 = findViewById3.findViewById(R.id.view_4);
                                                                    if (findViewById7 != null) {
                                                                        rz b5 = rz.b(findViewById7);
                                                                        i5 = R.id.view_5;
                                                                        View findViewById8 = findViewById3.findViewById(R.id.view_5);
                                                                        if (findViewById8 != null) {
                                                                            rz b6 = rz.b(findViewById8);
                                                                            i5 = R.id.view_6;
                                                                            View findViewById9 = findViewById3.findViewById(R.id.view_6);
                                                                            if (findViewById9 != null) {
                                                                                sy syVar = new sy((ConstraintLayout) inflate, wxVar, myVar, recyclerView, new xx(constraintLayout2, constraintLayout2, b2, b3, b4, b5, b6, rz.b(findViewById9)));
                                                                                n86.d(syVar, "inflate(layoutInflater)");
                                                                                return syVar;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        throw new NullPointerException("Missing required view with ID: ".concat(findViewById3.getResources().getResourceName(i5)));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            throw new NullPointerException("Missing required view with ID: ".concat(findViewById2.getResources().getResourceName(i4)));
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(findViewById.getResources().getResourceName(i3)));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public final void f(boolean z) {
        ed1 ed1 = new ed1("auto reclaim passes response", Long.MIN_VALUE);
        ed1.a("isDeviceAutoLinked", Boolean.valueOf(z));
        ed1.a("source", "History screen");
        ui1.m0(ed1);
    }

    public final c91 g() {
        return (c91) this.g.getValue();
    }

    public final void h() {
        if (!xt.f3961a.L().m() || g().j()) {
            j();
            return;
        }
        T t = this.f;
        n86.c(t);
        ConstraintLayout constraintLayout = ((sy) t).b.c;
        n86.d(constraintLayout, "viewBinding.emptyView.emptyViewContainer");
        constraintLayout.setVisibility(8);
        T t2 = this.f;
        n86.c(t2);
        ConstraintLayout constraintLayout2 = ((sy) t2).e.b;
        n86.d(constraintLayout2, "viewBinding.yourPlansSkeletonLoader.skeletonLayout");
        constraintLayout2.setVisibility(0);
        rc6 rc6 = this.l;
        if (rc6 != null) {
            ec6.j(rc6, null, 1, null);
        }
        ah b2 = wg.b(this);
        xb6 xb6 = xb6.f3911a;
        ad6 ad6 = xf6.c;
        int i2 = CoroutineExceptionHandler.d;
        this.l = hd3.Y1(b2, ad6.plus(new lh1(CoroutineExceptionHandler.a.f)), null, new a(this, null), 2, null);
    }

    public final void i() {
        ve activity = c();
        Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.base.BaseActivity<*>");
        T t = this.f;
        n86.c(t);
        ((ol0) activity).l0(((sy) t).f3277a);
    }

    public final void j() {
        T t = this.f;
        n86.c(t);
        ConstraintLayout constraintLayout = ((sy) t).e.b;
        n86.d(constraintLayout, "viewBinding.yourPlansSkeletonLoader.skeletonLayout");
        constraintLayout.setVisibility(8);
        if (!g().f()) {
            if (g().j()) {
                T t2 = this.f;
                n86.c(t2);
                FrameLayout frameLayout = ((sy) t2).c.c;
                n86.d(frameLayout, "viewBinding.reclaimPasse…eclaimPassesViewContainer");
                frameLayout.setVisibility(0);
            }
            T t3 = this.f;
            n86.c(t3);
            ConstraintLayout constraintLayout2 = ((sy) t3).b.c;
            n86.d(constraintLayout2, "viewBinding.emptyView.emptyViewContainer");
            constraintLayout2.setVisibility(8);
        } else if (!xt.f3961a.L().m()) {
            T t4 = this.f;
            n86.c(t4);
            wx wxVar = ((sy) t4).b;
            ConstraintLayout constraintLayout3 = wxVar.c;
            n86.d(constraintLayout3, "emptyViewContainer");
            constraintLayout3.setVisibility(0);
            wxVar.d.setText(getString(R.string.booking_history_login_banner));
            wxVar.b.setText(getString(R.string.log_in));
            MaterialTextView materialTextView = wxVar.b;
            n86.d(materialTextView, "bookTicketButton");
            materialTextView.setVisibility(0);
        } else if (g().d) {
            T t5 = this.f;
            n86.c(t5);
            wx wxVar2 = ((sy) t5).b;
            ConstraintLayout constraintLayout4 = wxVar2.c;
            n86.d(constraintLayout4, "emptyViewContainer");
            constraintLayout4.setVisibility(0);
            wxVar2.d.setText(getString(R.string.history_active_empty_bookings));
            wxVar2.b.setText(getString(R.string.buy_ticket_now));
            MaterialTextView materialTextView2 = wxVar2.b;
            n86.d(materialTextView2, "bookTicketButton");
            materialTextView2.setVisibility(0);
        } else {
            T t6 = this.f;
            n86.c(t6);
            wx wxVar3 = ((sy) t6).b;
            ConstraintLayout constraintLayout5 = wxVar3.c;
            n86.d(constraintLayout5, "emptyViewContainer");
            constraintLayout5.setVisibility(0);
            wxVar3.d.setText(getString(R.string.history_inactive_empty_bookings));
            MaterialTextView materialTextView3 = wxVar3.b;
            n86.d(materialTextView3, "bookTicketButton");
            materialTextView3.setVisibility(8);
        }
    }

    public final void onEvent(qd1 qd1) {
        n86.e(qd1, "networkConnectivityEvent");
        boolean z = qd1.f2931a;
        if (z != g().e) {
            if (qd1.f2931a) {
                if (g().f()) {
                    h();
                }
                g().i();
                ve activity = c();
                Objects.requireNonNull(activity, "null cannot be cast to non-null type app.zophop.ui.base.BaseActivity<*>");
                ((ol0) activity).k0();
            } else {
                i();
            }
            g().e = z;
        } else if (!g().e) {
            i();
        }
        jz5.b().m(qd1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        jz5.b().o(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        T t = this.f;
        n86.c(t);
        ((sy) t).d.setAdapter((dl0) this.j.getValue());
        h();
        T t2 = this.f;
        n86.c(t2);
        ((sy) t2).c.b.setOnClickListener(new wr0(this));
        T t3 = this.f;
        n86.c(t3);
        ((sy) t3).b.b.setOnClickListener(new xr0(this));
        ((mh) g().h.getValue()).f(getViewLifecycleOwner(), new vr0(this));
        g().i();
    }

    public final void onEvent(AutoLinkDeviceEvent autoLinkDeviceEvent) {
        jz5.b().m(autoLinkDeviceEvent);
        if (g().d) {
            gv0 gv0 = this.m;
            if (gv0 != null) {
                gv0.dismiss();
            }
            if (autoLinkDeviceEvent.getResponseType() == null) {
                Toast.makeText(c(), getString(R.string.toast_generic_error_message), 0).show();
            } else if (autoLinkDeviceEvent.getResponseType() != ad1.SUCCESS) {
                Toast.makeText(c(), getString(R.string.toast_generic_error_message), 0).show();
            } else if (autoLinkDeviceEvent.getRequestId() != null && n86.a(this.k, autoLinkDeviceEvent.getRequestId())) {
                if (autoLinkDeviceEvent.isIsAutoLinked()) {
                    f(true);
                    g().i();
                    return;
                }
                f(false);
                Context requireContext = requireContext();
                n86.d(requireContext, "requireContext()");
                n86.e(requireContext, AnalyticsConstants.CONTEXT);
                Uri.Builder builder = new Uri.Builder();
                String f2 = xt.f3961a.t().f("reclaimPassesRequestUrl");
                n86.d(f2, "getFireBaseRemoteConfig(…_RECLAIM_REQUEST_URL_KEY)");
                int length = f2.length() - 1;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = n86.g(f2.charAt(!z ? i2 : length), 32) <= 0;
                    if (!z) {
                        if (!z2) {
                            z = true;
                        } else {
                            i2++;
                        }
                    } else if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                }
                Uri.Builder encodedPath = builder.encodedPath(f2.subSequence(i2, length + 1).toString());
                StringBuilder sb = new StringBuilder();
                xt.t1 t1Var = xt.f3961a;
                UserProfile e2 = t1Var.L().e();
                if (e2 != null) {
                    if (e2.getFirstName() != null) {
                        sb.append(e2.getFirstName());
                    }
                    if (e2.getLastName() != null) {
                        sb.append(" ");
                        sb.append(e2.getLastName());
                    }
                }
                String sb2 = sb.toString();
                n86.d(sb2, "lNameBuilder.toString()");
                encodedPath.appendQueryParameter("entry.1987039175", sb2).appendQueryParameter("entry.58353678", t1Var.L().getUserId());
                String uri = builder.build().toString();
                n86.d(uri, "lBuilder.build().toString()");
                WebViewActivity.h0(requireContext, uri, requireContext.getString(R.string.app_name), false, false);
            }
        }
    }

    public final void onEvent(TransactionsFetchedOnlineEvent transactionsFetchedOnlineEvent) {
        n86.e(transactionsFetchedOnlineEvent, "transactionsFetchedOnlineEvent");
        jz5.b().m(transactionsFetchedOnlineEvent);
        if (transactionsFetchedOnlineEvent.getResponseType().equals(ad1.SUCCESS) && g().f()) {
            rc6 rc6 = this.l;
            if (rc6 != null) {
                ec6.j(rc6, null, 1, null);
            }
            j();
        }
    }
}
