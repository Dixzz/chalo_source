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
import app.zophop.ui.fragments.superPassValidation.ActiveSuperPassFragment;
import com.freshchat.consumer.sdk.beans.config.DefaultRefreshIntervals;
import com.google.firebase.appindexing.Indexable;
import java.util.Objects;
import kotlinx.coroutines.CoroutineExceptionHandler;

/* renamed from: b11  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class b11 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ActiveSuperPassFragment f364a;

    public /* synthetic */ b11(ActiveSuperPassFragment activeSuperPassFragment) {
        this.f364a = activeSuperPassFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        ActiveSuperPassFragment activeSuperPassFragment = this.f364a;
        SuperPass superPass = (SuperPass) obj;
        ActiveSuperPassFragment.a aVar = ActiveSuperPassFragment.i;
        n86.e(activeSuperPassFragment, "this$0");
        n86.d(superPass, "lSuperPass");
        ed1 ed1 = new ed1("super pass fetched", Long.MIN_VALUE);
        ed1.a("source", "Active Super Pass Fragment");
        gi1.f1265a.d(ed1, superPass);
        ui1.m0(ed1);
        T t = activeSuperPassFragment.f;
        n86.c(t);
        ((dx) t).n.setTitle(superPass.getSuperPassUIProperties().getFareMappingDisplayName());
        SuperPassUserDetails superPassUserDetails = superPass.getSuperPassUIProperties().getSuperPassUserDetails();
        T t2 = activeSuperPassFragment.f;
        n86.c(t2);
        ((dx) t2).k.setText(superPassUserDetails.getFullName());
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
        T t3 = activeSuperPassFragment.f;
        n86.c(t3);
        ((dx) t3).c.setText(ui1.w(dateOfBirth));
        T t4 = activeSuperPassFragment.f;
        n86.c(t4);
        ((dx) t4).d.setText(activeSuperPassFragment.getString(superPassUserDetails.getGender().getResId()));
        if (superPassUserDetails.getProfilePhoto().length() > 0) {
            T t5 = activeSuperPassFragment.f;
            n86.c(t5);
            ProgressBar progressBar = ((dx) t5).h;
            n86.d(progressBar, "viewBinding.passProfilePicProgressbar");
            progressBar.setVisibility(0);
            ml1<Bitmap> j = gl1.g(activeSuperPassFragment.c()).j();
            j.h(superPassUserDetails.getProfilePhoto());
            j.a(new rs1().q(50000));
            j.f(new b31(activeSuperPassFragment));
            T t6 = activeSuperPassFragment.f;
            n86.c(t6);
            ((dx) t6).l.setOnClickListener(new z01(activeSuperPassFragment, superPassUserDetails));
        }
        if ((superPass.getSuperPassValidationProperties().getStartTime() + jh1.a(superPass.getSuperPassUIProperties().getNumOfDays())) - ((long) Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL) < superPass.getSuperPassValidationProperties().getExpiryTime()) {
            String j0 = ui1.j0();
            T t7 = activeSuperPassFragment.f;
            n86.c(t7);
            py pyVar = ((dx) t7).g;
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
                T t8 = activeSuperPassFragment.f;
                n86.c(t8);
                LinearLayout linearLayout3 = ((dx) t8).o.f352a;
                n86.d(linearLayout3, "viewBinding.tripDetailsContainer.root");
                linearLayout3.setVisibility(8);
            } else {
                T t9 = activeSuperPassFragment.f;
                n86.c(t9);
                LinearLayout linearLayout4 = ((dx) t9).o.f352a;
                n86.d(linearLayout4, "viewBinding.tripDetailsContainer.root");
                linearLayout4.setVisibility(0);
                T t10 = activeSuperPassFragment.f;
                n86.c(t10);
                ((dx) t10).o.c.setText(activeSuperPassFragment.getString(R.string.trips_remaining));
                if (remainingTotalTrips == -1) {
                    T t11 = activeSuperPassFragment.f;
                    n86.c(t11);
                    TextView textView = ((dx) t11).o.b;
                    String string = activeSuperPassFragment.getString(R.string.tripCountDetailsActivateScreenOnlyDailyLimit, Integer.valueOf(remainingTripsForToday));
                    n86.d(string, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string, "java.lang.String.format(format, *args)", textView);
                } else if (remainingTripsForToday == -1) {
                    T t12 = activeSuperPassFragment.f;
                    n86.c(t12);
                    TextView textView2 = ((dx) t12).o.b;
                    String string2 = activeSuperPassFragment.getString(R.string.tripCountDetailsActivateScreenNoDailyLimit, Integer.valueOf(rideBasedSuperPass.getRemainingTotalTrips()));
                    n86.d(string2, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string2, "java.lang.String.format(format, *args)", textView2);
                } else {
                    T t13 = activeSuperPassFragment.f;
                    n86.c(t13);
                    TextView textView3 = ((dx) t13).o.b;
                    String string3 = activeSuperPassFragment.getString(R.string.tripCountDetailsActivateScreen, Integer.valueOf(remainingTotalTrips), Integer.valueOf(remainingTripsForToday));
                    n86.d(string3, "getString(\n             …                        )");
                    hj1.e(new Object[0], 0, string3, "java.lang.String.format(format, *args)", textView3);
                }
            }
            double maxPricePerTrip = rideBasedSuperPass.getSuperPassUIProperties().getMaxPricePerTrip();
            if (!(maxPricePerTrip == -1.0d)) {
                T t14 = activeSuperPassFragment.f;
                n86.c(t14);
                dx dxVar = (dx) t14;
                T t15 = activeSuperPassFragment.f;
                n86.c(t15);
                View view = ((dx) t15).e;
                n86.d(view, "viewBinding.maxFareDivider");
                view.setVisibility(0);
                LinearLayout linearLayout5 = dxVar.f.f352a;
                n86.d(linearLayout5, "maxFareInfo.root");
                linearLayout5.setVisibility(0);
                dxVar.f.c.setText(activeSuperPassFragment.getString(R.string.maxFareCopy));
                TextView textView4 = dxVar.f.b;
                StringBuilder i0 = hj1.i0("Upto ");
                i0.append((Object) ui1.H());
                hj1.T0(i0, (int) maxPricePerTrip, textView4);
            } else {
                T t16 = activeSuperPassFragment.f;
                n86.c(t16);
                View view2 = ((dx) t16).e;
                n86.d(view2, "viewBinding.maxFareDivider");
                view2.setVisibility(8);
                T t17 = activeSuperPassFragment.f;
                n86.c(t17);
                LinearLayout linearLayout6 = ((dx) t17).f.f352a;
                n86.d(linearLayout6, "viewBinding.maxFareInfo.root");
                linearLayout6.setVisibility(8);
            }
        } else {
            T t18 = activeSuperPassFragment.f;
            n86.c(t18);
            LinearLayout linearLayout7 = ((dx) t18).o.f352a;
            n86.d(linearLayout7, "viewBinding.tripDetailsContainer.root");
            linearLayout7.setVisibility(8);
            T t19 = activeSuperPassFragment.f;
            n86.c(t19);
            View view3 = ((dx) t19).e;
            n86.d(view3, "viewBinding.maxFareDivider");
            view3.setVisibility(8);
            T t20 = activeSuperPassFragment.f;
            n86.c(t20);
            LinearLayout linearLayout8 = ((dx) t20).f.f352a;
            n86.d(linearLayout8, "viewBinding.maxFareInfo.root");
            linearLayout8.setVisibility(8);
        }
        String x = ea6.x(activeSuperPassFragment.getString(R.string.mticket_booking_valid_till) + ' ' + ((Object) jh1.f(superPass.getSuperPassValidationProperties().getExpiryTime())), ",", "on", false, 4);
        T t21 = activeSuperPassFragment.f;
        n86.c(t21);
        ((dx) t21).j.setText(x);
        z25 z25 = new z25();
        ah b = wg.b(activeSuperPassFragment);
        x21 x21 = new x21(activeSuperPassFragment, z25, superPass);
        n86.e(b, "<this>");
        n86.e(x21, "action");
        kb6 kb6 = xb6.b;
        CoroutineExceptionHandler.a aVar2 = CoroutineExceptionHandler.a.f;
        hd3.Y1(b, hj1.s0(aVar2, kb6), null, new rh1(1000, x21, null), 2, null);
        T t22 = activeSuperPassFragment.f;
        n86.c(t22);
        ((dx) t22).i.setOnClickListener(new w01(superPass, activeSuperPassFragment));
        ah b2 = wg.b(activeSuperPassFragment);
        z21 z21 = new z21(activeSuperPassFragment, superPass);
        n86.e(b2, "<this>");
        n86.e(z21, "action");
        hd3.Y1(b2, hj1.s0(aVar2, kb6), null, new sh1(DefaultRefreshIntervals.ACTIVE_CONV_MAX_FETCH_INTERVAL, z21, null), 2, null);
        T t23 = activeSuperPassFragment.f;
        n86.c(t23);
        FrameLayout frameLayout = ((dx) t23).b.e;
        n86.d(frameLayout, "viewBinding.brandingSuperPass.frameLayout");
        frameLayout.setVisibility(superPass.getSuperPassUIProperties().getProductBranding().isVisible() ? 0 : 8);
        if (superPass.getSuperPassUIProperties().getProductBranding().isVisible()) {
            String cityName = superPass.getSuperPassProperties().getCityName();
            T t24 = activeSuperPassFragment.f;
            n86.c(t24);
            qw qwVar = ((dx) t24).b;
            if (ea6.f("indore", cityName, true)) {
                T t25 = activeSuperPassFragment.f;
                n86.c(t25);
                ((dx) t25).b.c.setImageResource(R.drawable.aictsl_logo_grey);
                T t26 = activeSuperPassFragment.f;
                n86.c(t26);
                ((dx) t26).b.c.setVisibility(0);
                T t27 = activeSuperPassFragment.f;
                n86.c(t27);
                ((dx) t27).b.d.setVisibility(8);
                T t28 = activeSuperPassFragment.f;
                n86.c(t28);
                ((dx) t28).b.b.setVisibility(8);
            } else if (ea6.f("jabalpur", cityName, true)) {
                qwVar.f.setImageResource(R.drawable.jabalpur_logo_1);
                qwVar.g.setImageResource(R.drawable.jabalpur_logo_2);
                qwVar.c.setVisibility(8);
                qwVar.d.setVisibility(0);
            } else if (ea6.f("bhopal", cityName, true)) {
                qwVar.f.setImageResource(R.drawable.bhopal_logo_1);
                qwVar.g.setImageResource(R.drawable.bhopal_logo_2);
                qwVar.c.setVisibility(8);
                qwVar.d.setVisibility(0);
            } else {
                qwVar.c.setVisibility(8);
                qwVar.d.setVisibility(8);
                qwVar.b.setVisibility(0);
                TextView textView5 = qwVar.b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(activeSuperPassFragment.getString(R.string.agency_text));
                sb2.append(' ');
                String agencyName = superPass.getSuperPassProperties().getAgencyName();
                Objects.requireNonNull(agencyName, "null cannot be cast to non-null type java.lang.String");
                String upperCase = agencyName.toUpperCase();
                n86.d(upperCase, "(this as java.lang.String).toUpperCase()");
                sb2.append(upperCase);
                textView5.setText(sb2.toString());
            }
        }
        T t29 = activeSuperPassFragment.f;
        n86.c(t29);
        ((dx) t29).n.setOnMenuItemClickListener(new x01(activeSuperPassFragment, superPass));
    }
}
