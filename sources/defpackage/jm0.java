package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;

/* renamed from: jm0  reason: default package */
/* compiled from: ChaloRecentProductErrorDialog.kt */
public final class jm0 extends im0<yy> {
    public final a h;
    public final String i;
    public final String j;
    public final boolean k;

    /* renamed from: jm0$a */
    /* compiled from: ChaloRecentProductErrorDialog.kt */
    public interface a {
        void a();

        void b();
    }

    public jm0(a aVar, String str, String str2, String str3, boolean z) {
        super(str);
        this.h = aVar;
        this.i = str2;
        this.j = str3;
        this.k = z;
    }

    public static final void e(FragmentManager fragmentManager, a aVar, String str, String str2, String str3, boolean z) {
        jm0 jm0 = new jm0(aVar, str, str2, str3, z);
        if (fragmentManager != null) {
            jm0.show(fragmentManager, (String) null);
        }
        jm0.setCancelable(false);
    }

    /* Return type fixed from 'qo' to match base method */
    @Override // defpackage.im0
    public yy d(LayoutInflater layoutInflater) {
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.recent_product_error_dialog, (ViewGroup) null, false);
        int i2 = R.id.dialog_title;
        TextView textView = (TextView) inflate.findViewById(R.id.dialog_title);
        if (textView != null) {
            i2 = R.id.dismiss_button;
            TextView textView2 = (TextView) inflate.findViewById(R.id.dismiss_button);
            if (textView2 != null) {
                i2 = R.id.error_description;
                TextView textView3 = (TextView) inflate.findViewById(R.id.error_description);
                if (textView3 != null) {
                    i2 = R.id.okay_button;
                    TextView textView4 = (TextView) inflate.findViewById(R.id.okay_button);
                    if (textView4 != null) {
                        i2 = R.id.view_container;
                        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.view_container);
                        if (linearLayout != null) {
                            yy yyVar = new yy((LinearLayout) inflate, textView, textView2, textView3, textView4, linearLayout);
                            n86.d(yyVar, "inflate(inflater)");
                            return yyVar;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i2)));
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n86.e(view, "view");
        super.onViewCreated(view, bundle);
        if (!TextUtils.isEmpty(this.i)) {
            T t = this.g;
            n86.c(t);
            ((yy) t).d.setText(this.i);
        }
        if (!TextUtils.isEmpty(this.j)) {
            T t2 = this.g;
            n86.c(t2);
            ((yy) t2).b.setText(this.j);
        }
        T t3 = this.g;
        n86.c(t3);
        TextView textView = ((yy) t3).c;
        n86.d(textView, "viewBinding.dismissButton");
        textView.setVisibility(this.k ? 0 : 8);
        T t4 = this.g;
        n86.c(t4);
        ((yy) t4).e.setOnClickListener(new zl0(this));
        T t5 = this.g;
        n86.c(t5);
        ((yy) t5).c.setOnClickListener(new yl0(this));
        a aVar = this.h;
        if (aVar != null) {
            aVar.a();
        }
    }
}
