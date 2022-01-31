package defpackage;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;

/* renamed from: du0  reason: default package */
/* compiled from: ConfirmationBottomSheet.kt */
public class du0 extends qn0 {
    public TextView h;
    public TextView i;
    public TextView j;
    public TextView k;
    public String l;
    public String m;
    public String n;
    public String o;
    public int p;
    public ImageView q;
    public int r = 1;
    public int s;
    public String t;
    public a u;
    public View.OnClickListener v;
    public View.OnClickListener w;

    /* renamed from: du0$a */
    /* compiled from: ConfirmationBottomSheet.kt */
    public interface a {
        void a();
    }

    public static final du0 f(FragmentManager fragmentManager, String str, String str2, String str3, String str4, int i2, int i3, String str5) {
        n86.e(fragmentManager, "manager");
        du0 du0 = new du0();
        new qn0().g = str5;
        Bundle bundle = new Bundle();
        if (str != null) {
            bundle.putString("extra:title_copy", str);
        }
        if (str2 != null) {
            bundle.putString("extra:message_copy", str2);
        }
        if (str3 != null) {
            bundle.putString("extra:positive_action_copy", str3);
        }
        if (str4 != null) {
            bundle.putString("extra:negative_action_copy", str4);
        }
        bundle.putInt("extra:alignment_id", i2);
        bundle.putInt("extra:drawable_id", i3);
        du0.setArguments(bundle);
        du0.show(fragmentManager, "confirmation_bottomsheet");
        return du0;
    }

    public final void d(View.OnClickListener onClickListener) {
        TextView textView = this.k;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        } else {
            this.w = onClickListener;
        }
    }

    public final void e(View.OnClickListener onClickListener) {
        TextView textView = this.j;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        } else {
            this.v = onClickListener;
        }
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.AppBottomSheetDialogTheme);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.confirmation_bottomsheet, (ViewGroup) null, false);
        Bundle requireArguments = requireArguments();
        n86.d(requireArguments, "requireArguments()");
        n86.e(requireArguments, "arguments");
        this.l = requireArguments.getString("extra:title_copy");
        this.n = requireArguments.getString("extra:positive_action_copy");
        this.o = requireArguments.getString("extra:negative_action_copy");
        this.m = requireArguments.getString("extra:message_copy");
        this.p = requireArguments.getInt("extra:drawable_resource_id");
        this.r = requireArguments.getInt("extra:alignment_id");
        this.s = requireArguments.getInt("extra:drawable_id");
        this.t = requireArguments.getString("extra:image_url");
        n86.d(inflate, "view");
        this.h = (TextView) inflate.findViewById(R.id.confirmation_title);
        this.i = (TextView) inflate.findViewById(R.id.confirmation_message);
        this.j = (TextView) inflate.findViewById(R.id.confirmation_positive);
        this.k = (TextView) inflate.findViewById(R.id.confirmation_negative);
        View.OnClickListener onClickListener = this.v;
        if (!(onClickListener == null || (textView3 = this.j) == null)) {
            textView3.setOnClickListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = this.w;
        if (!(onClickListener2 == null || (textView2 = this.k) == null)) {
            textView2.setOnClickListener(onClickListener2);
        }
        this.q = (ImageView) inflate.findViewById(R.id.confirmation_bottomsheet_drawable);
        String str = this.l;
        if (str != null) {
            TextView textView4 = this.h;
            if (textView4 != null) {
                textView4.setText(str);
            }
            TextView textView5 = this.h;
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
        }
        String str2 = this.m;
        if (str2 != null) {
            TextView textView6 = this.i;
            if (textView6 != null) {
                textView6.setText(str2);
            }
            TextView textView7 = this.i;
            if (textView7 != null) {
                textView7.setVisibility(0);
            }
        }
        if (this.r == 0) {
            TextView textView8 = this.h;
            if (textView8 != null) {
                textView8.setGravity(3);
            }
            TextView textView9 = this.i;
            if (textView9 != null) {
                textView9.setGravity(3);
            }
        } else {
            TextView textView10 = this.h;
            if (textView10 != null) {
                textView10.setGravity(1);
            }
            TextView textView11 = this.i;
            if (textView11 != null) {
                textView11.setGravity(1);
            }
        }
        TextView textView12 = this.j;
        if (textView12 != null) {
            textView12.setText(this.n);
        }
        TextView textView13 = this.k;
        if (textView13 != null) {
            textView13.setText(this.o);
        }
        if (!(this.o == null || (textView = this.k) == null)) {
            textView.setVisibility(0);
        }
        if (!TextUtils.isEmpty(this.t)) {
            ImageView imageView = this.q;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            ml1<Drawable> p2 = gl1.g(c()).p(this.t);
            p2.a(new rs1().j(R.drawable.nearby_click));
            p2.e(this.q);
        } else if (this.s != 0) {
            ImageView imageView2 = this.q;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
            ImageView imageView3 = this.q;
            if (imageView3 != null) {
                imageView3.setImageResource(this.s);
            }
        } else if (this.p != 0) {
            ImageView imageView4 = this.q;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
            ml1<zq1> k2 = gl1.g(c()).k();
            k2.g(Integer.valueOf(this.p));
            k2.e(this.q);
        } else {
            ImageView imageView5 = this.q;
            if (imageView5 != null) {
                imageView5.setVisibility(8);
            }
        }
        a aVar = this.u;
        if (aVar != null) {
            aVar.a();
        }
        return inflate;
    }
}
