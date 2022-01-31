package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.freshchat.consumer.sdk.Event;
import com.freshchat.consumer.sdk.beans.Article;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Conversation;
import com.freshchat.consumer.sdk.beans.fragment.CarouselCardDefaultFragment;
import com.freshchat.consumer.sdk.beans.fragment.QuickReplyButtonFragment;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.e;
import com.freshchat.consumer.sdk.c.i;
import java.util.HashMap;
import java.util.Map;

public class bg {

    public static class a {
        private Event.EventName eventName;
        private Map<Event.Property, Object> properties;

        private a(Event.EventName eventName2) {
            this.properties = new HashMap();
            this.eventName = eventName2;
        }

        public /* synthetic */ a(Event.EventName eventName2, bh bhVar) {
            this(eventName2);
        }

        /* access modifiers changed from: private */
        public a a(Event.Property property, Object obj) {
            if (property == null) {
                ai.e("FRESHCHAT_WARNING", "property can not be null for Event::Builder::addProperty()");
                return this;
            }
            if (obj == null || ((obj instanceof String) && as.isEmpty(obj.toString()))) {
                ai.e("FRESHCHAT_WARNING", "value can not be null/empty for Event::Builder::addProperty()");
                return this;
            }
            this.properties.put(property, obj);
            return this;
        }

        /* access modifiers changed from: private */
        public Event gz() {
            Event event = new Event();
            event.setEventName(this.eventName);
            event.setProperties(this.properties);
            return event;
        }
    }

    public interface b {
        Event gy();
    }

    /* access modifiers changed from: private */
    public static Category A(Context context, String str) {
        if (y.cp(context)) {
            return null;
        }
        return new i(context).Y(str);
    }

    public static void J(Context context, String str) {
        a(context, Event.EventName.FCEventCalendarFindTimeSlotClick, str);
    }

    public static void K(Context context, String str) {
        a(context, Event.EventName.FCEventCalendarInviteCancel, str);
    }

    public static void L(Context context, String str) {
        a(context, Event.EventName.FCEventCalendarNoTimeSlotFound, str);
    }

    public static void M(Context context, String str) {
        a(context, Event.EventName.FCEventCalendarBookingSuccess, str);
    }

    public static void N(Context context, String str) {
        a(context, Event.EventName.FCEventCalendarBookingRetry, str);
    }

    public static void O(Context context, String str) {
        a(context, Event.EventName.FCEventCalendarBookingFailure, str);
    }

    public static Bundle a(Event event) {
        Bundle bundle = new Bundle();
        bundle.putString("event_name", event.getEventName().getName());
        for (Map.Entry<Event.Property, Object> entry : event.getProperties().entrySet()) {
            try {
                if (entry.getValue() instanceof String) {
                    bundle.putString(entry.getKey().getName(), entry.getValue().toString());
                } else if (entry.getValue() instanceof Long) {
                    bundle.putLong(entry.getKey().getName(), ((Long) entry.getValue()).longValue());
                } else if (entry.getValue() instanceof Integer) {
                    bundle.putInt(entry.getKey().getName(), ((Integer) entry.getValue()).intValue());
                } else if (entry.getValue() instanceof Boolean) {
                    bundle.putBoolean(entry.getKey().getName(), ((Boolean) entry.getValue()).booleanValue());
                } else {
                    ai.e("FRESHCHAT", "Error bundling Value of Property " + entry.getKey().getName());
                }
            } catch (Exception e) {
                StringBuilder i0 = hj1.i0("Error bundling Value of Property ");
                i0.append(entry.getKey().getName());
                i0.append("\n");
                i0.append(e.toString());
                ai.e("FRESHCHAT", i0.toString());
            }
        }
        return bundle;
    }

    /* access modifiers changed from: private */
    public static a a(Event.EventName eventName) {
        return new a(eventName, null);
    }

    public static void a(Context context, long j, boolean z, int i, String str) {
        a(context, new bw(context, j, z, i, str));
    }

    public static void a(Context context, long j, String[] strArr) {
        a(context, new bu(context, j, strArr));
    }

    public static void a(Context context, Uri uri) {
        a(context, new bj(uri));
    }

    private static void a(Context context, Event.EventName eventName) {
        a(context, new cr(eventName));
    }

    private static void a(Context context, Event.EventName eventName, String str) {
        a(context, new ce(eventName, str));
    }

    public static void a(Context context, CarouselCardDefaultFragment carouselCardDefaultFragment) {
        a(context, new bn(carouselCardDefaultFragment));
    }

    public static void a(Context context, QuickReplyButtonFragment quickReplyButtonFragment) {
        a(context, new bm(quickReplyButtonFragment));
    }

    private static void a(Context context, b bVar) {
        be.eC().gx().execute(new cu(context, bVar));
    }

    public static void a(Context context, String str, int i, boolean z) {
        a(context, new bs(str, i, z));
    }

    public static void a(Context context, String str, String str2, String str3, String str4, boolean z) {
        a(context, new bh(str2, str4, z, context, str, str3));
    }

    public static void a(Context context, String str, String str2, String str3, String str4, String[] strArr) {
        a(context, new bk(str4, str2, context, str, str3, strArr));
    }

    public static void a(Context context, String str, String str2, String[] strArr) {
        a(context, new bq(str2, context, str, strArr));
    }

    public static void b(Context context, CarouselCardDefaultFragment carouselCardDefaultFragment) {
        a(context, new bo(carouselCardDefaultFragment));
    }

    public static void bK(Context context) {
        a(context, Event.EventName.FCEventMessageReceive);
    }

    public static void bL(Context context) {
        a(context, Event.EventName.FCEventScreenView);
    }

    public static void bM(Context context) {
        a(context, Event.EventName.FCEventIdTokenStatusChange);
    }

    public static void bY(Context context) {
        a(context, Event.EventName.FCEventDropDownShow);
    }

    public static void bZ(Context context) {
        a(context, Event.EventName.FCEventCarouselShow);
    }

    /* access modifiers changed from: private */
    public static Conversation c(Context context, long j) {
        return new e(context).f(j);
    }

    public static void c(Context context, long j, long j2) {
        a(context, new bv(j2, context, j));
    }

    public static void c(Context context, String[] strArr) {
        a(context, new br(strArr));
    }

    public static void d(Context context, long j, long j2) {
        a(context, new bi(j2, context, j));
    }

    public static void d(Context context, String[] strArr) {
        a(context, new bt(strArr));
    }

    public static Event e(Bundle bundle) throws IllegalArgumentException {
        Event.EventName eventName = Event.EventName.get(bundle);
        if (eventName == null) {
            ai.e("FRESHCHAT_WARNING", "event_name missing in Event::fromBundle()");
            return null;
        }
        Bundle bundle2 = (Bundle) bundle.clone();
        bundle2.remove("event_name");
        HashMap hashMap = new HashMap();
        for (String str : bundle2.keySet()) {
            Event.Property property = Event.Property.get(str);
            if (property == null) {
                ai.e("FRESHCHAT", "Could not find eventName property - " + str);
            } else {
                hashMap.put(property, bundle2.get(str));
            }
        }
        Event event = new Event();
        event.setEventName(eventName);
        event.setProperties(hashMap);
        return event;
    }

    public static void f(Context context, boolean z) {
        a(context, new bp(z));
    }

    /* access modifiers changed from: private */
    public static Channel j(Context context, long j) {
        return new c(context).e(j);
    }

    public static void k(Context context, long j) {
        a(context, new bx(context, j));
    }

    public static void l(Context context, long j) {
        a(context, new bl(context, j));
    }

    /* access modifiers changed from: private */
    public static Article z(Context context, String str) {
        if (y.cp(context)) {
            return null;
        }
        return new i(context).ab(str);
    }
}
