package app.zophop.ui.activities;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import com.razorpay.AnalyticsConstants;
import defpackage.ut;
import java.util.UUID;

/* compiled from: SuperPassValidationActivity.kt */
public final class SuperPassValidationActivity extends ol0<lw> {
    public static final /* synthetic */ int l = 0;
    public final j56 k = new ai(z86.a(y91.class), new b(this), new c(this));

    @y66(c = "app.zophop.ui.activities.SuperPassValidationActivity$onEvent$1", f = "SuperPassValidationActivity.kt", l = {}, m = "invokeSuspend")
    /* compiled from: SuperPassValidationActivity.kt */
    public static final class a extends b76 implements w76<mb6, k66<? super s56>, Object> {
        public final /* synthetic */ SuperPassValidationActivity f;
        public final /* synthetic */ hf1 g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SuperPassValidationActivity superPassValidationActivity, hf1 hf1, k66<? super a> k66) {
            super(2, k66);
            this.f = superPassValidationActivity;
            this.g = hf1;
        }

        @Override // defpackage.u66
        public final k66<s56> create(Object obj, k66<?> k66) {
            return new a(this.f, this.g, k66);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // defpackage.w76
        public Object invoke(mb6 mb6, k66<? super s56> k66) {
            a aVar = new a(this.f, this.g, k66);
            s56 s56 = s56.f3190a;
            aVar.invokeSuspend(s56);
            return s56;
        }

        @Override // defpackage.u66
        public final Object invokeSuspend(Object obj) {
            p66 p66 = p66.COROUTINE_SUSPENDED;
            hd3.Y2(obj);
            LiveData<SuperPass> d = this.f.o0().d();
            SuperPassValidationActivity superPassValidationActivity = this.f;
            ra0 ra0 = new ra0(this.g, superPassValidationActivity);
            n86.e(d, "<this>");
            n86.e(superPassValidationActivity, "lifecycleOwner");
            n86.e(ra0, "observer");
            d.f(superPassValidationActivity, new th1(ra0, d));
            return s56.f3190a;
        }
    }

    /* compiled from: ActivityViewModelLazy.kt */
    public static final class b extends o86 implements h76<gi> {
        public final /* synthetic */ ComponentActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ComponentActivity componentActivity) {
            super(0);
            this.f = componentActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public gi invoke() {
            gi viewModelStore = this.f.getViewModelStore();
            n86.d(viewModelStore, "viewModelStore");
            return viewModelStore;
        }
    }

    /* compiled from: SuperPassValidationActivity.kt */
    public static final class c extends o86 implements h76<ci> {
        public final /* synthetic */ SuperPassValidationActivity f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(SuperPassValidationActivity superPassValidationActivity) {
            super(0);
            this.f = superPassValidationActivity;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // defpackage.h76
        public ci invoke() {
            Application application = this.f.getApplication();
            SuperPassValidationActivity superPassValidationActivity = this.f;
            return new xh(application, superPassValidationActivity, h.j(new m56("arg_super_pass_sub_type", superPassValidationActivity.getIntent().getParcelableExtra("arg_super_pass_sub_type")), new m56("arg_super_pass_id", this.f.getIntent().getStringExtra("arg_super_pass_id")), new m56("arg_source", this.f.getIntent().getStringExtra("arg_source"))));
        }
    }

    public static final void p0(Context context, SuperPassSubType superPassSubType, String str, String str2) {
        n86.e(context, AnalyticsConstants.CONTEXT);
        n86.e(superPassSubType, "superPassSubType");
        n86.e(str, "superPassId");
        n86.e(str2, "source");
        Intent intent = new Intent(context, SuperPassValidationActivity.class);
        intent.putExtra("arg_super_pass_sub_type", (Parcelable) superPassSubType);
        intent.putExtra("arg_super_pass_id", str);
        intent.putExtra("arg_source", str2);
        context.startActivity(intent);
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.ol0
    public lw g0() {
        View inflate = getLayoutInflater().inflate(R.layout.activity_validate_super_pass, (ViewGroup) null, false);
        FragmentContainerView fragmentContainerView = (FragmentContainerView) inflate.findViewById(R.id.nav_host_fragment_validate_super_pass);
        if (fragmentContainerView != null) {
            lw lwVar = new lw((ConstraintLayout) inflate, fragmentContainerView);
            n86.d(lwVar, "inflate(layoutInflater)");
            return lwVar;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(R.id.nav_host_fragment_validate_super_pass)));
    }

    @Override // defpackage.ol0
    public void h0(Bundle bundle) {
        LiveData<SuperPass> d = o0().d();
        pa0 pa0 = new pa0(this);
        n86.e(d, "<this>");
        n86.e(this, "lifecycleOwner");
        n86.e(pa0, "observer");
        d.f(this, new th1(pa0, d));
        ut.a aVar = ut.f3552a;
        getWindow().setFlags(RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST, RecyclerView.a0.FLAG_BOUNCED_FROM_HIDDEN_LIST);
    }

    @Override // defpackage.ol0
    public void i0() {
        jz5 b2 = jz5.b();
        b2.k(this, b2.e, true, 0);
    }

    @Override // defpackage.ol0
    public void j0() {
    }

    @Override // defpackage.ol0
    public void m0() {
        jz5.b().o(this);
    }

    @Override // defpackage.ol0
    public void n0() {
    }

    public final y91 o0() {
        return (y91) this.k.getValue();
    }

    public final void onEvent(hf1 hf1) {
        n86.e(hf1, "lSuperPassPunchEvent");
        jz5.b().m(hf1);
        ah b2 = wg.b(this);
        xb6 xb6 = xb6.f3911a;
        hd3.Y1(b2, xf6.c, null, new a(this, hf1, null), 2, null);
    }

    public final void q0() {
        xt.f3961a.g0().d(o0().e, this, UUID.randomUUID().toString());
    }
}
