package app.zophop.ui.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.zophop.R;
import com.google.firebase.appindexing.Indexable;
import com.google.gson.Gson;
import zophop.models.Itinerary;

public class SchedulerDescriptionActivity extends au {
    public static final /* synthetic */ int m = 0;
    public Itinerary k;
    public int l;

    @Override // defpackage.tf1
    public void e(Bundle bundle) {
        this.k = (Itinerary) new Gson().fromJson(getIntent().getStringExtra("itineary_description"), Itinerary.class);
        this.l = getIntent().getIntExtra("time_details", -1);
        setContentView(R.layout.scheduler_description);
        setSupportActionBar((Toolbar) findViewById(R.id.tool_bar));
        getSupportActionBar().z("");
        getSupportActionBar().o(true);
        getSupportActionBar().p(true);
        View inflate = getLayoutInflater().inflate(R.layout.schedule_description_toolbar_view, (ViewGroup) null);
        getSupportActionBar().m(inflate);
        ((TextView) inflate.findViewById(R.id.total_time)).setText(jh1.k((long) (ii1.r(this.k) * Indexable.MAX_INDEXABLES_TO_BE_UPDATED_IN_ONE_CALL)));
        TextView textView = (TextView) inflate.findViewById(R.id.fare);
        int D = ui1.D(this.k.fares);
        if (this.k.inCompleteFare || D == 0) {
            textView.setVisibility(8);
        } else {
            textView.setText(ui1.H() + D);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.no_changes);
        if (this.k.legs.size() > 1) {
            textView2.setVisibility(0);
            if (this.k.legs.size() == 2) {
                StringBuilder i0 = hj1.i0("1 ");
                i0.append(getString(R.string.mode_change));
                textView2.setText(i0.toString());
            } else {
                textView2.setText((this.k.legs.size() - 1) + " " + getString(R.string.changes));
            }
        } else {
            textView2.setVisibility(8);
        }
        wc1 wc1 = new wc1(this);
        wc1.c(this.k, this.l);
        ((LinearLayout) findViewById(R.id.card_container)).addView(wc1);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
