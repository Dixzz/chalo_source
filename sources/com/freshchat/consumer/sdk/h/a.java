package com.freshchat.consumer.sdk.h;

import android.content.Intent;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.freshchat.consumer.sdk.j.ag;

public class a {
    private long channelId;
    private long conversationId;
    private String ej;
    private int fb;
    private String fc;
    private String fd;
    private boolean fe;
    private String ff;
    private String fg;
    private String fh;
    private long marketingId;
    private long timestamp;

    public a(Intent intent) {
        o(ag.e(intent, "notif_type"));
        ai(ag.b(intent, ProductPromotionsObject.KEY_BODY));
        aj(ag.b(intent, "img_url"));
        setTimestamp(ag.d(intent, "timestamp"));
        l(ag.c(intent, "ephemeral"));
        setChannelId(ag.d(intent, "channel_id"));
        setConversationId(ag.d(intent, "conv_id"));
        setMarketingId(ag.d(intent, "marketing_id"));
        ak(ag.b(intent, "msg_alias"));
        al(ag.b(intent, "target_user_alias"));
        am(ag.b(intent, "user_name"));
        an(ag.b(intent, "link_uri_1"));
    }

    public void ai(String str) {
        this.fc = str;
    }

    public void aj(String str) {
        this.fd = str;
    }

    public void ak(String str) {
        this.ej = str;
    }

    public void al(String str) {
        this.ff = str;
    }

    public void am(String str) {
        this.fg = str;
    }

    public void an(String str) {
        this.fh = str;
    }

    public String dl() {
        return this.fd;
    }

    public boolean dm() {
        return this.fe;
    }

    public String dn() {
        return this.ej;
    }

    /* renamed from: do  reason: not valid java name */
    public String m6do() {
        return this.ff;
    }

    public int fK() {
        return this.fb;
    }

    public String getBody() {
        return this.fc;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getConversationId() {
        return this.conversationId;
    }

    public long getMarketingId() {
        return this.marketingId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void l(boolean z) {
        this.fe = z;
    }

    public void o(int i) {
        this.fb = i;
    }

    public void setChannelId(long j) {
        this.channelId = j;
    }

    public void setConversationId(long j) {
        this.conversationId = j;
    }

    public void setMarketingId(long j) {
        this.marketingId = j;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }
}
