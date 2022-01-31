package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.ui.activities.ActivePassScreen;
import app.zophop.ui.activities.BookingSummaryMagicPassActivity;

/* renamed from: jc0  reason: default package */
/* compiled from: ActivePassScreen */
public class jc0 implements View.OnClickListener {
    public final /* synthetic */ ActivePassScreen f;

    public jc0(ActivePassScreen activePassScreen) {
        this.f = activePassScreen;
    }

    public void onClick(View view) {
        jz5.b().g(new ed1("activation duration expired dialog view summary clicked", Long.MIN_VALUE));
        Intent intent = new Intent(this.f, BookingSummaryMagicPassActivity.class);
        intent.putExtra("magic_pass_info", ActivePassScreen.F);
        this.f.startActivity(intent);
        this.f.finish();
    }
}
