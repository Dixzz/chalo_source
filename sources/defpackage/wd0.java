package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import app.zophop.models.RouteInfo;
import app.zophop.models.mTicketing.MPass;
import app.zophop.products.CategorySelectionActivity;
import app.zophop.ui.activities.ConfirmMagicPassActivity;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

/* renamed from: wd0  reason: default package */
/* compiled from: ConfirmMagicPassActivity */
public class wd0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMagicPassActivity f;

    public wd0(ConfirmMagicPassActivity confirmMagicPassActivity) {
        this.f = confirmMagicPassActivity;
    }

    public void onClick(View view) {
        Context context = view.getContext();
        MPass mPass = ConfirmMagicPassActivity.v;
        ConfirmMagicPassActivity confirmMagicPassActivity = this.f;
        RouteInfo routeInfo = confirmMagicPassActivity.p;
        String str = confirmMagicPassActivity.q;
        List<String> list = confirmMagicPassActivity.r;
        int i = CategorySelectionActivity.d0;
        Intent N0 = hj1.N0(context, CategorySelectionActivity.class, "src", "pass details edit");
        if (routeInfo != null) {
            N0.putExtra("routeInfo", new Gson().toJson(routeInfo));
        }
        if (mPass != null) {
            N0.putExtra("edit_pass_info", new Gson().toJson(mPass));
        }
        N0.putExtra("productId", str);
        N0.putStringArrayListExtra("productIds", (ArrayList) list);
        context.startActivity(N0);
    }
}
