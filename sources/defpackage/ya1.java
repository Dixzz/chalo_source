package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/* renamed from: ya1  reason: default package */
/* compiled from: MTicketDiscountedView */
public class ya1 extends LinearLayout {
    public final String f;
    public final double g;
    public final Context h;

    public ya1(Context context, String str, double d) {
        super(context);
        this.h = context;
        setOrientation(1);
        this.f = str;
        this.g = d;
        View inflate = LayoutInflater.from(context).inflate(R.layout.mticket_fare_detailed_breakdown, (ViewGroup) this, false);
        inflate.setVisibility(0);
        ((TextView) inflate.findViewById(R.id.tv_discount_amount)).setText(str);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_discount_fare);
        if (d >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            textView.setText(vn.M(d));
        } else if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            textView.setText(getContext().getString(R.string.txt_minus) + " " + vn.M(d));
        }
        addView(inflate);
    }
}
