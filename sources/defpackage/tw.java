package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: tw  reason: default package */
/* compiled from: CheckInCardEntryBinding */
public final class tw implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final RelativeLayout f3411a;
    public final ImageView b;
    public final RelativeLayout c;
    public final TextView d;
    public final TextView e;
    public final TextView f;

    public tw(RelativeLayout relativeLayout, ImageView imageView, RelativeLayout relativeLayout2, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3) {
        this.f3411a = relativeLayout;
        this.b = imageView;
        this.c = relativeLayout2;
        this.d = textView;
        this.e = textView2;
        this.f = textView3;
    }

    public static tw b(View view) {
        int i = R.id.audio_toggle;
        ImageView imageView = (ImageView) view.findViewById(R.id.audio_toggle);
        if (imageView != null) {
            RelativeLayout relativeLayout = (RelativeLayout) view;
            i = R.id.desination_eta;
            TextView textView = (TextView) view.findViewById(R.id.desination_eta);
            if (textView != null) {
                i = R.id.info_container;
                LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.info_container);
                if (linearLayout != null) {
                    i = R.id.sub_title;
                    TextView textView2 = (TextView) view.findViewById(R.id.sub_title);
                    if (textView2 != null) {
                        i = R.id.title;
                        TextView textView3 = (TextView) view.findViewById(R.id.title);
                        if (textView3 != null) {
                            return new tw(relativeLayout, imageView, relativeLayout, textView, linearLayout, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f3411a;
    }
}
