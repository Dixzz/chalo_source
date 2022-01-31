package defpackage;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import app.zophop.R;
import app.zophop.models.Stop;
import app.zophop.ui.activities.MTicketTripInfoActivity;
import app.zophop.ui.activities.PickStopActivity;
import com.google.gson.Gson;
import java.util.List;
import java.util.Objects;

/* renamed from: pe0  reason: default package */
/* compiled from: MTicketTripInfoActivity */
public class pe0 implements View.OnClickListener {
    public final /* synthetic */ int f;
    public final /* synthetic */ MTicketTripInfoActivity g;

    public pe0(MTicketTripInfoActivity mTicketTripInfoActivity, int i) {
        this.g = mTicketTripInfoActivity;
        this.f = i;
    }

    public void onClick(View view) {
        Stop stop;
        MTicketTripInfoActivity mTicketTripInfoActivity = this.g;
        if (mTicketTripInfoActivity.n != null) {
            Intent intent = new Intent(this.g, PickStopActivity.class);
            MTicketTripInfoActivity mTicketTripInfoActivity2 = this.g;
            List<Stop> stopSequence = mTicketTripInfoActivity2.n.getStopSequence();
            int i = this.f;
            Objects.requireNonNull(mTicketTripInfoActivity2);
            if (i == 101) {
                Stop stop2 = mTicketTripInfoActivity2.q;
                if (stop2 != null) {
                    stopSequence = stopSequence.subList(0, stopSequence.indexOf(stop2));
                }
            } else if (i == 102 && (stop = mTicketTripInfoActivity2.p) != null) {
                stopSequence = stopSequence.subList(stopSequence.indexOf(stop) + 1, stopSequence.size());
            }
            intent.putExtra("stop_list_extra", new Gson().toJson(stopSequence));
            intent.putExtra("extra:search_copy", this.g.getString(R.string.type_station_name));
            intent.putExtra("extra_mode", this.g.r.toString());
            intent.putExtra("src", "mticket booking screen");
            this.g.startActivityForResult(intent, this.f);
            return;
        }
        mTicketTripInfoActivity._routeInfoLayout.findViewById(R.id.status).setVisibility(0);
        Toast.makeText(this.g, (int) R.string.mticket_toast_select_route, 0).show();
    }
}
