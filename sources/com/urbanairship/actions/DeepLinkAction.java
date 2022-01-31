package com.urbanairship.actions;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import app.zophop.engagement.airship.AirshipAutoPilot;
import app.zophop.products.ProductSelectionActivity;
import com.razorpay.AnalyticsConstants;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;

public class DeepLinkAction extends nk5 {
    @Override // defpackage.nk5
    public boolean a(ok5 ok5) {
        int i = ok5.f2706a;
        if ((i == 0 || i == 6 || i == 2 || i == 3 || i == 4) && qy5.f(ok5.b.d()) != null) {
            return true;
        }
        return false;
    }

    @Override // defpackage.nk5
    public rk5 d(ok5 ok5) {
        Uri f = qy5.f(ok5.b.d());
        if (f == null) {
            return rk5.a();
        }
        yj5.f("Deep linking: %s", f);
        vz vzVar = UAirship.l().f716a;
        if (vzVar != null) {
            String uri = f.toString();
            AirshipAutoPilot airshipAutoPilot = vzVar.f3693a;
            n86.e(airshipAutoPilot, "this$0");
            n86.e(uri, "deepLink");
            n86.j("setupDeeplinkHandlers: deeplink = ", uri);
            Intent intent = new Intent();
            intent.setData(Uri.parse(uri));
            n86.j("setupDeeplinkHandlers: intent data = ", intent.getData());
            g30 g30 = new g30(intent);
            n86.j("setupDeeplinkHandlers: intentUriParser isValid = ", Boolean.valueOf(g30.a()));
            n86.j("setupDeeplinkHandlers: intentUriParser host = ", g30.c);
            n86.j("setupDeeplinkHandlers: intentUriParser lastPathSegment = ", g30.b);
            if (g30.a() && n86.a(g30.b, "bookProduct")) {
                Context context = airshipAutoPilot.c;
                if (context != null) {
                    n86.j("setupDeeplinkHandlers: context = ", context);
                    Context context2 = airshipAutoPilot.c;
                    if (context2 != null) {
                        Intent intent2 = new Intent(context2, ProductSelectionActivity.class);
                        intent2.putExtra("src", "deeplink product");
                        intent2.setFlags(268435456);
                        Context context3 = airshipAutoPilot.c;
                        if (context3 != null) {
                            context3.startActivity(intent2);
                        } else {
                            n86.l(AnalyticsConstants.CONTEXT);
                            throw null;
                        }
                    } else {
                        n86.l(AnalyticsConstants.CONTEXT);
                        throw null;
                    }
                } else {
                    n86.l(AnalyticsConstants.CONTEXT);
                    throw null;
                }
            }
            yj5.f("Calling through to deep link listener with uri string: %s", f.toString());
            return rk5.d(ok5.b);
        }
        Intent intent3 = new Intent("android.intent.action.VIEW", f).addFlags(268435456).setPackage(UAirship.g());
        PushMessage pushMessage = (PushMessage) ok5.c.getParcelable("com.urbanairship.PUSH_MESSAGE");
        if (pushMessage != null) {
            intent3.putExtra("com.urbanairship.push.EXTRA_PUSH_MESSAGE_BUNDLE", pushMessage.g());
        }
        UAirship.d().startActivity(intent3);
        return rk5.d(ok5.b);
    }

    @Override // defpackage.nk5
    public boolean f() {
        return true;
    }
}
