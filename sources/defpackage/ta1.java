package defpackage;

import android.text.TextUtils;
import android.view.View;

/* renamed from: ta1  reason: default package */
/* compiled from: FavoriteTutorialView */
public class ta1 implements View.OnClickListener {
    public final /* synthetic */ String f;
    public final /* synthetic */ va1 g;

    public ta1(va1 va1, String str) {
        this.g = va1;
        this.f = str;
    }

    public void onClick(View view) {
        va1 va1 = this.g;
        String str = this.f;
        va1.b.post(new ua1(va1));
        ed1 ed1 = new ed1("Hint got it clicked", Long.MIN_VALUE);
        if (!TextUtils.isEmpty(va1.f)) {
            ed1.a("shown in", va1.f);
        }
        jz5.b().g(ed1);
        xt.f3961a.l().put(str, String.valueOf(true));
    }
}
