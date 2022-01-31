package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import app.zophop.ui.activities.WebViewActivity;

/* renamed from: li0  reason: default package */
/* compiled from: lambda */
public final /* synthetic */ class li0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ ProductPromotionsObject g;
    public final /* synthetic */ rj0 h;

    public /* synthetic */ li0(int i, ProductPromotionsObject productPromotionsObject, rj0 rj0) {
        this.f = i;
        this.g = productPromotionsObject;
        this.h = rj0;
    }

    public final void onClick(View view) {
        int i = this.f;
        ProductPromotionsObject productPromotionsObject = this.g;
        rj0 rj0 = this.h;
        n86.e(rj0, "this$0");
        ed1 ed1 = new ed1("homescreen dynamic card clicked", Long.MIN_VALUE);
        hj1.u0(i, ed1, "itemPos", ed1);
        try {
            String headerText = productPromotionsObject.getHeaderText();
            if (headerText == null) {
                headerText = "Info";
            }
            String action = productPromotionsObject.getAction();
            n86.d(action, "lPromotionsObject.action");
            if (ea6.c(action, "chalo.com", false, 2)) {
                Context context = rj0.c;
                context.startActivity(WebViewActivity.i0(context, productPromotionsObject.getAction(), headerText, false, false));
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(productPromotionsObject.getAction()));
            intent.putExtra("header", headerText);
            rj0.c.startActivity(intent);
        } catch (Exception e) {
            b00 b00 = b00.f358a;
            b00.a().b(e);
        }
    }
}
