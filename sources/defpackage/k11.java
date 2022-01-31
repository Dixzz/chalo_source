package defpackage;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.superPass.RideBasedSuperPass;
import app.zophop.models.mTicketing.superPass.SuperPass;
import app.zophop.models.mTicketing.superPass.SuperPassSubType;
import app.zophop.models.mTicketing.superPass.SuperPassUserDetails;
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassVisualValidationFragment;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.appindexing.Indexable;
import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: k11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class k11 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveSuperPassVisualValidationFragment f2010a;

    public /* synthetic */ k11(ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment) {
        this.f2010a = activeSuperPassVisualValidationFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ActiveSuperPassVisualValidationFragment activeSuperPassVisualValidationFragment = this.f2010a;
        SuperPass superPass = (SuperPass) obj;
        ActiveSuperPassVisualValidationFragment.a aVar = ActiveSuperPassVisualValidationFragment.i;
        n86.e(activeSuperPassVisualValidationFragment, "this$0");
        T t = activeSuperPassVisualValidationFragment.f;
        n86.c(t);
        ((ex) t).o.setTitle(superPass.getSuperPassUIProperties().getFareMappingDisplayName());
        n86.d(superPass, "lSuperPass");
        SuperPassUserDetails superPassUserDetails = superPass.getSuperPassUIProperties().getSuperPassUserDetails();
        T t2 = activeSuperPassVisualValidationFragment.f;
        n86.c(t2);
        ((ex) t2).l.setText(superPassUserDetails.getFullName());
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
        T t3 = activeSuperPassVisualValidationFragment.f;
        n86.c(t3);
        ((ex) t3).c.setText(ui1.w(dateOfBirth));
        T t4 = activeSuperPassVisualValidationFragment.f;
        n86.c(t4);
        ((ex) t4).d.setText(activeSuperPassVisualValidationFragment.getString(superPassUserDetails.getGender().getResId()));
        if (superPassUserDetails.getProfilePhoto().length() > 0) {
            T t5 = activeSuperPassVisualValidationFragment.f;
            n86.c(t5);
            ProgressBar progressBar = ((ex) t5).i;
            n86.d(progressBar, "viewBinding.passProfilePicProgressbar");
            progressBar.setVisibility(0);
            ml1<Bitmap> j = gl1.g(activeSuperPassVisualValidationFragment.c()).j();
            j.h(superPassUserDetails.getProfilePhoto());
            j.a(new rs1().q(50000));
            j.f(new p31(activeSuperPassVisualValidationFragment));
            T t6 = activeSuperPassVisualValidationFragment.f;
            n86.c(t6);
            ((ex) t6).m.setOnClickListener(new o11(activeSuperPassVisualValidationFragment, superPassUserDetails));
        }
        if ((superPass.getSuperPassValidationProperties().getStartTime() + jh1.a(superPass.getSuperPassUIProperties().getNumOfDays())) - ((long) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL) < superPass.getSuperPassValidationProperties().getExpiryTime()) {
            String j0 = ui1.j0();
            T t7 = activeSuperPassVisualValidationFragment.f;
            n86.c(t7);
            py pyVar = ((ex) t7).h;
            if (j0 != null) {
                LinearLayout linearLayout = pyVar.c;
                n86.d(linearLayout, "passValidityExtensionLayout");
                linearLayout.setVisibility(0);
                pyVar.b.setText(j0);
            } else {
                LinearLayout linearLayout2 = pyVar.c;
                n86.d(linearLayout2, "passValidityExtensionLayout");
                linearLayout2.setVisibility(8);
            }
        }
        if (superPass.getSuperPassProperties().getProductSubType() == SuperPassSubType.RIDE_BASED_SUPER_PASS) {
            RideBasedSuperPass rideBasedSuperPass = (RideBasedSuperPass) superPass;
            int remainingTripsForToday = rideBasedSuperPass.getRemainingTripsForToday();
            int remainingTotalTrips = rideBasedSuperPass.getRemainingTotalTrips();
            if (remainingTotalTrips == -1 && remainingTripsForToday == -1) {
                T t8 = activeSuperPassVisualValidationFragment.f;
                n86.c(t8);
                LinearLayout linearLayout3 = ((ex) t8).p.f352a;
                n86.d(linearLayout3, "viewBinding.tripDetailsContainer.root");
                linearLayout3.setVisibility(8);
                T t9 = activeSuperPassVisualValidationFragment.f;
                n86.c(t9);
                View view = ((ex) t9).g;
                n86.d(view, "viewBinding.passDivider");
                view.setVisibility(8);
            } else {
                T t10 = activeSuperPassVisualValidationFragment.f;
                n86.c(t10);
                LinearLayout linearLayout4 = ((ex) t10).p.f352a;
                n86.d(linearLayout4, "viewBinding.tripDetailsContainer.root");
                linearLayout4.setVisibility(0);
                T t11 = activeSuperPassVisualValidationFragment.f;
                n86.c(t11);
                View view2 = ((ex) t11).g;
                n86.d(view2, "viewBinding.passDivider");
                view2.setVisibility(0);
                T t12 = activeSuperPassVisualValidationFragment.f;
                n86.c(t12);
                ((ex) t12).p.c.setText(activeSuperPassVisualValidationFragment.getString(R.string.trips_remaining));
                if (remainingTotalTrips == -1) {
                    T t13 = activeSuperPassVisualValidationFragment.f;
                    n86.c(t13);
                    TextView textView = ((ex) t13).p.b;
                    String string = activeSuperPassVisualValidationFragment.getString(R.string.tripCountDetailsActivateScreenOnlyDailyLimit, Integer.valueOf(remainingTripsForToday));
                    n86.d(string, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string, "java.lang.String.format(format, *args)", textView);
                } else if (remainingTripsForToday == -1) {
                    T t14 = activeSuperPassVisualValidationFragment.f;
                    n86.c(t14);
                    TextView textView2 = ((ex) t14).p.b;
                    String string2 = activeSuperPassVisualValidationFragment.getString(R.string.tripCountDetailsActivateScreenNoDailyLimit, Integer.valueOf(rideBasedSuperPass.getRemainingTotalTrips()));
                    n86.d(string2, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string2, "java.lang.String.format(format, *args)", textView2);
                } else {
                    T t15 = activeSuperPassVisualValidationFragment.f;
                    n86.c(t15);
                    TextView textView3 = ((ex) t15).p.b;
                    String string3 = activeSuperPassVisualValidationFragment.getString(R.string.tripCountDetailsActivateScreen, Integer.valueOf(remainingTotalTrips), Integer.valueOf(remainingTripsForToday));
                    n86.d(string3, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string3, "java.lang.String.format(format, *args)", textView3);
                }
            }
            double maxPricePerTrip = rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip();
            if (!(maxPricePerTrip == -1.0d)) {
                T t16 = activeSuperPassVisualValidationFragment.f;
                n86.c(t16);
                ex exVar = (ex) t16;
                T t17 = activeSuperPassVisualValidationFragment.f;
                n86.c(t17);
                View view3 = ((ex) t17).e;
                n86.d(view3, "viewBinding.maxFareDivider");
                view3.setVisibility(0);
                LinearLayout linearLayout5 = exVar.f.f352a;
                n86.d(linearLayout5, "maxFareInfo.root");
                linearLayout5.setVisibility(0);
                exVar.f.c.setText(activeSuperPassVisualValidationFragment.getString(R.string.maxFareCopy));
                TextView textView4 = exVar.f.b;
                StringBuilder i0 = hj1.i0("Upto ");
                i0.append((Object) ui1.H());
                hj1.T0(i0, (int) maxPricePerTrip, textView4);
            } else {
                T t18 = activeSuperPassVisualValidationFragment.f;
                n86.c(t18);
                View view4 = ((ex) t18).e;
                n86.d(view4, "viewBinding.maxFareDivider");
                view4.setVisibility(8);
                T t19 = activeSuperPassVisualValidationFragment.f;
                n86.c(t19);
                LinearLayout linearLayout6 = ((ex) t19).f.f352a;
                n86.d(linearLayout6, "viewBinding.maxFareInfo.root");
                linearLayout6.setVisibility(8);
            }
        } else {
            T t20 = activeSuperPassVisualValidationFragment.f;
            n86.c(t20);
            LinearLayout linearLayout7 = ((ex) t20).p.f352a;
            n86.d(linearLayout7, "viewBinding.tripDetailsContainer.root");
            linearLayout7.setVisibility(8);
            T t21 = activeSuperPassVisualValidationFragment.f;
            n86.c(t21);
            View view5 = ((ex) t21).g;
            n86.d(view5, "viewBinding.passDivider");
            view5.setVisibility(8);
            T t22 = activeSuperPassVisualValidationFragment.f;
            n86.c(t22);
            View view6 = ((ex) t22).e;
            n86.d(view6, "viewBinding.maxFareDivider");
            view6.setVisibility(8);
            T t23 = activeSuperPassVisualValidationFragment.f;
            n86.c(t23);
            LinearLayout linearLayout8 = ((ex) t23).f.f352a;
            n86.d(linearLayout8, "viewBinding.maxFareInfo.root");
            linearLayout8.setVisibility(8);
        }
        String x = ea6.x(activeSuperPassVisualValidationFragment.getString(R.string.mticket_booking_valid_till) + ' ' + ((Object) jh1.f(superPass.getSuperPassValidationProperties().getExpiryTime())), ",", "on", false, 4);
        T t24 = activeSuperPassVisualValidationFragment.f;
        n86.c(t24);
        ((ex) t24).k.setText(x);
        z25 z25 = new z25();
        ah b = wg.b(activeSuperPassVisualValidationFragment);
        l31 l31 = new l31(activeSuperPassVisualValidationFragment, z25, superPass);
        n86.e(b, "<this>");
        n86.e(l31, "action");
        kb6 kb6 = xb6.b;
        CoroutineExceptionHandler.a aVar2 = CoroutineExceptionHandler.a.f;
        hd3.Y1(b, hj1.s0(aVar2, kb6), null, new rh1(1000, l31, null), 2, null);
        T t25 = activeSuperPassVisualValidationFragment.f;
        n86.c(t25);
        ((ex) t25).j.setOnClickListener(new m11(activeSuperPassVisualValidationFragment));
        T t26 = activeSuperPassVisualValidationFragment.f;
        n86.c(t26);
        FrameLayout frameLayout = ((ex) t26).b.e;
        n86.d(frameLayout, "viewBinding.brandingSuperPass.frameLayout");
        frameLayout.setVisibility(superPass.getSuperPassUIProperties().getProductBranding().isVisible() ? 0 : 8);
        if (superPass.getSuperPassUIProperties().getProductBranding().isVisible()) {
            String cityName = superPass.getSuperPassProperties().getCityName();
            T t27 = activeSuperPassVisualValidationFragment.f;
            n86.c(t27);
            rw rwVar = ((ex) t27).b;
            if (ea6.f("indore", cityName, true)) {
                T t28 = activeSuperPassVisualValidationFragment.f;
                n86.c(t28);
                ((ex) t28).b.c.setImageResource(R.drawable.aictsl_logo_grey);
                T t29 = activeSuperPassVisualValidationFragment.f;
                n86.c(t29);
                ((ex) t29).b.c.setVisibility(0);
                T t30 = activeSuperPassVisualValidationFragment.f;
                n86.c(t30);
                ((ex) t30).b.d.setVisibility(8);
                T t31 = activeSuperPassVisualValidationFragment.f;
                n86.c(t31);
                ((ex) t31).b.b.setVisibility(8);
            } else if (ea6.f("jabalpur", cityName, true)) {
                rwVar.f.setImageResource(R.drawable.jabalpur_logo_1);
                rwVar.g.setImageResource(R.drawable.jabalpur_logo_2);
                rwVar.c.setVisibility(8);
                rwVar.d.setVisibility(0);
            } else if (ea6.f("bhopal", cityName, true)) {
                rwVar.f.setImageResource(R.drawable.bhopal_logo_1);
                rwVar.g.setImageResource(R.drawable.bhopal_logo_2);
                rwVar.c.setVisibility(8);
                rwVar.d.setVisibility(0);
            } else {
                rwVar.c.setVisibility(8);
                rwVar.d.setVisibility(8);
                rwVar.b.setVisibility(0);
                TextView textView5 = rwVar.b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(activeSuperPassVisualValidationFragment.getString(R.string.agency_text));
                sb2.append(' ');
                String agencyName = superPass.getSuperPassProperties().getAgencyName();
                Objects.requireNonNull(agencyName, "null cannot be cast to non-null type java.lang.String");
                String upperCase = agencyName.toUpperCase();
                n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
                sb2.append(upperCase);
                textView5.setText(sb2.toString());
            }
        }
        ah b2 = wg.b(activeSuperPassVisualValidationFragment);
        n31 n31 = new n31(activeSuperPassVisualValidationFragment, superPass);
        n86.e(b2, "<this>");
        n86.e(n31, "action");
        hd3.Y1(b2, hj1.s0(aVar2, kb6), null, new sh1(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL, n31, null), 2, null);
        T t32 = activeSuperPassVisualValidationFragment.f;
        n86.c(t32);
        ((ex) t32).o.setOnMenuItemClickListener(new l11(activeSuperPassVisualValidationFragment, superPass));
    }
}
