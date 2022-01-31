package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.R;
import app.zophop.models.mTicketing.FareBreakupComponent;
import app.zophop.models.mTicketing.FareInfo;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassTransactionDetails;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.fragments.superPassHistory.SuperPassBookingSummaryFragment;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: oz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class oz0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SuperPassBookingSummaryFragment f2747a;

    public /* synthetic */ oz0(SuperPassBookingSummaryFragment superPassBookingSummaryFragment) {
        this.f2747a = superPassBookingSummaryFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        SuperPassBookingSummaryFragment superPassBookingSummaryFragment = this.f2747a;
        SuperPass superPass = (SuperPass) obj;
        int i = SuperPassBookingSummaryFragment.j;
        n86.e(superPassBookingSummaryFragment, "this$0");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("superPass Booking Summary Fragment Opened", Long.MIN_VALUE);
        superPassBookingSummaryFragment.i(ed1, superPass);
        ui1.m0(ed1);
        ve activity = superPassBookingSummaryFragment.c();
        if (activity != null) {
            if (superPass.getSuperPassProperties().getProductSubType() == SuperPassSubType.MAGIC_SUPER_PASS) {
                x supportActionBar = ((f0) activity).getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.z(superPass.getSuperPassUIProperties().getPassName());
                }
            } else {
                x supportActionBar2 = ((f0) activity).getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.z(superPass.getSuperPassUIProperties().getPassName());
                }
            }
        }
        if (superPass.isExpired()) {
            T t = superPassBookingSummaryFragment.f;
            n86.c(t);
            qx qxVar = (qx) t;
            qxVar.q.setImageDrawable(superPassBookingSummaryFragment.getResources().getDrawable(R.drawable.rejected_pass_summary));
            qxVar.r.setText(superPassBookingSummaryFragment.getResources().getString(R.string.expired));
            StringBuilder sb = new StringBuilder(superPassBookingSummaryFragment.getResources().getString(R.string.expired_on));
            sb.append(" ");
            sb.append(jh1.d(superPass.getSuperPassValidationProperties().getExpiryTime()));
            qxVar.o.setText(sb);
        } else if (superPass.isNotYetActive()) {
            T t2 = superPassBookingSummaryFragment.f;
            n86.c(t2);
            qx qxVar2 = (qx) t2;
            qxVar2.q.setImageDrawable(superPassBookingSummaryFragment.getResources().getDrawable(R.drawable.pending_pass_summary));
            qxVar2.r.setText(superPassBookingSummaryFragment.getResources().getString(R.string.pass_not_active));
            StringBuilder sb2 = new StringBuilder(superPassBookingSummaryFragment.getResources().getString(R.string.starts_from));
            sb2.append(" ");
            sb2.append(jh1.d(superPass.getSuperPassValidationProperties().getStartTime()));
            qxVar2.o.setText(sb2);
        } else {
            T t3 = superPassBookingSummaryFragment.f;
            n86.c(t3);
            qx qxVar3 = (qx) t3;
            qxVar3.q.setImageDrawable(superPassBookingSummaryFragment.getResources().getDrawable(R.drawable.active_pass_summary));
            qxVar3.r.setText(superPassBookingSummaryFragment.getResources().getString(R.string.pass_active));
            StringBuilder sb3 = new StringBuilder(superPassBookingSummaryFragment.getResources().getString(R.string.expires_on));
            sb3.append(" ");
            sb3.append(jh1.d(superPass.getSuperPassValidationProperties().getExpiryTime()));
            qxVar3.o.setText(sb3);
        }
        int i2 = 8;
        if (superPass.isNotYetActive() || superPass.canActivate()) {
            T t4 = superPassBookingSummaryFragment.f;
            n86.c(t4);
            CardView cardView = ((qx) t4).f;
            n86.d(cardView, "viewBinding.btnRenew");
            cardView.setVisibility(8);
        } else {
            T t5 = superPassBookingSummaryFragment.f;
            n86.c(t5);
            CardView cardView2 = ((qx) t5).f;
            n86.d(cardView2, "viewBinding.btnRenew");
            cardView2.setVisibility(0);
            T t6 = superPassBookingSummaryFragment.f;
            n86.c(t6);
            ((qx) t6).f.setOnClickListener(new tz0(superPassBookingSummaryFragment, superPass));
        }
        T t7 = superPassBookingSummaryFragment.f;
        n86.c(t7);
        ((qx) t7).g.setOnClickListener(new rz0(superPassBookingSummaryFragment, superPass));
        SpannableStringBuilder d = f71.f1097a.d(superPassBookingSummaryFragment.requireContext(), superPass.getSuperPassUIProperties().getSpecialFeatures());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) superPass.getSuperPassUIProperties().getFareMappingDisplayName());
        spannableStringBuilder.append((CharSequence) ",");
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) superPass.getSuperPassUIProperties().getCategoryName());
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) superPassBookingSummaryFragment.getResources().getString(R.string.category));
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) d);
        T t8 = superPassBookingSummaryFragment.f;
        n86.c(t8);
        qx qxVar4 = (qx) t8;
        qxVar4.p.setText(superPass.getSuperPassUIProperties().getPassName());
        qxVar4.w.setText(spannableStringBuilder);
        if (superPassBookingSummaryFragment.j().g == SuperPassSubType.MAGIC_SUPER_PASS) {
            TextView textView = qxVar4.u;
            n86.d(textView, "rideBasedPassFareLimitsDescription");
            textView.setVisibility(8);
            TextView textView2 = qxVar4.v;
            n86.d(textView2, "rideBasedPassTripLimitsDescription");
            textView2.setVisibility(8);
        } else if (superPassBookingSummaryFragment.j().g == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
            TextView textView3 = qxVar4.v;
            n86.d(textView3, "rideBasedPassTripLimitsDescription");
            textView3.setVisibility(0);
            RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) superPass;
            if (rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip() == -1.0d) {
                TextView textView4 = qxVar4.u;
                n86.d(textView4, "rideBasedPassFareLimitsDescription");
                textView4.setVisibility(8);
            } else {
                TextView textView5 = qxVar4.u;
                n86.d(textView5, "rideBasedPassFareLimitsDescription");
                textView5.setVisibility(0);
                qxVar4.u.setText(superPassBookingSummaryFragment.getResources().getString(R.string.maxFareConfirmScreen, Double.valueOf(rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip())));
            }
            qxVar4.v.setText(rideBasedSuperPass.getSuperPassUIProperties().getFareMappingDescription());
        }
        SuperPassUserDetails superPassUserDetails = superPass.getSuperPassUIProperties().getSuperPassUserDetails();
        T t9 = superPassBookingSummaryFragment.f;
        n86.c(t9);
        ((qx) t9).z.setText(superPassUserDetails.getFullName());
        T t10 = superPassBookingSummaryFragment.f;
        n86.c(t10);
        ((qx) t10).l.setText(superPassUserDetails.getGender().name());
        StringBuilder sb4 = new StringBuilder(superPassBookingSummaryFragment.getResources().getString(R.string.date_of_birth));
        sb4.append(ProductDiscountsObject.KEY_DELIMITER);
        sb4.append(" ");
        sb4.append(superPassUserDetails.getDateOfBirth());
        T t11 = superPassBookingSummaryFragment.f;
        n86.c(t11);
        ((qx) t11).h.setText(sb4);
        ml1<Drawable> p = gl1.f(superPassBookingSummaryFragment.requireContext()).p(superPassUserDetails.getProfilePhoto());
        T t12 = superPassBookingSummaryFragment.f;
        n86.c(t12);
        p.e(((qx) t12).A);
        T t13 = superPassBookingSummaryFragment.f;
        n86.c(t13);
        ((qx) t13).A.setOnClickListener(new vz0(superPassBookingSummaryFragment, superPassUserDetails));
        Map<String, SuperPassProofProperties> proofs = superPass.getSuperPassUIProperties().getProofs();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, SuperPassProofProperties> entry : proofs.entrySet()) {
            arrayList.add(entry.getValue());
        }
        T t14 = superPassBookingSummaryFragment.f;
        n86.c(t14);
        qx qxVar5 = (qx) t14;
        View view = qxVar5.i;
        n86.d(view, "divider");
        view.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        LinearLayout linearLayout = qxVar5.B;
        n86.d(linearLayout, "viewDocumentsHeader");
        linearLayout.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        RecyclerView recyclerView = qxVar5.t;
        n86.d(recyclerView, "proofDocumentsList");
        if (!arrayList.isEmpty()) {
            i2 = 0;
        }
        recyclerView.setVisibility(i2);
        if (!arrayList.isEmpty()) {
            Context requireContext = superPassBookingSummaryFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            ti0 ti0 = new ti0(requireContext, arrayList, new g01(superPassBookingSummaryFragment));
            T t15 = superPassBookingSummaryFragment.f;
            n86.c(t15);
            ((qx) t15).t.setAdapter(ti0);
            T t16 = superPassBookingSummaryFragment.f;
            n86.c(t16);
            ((qx) t16).t.setLayoutManager(new GridLayoutManager(superPassBookingSummaryFragment.requireContext(), 2));
            T t17 = superPassBookingSummaryFragment.f;
            n86.c(t17);
            ((qx) t17).B.setOnClickListener(new nz0(superPassBookingSummaryFragment));
        }
        FareInfo fareInfo = superPass.getSuperPassUIProperties().getFareInfo();
        T t18 = superPassBookingSummaryFragment.f;
        n86.c(t18);
        ((qx) t18).x.setText(n86.j(ui1.H(), fareInfo.getPayableAmountString()));
        T t19 = superPassBookingSummaryFragment.f;
        n86.c(t19);
        ((qx) t19).j.removeAllViews();
        for (FareBreakupComponent fareBreakupComponent : fareInfo.getFareBreakupComponentList()) {
            bx b = bx.b(superPassBookingSummaryFragment.getLayoutInflater());
            n86.d(b, "inflate(layoutInflater)");
            b.c.setText(fareBreakupComponent.getDisplayName());
            b.b.setText(fareBreakupComponent.getAmountName());
            T t20 = superPassBookingSummaryFragment.f;
            n86.c(t20);
            ((qx) t20).j.addView(b.f485a);
        }
        T t21 = superPassBookingSummaryFragment.f;
        n86.c(t21);
        ((qx) t21).k.setOnClickListener(new uz0(superPassBookingSummaryFragment, superPass));
        SuperPassTransactionDetails superPassTransactionDetails = superPass.getSuperPassTransactionDetails();
        T t22 = superPassBookingSummaryFragment.f;
        n86.c(t22);
        ((qx) t22).c.setText(superPassTransactionDetails.getTransactionId());
        T t23 = superPassBookingSummaryFragment.f;
        n86.c(t23);
        ((qx) t23).s.setText(superPassTransactionDetails.getPaymentMode());
        T t24 = superPassBookingSummaryFragment.f;
        n86.c(t24);
        ((qx) t24).b.setText(jh1.d(superPass.getSuperPassUIProperties().getBookingTime()));
    }
}
