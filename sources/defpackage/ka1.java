package defpackage;

import android.app.Activity;
import android.view.View;
import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import java.util.ArrayList;

/* renamed from: ka1  reason: default package */
/* compiled from: AlertInfoView */
public class ka1 implements View.OnClickListener {
    public final /* synthetic */ na1 f;

    public ka1(na1 na1) {
        this.f = na1;
    }

    public void onClick(View view) {
        Activity activity = this.f.l;
        ArrayList arrayList = new ArrayList();
        String C = hj1.C(xt.f3961a);
        if (C != null) {
            arrayList.add(C);
        }
        arrayList.add("commontag");
        Freshchat.showFAQs(activity, new FaqOptions().showFaqCategoriesAsGrid(false).filterByTags(arrayList, "Help and Support", FaqOptions.FilterType.CATEGORY));
        jz5.b().g(hj1.l("chat screen", Long.MIN_VALUE, "source", "alert info screen"));
    }
}
