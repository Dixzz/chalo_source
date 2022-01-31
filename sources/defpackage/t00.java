package defpackage;

import android.content.Context;
import app.zophop.models.autoCabBooking.BookingCode;
import app.zophop.models.autoCabBooking.BookingDetails;
import com.google.android.gms.maps.model.LatLng;
import defpackage.xt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.json.JSONException;

/* renamed from: t00  reason: default package */
/* compiled from: CabBookingListFeature */
public class t00 {

    /* renamed from: a  reason: collision with root package name */
    public final rf1 f3289a;
    public final jv b;
    public boolean c = false;

    public t00(Context context) {
        this.f3289a = new rf1(context, "booking_history_store");
        this.b = new jv();
        if (c()) {
            BookingDetails b2 = b();
            String provider = b2.getProvider();
            xt.t1 t1Var = xt.f3961a;
            t1Var.g().p(provider, t1Var.H().f(provider), b2.getRequestId());
        }
        jz5 b3 = jz5.b();
        b3.k(this, b3.e, true, 0);
    }

    public static boolean d(BookingCode bookingCode) {
        return Arrays.asList(BookingCode.ACCEPTED, BookingCode.IN_PROGRESS, BookingCode.PROCESSING).contains(bookingCode);
    }

    public List<BookingDetails> a() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.f3289a.b().keySet()) {
            String f = this.f3289a.f(str, null);
            if (f != null) {
                try {
                    arrayList.add(this.b.a(f));
                } catch (JSONException e) {
                    b00 b00 = b00.f358a;
                    b00.a().b(e);
                }
            }
        }
        Collections.sort(arrayList, new s00(this));
        return arrayList;
    }

    public BookingDetails b() {
        String string = this.f3289a.b.getString("live_booking", null);
        if (string != null) {
            try {
                return this.b.a(string);
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        }
        return null;
    }

    public boolean c() {
        return this.f3289a.b.contains("live_booking");
    }

    public void e(String str) {
        BookingDetails b2 = b();
        if (b2 != null) {
            BookingCode code = b2.getCode();
            if (code.equals(BookingCode.ACCEPTED) || code.equals(BookingCode.IN_PROGRESS)) {
                rf1 rf1 = this.f3289a;
                rf1.f3075a.putString("live_booking_url", str);
                rf1.f3075a.commit();
                return;
            }
            rf1 rf12 = this.f3289a;
            rf12.f3075a.remove("live_booking_url");
            rf12.f3075a.commit();
            rf1 rf13 = this.f3289a;
            rf13.f3075a.remove("live_booking_url");
            rf13.f3075a.commit();
        }
    }

    public void f(BookingDetails bookingDetails) {
        if (d(bookingDetails.getCode())) {
            try {
                String b2 = this.b.b(bookingDetails);
                rf1 rf1 = this.f3289a;
                rf1.f3075a.putString("live_booking", b2);
                rf1.f3075a.commit();
                mf1 toLocation = bookingDetails.getToLocation();
                if (toLocation != null && toLocation.b == null && toLocation.f2368a != null) {
                    xt.f3961a.B().f(toLocation.f2368a);
                }
            } catch (JSONException e) {
                b00 b00 = b00.f358a;
                b00.a().b(e);
            }
        } else {
            rf1 rf12 = this.f3289a;
            rf12.f3075a.remove("live_booking");
            rf12.f3075a.commit();
            rf1 rf13 = this.f3289a;
            rf13.f3075a.remove("live_booking_url");
            rf13.f3075a.commit();
            try {
                this.f3289a.j(bookingDetails.getRequestId(), this.b.b(bookingDetails));
            } catch (JSONException e2) {
                b00 b002 = b00.f358a;
                b00.a().b(e2);
            }
        }
    }

    public void onEvent(qe1 qe1) {
        BookingDetails b2;
        LatLng latLng;
        if (qe1.c.equals(ad1.SUCCESS) && (b2 = b()) != null && b2.getToLocation() != null && (latLng = b2.getToLocation().f2368a) != null && ui1.m(latLng, qe1.b) < 100.0d) {
            mf1 toLocation = b2.getToLocation();
            String str = qe1.f2934a;
            toLocation.b = str;
            toLocation.c = str;
            f(b2);
        }
    }
}
