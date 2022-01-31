package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import app.zophop.R;
import app.zophop.ui.views.OrderedTextList;
import java.util.List;

/* renamed from: on0  reason: default package */
/* compiled from: TnCDialog.kt */
public final class on0 extends ue {
    public static final on0 g = null;
    public static List<String> h = b66.f;
    public a f;

    /* renamed from: on0$a */
    /* compiled from: TnCDialog.kt */
    public interface a {
        void a();

        void b();
    }

    public static final void d(FragmentManager fragmentManager, List<String> list, a aVar) {
        n86.e(list, "lTermsAndConditionsList");
        n86.e(aVar, "lTnCAcceptedClickListener");
        on0 on0 = new on0();
        h = list;
        on0.f = aVar;
        if (fragmentManager != null) {
            on0.show(fragmentManager, "tncDialog");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n86.e(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.terms_dialog, (ViewGroup) null, false);
        TextView textView = (TextView) inflate.findViewById(R.id.accept_btn);
        TextView textView2 = (TextView) inflate.findViewById(R.id.cancel_btn);
        View findViewById = inflate.findViewById(R.id.list);
        n86.d(findViewById, "lView.findViewById(R.id.list)");
        OrderedTextList orderedTextList = (OrderedTextList) findViewById;
        orderedTextList.setShowBracketAfterNumber(true);
        if (true ^ h.isEmpty()) {
            orderedTextList.setData(h);
        } else if (ui1.c0(xt.f3961a.k().d())) {
            orderedTextList.setData(R.array.scan_pay_instructions_arr);
        } else {
            orderedTextList.setData(R.array.gen_instructions_arr);
        }
        textView2.setOnClickListener(new em0(this));
        textView.setOnClickListener(new fm0(this));
        return inflate;
    }
}
