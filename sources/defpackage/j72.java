package defpackage;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import j$.util.DesugarCollections;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/* renamed from: j72  reason: default package */
/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
public final class j72 extends Fragment implements s32 {
    public static final WeakHashMap<Activity, WeakReference<j72>> i = new WeakHashMap<>();
    public final Map<String, LifecycleCallback> f = DesugarCollections.synchronizedMap(new n2());
    public int g = 0;
    public Bundle h;

    @Override // defpackage.s32
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f.containsKey(str)) {
            this.f.put(str, lifecycleCallback);
            if (this.g > 0) {
                new jl2(Looper.getMainLooper()).post(new i72(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(hj1.b0(new StringBuilder(str.length() + 59), "LifecycleCallback with tag ", str, " already added to this fragment."));
    }

    @Override // defpackage.s32
    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return cls.cast(this.f.get(str));
    }

    @Override // defpackage.s32
    public final Activity c() {
        return getActivity();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.d(i2, i3, intent);
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.g = 1;
        this.h = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f.entrySet()) {
            entry.getValue().e(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        this.g = 5;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            Objects.requireNonNull(lifecycleCallback);
        }
    }

    public final void onResume() {
        super.onResume();
        this.g = 3;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.f();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle != null) {
            for (Map.Entry<String, LifecycleCallback> entry : this.f.entrySet()) {
                Bundle bundle2 = new Bundle();
                entry.getValue().g(bundle2);
                bundle.putBundle(entry.getKey(), bundle2);
            }
        }
    }

    public final void onStart() {
        super.onStart();
        this.g = 2;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.h();
        }
    }

    public final void onStop() {
        super.onStop();
        this.g = 4;
        for (LifecycleCallback lifecycleCallback : this.f.values()) {
            lifecycleCallback.i();
        }
    }
}
