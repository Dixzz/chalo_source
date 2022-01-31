package defpackage;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RecentlyNonNull;

/* renamed from: jc2  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public interface jc2 {
    void I();

    void K(Bundle bundle);

    void L(@RecentlyNonNull Activity activity, @RecentlyNonNull Bundle bundle, Bundle bundle2);

    @RecentlyNonNull
    View M(@RecentlyNonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle);

    void l();

    void m();

    void n();

    void onLowMemory();

    void u();

    void w();

    void z(@RecentlyNonNull Bundle bundle);
}
