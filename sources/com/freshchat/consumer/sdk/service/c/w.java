package com.freshchat.consumer.sdk.service.c;

import android.webkit.URLUtil;
import com.freshchat.consumer.sdk.FreshchatImageLoader;
import com.freshchat.consumer.sdk.FreshchatImageLoaderRequest;
import com.freshchat.consumer.sdk.beans.Category;
import com.freshchat.consumer.sdk.beans.Channel;
import com.freshchat.consumer.sdk.c.c;
import com.freshchat.consumer.sdk.c.i;
import com.freshchat.consumer.sdk.j.aa;
import com.freshchat.consumer.sdk.j.af;
import com.freshchat.consumer.sdk.j.q;
import com.freshchat.consumer.sdk.service.e.h;
import com.freshchat.consumer.sdk.service.e.k;
import com.freshchat.consumer.sdk.service.e.z;
import java.util.List;

public class w extends a<z, k> {
    private void dy() {
        List<Category> cJ = new i(getContext()).cJ();
        aa.fF();
        for (Category category : cJ) {
            if (category.getIconUrl() != null && URLUtil.isNetworkUrl(category.getIconUrl())) {
                try {
                    FreshchatImageLoaderRequest dM = new FreshchatImageLoaderRequest.a(category.getIconUrl()).dM();
                    FreshchatImageLoader eK = af.eK();
                    if (eK != null) {
                        eK.fetch(dM);
                    }
                } catch (Exception e) {
                    q.a(e);
                }
            }
        }
    }

    private void dz() {
        List<Channel> cv = new c(getContext()).cv();
        aa.fF();
        for (Channel channel : cv) {
            if (channel.getIconUrl() != null && URLUtil.isNetworkUrl(channel.getIconUrl())) {
                try {
                    FreshchatImageLoaderRequest dM = new FreshchatImageLoaderRequest.a(channel.getIconUrl()).dM();
                    FreshchatImageLoader eK = af.eK();
                    if (eK != null) {
                        eK.fetch(dM);
                    }
                } catch (Exception e) {
                    q.a(e);
                }
            }
        }
    }

    /* renamed from: a */
    public k b(z zVar) {
        h hVar = new h(true);
        if (!b(zVar)) {
            return hVar;
        }
        if (zVar.dR() == z.a.FAQ_ICONS) {
            dy();
        } else if (zVar.dR() == z.a.CHANNEL_ICONS) {
            dz();
        }
        return hVar;
    }

    public boolean b(z zVar) {
        return com.freshchat.consumer.sdk.j.w.ay(getContext());
    }
}
