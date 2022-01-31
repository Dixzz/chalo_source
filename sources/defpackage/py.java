package defpackage;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: py  reason: default package */
/* compiled from: PassValidityExtensionLayoutBinding */
public final class py implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final LinearLayout f2868a;
    public final TextView b;
    public final LinearLayout c;

    public py(LinearLayout linearLayout, View view, TextView textView, LinearLayout linearLayout2) {
        this.f2868a = linearLayout;
        this.b = textView;
        this.c = linearLayout2;
    }

    public static py b(View view) {
        int i = R.id.pass_divider;
        View findViewById = view.findViewById(R.id.pass_divider);
        if (findViewById != null) {
            i = R.id.pass_extension_textview;
            TextView textView = (TextView) view.findViewById(R.id.pass_extension_textview);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new py(linearLayout, findViewById, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2868a;
    }
}
