package defpackage;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import app.zophop.ui.fragments.cardRecharge.CardDetailsFragment;
import java.util.List;

/* renamed from: tx0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class tx0 implements ph {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CardDetailsFragment f3416a;

    public /* synthetic */ tx0(CardDetailsFragment cardDetailsFragment) {
        this.f3416a = cardDetailsFragment;
    }

    @Override // defpackage.ph
    public final void a(Object obj) {
        CardDetailsFragment cardDetailsFragment = this.f3416a;
        List list = (List) obj;
        int i = CardDetailsFragment.l;
        n86.e(cardDetailsFragment, "this$0");
        if (list == null || list.isEmpty()) {
            T t = cardDetailsFragment.f;
            n86.c(t);
            LinearLayout linearLayout = ((hx) t).j;
            n86.d(linearLayout, "viewBinding.recentPaymentsHeaderLayout");
            linearLayout.setVisibility(8);
            T t2 = cardDetailsFragment.f;
            n86.c(t2);
            RecyclerView recyclerView = ((hx) t2).i;
            n86.d(recyclerView, "viewBinding.recentCardPaymentsRecyclerView");
            recyclerView.setVisibility(8);
            T t3 = cardDetailsFragment.f;
            n86.c(t3);
            TextView textView = ((hx) t3).e;
            n86.d(textView, "viewBinding.dummyViewBottom");
            textView.setVisibility(8);
            return;
        }
        n86.d(list, "lRecentTransactionsList");
        if (list.isEmpty()) {
            T t4 = cardDetailsFragment.f;
            n86.c(t4);
            LinearLayout linearLayout2 = ((hx) t4).j;
            n86.d(linearLayout2, "viewBinding.recentPaymentsHeaderLayout");
            linearLayout2.setVisibility(8);
            T t5 = cardDetailsFragment.f;
            n86.c(t5);
            RecyclerView recyclerView2 = ((hx) t5).i;
            n86.d(recyclerView2, "viewBinding.recentCardPaymentsRecyclerView");
            recyclerView2.setVisibility(8);
            T t6 = cardDetailsFragment.f;
            n86.c(t6);
            TextView textView2 = ((hx) t6).e;
            n86.d(textView2, "viewBinding.dummyViewBottom");
            textView2.setVisibility(8);
            return;
        }
        T t7 = cardDetailsFragment.f;
        n86.c(t7);
        LinearLayout linearLayout3 = ((hx) t7).j;
        n86.d(linearLayout3, "viewBinding.recentPaymentsHeaderLayout");
        linearLayout3.setVisibility(0);
        T t8 = cardDetailsFragment.f;
        n86.c(t8);
        RecyclerView recyclerView3 = ((hx) t8).i;
        n86.d(recyclerView3, "viewBinding.recentCardPaymentsRecyclerView");
        recyclerView3.setVisibility(0);
        T t9 = cardDetailsFragment.f;
        n86.c(t9);
        TextView textView3 = ((hx) t9).e;
        n86.d(textView3, "viewBinding.dummyViewBottom");
        textView3.setVisibility(0);
        ((yu) cardDetailsFragment.j.getValue()).f2701a.b(list, null);
    }
}
