package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import app.zophop.utilities.external.loader_view.LoadingSpinnerView;

/* renamed from: ky  reason: default package */
/* compiled from: LoaderViewNewBinding */
public final class ky implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f2134a;
    public final LinearLayout b;
    public final ConstraintLayout c;
    public final LoadingSpinnerView d;
    public final TextView e;

    public ky(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2, ConstraintLayout constraintLayout2, LoadingSpinnerView loadingSpinnerView, TextView textView3, TextView textView4, TextView textView5) {
        this.f2134a = constraintLayout;
        this.b = linearLayout;
        this.c = constraintLayout2;
        this.d = loadingSpinnerView;
        this.e = textView5;
    }

    public static ky b(View view) {
        int i = R.id.alert_icon;
        ImageView imageView = (ImageView) view.findViewById(R.id.alert_icon);
        if (imageView != null) {
            i = R.id.connection_error_layout;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.connection_error_layout);
            if (linearLayout != null) {
                i = R.id.connection_error_textview;
                TextView textView = (TextView) view.findViewById(R.id.connection_error_textview);
                if (textView != null) {
                    i = R.id.empty_view_text;
                    TextView textView2 = (TextView) view.findViewById(R.id.empty_view_text);
                    if (textView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.loading_spinner;
                        LoadingSpinnerView loadingSpinnerView = (LoadingSpinnerView) view.findViewById(R.id.loading_spinner);
                        if (loadingSpinnerView != null) {
                            i = R.id.miscellaneous_text;
                            TextView textView3 = (TextView) view.findViewById(R.id.miscellaneous_text);
                            if (textView3 != null) {
                                i = R.id.miscellaneous_text2;
                                TextView textView4 = (TextView) view.findViewById(R.id.miscellaneous_text2);
                                if (textView4 != null) {
                                    i = R.id.retry;
                                    TextView textView5 = (TextView) view.findViewById(R.id.retry);
                                    if (textView5 != null) {
                                        return new ky(constraintLayout, imageView, linearLayout, textView, textView2, constraintLayout, loadingSpinnerView, textView3, textView4, textView5);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // defpackage.qo
    public View a() {
        return this.f2134a;
    }
}
