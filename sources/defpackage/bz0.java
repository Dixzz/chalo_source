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
import app.zophop.models.mTicketing.superPass.SuperPassProofProperties;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPass;
import app.zophop.models.mTicketing.superPass.pendingSuperPass.PendingSuperPassTransactionDetails;
import app.zophop.ui.fragments.superPassHistory.PendingSuperPassBookingSummaryFragment;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: bz0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class bz0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PendingSuperPassBookingSummaryFragment f494a;

    public /* synthetic */ bz0(PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment) {
        this.f494a = pendingSuperPassBookingSummaryFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        PendingSuperPassBookingSummaryFragment pendingSuperPassBookingSummaryFragment = this.f494a;
        PendingSuperPass pendingSuperPass = (PendingSuperPass) obj;
        int i = PendingSuperPassBookingSummaryFragment.i;
        n86.e(pendingSuperPassBookingSummaryFragment, "this$0");
        n86.d(pendingSuperPass, "lPendingSuperPass");
        ed1 ed1 = new ed1("pendingSuperPassApplication Summary Fragment Opened", Long.MIN_VALUE);
        pendingSuperPassBookingSummaryFragment.i(ed1, pendingSuperPass);
        ui1.m0(ed1);
        int ordinal = pendingSuperPass.getPendingSuperPassProperties().getStatus().ordinal();
        if (ordinal == 0) {
            T t = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t);
            ((qx) t).q.setImageDrawable(pendingSuperPassBookingSummaryFragment.getResources().getDrawable(R.drawable.rejected_pass_summary));
            T t2 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t2);
            ((qx) t2).r.setText(pendingSuperPassBookingSummaryFragment.getResources().getString(R.string.failed));
        } else if (ordinal == 1) {
            T t3 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t3);
            ((qx) t3).q.setImageDrawable(pendingSuperPassBookingSummaryFragment.getResources().getDrawable(R.drawable.pending_pass_summary));
            T t4 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t4);
            ((qx) t4).r.setText(pendingSuperPassBookingSummaryFragment.getResources().getString(R.string.processing));
        }
        T t5 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t5);
        TextView textView = ((qx) t5).o;
        n86.d(textView, "viewBinding.passExpiryDetails");
        int i2 = 8;
        textView.setVisibility(8);
        T t6 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t6);
        CardView cardView = ((qx) t6).f;
        n86.d(cardView, "viewBinding.btnRenew");
        cardView.setVisibility(8);
        SpannableStringBuilder d = f71.f1097a.d(pendingSuperPassBookingSummaryFragment.requireContext(), pendingSuperPass.getPendingSuperPassUIProperties().getSpecialFeatures());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) pendingSuperPass.getPendingSuperPassUIProperties().getFareMappingDisplayName());
        spannableStringBuilder.append((CharSequence) ",");
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) pendingSuperPass.getPendingSuperPassUIProperties().getCategoryName());
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) pendingSuperPassBookingSummaryFragment.getResources().getString(R.string.category));
        spannableStringBuilder.append((CharSequence) " ");
        spannableStringBuilder.append((CharSequence) d);
        T t7 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t7);
        qx qxVar = (qx) t7;
        qxVar.p.setText(pendingSuperPass.getPendingSuperPassUIProperties().getPassName());
        qxVar.w.setText(spannableStringBuilder);
        if (pendingSuperPassBookingSummaryFragment.j().g == SuperPassSubType.MAGIC_SUPER_PASS) {
            TextView textView2 = qxVar.u;
            n86.d(textView2, "rideBasedPassFareLimitsDescription");
            textView2.setVisibility(8);
            TextView textView3 = qxVar.v;
            n86.d(textView3, "rideBasedPassTripLimitsDescription");
            textView3.setVisibility(8);
        } else if (pendingSuperPassBookingSummaryFragment.j().g == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
            TextView textView4 = qxVar.v;
            n86.d(textView4, "rideBasedPassTripLimitsDescription");
            textView4.setVisibility(0);
            if (pendingSuperPass.getPendingSuperPassUIProperties().getMaxPricePerTrip() == -1.0d) {
                TextView textView5 = qxVar.u;
                n86.d(textView5, "rideBasedPassFareLimitsDescription");
                textView5.setVisibility(8);
            } else {
                TextView textView6 = qxVar.u;
                n86.d(textView6, "rideBasedPassFareLimitsDescription");
                textView6.setVisibility(0);
                qxVar.u.setText(pendingSuperPassBookingSummaryFragment.getResources().getString(R.string.maxFareConfirmScreen, Double.valueOf(pendingSuperPass.getPendingSuperPassUIProperties().getMaxPricePerTrip())));
            }
            String fareMappingDescription = pendingSuperPass.getPendingSuperPassUIProperties().getFareMappingDescription();
            if (fareMappingDescription == null || fareMappingDescription.length() == 0) {
                TextView textView7 = qxVar.v;
                n86.d(textView7, "rideBasedPassTripLimitsDescription");
                textView7.setVisibility(8);
            } else {
                TextView textView8 = qxVar.v;
                n86.d(textView8, "rideBasedPassTripLimitsDescription");
                textView8.setVisibility(0);
                qxVar.v.setText(pendingSuperPass.getPendingSuperPassUIProperties().getFareMappingDescription());
            }
        }
        SuperPassUserDetails superPassUserDetails = pendingSuperPass.getPendingSuperPassUIProperties().getSuperPassUserDetails();
        T t8 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t8);
        ((qx) t8).z.setText(superPassUserDetails.getFullName());
        T t9 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t9);
        ((qx) t9).l.setText(superPassUserDetails.getGender().name());
        StringBuilder sb = new StringBuilder(pendingSuperPassBookingSummaryFragment.getResources().getString(R.string.date_of_birth));
        sb.append(ProductDiscountsObject.KEY_DELIMITER);
        sb.append(" ");
        sb.append(superPassUserDetails.getDateOfBirth());
        T t10 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t10);
        ((qx) t10).h.setText(sb);
        ml1<Drawable> p = gl1.f(pendingSuperPassBookingSummaryFragment.requireContext()).p(superPassUserDetails.getProfilePhoto());
        T t11 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t11);
        p.e(((qx) t11).A);
        T t12 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t12);
        ((qx) t12).A.setOnClickListener(new dz0(pendingSuperPassBookingSummaryFragment, superPassUserDetails));
        Map<String, SuperPassProofProperties> proofs = pendingSuperPass.getPendingSuperPassUIProperties().getProofs();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, SuperPassProofProperties> entry : proofs.entrySet()) {
            arrayList.add(entry.getValue());
        }
        T t13 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t13);
        qx qxVar2 = (qx) t13;
        View view = qxVar2.i;
        n86.d(view, "divider");
        view.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        LinearLayout linearLayout = qxVar2.B;
        n86.d(linearLayout, "viewDocumentsHeader");
        linearLayout.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        RecyclerView recyclerView = qxVar2.t;
        n86.d(recyclerView, "proofDocumentsList");
        recyclerView.setVisibility(arrayList.isEmpty() ^ true ? 0 : 8);
        if (!arrayList.isEmpty()) {
            Context requireContext = pendingSuperPassBookingSummaryFragment.requireContext();
            n86.d(requireContext, "requireContext()");
            ti0 ti0 = new ti0(requireContext, arrayList, new e01(pendingSuperPassBookingSummaryFragment));
            T t14 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t14);
            ((qx) t14).t.setAdapter(ti0);
            T t15 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t15);
            ((qx) t15).t.setLayoutManager(new GridLayoutManager(pendingSuperPassBookingSummaryFragment.requireContext(), 2));
            T t16 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t16);
            ((qx) t16).B.setOnClickListener(new yy0(pendingSuperPassBookingSummaryFragment, pendingSuperPass));
        }
        FareInfo fareInfo = pendingSuperPass.getPendingSuperPassUIProperties().getFareInfo();
        T t17 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t17);
        ((qx) t17).x.setText(n86.j(ui1.H(), fareInfo.getPayableAmountString()));
        T t18 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t18);
        ((qx) t18).j.removeAllViews();
        for (FareBreakupComponent fareBreakupComponent : fareInfo.getFareBreakupComponentList()) {
            bx b = bx.b(pendingSuperPassBookingSummaryFragment.getLayoutInflater());
            n86.d(b, "inflate(layoutInflater)");
            b.c.setText(fareBreakupComponent.getDisplayName());
            b.b.setText(fareBreakupComponent.getAmountName());
            T t19 = pendingSuperPassBookingSummaryFragment.f;
            n86.c(t19);
            ((qx) t19).j.addView(b.f485a);
        }
        T t20 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t20);
        ((qx) t20).k.setOnClickListener(new cz0(pendingSuperPassBookingSummaryFragment, pendingSuperPass));
        PendingSuperPassTransactionDetails pendingSuperPassTransactionDetails = pendingSuperPass.getPendingSuperPassTransactionDetails();
        T t21 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t21);
        ((qx) t21).c.setText(pendingSuperPassTransactionDetails.getTransactionId());
        T t22 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t22);
        ((qx) t22).s.setText(pendingSuperPassTransactionDetails.getPaymentMode());
        T t23 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t23);
        ((qx) t23).m.setText(pendingSuperPassTransactionDetails.getOrderId());
        T t24 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t24);
        LinearLayout linearLayout2 = ((qx) t24).n;
        n86.d(linearLayout2, "viewBinding.orderIdLayout");
        String orderId = pendingSuperPass.getPendingSuperPassTransactionDetails().getOrderId();
        if (true ^ (orderId == null || orderId.length() == 0)) {
            i2 = 0;
        }
        linearLayout2.setVisibility(i2);
        T t25 = pendingSuperPassBookingSummaryFragment.f;
        n86.c(t25);
        ((qx) t25).b.setText(jh1.d(pendingSuperPass.getPendingSuperPassUIProperties().getBookingTime()));
    }
}
