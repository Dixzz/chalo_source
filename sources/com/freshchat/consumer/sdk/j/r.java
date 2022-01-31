package com.freshchat.consumer.sdk.j;

import android.content.Context;
import android.content.res.Resources;
import com.freshchat.consumer.sdk.R;
import com.freshchat.consumer.sdk.beans.ChannelResponseTime;
import com.freshchat.consumer.sdk.beans.reqres.ChannelsResponseTimeResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class r {
    private static Map<Long, ChannelResponseTime> hC = new HashMap();
    private static long hD;

    /* renamed from: com.freshchat.consumer.sdk.j.r$1  reason: invalid class name */
    public /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] kw;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000e */
        static {
            /*
                com.freshchat.consumer.sdk.beans.ChannelResponseTime.ResponseTimeType.values()
                r0 = 4
                int[] r0 = new int[r0]
                com.freshchat.consumer.sdk.j.r.AnonymousClass1.kw = r0
                r1 = 1
                com.freshchat.consumer.sdk.beans.ChannelResponseTime$ResponseTimeType r2 = com.freshchat.consumer.sdk.beans.ChannelResponseTime.ResponseTimeType.CURRENT_AVG     // Catch:{ NoSuchFieldError -> 0x000e }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000e }
            L_0x000e:
                int[] r0 = com.freshchat.consumer.sdk.j.r.AnonymousClass1.kw     // Catch:{ NoSuchFieldError -> 0x0015 }
                com.freshchat.consumer.sdk.beans.ChannelResponseTime$ResponseTimeType r2 = com.freshchat.consumer.sdk.beans.ChannelResponseTime.ResponseTimeType.LAST_WEEK_AVG     // Catch:{ NoSuchFieldError -> 0x0015 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0015 }
            L_0x0015:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.freshchat.consumer.sdk.j.r.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        UNDER_1_MIN(R.string.freshchat_typically_replies_within_a_minute, R.string.freshchat_currently_replying_in_a_minute),
        UNDER_X_MINS(R.string.freshchat_typically_replies_within_x_minutes, R.string.freshchat_currently_replying_in_x_minutes),
        UNDER_AN_HR(R.string.freshchat_typically_replies_within_an_hour, R.string.freshchat_currently_replying_in_an_hour),
        UNDER_2_HRS(R.string.freshchat_typically_replies_within_2_hours, R.string.freshchat_currently_replying_in_2_hours),
        UNDER_FEW_HRS(R.string.freshchat_typically_replies_within_few_hours, R.string.freshchat_currently_replying_in_few_hours);
        
        private int kC;
        private int kD;

        private a(int i, int i2) {
            this.kC = i;
            this.kD = i2;
        }

        public String a(Context context, ChannelResponseTime.ResponseTimeType responseTimeType) {
            Resources resources;
            int i;
            if (responseTimeType == null || context == null) {
                return null;
            }
            int i2 = AnonymousClass1.kw[responseTimeType.ordinal()];
            if (i2 == 1) {
                resources = context.getResources();
                i = this.kD;
            } else if (i2 != 2) {
                return null;
            } else {
                resources = context.getResources();
                i = this.kC;
            }
            return resources.getString(i);
        }
    }

    private static String a(Context context, ChannelResponseTime channelResponseTime) {
        if (context == null || channelResponseTime == null) {
            return null;
        }
        if (channelResponseTime.getResponseTimeType() == ChannelResponseTime.ResponseTimeType.ALL_MEMBERS_AWAY_RESPONSE) {
            return context.getString(R.string.freshchat_all_members_away_message);
        }
        if (channelResponseTime.getResponseTimeType() == ChannelResponseTime.ResponseTimeType.CUSTOM_RESPONSE) {
            return channelResponseTime.getCustomResponseTimeMessage();
        }
        long responseTime = channelResponseTime.getResponseTime();
        ChannelResponseTime.ResponseTimeType responseTimeType = channelResponseTime.getResponseTimeType();
        float f = ((float) responseTime) / 60.0f;
        if (f < 1.0f) {
            return a.UNDER_1_MIN.a(context, responseTimeType);
        }
        if (f >= 55.0f) {
            return f < 60.0f ? a.UNDER_AN_HR.a(context, responseTimeType) : f < 120.0f ? a.UNDER_2_HRS.a(context, responseTimeType) : a.UNDER_FEW_HRS.a(context, responseTimeType);
        }
        try {
            return a.UNDER_X_MINS.a(context, responseTimeType).replace(context.getString(R.string.freshchat_placeholder_minutes), String.valueOf(f < 10.0f ? (int) Math.ceil((double) f) : ((int) Math.ceil((double) (f / 5.0f))) * 5));
        } catch (Exception unused) {
            ai.e("FRESHCHAT_WARNING", "Channels response time to String conversation error");
            return null;
        }
    }

    public static void a(Context context, ChannelsResponseTimeResponse channelsResponseTimeResponse) {
        hC.clear();
        if (channelsResponseTimeResponse != null) {
            List<ChannelResponseTime> channelResponseTimesFor7Days = channelsResponseTimeResponse.getChannelResponseTimesFor7Days();
            List<ChannelResponseTime> channelResponseTime = channelsResponseTimeResponse.getChannelResponseTime();
            List<ChannelResponseTime> channelsCustomResponseTimeMessage = channelsResponseTimeResponse.getChannelsCustomResponseTimeMessage();
            List<ChannelResponseTime> channelsWithAllMembersAway = channelsResponseTimeResponse.getChannelsWithAllMembersAway();
            if (k.a(channelResponseTimesFor7Days)) {
                for (ChannelResponseTime channelResponseTime2 : channelResponseTimesFor7Days) {
                    channelResponseTime2.setResponseTimeType(ChannelResponseTime.ResponseTimeType.LAST_WEEK_AVG);
                    hC.put(Long.valueOf(channelResponseTime2.getChannelId()), channelResponseTime2);
                }
            }
            if (k.a(channelResponseTime)) {
                for (ChannelResponseTime channelResponseTime3 : channelResponseTime) {
                    channelResponseTime3.setResponseTimeType(ChannelResponseTime.ResponseTimeType.CURRENT_AVG);
                    hC.put(Long.valueOf(channelResponseTime3.getChannelId()), channelResponseTime3);
                }
            }
            if (k.a(channelsCustomResponseTimeMessage)) {
                for (ChannelResponseTime channelResponseTime4 : channelsCustomResponseTimeMessage) {
                    channelResponseTime4.setResponseTimeType(ChannelResponseTime.ResponseTimeType.CUSTOM_RESPONSE);
                    if (channelResponseTime4.getCustomResponseTimeMessage() != null && !channelResponseTime4.getCustomResponseTimeMessage().isEmpty()) {
                        hC.put(Long.valueOf(channelResponseTime4.getChannelId()), channelResponseTime4);
                    }
                }
            }
            if (k.a(channelsWithAllMembersAway)) {
                boolean z = false;
                if (context != null) {
                    z = as.a(context.getString(R.string.freshchat_all_members_away_message));
                }
                if (z) {
                    for (ChannelResponseTime channelResponseTime5 : channelsWithAllMembersAway) {
                        channelResponseTime5.setResponseTimeType(ChannelResponseTime.ResponseTimeType.ALL_MEMBERS_AWAY_RESPONSE);
                        hC.put(Long.valueOf(channelResponseTime5.getChannelId()), channelResponseTime5);
                    }
                }
            }
            ex();
        }
    }

    public static String d(Context context, long j) {
        if (context == null || j == 0) {
            return null;
        }
        return a(context, r(j));
    }

    private static void ex() {
        hD = System.currentTimeMillis();
    }

    public static long ey() {
        return hD;
    }

    private static ChannelResponseTime r(long j) {
        if (!k.d(hC) || !hC.containsKey(Long.valueOf(j))) {
            return null;
        }
        return hC.get(Long.valueOf(j));
    }
}
