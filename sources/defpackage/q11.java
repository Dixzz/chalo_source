package defpackage;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;

/* renamed from: q11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class q11 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ t31 f2882a;

    public /* synthetic */ q11(t31 t31) {
        this.f2882a = t31;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        t31 t31 = this.f2882a;
        SuperPass superPass = (SuperPass) obj;
        n86.e(t31, "this$0");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("super pass fetched", Long.MIN_VALUE);
        ed1.a("source", "bottom sheet super pass");
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
        T t = t31.f;
        n86.c(t);
        ((ow) t).i.setText(superPass.getSuperPassUIProperties().getPassName());
        SuperPassUserDetails superPassUserDetails = superPass.getSuperPassUIProperties().getSuperPassUserDetails();
        T t2 = t31.f;
        n86.c(t2);
        ((ow) t2).j.setText(superPassUserDetails.getFullName());
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
        T t3 = t31.f;
        n86.c(t3);
        ((ow) t3).c.setText(ui1.w(dateOfBirth));
        T t4 = t31.f;
        n86.c(t4);
        ((ow) t4).d.setText(t31.getString(superPassUserDetails.getGender().getResId()));
        boolean z = true;
        if (superPassUserDetails.getProfilePhoto().length() > 0) {
            T t5 = t31.f;
            n86.c(t5);
            ProgressBar progressBar = ((ow) t5).g;
            n86.d(progressBar, "viewBinding.passProfilePicProgressbar");
            progressBar.setVisibility(0);
            ml1<Bitmap> j = gl1.g(t31.c()).j();
            j.h(superPassUserDetails.getProfilePhoto());
            j.a(new rs1().q(50000));
            j.f(new v31(t31));
        }
        if (superPass.getSuperPassProperties().getProductSubType() == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
            RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) superPass;
            int remainingTripsForToday = rideBasedSuperPass.getRemainingTripsForToday();
            int remainingTotalTrips = rideBasedSuperPass.getRemainingTotalTrips();
            if (remainingTotalTrips == -1 && remainingTripsForToday == -1) {
                T t6 = t31.f;
                n86.c(t6);
                LinearLayout linearLayout = ((ow) t6).l.f352a;
                n86.d(linearLayout, "viewBinding.tripDetailsContainer.root");
                linearLayout.setVisibility(8);
                T t7 = t31.f;
                n86.c(t7);
                View view = ((ow) t7).m;
                n86.d(view, "viewBinding.tripDetailsMaxFareDivider");
                view.setVisibility(8);
            } else {
                T t8 = t31.f;
                n86.c(t8);
                LinearLayout linearLayout2 = ((ow) t8).l.f352a;
                n86.d(linearLayout2, "viewBinding.tripDetailsContainer.root");
                linearLayout2.setVisibility(0);
                T t9 = t31.f;
                n86.c(t9);
                View view2 = ((ow) t9).m;
                n86.d(view2, "viewBinding.tripDetailsMaxFareDivider");
                view2.setVisibility(0);
                T t10 = t31.f;
                n86.c(t10);
                ((ow) t10).l.c.setText(t31.getString(R.string.trips_remaining));
                if (remainingTotalTrips == -1) {
                    T t11 = t31.f;
                    n86.c(t11);
                    TextView textView = ((ow) t11).l.b;
                    String string = t31.getString(R.string.tripCountDetailsActivateScreenOnlyDailyLimit, Integer.valueOf(remainingTripsForToday));
                    n86.d(string, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string, "java.lang.String.format(format, *args)", textView);
                } else if (remainingTripsForToday == -1) {
                    T t12 = t31.f;
                    n86.c(t12);
                    TextView textView2 = ((ow) t12).l.b;
                    String string2 = t31.getString(R.string.tripCountDetailsActivateScreenNoDailyLimit, Integer.valueOf(rideBasedSuperPass.getRemainingTotalTrips()));
                    n86.d(string2, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string2, "java.lang.String.format(format, *args)", textView2);
                } else {
                    T t13 = t31.f;
                    n86.c(t13);
                    TextView textView3 = ((ow) t13).l.b;
                    String string3 = t31.getString(R.string.tripCountDetailsActivateScreen, Integer.valueOf(remainingTotalTrips), Integer.valueOf(remainingTripsForToday));
                    n86.d(string3, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string3, "java.lang.String.format(format, *args)", textView3);
                }
            }
            double maxPricePerTrip = rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip();
            if (maxPricePerTrip != -1.0d) {
                z = false;
            }
            if (!z) {
                T t14 = t31.f;
                n86.c(t14);
                ow owVar = (ow) t14;
                ConstraintLayout constraintLayout = owVar.f;
                n86.d(constraintLayout, "maxFareInfo");
                constraintLayout.setVisibility(0);
                owVar.e.c.setText(t31.getString(R.string.maxFareCopy));
                TextView textView4 = owVar.e.b;
                StringBuilder i0 = hj1.i0("Upto ");
                i0.append((Object) ui1.H());
                hj1.T0(i0, (int) maxPricePerTrip, textView4);
            } else {
                T t15 = t31.f;
                n86.c(t15);
                ConstraintLayout constraintLayout2 = ((ow) t15).f;
                n86.d(constraintLayout2, "viewBinding.maxFareInfo");
                constraintLayout2.setVisibility(8);
            }
        } else {
            T t16 = t31.f;
            n86.c(t16);
            LinearLayout linearLayout3 = ((ow) t16).l.f352a;
            n86.d(linearLayout3, "viewBinding.tripDetailsContainer.root");
            linearLayout3.setVisibility(8);
            T t17 = t31.f;
            n86.c(t17);
            View view3 = ((ow) t17).m;
            n86.d(view3, "viewBinding.tripDetailsMaxFareDivider");
            view3.setVisibility(8);
            T t18 = t31.f;
            n86.c(t18);
            ConstraintLayout constraintLayout3 = ((ow) t18).f;
            n86.d(constraintLayout3, "viewBinding.maxFareInfo");
            constraintLayout3.setVisibility(8);
        }
        String x = ea6.x(t31.getString(R.string.mticket_booking_valid_till) + ' ' + ((Object) jh1.f(superPass.getSuperPassValidationProperties().getExpiryTime())), ",", "on", false, 4);
        T t19 = t31.f;
        n86.c(t19);
        ((ow) t19).h.setText(x);
    }
}
