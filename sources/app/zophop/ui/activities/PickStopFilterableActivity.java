package app.zophop.ui.activities;

import android.content.Intent;
import android.widget.ListAdapter;
import app.zophop.models.Stop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

public class PickStopFilterableActivity extends bf0<Stop> {
    public List<Stop> u;

    public class a extends TypeToken<List<Stop>> {
        public a(PickStopFilterableActivity pickStopFilterableActivity) {
        }
    }

    @Override // defpackage.vf1, defpackage.bf0
    public ListAdapter i0() {
        return h0();
    }

    @Override // defpackage.bf0
    public List<Stop> s0() {
        return this.u;
    }

    @Override // defpackage.bf0
    public void t0(Intent intent) {
        this.u = (List) new Gson().fromJson(intent.getStringExtra("stop_list"), new a(this).getType());
        String stringExtra = getIntent().getStringExtra("remove_till_stop");
        ArrayList arrayList = new ArrayList();
        if (stringExtra != null) {
            boolean z = false;
            for (Stop stop : this.u) {
                if (stop.getName().equals(stringExtra)) {
                    z = true;
                } else if (z) {
                    arrayList.add(stop);
                }
            }
            this.u = arrayList;
        }
    }
}
