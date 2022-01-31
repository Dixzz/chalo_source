package defpackage;

import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import java.util.HashMap;

/* renamed from: we3  reason: default package */
public final class we3 extends iz1<we3> {

    /* renamed from: a  reason: collision with root package name */
    public String f3768a;
    public boolean b;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [iz1] */
    @Override // defpackage.iz1
    public final /* synthetic */ void c(we3 we3) {
        we3 we32 = we3;
        if (!TextUtils.isEmpty(this.f3768a)) {
            we32.f3768a = this.f3768a;
        }
        boolean z = this.b;
        if (z) {
            we32.b = z;
        }
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("description", this.f3768a);
        hashMap.put(CrashlyticsController.FIREBASE_CRASH_TYPE, Boolean.valueOf(this.b));
        return iz1.a(hashMap);
    }
}
