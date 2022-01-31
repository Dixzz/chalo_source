package defpackage;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.fragments.superPassValidation.ActivateSuperPassFragment;

/* renamed from: o01  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class o01 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActivateSuperPassFragment f2628a;

    public /* synthetic */ o01(ActivateSuperPassFragment activateSuperPassFragment) {
        this.f2628a = activateSuperPassFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ActivateSuperPassFragment activateSuperPassFragment = this.f2628a;
        SuperPass superPass = (SuperPass) obj;
        ActivateSuperPassFragment.a aVar = ActivateSuperPassFragment.h;
        n86.e(activateSuperPassFragment, "this$0");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("super pass fetched", Long.MIN_VALUE);
        ed1.a("source", "Activate Super pass Screen");
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
        T t = activateSuperPassFragment.f;
        n86.c(t);
        ((cx) t).n.setTitle(superPass.getSuperPassUIProperties().getFareMappingDisplayName());
        SuperPassUserDetails superPassUserDetails = superPass.getSuperPassUIProperties().getSuperPassUserDetails();
        T t2 = activateSuperPassFragment.f;
        n86.c(t2);
        ((cx) t2).i.setText(superPassUserDetails.getFullName());
        String dateOfBirth = superPassUserDetails.getDateOfBirth();
        if (dateOfBirth.charAt(2) != '/') {
            StringBuilder sb = new StringBuilder();
            hj1.L0(dateOfBirth, 8, 10, "(this as java.lang.Strin…ing(startIndex, endIndex)", sb, '/');
            hj1.L0(dateOfBirth, 5, 7, "(this as java.lang.Strin…ing(startIndex, endIndex)", sb, '/');
            String substring = dateOfBirth.substring(0, 4);
            n86.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            sb.append(substring);
            dateOfBirth = sb.toString();
        }
        T t3 = activateSuperPassFragment.f;
        n86.c(t3);
        ((cx) t3).c.setText(ui1.w(dateOfBirth));
        T t4 = activateSuperPassFragment.f;
        n86.c(t4);
        ((cx) t4).d.setText(activateSuperPassFragment.getString(superPassUserDetails.getGender().getResId()));
        boolean z = true;
        if (superPassUserDetails.getProfilePhoto().length() > 0) {
            T t5 = activateSuperPassFragment.f;
            n86.c(t5);
            ProgressBar progressBar = ((cx) t5).h;
            n86.d(progressBar, "viewBinding.passProfilePicProgressbar");
            progressBar.setVisibility(0);
            ml1<Bitmap> j = gl1.g(activateSuperPassFragment.c()).j();
            j.h(superPassUserDetails.getProfilePhoto());
            j.a(new rs1().q(50000));
            j.f(new p21(activateSuperPassFragment));
            T t6 = activateSuperPassFragment.f;
            n86.c(t6);
            ((cx) t6).j.setOnClickListener(new m01(activateSuperPassFragment, superPassUserDetails));
        }
        if (superPass.getSuperPassProperties().getProductSubType() == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
            RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) superPass;
            String string = activateSuperPassFragment.getString(R.string.ride_based_pass_activation_text);
            n86.d(string, "getString(R.string.ride_…sed_pass_activation_text)");
            String e0 = hj1.e0(new Object[]{vn.O(activateSuperPassFragment.getContext(), rideBasedSuperPass.getSuperPassValidationProperties().getActiveDuration())}, 1, string, "java.lang.String.format(format, *args)");
            T t7 = activateSuperPassFragment.f;
            n86.c(t7);
            ((cx) t7).b.c.setText(e0);
            int remainingTripsForToday = rideBasedSuperPass.getRemainingTripsForToday();
            int remainingTotalTrips = rideBasedSuperPass.getRemainingTotalTrips();
            if (remainingTotalTrips == -1 && remainingTripsForToday == -1) {
                T t8 = activateSuperPassFragment.f;
                n86.c(t8);
                ConstraintLayout constraintLayout = ((cx) t8).o;
                n86.d(constraintLayout, "viewBinding.tripDetails");
                constraintLayout.setVisibility(8);
                T t9 = activateSuperPassFragment.f;
                n86.c(t9);
                View view = ((cx) t9).f;
                n86.d(view, "viewBinding.maxFareDivider");
                view.setVisibility(8);
            } else {
                T t10 = activateSuperPassFragment.f;
                n86.c(t10);
                ConstraintLayout constraintLayout2 = ((cx) t10).o;
                n86.d(constraintLayout2, "viewBinding.tripDetails");
                constraintLayout2.setVisibility(0);
                T t11 = activateSuperPassFragment.f;
                n86.c(t11);
                View view2 = ((cx) t11).f;
                n86.d(view2, "viewBinding.maxFareDivider");
                view2.setVisibility(0);
                if (remainingTotalTrips == -1) {
                    T t12 = activateSuperPassFragment.f;
                    n86.c(t12);
                    TextView textView = ((cx) t12).k.b;
                    String string2 = activateSuperPassFragment.getString(R.string.tripCountDetailsActivateScreenOnlyDailyLimit, Integer.valueOf(remainingTripsForToday));
                    n86.d(string2, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string2, "java.lang.String.format(format, *args)", textView);
                } else if (remainingTripsForToday == -1) {
                    T t13 = activateSuperPassFragment.f;
                    n86.c(t13);
                    TextView textView2 = ((cx) t13).k.b;
                    String string3 = activateSuperPassFragment.getString(R.string.tripCountDetailsActivateScreenNoDailyLimit, Integer.valueOf(rideBasedSuperPass.getRemainingTotalTrips()));
                    n86.d(string3, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string3, "java.lang.String.format(format, *args)", textView2);
                } else {
                    T t14 = activateSuperPassFragment.f;
                    n86.c(t14);
                    TextView textView3 = ((cx) t14).k.b;
                    String string4 = activateSuperPassFragment.getString(R.string.tripCountDetailsActivateScreen, Integer.valueOf(remainingTotalTrips), Integer.valueOf(remainingTripsForToday));
                    n86.d(string4, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string4, "java.lang.String.format(format, *args)", textView3);
                }
            }
            double maxPricePerTrip = rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip();
            if (maxPricePerTrip != -1.0d) {
                z = false;
            }
            if (!z) {
                T t15 = activateSuperPassFragment.f;
                n86.c(t15);
                cx cxVar = (cx) t15;
                ConstraintLayout constraintLayout3 = cxVar.g;
                n86.d(constraintLayout3, "maxFareInfo");
                constraintLayout3.setVisibility(0);
                cxVar.e.c.setText(activateSuperPassFragment.getString(R.string.maxFareCopy));
                TextView textView4 = cxVar.e.b;
                StringBuilder i0 = hj1.i0("Upto ");
                i0.append((Object) ui1.H());
                hj1.T0(i0, (int) maxPricePerTrip, textView4);
            } else {
                T t16 = activateSuperPassFragment.f;
                n86.c(t16);
                ConstraintLayout constraintLayout4 = ((cx) t16).g;
                n86.d(constraintLayout4, "viewBinding.maxFareInfo");
                constraintLayout4.setVisibility(8);
            }
        } else {
            String string5 = activateSuperPassFragment.getString(R.string.ride_based_pass_activation_text);
            n86.d(string5, "getString(R.string.ride_…sed_pass_activation_text)");
            String e02 = hj1.e0(new Object[]{vn.O(activateSuperPassFragment.getContext(), superPass.getSuperPassValidationProperties().getActiveDuration())}, 1, string5, "java.lang.String.format(format, *args)");
            T t17 = activateSuperPassFragment.f;
            n86.c(t17);
            ((cx) t17).b.c.setText(e02);
        }
        String string6 = activateSuperPassFragment.getString(R.string.mticket_booking_valid_till);
        n86.d(string6, "getString(R.string.mticket_booking_valid_till)");
        String f = jh1.f(superPass.getSuperPassValidationProperties().getExpiryTime());
        n86.d(f, "lExpiryString");
        String x = ea6.x(f, ",", "on", false, 4);
        T t18 = activateSuperPassFragment.f;
        n86.c(t18);
        ((cx) t18).m.setText(string6 + " " + x);
        T t19 = activateSuperPassFragment.f;
        n86.c(t19);
        xv xvVar = ((cx) t19).b;
        xvVar.d.setText(activateSuperPassFragment.getResources().getString(R.string.activate_screen_bottomsheet_title));
        xvVar.b.setText(activateSuperPassFragment.getResources().getString(R.string.btn_txt_activate));
        xvVar.b.setOnClickListener(new t01(superPass, activateSuperPassFragment));
        xvVar.e.setOnClickListener(new s01(activateSuperPassFragment, superPass));
        T t20 = activateSuperPassFragment.f;
        n86.c(t20);
        ((cx) t20).n.setOnMenuItemClickListener(new u01(activateSuperPassFragment, superPass));
    }
}
