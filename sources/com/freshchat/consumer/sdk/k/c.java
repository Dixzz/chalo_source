package com.freshchat.consumer.sdk.k;

import android.content.Context;
import android.net.Uri;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.CalendarDay;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.MessageInternalMeta;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.beans.fragment.TextFragment;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.be;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.cm;
import com.freshchat.consumer.sdk.j.ct;
import com.freshchat.consumer.sdk.j.k;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.l.c;
import com.freshchat.consumer.sdk.l.j;
import defpackage.jk;
import java.util.List;
import java.util.Map;

public class c extends b {
    private long nq;
    private long ok;
    private final com.freshchat.consumer.sdk.l.c qr = new com.freshchat.consumer.sdk.l.c();

    public class a extends jk.b {
        private final List<Message> lA;
        private final List<Message> lB;

        public a(List<Message> list, List<Message> list2) {
            this.lA = list;
            this.lB = list2;
        }

        @Override // defpackage.jk.b
        public boolean areContentsTheSame(int i, int i2) {
            return this.lA.get(i).equals(this.lB.get(i2));
        }

        @Override // defpackage.jk.b
        public boolean areItemsTheSame(int i, int i2) {
            return as.o(this.lA.get(i).getAlias(), this.lB.get(i2).getAlias());
        }

        @Override // defpackage.jk.b
        public int getNewListSize() {
            return k.b(this.lB);
        }

        @Override // defpackage.jk.b
        public int getOldListSize() {
            return k.b(this.lA);
        }
    }

    public c(Context context) {
        super(context);
    }

    private MessageInternalMeta c(CalendarMessageMeta calendarMessageMeta) {
        MessageInternalMeta messageInternalMeta = new MessageInternalMeta();
        messageInternalMeta.setCalendarMessageMeta(calendarMessageMeta);
        return messageInternalMeta;
    }

    public void A(Message message) {
        String t = cm.t(message);
        if (as.a(t)) {
            bg.J(getContext(), t);
        }
    }

    public void B(Message message) {
        String t = cm.t(message);
        if (as.a(t)) {
            bg.K(getContext(), t);
        }
    }

    public boolean I(List<Message> list) {
        if (k.isEmpty(list)) {
            return false;
        }
        return cm.u(list.get(k.b(list) - 1));
    }

    public int a(int i, int i2, int i3) {
        if (i >= i2) {
            i = i2;
        }
        return i * i3;
    }

    public Message a(CalendarMessageMeta calendarMessageMeta, long j, long j2) {
        if (calendarMessageMeta == null) {
            return null;
        }
        String C = new j().C(getContext());
        if (as.isEmpty(C)) {
            return null;
        }
        TextFragment textFragment = new TextFragment();
        textFragment.setContent(getContext().getString(R.string.freshchat_calendar_cancel_invite_message));
        textFragment.setContentType("text/html");
        MessageInternalMeta c = c(calendarMessageMeta);
        Message a2 = a(C, textFragment, Message.MessageType.MESSAGE_TYPE_CALENDER_INVITE_CANCELLED_BY_USER, j, j2, -1);
        if (a2 == null) {
            return null;
        }
        a2.setInternalMeta(c);
        return a2;
    }

    public Message a(CalendarMessageMeta calendarMessageMeta, CalendarDay.TimeSlot timeSlot, int i, long j, long j2) {
        if (calendarMessageMeta == null || timeSlot == null) {
            return null;
        }
        j jVar = new j();
        String C = jVar.C(getContext());
        CalendarEventFragment calendarEventFragment = new CalendarEventFragment();
        calendarEventFragment.setStartMillis(timeSlot.getFromMillis());
        calendarEventFragment.setEndMillis(timeSlot.getToMillis());
        calendarEventFragment.setEventProviderType(i);
        calendarEventFragment.setUserTimeZone(ct.hX());
        Message a2 = a(C, calendarEventFragment, Message.MessageType.MESSAGE_TYPE_NORMAL, j, j2, -1);
        if (a2 == null) {
            return null;
        }
        MessageInternalMeta c = c(calendarMessageMeta);
        calendarMessageMeta.setCalendarBookingEmail(jVar.cd(getContext()));
        a2.setInternalMeta(c);
        return a2;
    }

    public Message a(String str, MessageFragment messageFragment, long j, long j2, long j3) {
        return a(str, messageFragment, Message.MessageType.MESSAGE_TYPE_NORMAL, j, j2, j3);
    }

    public Message a(String str, MessageFragment messageFragment, Message.MessageType messageType, long j, long j2, long j3) {
        if (messageFragment == null) {
            return null;
        }
        try {
            return com.freshchat.consumer.sdk.service.d.c.a(str, messageFragment, messageType, j, j2, j3);
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    public String a(CalendarMessageMeta calendarMessageMeta, Map<String, Participant> map) {
        Participant participant;
        if (calendarMessageMeta == null || k.c(map)) {
            return null;
        }
        String calendarAgentAlias = calendarMessageMeta.getCalendarAgentAlias();
        if (!as.isEmpty(calendarAgentAlias) && (participant = map.get(calendarAgentAlias)) != null) {
            return participant.getProfilePicUrl();
        }
        return null;
    }

    public void a(long j, c.b bVar) {
        this.qr.a(getContext(), j, bVar);
    }

    public jk.d b(List<Message> list, List<Message> list2) {
        return jk.a(new a(list, list2));
    }

    public Uri w(Message message) {
        return cm.w(message);
    }

    public CalendarMessageMeta x(Message message) {
        MessageInternalMeta internalMeta = message.getInternalMeta();
        if (internalMeta == null) {
            return null;
        }
        return internalMeta.getCalendarMessageMeta();
    }

    public void x(long j) {
        if (j != this.nq && ha()) {
            this.nq = j;
            bg.bY(getContext());
        }
    }

    public void y(long j) {
        if (j != this.ok && ha()) {
            this.ok = j;
            bg.bZ(getContext());
        }
    }

    public String z(Message message) {
        return cm.g(getContext(), message);
    }

    public void z(List<Message> list) {
        be.eC().gZ().execute(new d(this, list));
    }
}
