package com.freshchat.consumer.sdk.m;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.a.l;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.k.r;
import com.freshchat.consumer.sdk.service.Status;
import com.freshchat.consumer.sdk.service.b;
import java.util.List;

public class n extends b {
    private ProgressBar bX;
    private r qZ;
    private View ra;
    private LinearLayout rb;
    private View rc;
    private View rd;

    /* access modifiers changed from: private */
    public void a(b<List<l.b>> bVar) {
        View view;
        this.bX.setVisibility(8);
        this.ra.setVisibility(0);
        if (bVar.getStatus() == Status.SUCCESS) {
            iS();
            List<l.b> data = bVar.getData();
            this.rd.setVisibility(8);
            if (k.a(data)) {
                this.rb.setVisibility(0);
                this.rc.setVisibility(8);
                G(data);
                return;
            }
            this.qZ.jr();
            this.rb.setVisibility(8);
            view = this.rc;
        } else {
            this.rb.setVisibility(8);
            this.rc.setVisibility(8);
            view = this.rd;
        }
        view.setVisibility(0);
    }

    private void g(View view) {
        this.bX = (ProgressBar) view.findViewById(R.id.freshchat_fragment_calendar_limited_time_slots_progressbar);
        this.ra = view.findViewById(R.id.freshchat_limited_time_slots_view_content);
        this.rb = (LinearLayout) view.findViewById(R.id.freshchat_calendar_timeslots_data_layout);
        View findViewById = view.findViewById(R.id.freshchat_calendar_show_more_time_slots_button);
        this.rc = view.findViewById(R.id.freshchat_calendar_no_timeslots_layout);
        View findViewById2 = view.findViewById(R.id.freshchat_calendar_cancel_invite_button);
        this.rd = view.findViewById(R.id.freshchat_calendar_retry_option_layout);
        View findViewById3 = view.findViewById(R.id.freshchat_calendar_retry_button);
        findViewById.setOnClickListener(new o(this));
        findViewById3.setOnClickListener(new p(this));
        findViewById2.setOnClickListener(new q(this));
    }

    /* access modifiers changed from: private */
    public void hH() {
        if (!isDetached()) {
            this.bX.setVisibility(0);
            this.ra.setVisibility(8);
            this.qZ.a(new r(this));
        }
    }

    private void iS() {
        f hB = hB();
        if (hB != null) {
            hB.bo(this.qZ.ia());
        }
    }

    @Override // com.freshchat.consumer.sdk.m.a
    public void cc(Context context) {
        r rVar = new r(context);
        this.qZ = rVar;
        rVar.setCalendarMessageMeta(getCalendarMessageMeta());
    }

    @Override // com.freshchat.consumer.sdk.m.b
    public int getCalendarType() {
        return this.qZ.getCalendarType();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.freshchat_fragment_calendar_limited_timeslots, viewGroup, false);
    }

    @Override // com.freshchat.consumer.sdk.m.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g(view);
        hH();
    }
}
