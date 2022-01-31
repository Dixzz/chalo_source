package com.freshchat.consumer.sdk.m;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.b.i;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.m.a;
import defpackage.e0;

public class f extends y {
    private CalendarMessageMeta calendarMessageMeta;
    private String oY;
    private TextView oZ;
    private a pa;

    public interface a {
        void b(CalendarMessageMeta calendarMessageMeta);

        void b(CalendarMessageMeta calendarMessageMeta, CalendarDay.TimeSlot timeSlot, int i);
    }

    public static f a(int i, CalendarMessageMeta calendarMessageMeta2, String str) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putInt("Orientation", i);
        bundle.putParcelable("MessageMeta", calendarMessageMeta2);
        bundle.putString("AgentProfilePicUrl", str);
        fVar.setArguments(bundle);
        return fVar;
    }

    private void g(View view) {
        this.oZ = (TextView) view.findViewById(R.id.freshchat_calendar_dialog_duration_textview);
        ((ImageView) view.findViewById(R.id.freshchat_calendar_cancel_invite_imageview)).setOnClickListener(new g(this));
    }

    /* access modifiers changed from: private */
    public void hN() {
        if (c() != null) {
            e0.a m = i.m(c());
            m.f908a.f = getString(R.string.freshchat_calendar_cancel_booking_prompt_message);
            m.b(R.string.freshchat_calendar_cancel_booking_prompt_cancel, new h(this));
            int i = R.string.freshchat_calendar_cancel_booking_prompt_continue;
            i iVar = new i(this);
            AlertController.b bVar = m.f908a;
            bVar.i = bVar.f194a.getText(i);
            m.f908a.j = iVar;
            e0 a2 = m.a();
            a2.setCanceledOnTouchOutside(false);
            a2.show();
        }
    }

    private boolean hO() {
        return getChildFragmentManager().I("Calendar") instanceof a;
    }

    public void a(CalendarDay.TimeSlot timeSlot, int i) {
        a aVar = this.pa;
        if (aVar != null) {
            aVar.b(this.calendarMessageMeta, timeSlot, i);
        }
        dismiss();
    }

    public void a(a.EnumC0014a aVar, Bundle bundle) {
        try {
            a aVar2 = (a) aVar.hE().newInstance();
            if (bundle != null) {
                aVar2.setArguments(bundle);
            }
            ke keVar = new ke(getChildFragmentManager());
            if (hO()) {
                int i = R.anim.freshchat_slide_in_right;
                int i2 = R.anim.freshchat_slide_out_left;
                keVar.b = i;
                keVar.c = i2;
                keVar.d = 0;
                keVar.e = 0;
                keVar.g(R.id.freshchat_calendar_child_fragment_container, aVar2, "Calendar");
                keVar.c(null);
            } else {
                keVar.f(R.id.freshchat_calendar_child_fragment_container, aVar2, "Calendar", 1);
            }
            keVar.d();
        } catch (Exception | IllegalAccessException | InstantiationException e) {
            q.a(e);
        }
    }

    public void bo(String str) {
        if (as.a(str)) {
            this.oZ.setText(str);
            this.oZ.setVisibility(0);
        }
    }

    public CalendarMessageMeta getCalendarMessageMeta() {
        return this.calendarMessageMeta;
    }

    public void hK() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            try {
                if (arguments.containsKey("Orientation")) {
                    setOrientation(arguments.getInt("Orientation"));
                }
                this.calendarMessageMeta = (CalendarMessageMeta) arguments.getParcelable("MessageMeta");
                this.oY = arguments.getString("AgentProfilePicUrl");
            } catch (Exception e) {
                q.a(e);
                dismiss();
            }
        }
    }

    public String hL() {
        return this.oY;
    }

    public void hM() {
        a aVar = this.pa;
        if (aVar != null) {
            aVar.b(this.calendarMessageMeta);
        }
        dismiss();
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        ve activity = c();
        if (activity instanceof a) {
            this.pa = (a) activity;
        }
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment, com.freshchat.consumer.sdk.m.y
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        hK();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.freshchat_fragment_calendar_bottomsheet_dialog, viewGroup, false);
    }

    @Override // defpackage.ue, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.pa = null;
    }

    @Override // defpackage.ue
    public void onDismiss(DialogInterface dialogInterface) {
        if (c() != null) {
            i.a(getContext(), c().getCurrentFocus());
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        g(view);
        if (!hO()) {
            a(a.EnumC0014a.CALENDAR_EMAIL_ENTRY_FRAGMENT, (Bundle) null);
        }
    }
}
