package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.drawerlayout.widget.DrawerLayout;
import app.zophop.R;
import app.zophop.models.City;
import app.zophop.models.TransitMode;
import app.zophop.models.mTicketing.UserProfile;
import defpackage.xt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* renamed from: pj0  reason: default package */
/* compiled from: HomeDrawerAdapter */
public class pj0 extends BaseAdapter {
    public List<a> f = b();
    public DrawerLayout g;
    public final Context h;

    /* renamed from: pj0$a */
    /* compiled from: HomeDrawerAdapter */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final int f2811a;
        public final int b;
        public final qj0 c;

        public a(int i, int i2, qj0 qj0, kj0 kj0) {
            this.f2811a = i;
            this.b = i2;
            this.c = qj0;
        }
    }

    public pj0(Context context) {
        this.h = context;
    }

    public static void a(pj0 pj0, String str) {
        Objects.requireNonNull(pj0);
        ed1 ed1 = new ed1("home screen social media", Long.MIN_VALUE);
        ed1.a("socialMedia", str);
        jz5.b().g(ed1);
        DrawerLayout drawerLayout = pj0.g;
        if (drawerLayout != null) {
            drawerLayout.d(false);
        }
    }

    public final ArrayList<a> b() {
        int i;
        ArrayList<a> arrayList = new ArrayList<>();
        arrayList.add(new a(0, R.string.drawer_log_in_register, qj0.MY_PROFILE, null));
        xt.t1 t1Var = xt.f3961a;
        City d = t1Var.k().d();
        qj0 qj0 = qj0.FEATURE_OTHER;
        arrayList.add(new a(0, R.string.drawer_feature_other, qj0, null));
        TransitMode transitMode = TransitMode.bus;
        if ((ui1.b0(transitMode, d) || ui1.c0(d)) && t1Var.k().f() != null) {
            arrayList.add(new a(R.drawable.pass_history, R.string.your_tickets_and_passes, qj0.PASS_TICKET_HISTORY, null));
        }
        if (ui1.c0(d) && !ui1.b0(transitMode, d) && t1Var.k().f() != null && t1Var.t().b("shouldShowInNavBar")) {
            arrayList.add(new a(R.drawable.scan_and_pay_navigation, R.string.scan_pay_tag, qj0.SCAN_PAY, null));
        }
        if (ui1.a0(d) && t1Var.k().f() != null) {
            arrayList.add(new a(R.drawable.card_recharge_icon, R.string.card_recharges, qj0.CARD_RECHARGES, null));
        }
        boolean z = true;
        if (d.getModes().contains(transitMode) && d.getModes().size() > 1) {
            arrayList.add(new a(R.drawable.drawer_schedules, R.string.drawer_scheduler, qj0.SCHEDULER, null));
        }
        arrayList.add(new a(R.drawable.drawer_nearby, R.string.drawer_nearby_stops, qj0.NEARBY_STOPS, null));
        if (!ui1.e0()) {
            arrayList.add(new a(R.drawable.drawer_favorites, R.string.drawer_favorites, qj0.FAVORITES, null));
        }
        if (!(d.getLineMaps().size() == 0 && d.getBusMapUrl() == null)) {
            int i2 = (d.getModes().contains(TransitMode.train) || d.getModes().contains(TransitMode.metro)) ? R.string.drawer_train_map : R.string.busMapCopy;
            f20 t = t1Var.t();
            String f2 = t.f(d.getName().toLowerCase() + "MapCopy");
            if (f2.length() != 0) {
                i2 = this.h.getResources().getIdentifier(f2, "string", this.h.getPackageName());
            }
            arrayList.add(new a(R.drawable.line_map, i2, qj0.TRAIN_MAP, null));
        }
        if (c() && c()) {
            arrayList.add(new a(R.drawable.ride_history_navigation, R.string.cab_ride_history, qj0.CAB_HISTORY, null));
        }
        arrayList.add(new a(0, R.string.drawer_feature_other, qj0, null));
        int i3 = 0;
        for (re1 re1 : t1Var.F().e()) {
            if (!re1.k) {
                i3++;
            }
        }
        if (i3 > 0) {
            arrayList.add(new a(R.drawable.alerts_bubble, R.string.drawer_alert, qj0.ALERT, null));
        } else {
            arrayList.add(new a(R.drawable.drawer_alerts, R.string.drawer_alert, qj0.ALERT, null));
        }
        xt.t1 t1Var2 = xt.f3961a;
        if (t1Var2.t().b("showChatOptionsDrawer")) {
            arrayList.add(new a(R.drawable.chat_navigation, R.string.drawer_chat, qj0.CHAT, null));
        }
        arrayList.add(new a(R.drawable.change_city_navigation, R.string.drawer_change_city, qj0.CHANGE_CITY, null));
        arrayList.add(new a(R.drawable.language_navigation, R.string.drawer_change_language, qj0.CHANGE_LANG, null));
        f20 t2 = t1Var2.t();
        StringBuilder i0 = hj1.i0("partnerInfo");
        i0.append(t1Var2.k().d().getName().toLowerCase());
        if (!TextUtils.isEmpty(t2.f(i0.toString()))) {
            arrayList.add(new a(R.drawable.city_info, R.string.partners, qj0.PARTNERS, null));
        }
        arrayList.add(new a(R.drawable.drawer_sos, R.string.drawer_sos, qj0.SOS, null));
        PreferenceManager.getDefaultSharedPreferences(this.h).edit();
        arrayList.add(new a(0, R.string.social_media, qj0.FEATURE_SOCIAL_MEDIA, null));
        arrayList.add(new a(R.drawable.invite_navigation, R.string.drawer_invite, qj0.INVITE, null));
        arrayList.add(new a(0, R.string.follow_us, qj0.FOLLOW_US, null));
        arrayList.add(new a(0, 0, qj0.SOCIAL_MEDIA, null));
        Context context = this.h;
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            i = 0;
        }
        if (i >= xt.f3961a.k0().e()) {
            z = false;
        }
        if (z) {
            arrayList.add(new a(0, R.string.update_app, qj0.UPDATE, null));
        }
        arrayList.add(new a(0, R.string.drawer_feature_other, qj0.FEATURE_DIVIDER, null));
        arrayList.add(new a(0, R.string.terms_home_drawer, qj0.TERMS, null));
        return arrayList;
    }

    public final boolean c() {
        return ((ArrayList) xt.f3961a.f().a()).size() > 0;
    }

    public int getCount() {
        return this.f.size();
    }

    public Object getItem(int i) {
        return this.f.get(i).c;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater from = LayoutInflater.from(this.h);
        a aVar = this.f.get(i);
        int ordinal = aVar.c.ordinal();
        if (ordinal != 0) {
            if (!(ordinal == 1 || ordinal == 7 || ordinal == 11 || ordinal == 16)) {
                if (ordinal == 23) {
                    View inflate = from.inflate(R.layout.drawer_update, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.app_version)).append("7.6.4");
                    inflate.findViewById(R.id.update).setOnClickListener(new kj0(this));
                    return inflate;
                } else if (ordinal == 35) {
                    return from.inflate(R.layout.category_divider_layout, viewGroup, false);
                } else {
                    if (ordinal == 26) {
                        View inflate2 = from.inflate(R.layout.drawer_item_share, (ViewGroup) null);
                        inflate2.findViewById(R.id.share_facebook).setOnClickListener(new lj0(this));
                        inflate2.findViewById(R.id.share_twitter).setOnClickListener(new mj0(this));
                        inflate2.findViewById(R.id.share_instagram).setOnClickListener(new nj0(this));
                        return inflate2;
                    } else if (ordinal != 27) {
                        View inflate3 = from.inflate(R.layout.drawer_home_screen_item, (ViewGroup) null);
                        if (aVar.b != 0) {
                            ((TextView) inflate3.findViewById(R.id.drawer_title)).setText(this.h.getString(aVar.b));
                        }
                        ((ImageView) inflate3.findViewById(R.id.drawer_icon)).setImageResource(aVar.f2811a);
                        if (aVar.c.equals(qj0.TRAIN_MAP)) {
                            xt.t1 t1Var = xt.f3961a;
                            String B = hj1.B(t1Var);
                            f20 t = t1Var.t();
                            String f2 = t.f(B.toLowerCase() + "mapCustomCopy");
                            if (f2.length() != 0) {
                                ((TextView) inflate3.findViewById(R.id.drawer_title)).setText(f2);
                            }
                        } else if (aVar.c.equals(qj0.TERMS)) {
                            hj1.x0(inflate3, R.id.drawer_icon, 8, R.id.version, 0);
                            ((TextView) inflate3.findViewById(R.id.version)).setText("V 7.6.4");
                        } else if (aVar.c.equals(qj0.EMPTY)) {
                            hj1.x0(inflate3, R.id.drawer_icon, 8, R.id.version, 8);
                            ((TextView) inflate3.findViewById(R.id.drawer_title)).setText(" ");
                        } else if (aVar.c.equals(qj0.FOLLOW_US)) {
                            inflate3.findViewById(R.id.drawer_icon).setVisibility(8);
                            ((TextView) inflate3.findViewById(R.id.drawer_title)).setText(this.h.getString(aVar.b));
                            inflate3.setBackgroundColor(this.h.getResources().getColor(R.color.white));
                        } else {
                            inflate3.findViewById(R.id.drawer_icon).setVisibility(0);
                        }
                        if (((int) xt.f3961a.t().c("shouldShowNewIconForMTicketKolkata")) != 1 || !aVar.c.equals(qj0.MTICKET)) {
                            inflate3.findViewById(R.id.drawer_image).setVisibility(8);
                        } else {
                            inflate3.findViewById(R.id.drawer_image).setVisibility(0);
                        }
                        return inflate3;
                    }
                }
            }
            View inflate4 = from.inflate(R.layout.drawer_category_header, viewGroup, false);
            inflate4.setOnClickListener(new nh1(new oj0(this), 5));
            return inflate4;
        }
        View inflate5 = from.inflate(R.layout.drawer_user_info, (ViewGroup) null);
        TextView textView = (TextView) inflate5.findViewById(R.id.user_name);
        TextView textView2 = (TextView) inflate5.findViewById(R.id.user_email);
        ImageView imageView = (ImageView) inflate5.findViewById(R.id.profile_picture);
        xt.t1 t1Var2 = xt.f3961a;
        if (!t1Var2.L().f()) {
            textView2.setVisibility(0);
            if (ui1.b0(TransitMode.bus, t1Var2.k().d())) {
                textView2.setText(this.h.getResources().getString(R.string.drawer_signin_desc));
            } else {
                textView2.setVisibility(8);
            }
            textView.setText(this.h.getString(R.string.drawer_sign_in_register));
        } else if (t1Var2.L().e() == null) {
            textView2.setVisibility(0);
            textView2.setText(this.h.getResources().getString(R.string.drawer_signin_desc));
            textView.setText(t1Var2.L().p());
        } else {
            UserProfile e = t1Var2.L().e();
            if (e.getFirstName().length() > 0) {
                if (TextUtils.isEmpty(e.getFirstName())) {
                    textView.setText(t1Var2.L().p());
                } else {
                    textView.setText(e.getFirstName());
                }
                textView2.setVisibility(0);
                textView2.setText(this.h.getResources().getString(R.string.view_profile));
            } else {
                textView2.setText(this.h.getResources().getString(R.string.view_profile));
                textView.setText(t1Var2.L().p());
            }
            ml1<Drawable> p = gl1.f(this.h).p(e.getProfilePhoto());
            p.a(new rs1().j(R.drawable.nopic_user_drawer));
            p.e(imageView);
        }
        return inflate5;
    }

    public void notifyDataSetChanged() {
        this.f = b();
        super.notifyDataSetChanged();
    }
}
