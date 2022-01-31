package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.zophop.R;

/* renamed from: hm0  reason: default package */
/* compiled from: ChaloConfirmationDialog.kt */
public class hm0 extends im0<ww> {
    public static final a o = new a(null);
    public String h;
    public String i;
    public String j;
    public String k;
    public int l;
    public View.OnClickListener m;
    public View.OnClickListener n;

    /* renamed from: hm0$a */
    /* compiled from: ChaloConfirmationDialog.kt */
    public static final class a {
        public a(j86 j86) {
        }
    }

    public hm0() {
        super(null);
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.im0
    public ww d(LayoutInflater layoutInflater) {
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.confirmation_dialog, (ViewGroup) null, false);
        int i2 = R.id.confirmation_dialog;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.confirmation_dialog);
        if (linearLayout != null) {
            i2 = R.id.confirmation_dialog_drawable;
            ImageView imageView = (ImageView) inflate.findViewById(R.id.confirmation_dialog_drawable);
            if (imageView != null) {
                i2 = R.id.message;
                TextView textView = (TextView) inflate.findViewById(R.id.message);
                if (textView != null) {
                    i2 = R.id.negative;
                    TextView textView2 = (TextView) inflate.findViewById(R.id.negative);
                    if (textView2 != null) {
                        i2 = R.id.positive;
                        TextView textView3 = (TextView) inflate.findViewById(R.id.positive);
                        if (textView3 != null) {
                            i2 = R.id.title;
                            TextView textView4 = (TextView) inflate.findViewById(R.id.title);
                            if (textView4 != null) {
                                ww wwVar = new ww((LinearLayout) inflate, linearLayout, imageView, textView, textView2, textView3, textView4);
                                n86.d(wwVar, "inflate(inflater)");
                                return wwVar;
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    public void e(Bundle bundle) {
        String str;
        String str2;
        int i2;
        String str3 = null;
        String string = bundle == null ? null : bundle.getString("extra:title_copy");
        if (string == null) {
            string = new String();
        }
        this.k = string;
        if (bundle == null) {
            str = null;
        } else {
            str = bundle.getString("extra:postive_action_copy");
        }
        if (str == null) {
            str = new String();
        }
        this.i = str;
        if (bundle == null) {
            str2 = null;
        } else {
            str2 = bundle.getString("extra:negative_action_copy");
        }
        if (str2 == null) {
            str2 = new String();
        }
        this.h = str2;
        if (bundle != null) {
            str3 = bundle.getString("extra:message_copy");
        }
        if (str3 == null) {
            str3 = new String();
        }
        this.j = str3;
        if (bundle == null) {
            i2 = 0;
        } else {
            i2 = bundle.getInt("extra:drawable_resource_id");
        }
        this.l = i2;
    }

    public void f() {
        T t = this.g;
        n86.c(t);
        TextView textView = ((ww) t).c;
        String str = this.j;
        if (str != null) {
            textView.setText(str);
        } else {
            n86.l("_messageCopy");
            throw null;
        }
    }

    public void g() {
        T t = this.g;
        n86.c(t);
        TextView textView = ((ww) t).d;
        String str = this.h;
        if (str != null) {
            textView.setText(str);
            String str2 = this.h;
            if (str2 != null) {
                if (str2.length() > 0) {
                    T t2 = this.g;
                    n86.c(t2);
                    ((ww) t2).d.setVisibility(0);
                    return;
                }
                return;
            }
            n86.l("_negativeCopy");
            throw null;
        }
        n86.l("_negativeCopy");
        throw null;
    }

    public void h() {
        T t = this.g;
        n86.c(t);
        TextView textView = ((ww) t).e;
        String str = this.i;
        if (str != null) {
            textView.setText(str);
        } else {
            n86.l("_positiveCopy");
            throw null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        e(getArguments());
        if (this.m != null) {
            T t = this.g;
            n86.c(t);
            ((ww) t).e.setOnClickListener(this.m);
        }
        if (this.n != null) {
            T t2 = this.g;
            n86.c(t2);
            ((ww) t2).d.setOnClickListener(this.n);
        }
        String str = this.k;
        if (str != null) {
            if (str.length() > 0) {
                T t3 = this.g;
                n86.c(t3);
                TextView textView = ((ww) t3).f;
                String str2 = this.k;
                if (str2 != null) {
                    textView.setText(str2);
                    T t4 = this.g;
                    n86.c(t4);
                    ((ww) t4).f.setVisibility(0);
                } else {
                    n86.l("_titleCopy");
                    throw null;
                }
            } else {
                T t5 = this.g;
                n86.c(t5);
                ((ww) t5).c.setAlpha(0.87f);
                T t6 = this.g;
                n86.c(t6);
                ((ww) t6).f.setVisibility(8);
            }
            h();
            g();
            f();
            if (this.l != 0) {
                T t7 = this.g;
                n86.c(t7);
                ((ww) t7).b.setVisibility(0);
                ml1<zq1> k2 = gl1.g(c()).k();
                k2.g(Integer.valueOf(this.l));
                T t8 = this.g;
                n86.c(t8);
                k2.e(((ww) t8).b);
                return;
            }
            T t9 = this.g;
            n86.c(t9);
            ((ww) t9).b.setVisibility(8);
            return;
        }
        n86.l("_titleCopy");
        throw null;
    }

    public hm0(String str) {
        super(str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public hm0(String str, int i2) {
        super(null);
        int i3 = i2 & 1;
    }
}
