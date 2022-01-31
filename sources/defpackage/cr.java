package defpackage;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;

/* renamed from: cr  reason: default package */
/* compiled from: SystemJobInfoConverter */
public class cr {
    public static final String b = tp.e("SystemJobInfoConverter");

    /* renamed from: a  reason: collision with root package name */
    public final ComponentName f745a;

    public cr(Context context) {
        this.f745a = new ComponentName(context.getApplicationContext(), SystemJobService.class);
    }
}
