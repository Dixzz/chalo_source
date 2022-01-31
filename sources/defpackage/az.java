package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: az  reason: default package */
/* compiled from: RideDetailsBinding */
public final class az implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f352a;
    public final TextView b;
    public final TextView c;

    public az(LinearLayout linearLayout, TextView textView, TextView textView2) {
        this.f352a = linearLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static az b(View view) {
        int i = R.id.trip_count;
        TextView textView = (TextView) view.findViewById(R.id.trip_count);
        if (textView != null) {
            i = R.id.trip_heading;
            TextView textView2 = (TextView) view.findViewById(R.id.trip_heading);
            if (textView2 != null) {
                return new az((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f352a;
    }
}
