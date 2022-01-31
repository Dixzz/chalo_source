package defpackage;

import android.text.TextUtils;
import android.view.View;
import app.zophop.models.ScanPayTicket;
import app.zophop.models.mTicketing.MPass;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.models.mTicketing.UserProfile;
import app.zophop.ui.activities.ValidationScreen;
import java.util.HashMap;
import java.util.Objects;

/* renamed from: kh0  reason: default package */
/* compiled from: ValidationScreen */
public class kh0 implements View.OnClickListener {
    public final /* synthetic */ ValidationScreen f;

    public kh0(ValidationScreen validationScreen) {
        this.f = validationScreen;
    }

    public void onClick(View view) {
        UserProfile userProfile;
        String str;
        String str2;
        RouteStopsInfo routeStopsInfo;
        String str3;
        ValidationScreen validationScreen = this.f;
        int i = ValidationScreen.u;
        Objects.requireNonNull(validationScreen);
        y20 R = xt.f3961a.R();
        HashMap hashMap = new HashMap();
        MTicket mTicket = validationScreen.p;
        String str4 = null;
        if (mTicket != null) {
            str4 = mTicket.getCityName();
            userProfile = validationScreen.p.get_userProfile();
            str3 = validationScreen.p.getAgency();
            routeStopsInfo = validationScreen.p.getUpTripRouteStopsInfo();
            str2 = validationScreen.p.getMTicketId();
            str = validationScreen.p.getOrderId();
        } else {
            MPass mPass = validationScreen.q;
            if (mPass != null) {
                String str5 = mPass.get_cityName();
                UserProfile userProfile2 = validationScreen.q.getUserProfile();
                String agency = validationScreen.q.getAgency();
                str2 = validationScreen.q.getBookingPassId();
                str = validationScreen.q.getOrderId();
                str4 = str5;
                userProfile = userProfile2;
                str3 = agency;
                routeStopsInfo = null;
            } else {
                ScanPayTicket scanPayTicket = validationScreen.r;
                if (scanPayTicket != null) {
                    String str6 = scanPayTicket.get_cityName();
                    str3 = validationScreen.r.get_agencyName();
                    String str7 = validationScreen.r.get_transactionId();
                    str = validationScreen.r.get_orderId();
                    str2 = str7;
                    routeStopsInfo = null;
                    str4 = str6;
                    userProfile = null;
                } else {
                    userProfile = null;
                    str3 = null;
                    routeStopsInfo = null;
                    str2 = null;
                    str = null;
                }
            }
        }
        if (!TextUtils.isEmpty(str4)) {
            hashMap.put("userPropertyCity", str4);
        }
        if (userProfile != null) {
            String firstName = userProfile.getFirstName();
            String lastName = userProfile.getLastName();
            if (firstName != null) {
                if (lastName != null) {
                    firstName = hj1.T(firstName, " ", lastName);
                }
                hashMap.put("userPropertyUserName", firstName);
            } else if (lastName != null) {
                hashMap.put("userPropertyUserName", lastName);
            }
            if (userProfile.getPhone() != null) {
                hashMap.put("userPropertyPhoneNo", userProfile.getPhone());
            }
            if (userProfile.getUserId() != null) {
                hashMap.put("userPropertyUserID", userProfile.getUserId());
            }
        }
        if (str3 != null) {
            hashMap.put("userPropertyAgencyName", str3);
        }
        if (routeStopsInfo != null) {
            if (routeStopsInfo.getRouteId() != null) {
                hashMap.put("userPropertyRouteId", routeStopsInfo.getRouteId());
            }
            if (routeStopsInfo.getRouteName() != null) {
                hashMap.put("userPropertyRouteName", routeStopsInfo.getRouteName());
            }
        }
        if (str2 != null) {
            hashMap.put("userPropertyMTicketId", str2);
        }
        if (str != null) {
            hashMap.put("userPropertyOrderId", str);
        }
        R.b(validationScreen, "transactionRelatedScreen", "activateMticketScreen", hashMap, false);
        ValidationScreen.n0();
        ValidationScreen.n0();
    }
}
