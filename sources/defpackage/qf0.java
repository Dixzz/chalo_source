package defpackage;

import android.content.Intent;
import android.view.View;
import app.zophop.R;
import app.zophop.ui.activities.PickStopActivity;
import app.zophop.ui.activities.SubscriptionActivity;
import com.google.gson.Gson;
import java.util.Objects;

/* renamed from: qf0  reason: default package */
/* compiled from: SubscriptionActivity */
public class qf0 implements View.OnClickListener {
    public final /* synthetic */ SubscriptionActivity f;

    public qf0(SubscriptionActivity subscriptionActivity) {
        this.f = subscriptionActivity;
    }

    public void onClick(View view) {
        SubscriptionActivity subscriptionActivity = this.f;
        int i = SubscriptionActivity.y;
        Objects.requireNonNull(subscriptionActivity);
        Intent intent = new Intent(subscriptionActivity, PickStopActivity.class);
        intent.putExtra("extra_mode", subscriptionActivity.x.toString());
        if (subscriptionActivity.k != null) {
            intent.putExtra("stop_list_extra", new Gson().toJson(subscriptionActivity.k.getStopSequence()));
        } else {
            intent.putExtra("extra_route_id", subscriptionActivity.p.getRouteId());
        }
        intent.putExtra("extra:search_copy", subscriptionActivity.getString(R.string.type_stop_name));
        subscriptionActivity.startActivityForResult(intent, 1010);
    }
}
