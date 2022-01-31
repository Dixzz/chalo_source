package defpackage;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* renamed from: s32  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public interface s32 {
    void a(@RecentlyNonNull String str, @RecentlyNonNull LifecycleCallback lifecycleCallback);

    @RecentlyNullable
    <T extends LifecycleCallback> T b(@RecentlyNonNull String str, @RecentlyNonNull Class<T> cls);

    @RecentlyNonNull
    Activity c();

    void startActivityForResult(@RecentlyNonNull Intent intent, int i);
}
