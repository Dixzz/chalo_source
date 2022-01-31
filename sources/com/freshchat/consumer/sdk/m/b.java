package com.freshchat.consumer.sdk.m;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.i;
import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.ui.e;
import java.util.List;

public abstract class b extends a {
    private RecyclerView dR;
    private l oU;
    private int orientation;
    private i.a ox = new c(this);

    private void hF() {
        l lVar = this.oU;
        if (lVar != null) {
            lVar.K(hG());
            this.oU.notifyDataSetChanged();
        }
    }

    private int hG() {
        return getResources().getInteger(this.orientation == 1 ? R.integer.freshchat_calendar_timeslot_items_portrait : R.integer.freshchat_calendar_timeslot_items_landscape);
    }

    public void G(List<l.b> list) {
        if (getContext() != null) {
            l lVar = new l(list, this.ox);
            this.oU = lVar;
            e eVar = new e(lVar);
            this.oU.K(hG());
            this.dR.f(eVar);
            this.dR.setLayoutManager(new LinearLayoutManager(getContext()));
            this.dR.setAdapter(this.oU);
        }
    }

    public abstract int getCalendarType();

    @Override // androidx.fragment.app.Fragment
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.orientation = configuration.orientation;
        hF();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.orientation = hD();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.dR = (RecyclerView) view.findViewById(R.id.freshchat_all_timeslots_recycler_view);
    }
}
