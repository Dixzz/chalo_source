package com.freshchat.consumer.sdk.h;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.FreshchatNotificationConfig;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.activity.ConversationDetailActivity;
import com.freshchat.consumer.sdk.b.e;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.beans.Message;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.ag;
import com.freshchat.consumer.sdk.j.ai;
import com.freshchat.consumer.sdk.j.aq;
import com.freshchat.consumer.sdk.j.as;
import com.freshchat.consumer.sdk.j.aw;
import com.freshchat.consumer.sdk.j.bg;
import com.freshchat.consumer.sdk.j.g;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.receiver.FreshchatReceiver;
import com.freshchat.consumer.sdk.service.a;
import com.freshchat.consumer.sdk.service.e.b;
import com.freshchat.consumer.sdk.service.e.d;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.util.DeepLinkUtils;
import com.google.firebase.messaging.RemoteMessage;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class b {
    private static final String TAG = "com.freshchat.consumer.sdk.h.b";

    private static Uri N(Context context) {
        Uri uri;
        String ee = e.i(context).ee();
        if (as.a(ee)) {
            try {
                uri = Uri.parse(ee);
            } catch (Exception unused) {
            }
            return (uri != null || as.isEmpty(uri.toString())) ? RingtoneManager.getDefaultUri(2) : uri;
        }
        uri = null;
        if (uri != null) {
        }
    }

    public static void O(Context context) {
        b(context, true);
        b(context, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.Intent a(android.content.Context r4, com.freshchat.consumer.sdk.h.a r5, com.freshchat.consumer.sdk.b.e r6) {
        /*
            android.content.Intent r6 = new android.content.Intent
            java.lang.Class<com.freshchat.consumer.sdk.activity.DeeplinkInterstitialActivity> r0 = com.freshchat.consumer.sdk.activity.DeeplinkInterstitialActivity.class
            r6.<init>(r4, r0)
            boolean r0 = r5.dm()
            r1 = 1
            if (r0 == 0) goto L_0x0014
            java.lang.String r4 = "LAUNCH_APP_ON_CLICK"
        L_0x0010:
            r6.putExtra(r4, r1)
            goto L_0x0036
        L_0x0014:
            android.content.Intent r6 = new android.content.Intent
            java.lang.Class<com.freshchat.consumer.sdk.activity.ConversationDetailActivity> r0 = com.freshchat.consumer.sdk.activity.ConversationDetailActivity.class
            r6.<init>(r4, r0)
            r0 = 67108864(0x4000000, float:1.5046328E-36)
            r6.setFlags(r0)
            long r2 = r5.getChannelId()
            java.lang.String r0 = "CHANNEL_ID"
            r6.putExtra(r0, r2)
            long r2 = r5.getChannelId()
            boolean r4 = a(r4, r2)
            if (r4 != 0) goto L_0x0036
            java.lang.String r4 = "UNFETCHED_CHANNEL"
            goto L_0x0010
        L_0x0036:
            long r4 = r5.getMarketingId()
            r2 = 0
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x004a
            java.lang.String r0 = "NOTIFICATION_CLICKED"
            r6.putExtra(r0, r1)
            java.lang.String r0 = "MARKETING_ID"
            r6.putExtra(r0, r4)
        L_0x004a:
            java.lang.String r4 = "LAUNCHED_FROM_NOTIFICATION"
            r6.putExtra(r4, r1)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.h.b.a(android.content.Context, com.freshchat.consumer.sdk.h.a, com.freshchat.consumer.sdk.b.e):android.content.Intent");
    }

    public static Bundle a(Object obj) {
        if (obj instanceof Bundle) {
            return (Bundle) obj;
        }
        if (obj instanceof Intent) {
            return ((Intent) obj).getExtras();
        }
        if (dq() && (obj instanceof RemoteMessage)) {
            RemoteMessage remoteMessage = (RemoteMessage) obj;
            if (!(remoteMessage.getData() == null || remoteMessage.getData().size() == 0)) {
                Bundle bundle = new Bundle();
                Map<String, String> data = remoteMessage.getData();
                for (String str : data.keySet()) {
                    bundle.putString(str, data.get(str));
                }
                return bundle;
            }
        }
        return null;
    }

    private static f5 a(Context context, e eVar, a aVar) {
        int bQ = eVar.bQ();
        int n = n(context);
        Bitmap o = o(context);
        String d = d(context, aVar);
        CharSequence f = f(context, aVar);
        f5 f5Var = new f5(context, null);
        f5Var.v.icon = n;
        f5Var.j(o);
        f5Var.g(d);
        f5Var.f(f);
        f5Var.n(f);
        boolean z = true;
        f5Var.i(16, true);
        f5Var.j = bQ;
        e5 e5Var = new e5();
        e5Var.d(f);
        f5Var.l(e5Var);
        int a2 = aq.a(context, R.color.freshchat_notification_accent_color, 0);
        if (a2 != 0) {
            f5Var.q = a2;
        }
        if (eVar.isNotificationSoundEnabled()) {
            f5Var.k(N(context));
        }
        if (aw.eN() && g.an(context)) {
            if (aVar.getMarketingId() <= 0) {
                z = false;
            }
            String str = z ? "fc_campaign_notif_ch" : "fc_conv_notif_ch";
            if (!s(context, str)) {
                b(context, z);
            }
            a(context, str, f5Var);
        }
        return f5Var;
    }

    public static void a(Context context, long j, long j2) {
        int b = b(j, j2);
        if (b > 0) {
            ((NotificationManager) context.getSystemService("notification")).cancel(b);
        }
    }

    public static void a(Context context, FreshchatNotificationConfig freshchatNotificationConfig) {
        e i = e.i(context);
        i.h(freshchatNotificationConfig.getPriority());
        i.D(freshchatNotificationConfig.getImportance());
        i.i(freshchatNotificationConfig.isNotificationSoundEnabled());
        if (freshchatNotificationConfig.getNotificationSound() != null) {
            i.L(freshchatNotificationConfig.getNotificationSound().toString());
        }
        if (as.a(freshchatNotificationConfig.getActivityToLaunchOnFinish())) {
            i.F(freshchatNotificationConfig.getActivityToLaunchOnFinish());
        }
        i.j(freshchatNotificationConfig.getLargeIcon());
        i.i(freshchatNotificationConfig.getSmallIcon());
        i.u(freshchatNotificationConfig.isNotificationInterceptionEnabled());
    }

    private static void a(final Context context, final a aVar) {
        if (!a(context, aVar.dn(), aVar.getMarketingId())) {
            aa.a(context, aVar.getChannelId(), aVar.getConversationId(), 6, d.a.IMMEDIATE, aVar.getMarketingId() != 0);
            if (a(context, aVar.getChannelId())) {
                b(context, aVar);
                return;
            }
            ai.i(TAG, "Received message from a new unfetched channel");
            com.freshchat.consumer.sdk.j.b.a(context, b.a.IMMEDIATE, new a() {
                /* class com.freshchat.consumer.sdk.h.b.AnonymousClass1 */

                @Override // com.freshchat.consumer.sdk.service.a
                public void a(k kVar) {
                    b.b(context, aVar);
                }
            });
        }
    }

    private static void a(Context context, String str, f5 f5Var) {
        Method method;
        try {
            if (aw.eN() && g.an(context) && (method = f5.class.getMethod("e", String.class)) != null) {
                method.invoke(f5Var, str);
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public static boolean a(long j, boolean z) {
        return z || j != ConversationDetailActivity.H();
    }

    private static boolean a(Context context, long j) {
        return (context == null || j <= 0 || new c(context).e(j) == null) ? false : true;
    }

    private static boolean a(Context context, String str, long j) {
        Message X;
        com.freshchat.consumer.sdk.c.g gVar = new com.freshchat.consumer.sdk.c.g(context);
        if (j > 0) {
            return gVar.j(j);
        }
        if (!as.a(str) || (X = gVar.X(str)) == null) {
            return false;
        }
        String str2 = TAG;
        ai.d(str2, "Ignoring duplicate message " + X);
        return true;
    }

    private static int b(long j, long j2) {
        String l;
        if (j2 > 0) {
            l = Long.toString(j2);
        } else if (j <= 0) {
            return -1;
        } else {
            l = Long.toString(j);
        }
        return aa.aB(l);
    }

    public static void b(Context context, Intent intent) {
        if (intent != null) {
            int e = ag.e(intent, "notif_type");
            a aVar = new a(intent);
            bg.d(context, aVar.getChannelId(), aVar.getConversationId());
            if (aVar.getMarketingId() == 0 && !as.m(e.i(context).bj(), aVar.m6do())) {
                return;
            }
            if (e == 1 || e == 2) {
                a(context, aVar);
            } else if (e == 3) {
                c(context, aVar);
            } else {
                ai.d("FRESHCHAT", "Unknown notification category " + e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static void b(Context context, a aVar) {
        int b = b(aVar.getChannelId(), aVar.getMarketingId());
        Notification a2 = a(context, aVar, b);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (a(aVar.getChannelId(), aVar.dm())) {
            notificationManager.notify(b, a2);
        }
        com.freshchat.consumer.sdk.b.a.g(context);
        com.freshchat.consumer.sdk.b.a.f(context);
        com.freshchat.consumer.sdk.b.a.aJ(context);
        String str = TAG;
        StringBuilder j0 = hj1.j0("Notified with Id ", b, " for channel id: ");
        j0.append(aVar.getChannelId());
        j0.append(", marketing id: ");
        j0.append(aVar.getMarketingId());
        ai.d(str, j0.toString());
        aa.e(context, aVar.getMarketingId());
    }

    public static void b(Context context, boolean z) {
        int i;
        if (!aw.fI() && !g.ao(context)) {
            String str = z ? "fc_campaign_notif_ch" : "fc_conv_notif_ch";
            if (z) {
                try {
                    i = R.string.freshchat_campaign_notification_channel_name;
                } catch (Exception unused) {
                    return;
                }
            } else {
                i = R.string.freshchat_conversation_notification_channel_name;
            }
            String string = context.getString(i);
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str);
            if (notificationChannel == null) {
                NotificationChannel notificationChannel2 = new NotificationChannel(str, string, e.i(context).gw());
                notificationChannel2.setSound(N(context), new AudioAttributes.Builder().setContentType(4).setUsage(6).build());
                notificationManager.createNotificationChannel(notificationChannel2);
            } else if (as.p(string, notificationChannel.getName().toString())) {
                notificationChannel.setName(string);
            }
        }
    }

    public static void bj(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            c cVar = new c(context);
            com.freshchat.consumer.sdk.c.g gVar = new com.freshchat.consumer.sdk.c.g(context);
            for (Channel channel : cVar.d((List<String>) null)) {
                arrayList.add(Integer.valueOf(aa.aB(Long.toString(channel.getId()))));
                for (Long l : gVar.i(channel.getId())) {
                    arrayList.add(Integer.valueOf(aa.aB(Long.toString(l.longValue()))));
                }
            }
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    notificationManager.cancel(((Integer) it.next()).intValue());
                }
            }
        } catch (Exception e) {
            q.a(e);
        }
    }

    private static void c(final Context context, a aVar) {
        e i = e.i(context);
        final long channelId = aVar.getChannelId();
        final int b = b(channelId, 0);
        f5 a2 = a(context, i, aVar);
        Intent intent = new Intent(context, ConversationDetailActivity.class);
        intent.setFlags(67108864);
        intent.putExtra("CHANNEL_ID", channelId);
        a2.g = PendingIntent.getActivity(context, b, intent, 268435456);
        final Notification b2 = a2.b();
        com.freshchat.consumer.sdk.j.b.a(context, 6, d.a.IMMEDIATE, new a() {
            /* class com.freshchat.consumer.sdk.h.b.AnonymousClass2 */

            @Override // com.freshchat.consumer.sdk.service.a
            public void a(k kVar) {
                if (b.a(channelId, false)) {
                    ((NotificationManager) context.getSystemService("notification")).notify(b, b2);
                }
                com.freshchat.consumer.sdk.b.a.f(context);
                com.freshchat.consumer.sdk.b.a.g(context);
            }
        });
    }

    private static String d(Context context, a aVar) {
        return context.getString((aVar.getMarketingId() > 0 ? 1 : (aVar.getMarketingId() == 0 ? 0 : -1)) > 0 ? R.string.freshchat_promotional_message_notification_title : R.string.freshchat_support_message_notification_title).replace(context.getString(R.string.freshchat_placeholder_app_name), g.getAppName(context));
    }

    private static boolean dq() {
        try {
            Class.forName("com.google.firebase.messaging.RemoteMessage");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static CharSequence f(Context context, a aVar) {
        if (aVar.fK() == 3) {
            String string = context.getString(R.string.freshchat_chat_resolution_survey_question);
            if (as.a(string)) {
                return as.fromHtml(string);
            }
        }
        return as.fromHtml(aVar.getBody());
    }

    private static int n(Context context) {
        e i = e.i(context);
        if (i.bR() != 0) {
            return i.bR();
        }
        int a2 = aq.a(context, R.style.Theme_Freshchat_SelectedTheme, R.attr.freshchatContactUsIcon, false);
        return a2 != 0 ? a2 : R.drawable.freshchat_ic_action_contact_us;
    }

    private static Bitmap o(Context context) {
        try {
            e i = e.i(context);
            int bS = i.bS() != 0 ? i.bS() : g.P(context);
            if (bS != 0) {
                return af.b(context, bS, R.dimen.freshchat_notification_large_icon_size);
            }
            return null;
        } catch (Exception e) {
            ai.e("FRESHCHAT_WARNING", e.toString());
            return null;
        }
    }

    @TargetApi(26)
    private static boolean s(Context context, String str) {
        try {
            return as.a(str) && ((NotificationManager) context.getSystemService("notification")).getNotificationChannel(str) != null;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v6, resolved type: d5 */
    /* JADX WARN: Multi-variable type inference failed */
    private static Notification a(Context context, a aVar, int i) {
        e5 e5Var;
        PendingIntent pendingIntent;
        e i2 = e.i(context);
        f5 a2 = a(context, i2, aVar);
        if (aVar.getMarketingId() > 0) {
            a2.v.when = aVar.getTimestamp();
        }
        CharSequence f = f(context, aVar);
        if (URLUtil.isNetworkUrl(aVar.dl())) {
            Bitmap bitmap = null;
            FreshchatImageLoaderRequest dM = new FreshchatImageLoaderRequest.a(aVar.dl()).dM();
            FreshchatImageLoader eK = af.eK();
            if (eK != null) {
                bitmap = eK.get(dM);
            }
            d5 d5Var = new d5();
            d5Var.e = bitmap;
            d5Var.e(f);
            e5Var = d5Var;
        } else {
            e5 e5Var2 = new e5();
            e5Var2.d(f);
            e5Var = e5Var2;
        }
        a2.l(e5Var);
        if (i2.isNotificationInterceptionEnabled()) {
            Intent intent = new Intent(context, FreshchatReceiver.class);
            intent.setAction("com.freshchat.consumer.sdk.actions.NotificationClicked");
            intent.putExtra("FRESHCHAT_DEEPLINK", DeepLinkUtils.v(aVar.getChannelId()));
            pendingIntent = PendingIntent.getBroadcast(context, i, intent, 268435456);
        } else {
            pendingIntent = PendingIntent.getActivity(context, i, a(context, aVar, i2), 268435456);
        }
        a2.g = pendingIntent;
        return a2.b();
    }
}
