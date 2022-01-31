package defpackage;

import android.graphics.BitmapFactory;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.assets.Assets;
import com.urbanairship.json.JsonValue;
import defpackage.zt5;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/* renamed from: zr5  reason: default package */
/* compiled from: AirshipPrepareAssetsDelegate */
public class zr5 implements ds5 {
    public my5 a(Assets assets, String str) throws IOException {
        File b = assets.b(str);
        my5 I0 = hd3.I0(new URL(str), b);
        if (I0.b) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(b.getAbsolutePath(), options);
            zt5.b s = zt5.s();
            s.i("width", Integer.valueOf(options.outWidth));
            s.i("height", Integer.valueOf(options.outHeight));
            zt5 a2 = s.a();
            synchronized (assets.k) {
                assets.j.put(str, JsonValue.x(a2));
                assets.f.execute(new cs5(assets));
            }
        }
        return I0;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public int b(String str, InAppMessage inAppMessage, Assets assets) {
        vr5 vr5;
        String str2 = inAppMessage.f;
        str2.hashCode();
        boolean z = false;
        char c = 65535;
        switch (str2.hashCode()) {
            case -1396342996:
                if (str2.equals("banner")) {
                    c = 0;
                    break;
                }
                break;
            case 104069805:
                if (str2.equals("modal")) {
                    c = 1;
                    break;
                }
                break;
            case 110066619:
                if (str2.equals("fullscreen")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                hs5 hs5 = (hs5) inAppMessage.c();
                if (hs5 != null) {
                    vr5 = hs5.h;
                    break;
                }
                vr5 = null;
                break;
            case 1:
                ws5 ws5 = (ws5) inAppMessage.c();
                if (ws5 != null) {
                    vr5 = ws5.h;
                    break;
                }
                vr5 = null;
                break;
            case 2:
                ns5 ns5 = (ns5) inAppMessage.c();
                if (ns5 != null) {
                    vr5 = ns5.h;
                    break;
                }
                vr5 = null;
                break;
            default:
                vr5 = null;
                break;
        }
        if (vr5 == null || !ProductPromotionsObject.KEY_IMAGE.equals(vr5.h) || assets.b(vr5.f).exists()) {
            return 0;
        }
        try {
            my5 a2 = a(assets, vr5.f);
            if (a2.b) {
                return 0;
            }
            if (a2.f2461a / 100 == 4) {
                z = true;
            }
            return z ? 2 : 1;
        } catch (IOException e) {
            yj5.e(e, "Unable to download file: %s ", vr5.f);
            return 1;
        }
    }
}
