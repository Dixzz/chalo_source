package defpackage;

import android.content.Context;
import app.zophop.models.mTicketing.ProductPromotionsObject;
import com.urbanairship.UAirship;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.assets.Assets;

/* renamed from: ur5  reason: default package */
/* compiled from: MediaDisplayAdapter */
public abstract class ur5 extends cr5 {

    /* renamed from: a  reason: collision with root package name */
    public final InAppMessage f3548a;
    public final vr5 b;
    public Assets c;

    public ur5(InAppMessage inAppMessage, vr5 vr5) {
        this.f3548a = inAppMessage;
        this.b = vr5;
    }

    @Override // defpackage.gr5
    public void a(Context context) {
    }

    @Override // defpackage.gr5
    public int b(Context context, Assets assets) {
        this.c = assets;
        vr5 vr5 = this.b;
        if (vr5 == null) {
            return 0;
        }
        if (UAirship.l().k.d(vr5.f, 2) || ProductPromotionsObject.KEY_IMAGE.equals(this.b.h)) {
            return 0;
        }
        yj5.c("URL not allowed. Unable to load: %s", this.b.f);
        return 2;
    }

    @Override // defpackage.gr5
    public boolean c(Context context) {
        er5 f = er5.f(context);
        if (!(!f.f1021a.c(f.d).isEmpty())) {
            return false;
        }
        vr5 vr5 = this.b;
        if (vr5 == null) {
            return true;
        }
        Assets assets = this.c;
        if (assets == null || !assets.b(vr5.f).exists()) {
            return hd3.E1();
        }
        return true;
    }
}
