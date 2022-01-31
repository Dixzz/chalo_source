package defpackage;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import app.zophop.R;
import app.zophop.models.mTicketing.ProductConfiguration;
import app.zophop.ui.views.OrderedTextList;
import java.util.List;

/* renamed from: mn0  reason: default package */
/* compiled from: TermsAndConditionsDialog */
public class mn0 extends DialogFragment {
    public static final String f = mn0.class.getName();
    public static String g;

    /* renamed from: mn0$a */
    /* compiled from: TermsAndConditionsDialog */
    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            mn0.this.dismiss();
            jz5.b().g(new ed1("terms cancel", Long.MIN_VALUE));
        }
    }

    /* renamed from: mn0$b */
    /* compiled from: TermsAndConditionsDialog */
    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            mn0.this.dismiss();
            jz5.b().g(new ed1("terms accept", Long.MIN_VALUE));
            if (mn0.this.getActivity() instanceof c) {
                ((c) mn0.this.getActivity()).a0();
            }
        }
    }

    /* renamed from: mn0$c */
    /* compiled from: TermsAndConditionsDialog */
    public interface c {
        void a0();
    }

    public static void a(FragmentManager fragmentManager, String str) {
        g = str;
        new mn0().show(fragmentManager, f);
        jz5.b().g(new ed1("terms and conditions open", Long.MIN_VALUE));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.terms_dialog, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.accept_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.cancel_btn);
        OrderedTextList orderedTextList = (OrderedTextList) inflate.findViewById(R.id.list);
        orderedTextList.setShowBracketAfterNumber(true);
        ProductConfiguration m0 = vn.m0(g);
        List<String> productTerms = m0 != null ? m0.getProductTerms() : null;
        if (productTerms != null && productTerms.size() > 0) {
            orderedTextList.setData(productTerms);
        } else if (ui1.c0(xt.f3961a.k().d())) {
            orderedTextList.setData(R.array.scan_pay_instructions_arr);
        } else {
            orderedTextList.setData(R.array.gen_instructions_arr);
        }
        textView2.setOnClickListener(new a());
        textView.setOnClickListener(new b());
        return inflate;
    }
}
