package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.Stop;
import java.util.Objects;

/* renamed from: oc1  reason: default package */
/* compiled from: EtaListCard */
public class oc1 extends LinearLayout {
    public final Context f;
    public LinearLayout g;
    public LinearLayout h;
    public ci1<Boolean> i;

    public oc1(Context context) {
        super(context);
        this.f = context;
        LayoutInflater.from(context).inflate(R.layout.route_eta_list_card, (ViewGroup) this, true);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.eta_card_root);
        this.g = linearLayout;
        this.h = (LinearLayout) linearLayout.findViewById(R.id.route_availability_level_banner);
    }

    public static void a(oc1 oc1, String str, boolean z, boolean z2) {
        Objects.requireNonNull(oc1);
        ed1 ed1 = new ed1("availability route banner clicked", Long.MIN_VALUE);
        ed1.a("availability priority", str);
        if (z2) {
            ed1.a("button clicked", Boolean.valueOf(z));
        }
        hj1.d(z2, ed1, "cta visibility", ed1);
    }

    public RelativeLayout getDisruptionView() {
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            return (RelativeLayout) linearLayout.findViewById(R.id.disruptionBanner);
        }
        return null;
    }

    public View getRootView() {
        return this.g;
    }

    public TextView getSeatView() {
        LinearLayout linearLayout = this.g;
        if (linearLayout != null) {
            return (TextView) linearLayout.findViewById(R.id.seat_availaility_view);
        }
        return null;
    }

    public Stop getStop() {
        throw null;
    }

    public void setPanelExpanded(boolean z) {
    }
}
