package com.urbanairship.messagecenter.webkit;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Base64;
import app.zophop.models.mTicketing.ProductDiscountsObject;
import com.urbanairship.webkit.AirshipWebView;
import defpackage.fz5;
import java.util.HashMap;

public class MessageWebView extends AirshipWebView {
    public MessageWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void b(wu5 wu5) {
        kv5 kv5 = yu5.j().g.g;
        HashMap hashMap = new HashMap();
        if (!(kv5.b() == null || kv5.c() == null)) {
            String str = wu5.l;
            String b = kv5.b();
            String c = kv5.c();
            this.g = str;
            if (getWebViewClientCompat() != null && (getWebViewClientCompat() instanceof fz5)) {
                fz5 fz5 = (fz5) getWebViewClientCompat();
                String host = Uri.parse(str).getHost();
                if (host != null) {
                    fz5.f1191a.put(host, new fz5.c(b, c));
                }
            }
            String T = hj1.T(kv5.b(), ProductDiscountsObject.KEY_DELIMITER, kv5.c());
            StringBuilder i0 = hj1.i0("Basic ");
            i0.append(Base64.encodeToString(T.getBytes(), 2));
            hashMap.put("Authorization", i0.toString());
        }
        loadUrl(wu5.l, hashMap);
    }
}
