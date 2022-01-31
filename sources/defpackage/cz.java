package defpackage;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import app.zophop.R;
import com.google.android.material.textview.MaterialTextView;

/* renamed from: cz  reason: default package */
/* compiled from: RouteFromToLayoutBinding */
public final class cz implements qo {

    /* renamed from: a  reason: collision with root package name */
    public final ConstraintLayout f768a;
    public final MaterialTextView b;
    public final TextView c;
    public final TextView d;

    public cz(ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout2, ImageView imageView3, MaterialTextView materialTextView, View view, MaterialTextView materialTextView2, TextView textView, TextView textView2) {
        this.f768a = constraintLayout;
        this.b = materialTextView;
        this.c = textView;
        this.d = textView2;
    }

    public static cz b(View view) {
        int i = R.id.iv_circle_end;
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_circle_end);
        if (imageView != null) {
            i = R.id.iv_circle_start;
            ImageView imageView2 = (ImageView) view.findViewById(R.id.iv_circle_start);
            if (imageView2 != null) {
                i = R.id.mticket_constraintlayout;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.mticket_constraintlayout);
                if (constraintLayout != null) {
                    i = R.id.route_mode_icon;
                    ImageView imageView3 = (ImageView) view.findViewById(R.id.route_mode_icon);
                    if (imageView3 != null) {
                        i = R.id.route_name;
                        MaterialTextView materialTextView = (MaterialTextView) view.findViewById(R.id.route_name);
                        if (materialTextView != null) {
                            i = R.id.start_end_separator;
                            View findViewById = view.findViewById(R.id.start_end_separator);
                            if (findViewById != null) {
                                i = R.id.title;
                                MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(R.id.title);
                                if (materialTextView2 != null) {
                                    i = R.id.tv_end_stop;
                                    TextView textView = (TextView) view.findViewById(R.id.tv_end_stop);
                                    if (textView != null) {
                                        i = R.id.tv_start_stop;
                                        TextView textView2 = (TextView) view.findViewById(R.id.tv_start_stop);
                                        if (textView2 != null) {
                                            return new cz((ConstraintLayout) view, imageView, imageView2, constraintLayout, imageView3, materialTextView, findViewById, materialTextView2, textView, textView2);
                                        }
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
        return this.f768a;
    }
}
