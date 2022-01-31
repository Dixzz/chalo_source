package defpackage;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.LastRideInfo;
import app.zophop.models.mTicketing.MTicket;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.room.ProductRepository;
import app.zophop.room.Ticket;
import app.zophop.ui.activities.ActivateMTicketScreen;
import app.zophop.ui.activities.ActiveMTicketScreen;
import app.zophop.ui.activities.ValidationScreen;
import com.google.android.gms.maps.model.LatLng;
import defpackage.ut;
import defpackage.xt;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: nb0  reason: default package */
/* compiled from: ActivateMTicketScreen */
public class nb0 implements View.OnClickListener {
    public final /* synthetic */ ActivateMTicketScreen f;

    /* renamed from: nb0$a */
    /* compiled from: ActivateMTicketScreen */
    public class a implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public a(lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            MTicket mTicket;
            ProductConfiguration m0;
            ActivateMTicketScreen activateMTicketScreen = nb0.this.f;
            boolean z = false;
            SharedPreferences.Editor edit = activateMTicketScreen.getSharedPreferences(activateMTicketScreen.getString(R.string.FROM_KEY), 0).edit();
            vn.y(nb0.this.f.k.getMTicketConfiguration().getId());
            edit.putString(nb0.this.f.getString(R.string.FROM), nb0.this.f.getString(R.string.activate));
            edit.commit();
            long Q = ui1.Q();
            nb0.this.f.k.setIsUpTripActivated(true);
            nb0.this.f.k.setUpTripActivationTime(Q);
            xt.t1 t1Var = xt.f3961a;
            t1Var.p().b(nb0.this.f.k, Q);
            ProductRepository productRepository = new ProductRepository(nb0.this.f);
            Ticket currentTicket = productRepository.getCurrentTicket(nb0.this.f.k.getMTicketId());
            if (currentTicket != null) {
                mTicket = currentTicket.getmTicket();
            } else {
                currentTicket = new Ticket();
                mTicket = nb0.this.f.k;
            }
            mTicket.setIsUpTripActivated(true);
            mTicket.setUpTripActivationTime(Q);
            mTicket.setCityName(mTicket.getCityName().toLowerCase());
            currentTicket.setmTicket(mTicket);
            currentTicket.setTicketId(mTicket.getMTicketId());
            productRepository.insertOrUpdate(currentTicket);
            t1Var.c().U(nb0.this.f.k);
            t1Var.c().l0(nb0.this.f.k, ui1.Q());
            MTicket mTicket2 = nb0.this.f.k;
            if (!(mTicket2 == null || mTicket2.getMTicketConfiguration() == null || (m0 = vn.m0(mTicket2.getMTicketConfiguration().getId())) == null)) {
                LastRideInfo lastRideInfo = new LastRideInfo();
                lastRideInfo.setBookingId(mTicket2.getMTicketId());
                lastRideInfo.setActivationTimeStamp(ui1.Q());
                lastRideInfo.setActivationDuration(m0.getProductActiveDuration());
                lastRideInfo.setProductType(m0.getProductType());
                t1Var.s().a(lastRideInfo);
            }
            if (!ui1.B0() || nb0.this.f.k.getTone() == null) {
                ut.a aVar = ut.f3552a;
                String f2 = t1Var.t().f("visualValidationCityList");
                String D = hj1.D(t1Var);
                if (f2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(f2);
                        int length = jSONArray.length();
                        if (length > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                String string = jSONArray.getString(i);
                                if (string != null && ea6.f(string, D, true)) {
                                    z = true;
                                    break;
                                } else if (i2 >= length) {
                                    break;
                                } else {
                                    i = i2;
                                }
                            }
                        }
                    } catch (JSONException e) {
                        b00 b00 = b00.f358a;
                        hj1.X0(e, b00.a());
                    }
                }
                if (z) {
                    ui1.m0(new ed1("mTicket activated for visual validation", Long.MIN_VALUE));
                    t1Var.n0().b(nb0.this.f.k, ui1.Q());
                }
                ActivateMTicketScreen activateMTicketScreen2 = nb0.this.f;
                ActiveMTicketScreen.i0(activateMTicketScreen2, activateMTicketScreen2.k, "activate mticket screen", activateMTicketScreen2.l);
            } else {
                ActivateMTicketScreen activateMTicketScreen3 = nb0.this.f;
                ValidationScreen.l0(activateMTicketScreen3, activateMTicketScreen3.k, "activate mticket screen", activateMTicketScreen3.l);
            }
            this.f.dismiss();
            ActivateMTicketScreen activateMTicketScreen4 = nb0.this.f;
            ed1 ed1 = new ed1("mticket activated", Long.MIN_VALUE);
            vn.a(ed1, activateMTicketScreen4.k);
            if (t1Var.B().h() != null) {
                LatLng h = t1Var.B().h();
                ed1.a("long", hj1.U(hj1.f0(ed1, "lat", hj1.U(new StringBuilder(), h.latitude, "")), h.longitude, ""));
            }
            ed1.a("userId", activateMTicketScreen4.k.getUserId());
            ed1.a("time", jh1.g(System.currentTimeMillis()));
            ed1.a("date", jh1.c(System.currentTimeMillis()));
            jz5.b().g(ed1);
            zz zzVar = new zz("mticket activated", new HashMap());
            zzVar.a("date", jh1.c(ui1.Q()));
            zzVar.a("time", jh1.g(ui1.Q()));
            ui1.l0(zzVar);
            nb0.this.f.finish();
        }
    }

    /* renamed from: nb0$b */
    /* compiled from: ActivateMTicketScreen */
    public class b implements View.OnClickListener {
        public final /* synthetic */ lm0 f;

        public b(nb0 nb0, lm0 lm0) {
            this.f = lm0;
        }

        public void onClick(View view) {
            this.f.dismiss();
        }
    }

    public nb0(ActivateMTicketScreen activateMTicketScreen) {
        this.f = activateMTicketScreen;
    }

    public void onClick(View view) {
        String str;
        String displayLanguage = Locale.getDefault().getDisplayLanguage();
        if (displayLanguage.toLowerCase().contains("en") || displayLanguage.toLowerCase().contains("as")) {
            String string = this.f.getString(R.string.dialog_message_confirm_mticket_activation);
            ActivateMTicketScreen activateMTicketScreen = this.f;
            str = String.format(string, vn.O(activateMTicketScreen, vn.y(activateMTicketScreen.k.getMTicketConfiguration().getId())));
        } else {
            str = this.f.getString(R.string.dialog_message_confirm_mticket_activation);
        }
        lm0 a2 = lm0.a(this.f.getFragmentManager(), null, str, this.f.getResources().getString(R.string.yes), this.f.getResources().getString(R.string.no));
        a aVar = new a(a2);
        TextView textView = a2.i;
        if (textView != null) {
            textView.setOnClickListener(aVar);
        } else {
            a2.q = aVar;
        }
        b bVar = new b(this, a2);
        TextView textView2 = a2.j;
        if (textView2 != null) {
            textView2.setOnClickListener(bVar);
        } else {
            a2.r = bVar;
        }
    }
}
