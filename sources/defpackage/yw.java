package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: yw  reason: default package */
/* compiled from: ConnectionErrorLayoutBinding */
public final class yw implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f4090a;
    public final TextView b;
    public final TextView c;

    public yw(LinearLayout linearLayout, TextView textView, TextView textView2, LinearLayout linearLayout2, TextView textView3, ImageView imageView) {
        this.f4090a = linearLayout;
        this.b = textView;
        this.c = textView2;
    }

    public static yw b(View view) {
        int i = R.id.btn_retry;
        TextView textView = (TextView) view.findViewById(R.id.btn_retry);
        if (textView != null) {
            i = R.id.connection_error_desc;
            TextView textView2 = (TextView) view.findViewById(R.id.connection_error_desc);
            if (textView2 != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i = R.id.connection_error_title;
                TextView textView3 = (TextView) view.findViewById(R.id.connection_error_title);
                if (textView3 != null) {
                    i = R.id.ic_connection_error;
                    ImageView imageView = (ImageView) view.findViewById(R.id.ic_connection_error);
                    if (imageView != null) {
                        return new yw(linearLayout, textView, textView2, linearLayout, textView3, imageView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f4090a;
    }
}
