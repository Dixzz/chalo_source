package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.models.mTicketing.RouteStopsInfo;
import app.zophop.ui.activities.ConfirmMagicPassActivity;
import app.zophop.ui.activities.UserDetailsActivity;
import com.google.gson.Gson;
import java.util.ArrayList;

/* renamed from: vd0  reason: default package */
/* compiled from: ConfirmMagicPassActivity */
public class vd0 implements View.OnClickListener {
    public final /* synthetic */ ConfirmMagicPassActivity f;

    public vd0(ConfirmMagicPassActivity confirmMagicPassActivity) {
        this.f = confirmMagicPassActivity;
    }

    public void onClick(View view) {
        Intent intent = new Intent(this.f, UserDetailsActivity.class);
        if (this.f.p != null) {
            intent.putExtra("route_info_extra", new Gson().toJson(this.f.p));
            RouteStopsInfo routeStopsInfo = new RouteStopsInfo(this.f.p.getRouteId(), this.f.p.getRouteName(), null, this.f.p.getFirstStopName(), null, this.f.p.getLastStopName());
            routeStopsInfo.set_spf(this.f.p.get_updateSpecialFeaturesList());
            ConfirmMagicPassActivity.v.setRouteStopsInfo(routeStopsInfo);
        }
        intent.putExtra("productId", this.f.q);
        intent.putExtra("src", "pass validity edit");
        intent.putStringArrayListExtra("productIds", (ArrayList) this.f.r);
        intent.putExtra("magic_pass_info", ov.f(ConfirmMagicPassActivity.v));
        this.f.startActivity(intent);
    }
}
