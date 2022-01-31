package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.net.Uri;
import com.freshchat.consumer.sdk.beans.CalendarMessageMeta;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.beans.MessageInternalMeta;
import com.freshchat.consumer.sdk.beans.Participant;
import com.freshchat.consumer.sdk.beans.fragment.CalendarEventFragment;
import com.freshchat.consumer.sdk.beans.fragment.MessageFragment;
import com.freshchat.consumer.sdk.c.g;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cm {
    private static Message a(Map<String, Message> map, String str) {
        Message message = map.get(str);
        if (message == null) {
            return null;
        }
        map.remove(str);
        message.setResponded(true);
        return message;
    }

    public static String a(Map<String, Participant> map, Message message) {
        CalendarMessageMeta calendarMessageMeta;
        Participant participant;
        MessageInternalMeta internalMeta = message.getInternalMeta();
        if (internalMeta == null || k.c(map) || (calendarMessageMeta = internalMeta.getCalendarMessageMeta()) == null) {
            return null;
        }
        String calendarAgentAlias = calendarMessageMeta.getCalendarAgentAlias();
        if (!as.isEmpty(calendarAgentAlias) && (participant = map.get(calendarAgentAlias)) != null) {
            return participant.getProfilePicUrl();
        }
        return null;
    }

    public static void a(Context context, Message message, long j) {
        if (v(message)) {
            be.eC().gx().execute(new cn(message, context, j));
        }
    }

    public static void a(Context context, List<Message> list, long j) {
        HashMap hashMap = new HashMap();
        g ch = ch(context);
        for (Message message : ch.A(j)) {
            b(hashMap, message);
        }
        HashMap hashMap2 = new HashMap();
        for (Message message2 : list) {
            if (u(message2)) {
                b(hashMap2, message2);
            } else if (v(message2)) {
                String t = t(message2);
                if (!as.isEmpty(t)) {
                    Message a2 = a(hashMap, t);
                    if (a2 != null) {
                        ch.b(a2);
                    } else {
                        a(hashMap2, t);
                    }
                }
            }
        }
    }

    public static boolean a(CalendarEventFragment calendarEventFragment) {
        if (calendarEventFragment == null) {
            return false;
        }
        return as.a(calendarEventFragment.getEventId());
    }

    private static void b(Map<String, Message> map, Message message) {
        String t = t(message);
        if (!as.isEmpty(t)) {
            map.put(t, message);
        }
    }

    private static g ch(Context context) {
        return new g(context);
    }

    public static String g(Context context, Message message) {
        CalendarEventFragment s = s(message);
        if (s == null) {
            return null;
        }
        long startMillis = s.getStartMillis();
        if (startMillis <= 0) {
            return null;
        }
        return n.o(context, startMillis);
    }

    public static CalendarEventFragment s(Message message) {
        List<MessageFragment> messageFragments = message.getMessageFragments();
        if (!k.a(messageFragments) || !(messageFragments.get(0) instanceof CalendarEventFragment)) {
            return null;
        }
        return (CalendarEventFragment) messageFragments.get(0);
    }

    public static String t(Message message) {
        CalendarMessageMeta x = x(message);
        if (x == null) {
            return null;
        }
        return x.getCalendarInviteId();
    }

    public static boolean u(Message message) {
        return message.getMessageType() == Message.MessageType.MESSAGE_TYPE_CALENDER_INVITE_SENT_BY_AGENT.getIntValue();
    }

    private static boolean v(Message message) {
        return message.getMessageType() == Message.MessageType.MESSAGE_TYPE_CALENDER_INVITE_CANCELLED_BY_USER.getIntValue() || s(message) != null;
    }

    public static Uri w(Message message) {
        CalendarMessageMeta x = x(message);
        if (x == null) {
            return null;
        }
        try {
            String calendarEventLink = x.getCalendarEventLink();
            if (as.a(calendarEventLink)) {
                return Uri.parse(calendarEventLink);
            }
            return null;
        } catch (Exception e) {
            q.a(e);
            return null;
        }
    }

    private static CalendarMessageMeta x(Message message) {
        if (message == null || message.getInternalMeta() == null) {
            return null;
        }
        return message.getInternalMeta().getCalendarMessageMeta();
    }

    public static boolean y(Message message) {
        CalendarMessageMeta x = x(message);
        if (x == null) {
            return false;
        }
        return x.isRetryCalendarEvent();
    }
}
