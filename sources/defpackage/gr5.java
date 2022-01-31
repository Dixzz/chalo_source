package defpackage;

import android.content.Context;
import com.urbanairship.iam.DisplayHandler;
import com.urbanairship.iam.InAppMessage;
import com.urbanairship.iam.assets.Assets;

/* renamed from: gr5  reason: default package */
/* compiled from: InAppMessageAdapter */
public interface gr5 {

    /* renamed from: gr5$a */
    /* compiled from: InAppMessageAdapter */
    public interface a {
        gr5 a(InAppMessage inAppMessage);
    }

    void a(Context context);

    int b(Context context, Assets assets);

    boolean c(Context context);

    void d(Context context, DisplayHandler displayHandler);
}
